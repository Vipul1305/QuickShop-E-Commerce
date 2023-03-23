package com.ecommerce.QuickShop.Service;

import com.ecommerce.QuickShop.Model.Seller;
import com.ecommerce.QuickShop.RequestDTO.SellerRequestDto;
import com.ecommerce.QuickShop.ResponseDTO.GetAllSellerResponseDto;
import com.ecommerce.QuickShop.ResponseDTO.SellerResponseDto;

import java.util.List;

public interface SellerService {

    public SellerResponseDto addSeller(SellerRequestDto sellerRequestDto) throws Exception;

    public List<GetAllSellerResponseDto> getAllSeller();
}
