package com.ecommerce.QuickShop.Service;

import com.ecommerce.QuickShop.Exception.CustomerNotFoundException;
import com.ecommerce.QuickShop.Exception.ProductNotFoundException;
import com.ecommerce.QuickShop.RequestDTO.OrderRequestDto;
import com.ecommerce.QuickShop.ResponseDTO.OrderResponseDto;

public interface OrderService {

    public OrderResponseDto placeOrder(OrderRequestDto orderRequestDto) throws Exception;
}
