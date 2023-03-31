package com.ecommerce.QuickShop.RequestDTO;

import com.ecommerce.QuickShop.Enum.CardType;
import com.ecommerce.QuickShop.Model.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardRequestDto {

    private int customerId;

    private String cardNo;

    private int cvv;

    private CardType cardType;
}
