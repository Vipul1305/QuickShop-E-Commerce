package com.ecommerce.QuickShop.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellerRequestDto {
    private String name;

    private String email;

    private String mobNo;

    private String panCard;
}
