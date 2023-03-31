package com.ecommerce.QuickShop.Service.Impl;

import com.ecommerce.QuickShop.Exception.DetailsAlreadyExistsException;
import com.ecommerce.QuickShop.Model.Cart;
import com.ecommerce.QuickShop.Model.Customer;
import com.ecommerce.QuickShop.Repository.CustomerRepository;
import com.ecommerce.QuickShop.RequestDTO.CustomerRequestDto;
import com.ecommerce.QuickShop.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    @Override
    public String addCustomer(CustomerRequestDto customerRequestDto) throws DetailsAlreadyExistsException {
        Customer customer = Customer.builder()
                .name(customerRequestDto.getName())
                .age(customerRequestDto.getAge())
                .mobNo(customerRequestDto.getMobNo())
                .email(customerRequestDto.getEmail())
                .build();
        // allocate a cart to customer
        Cart cart = new Cart();
        cart.setCartValue(0);
        cart.setCustomer(customer);
        //set Cart in customer
        customer.setCart(cart);

        try {
            customerRepository.save(customer);
        }catch (Exception e){
            throw new DetailsAlreadyExistsException("Duplicate Elements!!");
        }

        return "Congrats !! Welcome to QuickShop.";
    }
}
