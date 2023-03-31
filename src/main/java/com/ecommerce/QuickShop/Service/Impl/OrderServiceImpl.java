package com.ecommerce.QuickShop.Service.Impl;

import com.ecommerce.QuickShop.Enum.ProductStatus;
import com.ecommerce.QuickShop.Exception.CustomerNotFoundException;
import com.ecommerce.QuickShop.Exception.ProductNotFoundException;
import com.ecommerce.QuickShop.Model.*;
import com.ecommerce.QuickShop.Repository.CustomerRepository;
import com.ecommerce.QuickShop.Repository.OrderedRepository;
import com.ecommerce.QuickShop.Repository.ProductRepository;
import com.ecommerce.QuickShop.RequestDTO.OrderRequestDto;
import com.ecommerce.QuickShop.ResponseDTO.OrderResponseDto;
import com.ecommerce.QuickShop.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderedRepository orderedRepository;
    @Override
    public OrderResponseDto placeOrder(OrderRequestDto orderRequestDto) throws Exception {
        Customer customer;
        try {
            customer = customerRepository.findById(orderRequestDto.getCustomerId()).get();
        }catch (Exception e){
            throw new CustomerNotFoundException("Invalid Customer");
        }
        Product product;
        try {
            product = productRepository.findById(orderRequestDto.getProductId()).get();
        }catch (Exception e){
            throw new ProductNotFoundException("Product Not Found");
        }
        if(orderRequestDto.getRequiredQuantity()>product.getQuantity()){
            throw new Exception("Sorry! Required quantity not available");
        }
        //now place order

        // update the quantity of product left in warehouse
        int leftQuantity = product.getQuantity()- orderRequestDto.getRequiredQuantity();
        if(leftQuantity<=0)
            product.setProductStatus(ProductStatus.OUT_OF_STOCK);
        product.setQuantity(leftQuantity);

        //calculate total cost
        int totalCost = product.getPrice()*orderRequestDto.getRequiredQuantity();
        int delivery = 0;
        if (totalCost < 500){
            delivery = 40;
            totalCost += delivery;
        }
        //get card used for payment
        Card card = customer.getCardList().get(0);
        //hide card num for security
        String cardUsed = "";
        int cardLength = card.getCardNo().length();
        for(int i = 0; i<cardLength-4; i++){
            cardUsed += 'X';
        }
        cardUsed += card.getCardNo().substring(cardLength-4);

        // make Order
        Ordered ordered = Ordered.builder()
                .deliveryCharge(delivery)
                .totalCost(totalCost)
                .cardUsedForPayment(cardUsed)
                .itemList(new ArrayList<>())
                .customer(customer)
                .build();

        //build item of order product
        Item item = Item.builder()
                .requiredQuantity(orderRequestDto.getRequiredQuantity())
                .product(product)
                .ordered(ordered)
                .build();
        //update ordered list of item
        ordered.getItemList().add(item);
        //update customer list of order
        customer.getOrderedList().add(ordered);

        product.setItem(item);

        orderedRepository.save(ordered);

        //Response
        OrderResponseDto orderResponseDto = OrderResponseDto.builder()
                .productName(product.getProductName())
                .orderDate(ordered.getOrderDate())
                .quantityOrdered(item.getRequiredQuantity())
                .itemPrice(product.getPrice())
                .deliveryCharge(ordered.getDeliveryCharge())
                .totalCost(ordered.getTotalCost())
                .cardUsedForPayment(ordered.getCardUsedForPayment())
                .build();
        return orderResponseDto;
    }
}
