package com.ecommerce.QuickShop.Service.Impl;

import com.ecommerce.QuickShop.Exception.CustomerNotFoundException;
import com.ecommerce.QuickShop.Exception.ProductNotFoundException;
import com.ecommerce.QuickShop.Model.Cart;
import com.ecommerce.QuickShop.Model.Customer;
import com.ecommerce.QuickShop.Model.Item;
import com.ecommerce.QuickShop.Model.Product;
import com.ecommerce.QuickShop.Repository.CartRepository;
import com.ecommerce.QuickShop.Repository.CustomerRepository;
import com.ecommerce.QuickShop.Repository.ProductRepository;
import com.ecommerce.QuickShop.RequestDTO.OrderRequestDto;
import com.ecommerce.QuickShop.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;

    @Autowired
    CartRepository cartRepository;
    @Override
    public String addToCart(OrderRequestDto orderRequestDto) throws Exception {
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
        //now add to cart
        Cart cart = customer.getCart();
        int cartTotal = cart.getCartValue() + product.getPrice()*orderRequestDto.getRequiredQuantity();
        cart.setCartValue(cartTotal);
        //cart.setCustomer(customer); no need already getting it from customer only.

        // Add item to current cart
        Item item = Item.builder()
                .requiredQuantity(orderRequestDto.getRequiredQuantity())
                .cart(cart)
                .product(product)
                .build();

        cart.getItemList().add(item);
        //product.setItem(item);

        cartRepository.save(cart);
        return "Item has been added to your Cart!!";
    }
}
