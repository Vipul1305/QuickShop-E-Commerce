package com.ecommerce.QuickShop.Controller;

import com.ecommerce.QuickShop.RequestDTO.OrderRequestDto;
import com.ecommerce.QuickShop.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;
    @PostMapping("/add")
    public String addToCart(@RequestBody OrderRequestDto orderRequestDto){
        String message;
        try {
            message = cartService.addToCart(orderRequestDto);
        }catch (Exception e){
            return e.getMessage();
        }
        return message;
    }
}
