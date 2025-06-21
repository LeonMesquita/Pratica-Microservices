package com.microservices.credit_validator.configs;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Value("${mq.queues.card-issuance}")
    private String cardIssuanceQueue;

    @Bean
    public Queue cardIssuanceQueue() {

        return new Queue(cardIssuanceQueue, true);
    }
}
