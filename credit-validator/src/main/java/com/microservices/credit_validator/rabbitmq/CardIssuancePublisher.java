package com.microservices.credit_validator.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservices.credit_validator.dtos.DataCardIssuanceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class CardIssuancePublisher {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    Queue queueCardsIssuance;

    public void requestCard(DataCardIssuanceRequest data) throws JsonProcessingException  {
        var json = this.convertIntoJson(data);
        rabbitTemplate.convertAndSend(queueCardsIssuance.getName(), json);
    }

    private String convertIntoJson(DataCardIssuanceRequest data) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(data);
    }
}
