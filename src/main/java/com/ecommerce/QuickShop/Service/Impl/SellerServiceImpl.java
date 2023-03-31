package com.ecommerce.QuickShop.Service.Impl;

import com.ecommerce.QuickShop.Converter.ProductConverter;
import com.ecommerce.QuickShop.Converter.SellerConverter;
import com.ecommerce.QuickShop.Exception.DetailsAlreadyExistsException;
import com.ecommerce.QuickShop.Model.Seller;
import com.ecommerce.QuickShop.Repository.SellerRepository;
import com.ecommerce.QuickShop.RequestDTO.SellerRequestDto;
import com.ecommerce.QuickShop.ResponseDTO.GetAllSellerResponseDto;
import com.ecommerce.QuickShop.ResponseDTO.SellerResponseDto;
import com.ecommerce.QuickShop.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    SellerRepository sellerRepository;

    @Override
    public SellerResponseDto addSeller(SellerRequestDto sellerRequestDto) throws Exception {
        Seller seller = SellerConverter.sellerRequestDtoToSeller(sellerRequestDto);
        try {
            sellerRepository.save(seller);
        }catch (Exception e){
            throw new DetailsAlreadyExistsException("Duplicate Elements!!");
        }

        return SellerConverter.sellerToSellerResponseDto(seller);
    }

    @Override
    public List<GetAllSellerResponseDto> getAllSeller() {
        List<Seller> sellerList = sellerRepository.findAll();

     List<GetAllSellerResponseDto> list = new ArrayList<>();
        for(Seller seller: sellerList){
            GetAllSellerResponseDto getAllSellerResponseDto = GetAllSellerResponseDto.builder()
                    .sellerId(seller.getSellerId())
                    .name(seller.getName())
                    .mobNo(seller.getMobNo())
                    .email(seller.getEmail())
                    .panCard(seller.getPanCard())
                    .productList(ProductConverter.productToProductDto(seller.getProductList()))
                    .build();
            list.add(getAllSellerResponseDto);
        }
      return list;
    }
}
