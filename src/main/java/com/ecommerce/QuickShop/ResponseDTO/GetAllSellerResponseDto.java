package com.ecommerce.QuickShop.ResponseDTO;

import com.ecommerce.QuickShop.Model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetAllSellerResponseDto {
    private int sellerId;

    private String name;

    private String email;

    private String mobNo;

    private String panCard;

    List<ProductDto> productList = new ArrayList<>();

}
