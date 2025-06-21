package com.microservices.cards.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservices.cards.dtos.DataCardIssuanceRequest;
import com.microservices.cards.models.CardModel;
import com.microservices.cards.models.ClientCardModel;
import com.microservices.cards.repositories.CardRepository;
import com.microservices.cards.repositories.ClientCardRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class CardIssuanceSubscriber {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    ClientCardRepository clientCardRepository;

    @RabbitListener(queues = "card-issuance")
    public void receiveIssuanceRequest(@Payload String payload) {
        try {
            var mapper = new ObjectMapper();
            DataCardIssuanceRequest data = mapper.readValue(payload, DataCardIssuanceRequest.class);
            CardModel cardModel = cardRepository.findById(data.getCardId()).orElseThrow();
            ClientCardModel clientCardModel = new ClientCardModel();
            clientCardModel.setCard(cardModel);
            clientCardModel.setCpf(data.getCpf());
            clientCardModel.setApprovedLimit(data.getApprovedLimit());
            clientCardRepository.save(clientCardModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
