package com.microservices.cards.services;

import com.microservices.cards.dtos.CardDTO;
import com.microservices.cards.models.CardModel;
import com.microservices.cards.repositories.CardRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CardService {
    @Autowired
    CardRepository cardRepository;


    public CardModel save(CardDTO dto) {
        CardModel cardModel = new CardModel();
        BeanUtils.copyProperties(dto, cardModel);
        return cardRepository.save(cardModel);
    }

    public List<CardModel> getCardsByRentLessEqual(Long rent) {
        BigDecimal bigDecimal = BigDecimal.valueOf(rent);
        return cardRepository.findByIncomeLessThanEqual(bigDecimal);
    }


}
