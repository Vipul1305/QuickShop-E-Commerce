package com.ecommerce.QuickShop.Controller;

import com.ecommerce.QuickShop.RequestDTO.CardRequestDto;
import com.ecommerce.QuickShop.ResponseDTO.CardResponseDto;
import com.ecommerce.QuickShop.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    CardService cardService;

    @PostMapping("/add")
    public ResponseEntity addCard(@RequestBody CardRequestDto cardRequestDto){
        CardResponseDto cardResponseDto;
        try {
            cardResponseDto = cardService.addCard(cardRequestDto);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(cardResponseDto,HttpStatus.CREATED);
    }
}
