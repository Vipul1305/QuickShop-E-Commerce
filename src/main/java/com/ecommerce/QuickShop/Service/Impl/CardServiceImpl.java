package com.ecommerce.QuickShop.Service.Impl;

import com.ecommerce.QuickShop.Exception.CardNoAlreadyExistsException;
import com.ecommerce.QuickShop.Exception.CustomerNotFoundException;
import com.ecommerce.QuickShop.Model.Card;
import com.ecommerce.QuickShop.Model.Customer;
import com.ecommerce.QuickShop.Repository.CustomerRepository;
import com.ecommerce.QuickShop.RequestDTO.CardRequestDto;
import com.ecommerce.QuickShop.ResponseDTO.CardDto;
import com.ecommerce.QuickShop.ResponseDTO.CardResponseDto;
import com.ecommerce.QuickShop.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public CardResponseDto addCard(CardRequestDto cardRequestDto) throws CustomerNotFoundException, CardNoAlreadyExistsException {
        Customer customer;
        try {
            customer = customerRepository.findById(cardRequestDto.getCustomerId()).get();
        }catch (Exception e){
            throw new CustomerNotFoundException("Invalid CustomerId!!");
        }

        Card card = Card.builder()
                .cardNo(cardRequestDto.getCardNo())
                .cvv(cardRequestDto.getCvv())
                .cardType(cardRequestDto.getCardType())
                .customer(customer)
                .build();
        customer.getCardList().add(card);

        try {
            customerRepository.save(customer);
        }catch (Exception e){
            throw new CardNoAlreadyExistsException("Card Already Existed!!");
        }

        //Prepare ResponseDto
        //show the List of Card
        List<Card> cardList = customer.getCardList();

        List<CardDto> cardDtoList = new ArrayList<>();
        for (Card card1: cardList){
            CardDto cardDto = CardDto.builder()
                    .cardNo(card1.getCardNo())
                    .cardType(card1.getCardType())
                    .build();
            cardDtoList.add(cardDto);
        }
        return CardResponseDto.builder()
                .customerName(customer.getName())
                .cardList(cardDtoList)
                .build();
    }
}
