package com.ecommerce.QuickShop.Service;

import com.ecommerce.QuickShop.Exception.DetailsAlreadyExistsException;
import com.ecommerce.QuickShop.RequestDTO.CustomerRequestDto;

public interface CustomerService {

    public String addCustomer(CustomerRequestDto customerRequestDto) throws DetailsAlreadyExistsException;
}
