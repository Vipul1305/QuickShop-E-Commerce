package com.ecommerce.QuickShop.Service;

import com.ecommerce.QuickShop.Exception.CustomerNotFoundException;
import com.ecommerce.QuickShop.Exception.ProductNotFoundException;
import com.ecommerce.QuickShop.RequestDTO.OrderRequestDto;

public interface CartService {

    String addToCart(OrderRequestDto orderRequestDto) throws Exception;
}
