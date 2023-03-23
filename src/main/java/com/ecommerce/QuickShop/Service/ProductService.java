package com.ecommerce.QuickShop.Service;

import com.ecommerce.QuickShop.RequestDTO.ProductRequestDto;
import com.ecommerce.QuickShop.ResponseDTO.ProductResponseDto;

public interface ProductService {

    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) throws Exception;
}
