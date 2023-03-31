package com.ecommerce.QuickShop.Controller;

import com.ecommerce.QuickShop.RequestDTO.OrderRequestDto;
import com.ecommerce.QuickShop.ResponseDTO.OrderResponseDto;
import com.ecommerce.QuickShop.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/place")
    public ResponseEntity placeOrder(@RequestBody OrderRequestDto orderRequestDto){
        OrderResponseDto orderResponseDto;
        try {
            orderResponseDto = orderService.placeOrder(orderRequestDto);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(orderResponseDto,HttpStatus.ACCEPTED);
    }
}
