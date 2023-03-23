package com.ecommerce.QuickShop.Controller;

import com.ecommerce.QuickShop.Model.Seller;
import com.ecommerce.QuickShop.RequestDTO.SellerRequestDto;
import com.ecommerce.QuickShop.ResponseDTO.GetAllSellerResponseDto;
import com.ecommerce.QuickShop.ResponseDTO.SellerResponseDto;
import com.ecommerce.QuickShop.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seller")
public class SellerController {
    @Autowired
    SellerService sellerService;

    @PostMapping("/add")
    public ResponseEntity addSeller(@RequestBody SellerRequestDto sellerRequestDto){
        SellerResponseDto sellerResponseDto;
        try {
            sellerResponseDto = sellerService.addSeller(sellerRequestDto);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(sellerResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/get_all_seller")
    public ResponseEntity<List<GetAllSellerResponseDto>> getAllSeller(){
        List<GetAllSellerResponseDto> list =  sellerService.getAllSeller();
        return new ResponseEntity<>(list,HttpStatus.CREATED);
    }
}
