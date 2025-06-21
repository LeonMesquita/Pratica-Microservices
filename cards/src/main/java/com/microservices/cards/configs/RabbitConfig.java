package com.microservices.cards.configs;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue cardIssuanceQueue() {
        return new Queue("card-issuance", true); // true = durável
    }
}
