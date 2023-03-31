package com.ecommerce.QuickShop.Service;

import com.ecommerce.QuickShop.Exception.CardNoAlreadyExistsException;
import com.ecommerce.QuickShop.Exception.CustomerNotFoundException;
import com.ecommerce.QuickShop.RequestDTO.CardRequestDto;
import com.ecommerce.QuickShop.ResponseDTO.CardResponseDto;

public interface CardService {

    public CardResponseDto addCard(CardRequestDto cardRequestDto) throws CustomerNotFoundException, CardNoAlreadyExistsException;
}
