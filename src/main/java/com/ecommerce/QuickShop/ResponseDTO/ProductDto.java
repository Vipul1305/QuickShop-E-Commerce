package com.ecommerce.QuickShop.ResponseDTO;

import com.ecommerce.QuickShop.Enum.ProductCategory;
import com.ecommerce.QuickShop.Enum.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {

    private int productId;

    private String productName;

    private int price;

    private int quantity;

    private ProductCategory productCategory;

    private ProductStatus productStatus;
}
