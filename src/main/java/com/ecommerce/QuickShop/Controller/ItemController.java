package com.ecommerce.QuickShop.Controller;

import com.ecommerce.QuickShop.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemService;
    @PostMapping("/view/{productId}")
    public ResponseEntity viewItem(@PathVariable("productId") int productId){
        String message;
        try {
            message = itemService.viewItem(productId);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

}
