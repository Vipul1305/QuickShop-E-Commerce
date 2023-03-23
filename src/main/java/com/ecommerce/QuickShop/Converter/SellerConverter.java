package com.ecommerce.QuickShop.Converter;

import com.ecommerce.QuickShop.Model.Seller;
import com.ecommerce.QuickShop.RequestDTO.SellerRequestDto;
import com.ecommerce.QuickShop.ResponseDTO.SellerResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SellerConverter {

    public static Seller sellerRequestDtoToSeller(SellerRequestDto sellerRequestDto){
        return Seller.builder()
                .name(sellerRequestDto.getName())
                .email(sellerRequestDto.getEmail())
                .mobNo(sellerRequestDto.getMobNo())
                .panCard(sellerRequestDto.getPanCard())
                .build();
    }
    public static SellerResponseDto sellerToSellerResponseDto(Seller seller){
        return SellerResponseDto.builder()
                .sellerId(seller.getSellerId())
                .message("Congrats! Now you can sell on  QuickShop !!!")
                .build();
    }
}
