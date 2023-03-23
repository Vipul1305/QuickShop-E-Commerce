package com.ecommerce.QuickShop.Converter;

import com.ecommerce.QuickShop.Enum.ProductCategory;
import com.ecommerce.QuickShop.Enum.ProductStatus;
import com.ecommerce.QuickShop.Model.Product;
import com.ecommerce.QuickShop.RequestDTO.ProductRequestDto;
import com.ecommerce.QuickShop.ResponseDTO.ProductDto;
import com.ecommerce.QuickShop.ResponseDTO.ProductResponseDto;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class ProductConverter {

    public static Product productRequestDtoToProduct(ProductRequestDto productRequestDto){
        return Product.builder()
                .productName(productRequestDto.getProductName())
                .price(productRequestDto.getPrice())
                .quantity(productRequestDto.getQuantity())
                .productCategory(productRequestDto.getProductCategory())
                .productStatus(ProductStatus.AVAILABLE)
                .build();
    }
    public static ProductResponseDto productToProductResponseDto(Product product){
        return ProductResponseDto.builder()
                .productName(product.getProductName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .productCategory(product.getProductCategory())
                .productStatus(product.getProductStatus())
                .build();
    }
    public static List<ProductDto> productToProductDto(List<Product> productList){
        List<ProductDto> list = new ArrayList<>();
        for(Product product: productList) {
            ProductDto productDto = ProductDto.builder()
                    .productId(product.getProductId())
                    .price(product.getPrice())
                    .productName(product.getProductName())
                    .productStatus(product.getProductStatus())
                    .productCategory(product.getProductCategory())
                    .quantity(product.getQuantity())
                    .build();
            list.add(productDto);
        }
        return list;
    }
}
