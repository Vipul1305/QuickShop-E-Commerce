package com.ecommerce.QuickShop.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponseDto {

    private String productName;
    private Date orderDate;

    private int quantityOrdered;

    private int itemPrice;
    private int deliveryCharge;

    private int totalCost;

    private String cardUsedForPayment;
}
