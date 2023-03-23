package com.ecommerce.QuickShop.Service.Impl;

import com.ecommerce.QuickShop.Converter.ProductConverter;
import com.ecommerce.QuickShop.Exception.SellerNotFoundException;
import com.ecommerce.QuickShop.Model.Product;
import com.ecommerce.QuickShop.Model.Seller;
import com.ecommerce.QuickShop.Repository.SellerRepository;
import com.ecommerce.QuickShop.RequestDTO.ProductRequestDto;
import com.ecommerce.QuickShop.ResponseDTO.ProductResponseDto;
import com.ecommerce.QuickShop.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceIpml implements ProductService {

    @Autowired
    SellerRepository sellerRepository;
    @Override
    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) throws Exception {
        // find seller by sellerId
        Seller seller;
        try {
            seller = sellerRepository.findById(productRequestDto.getSellerId()).get();
        }catch (Exception e){
            throw new SellerNotFoundException("Invalid Seller Id");
        }
        Product product = ProductConverter.productRequestDtoToProduct(productRequestDto);
        product.setSeller(seller);

        //add in seller list
        seller.getProductList().add(product);

        sellerRepository.save(seller);

        //Response
        return ProductConverter.productToProductResponseDto(product);
    }
}
