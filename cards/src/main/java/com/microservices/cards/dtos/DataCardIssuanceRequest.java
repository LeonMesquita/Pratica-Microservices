package com.microservices.cards.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DataCardIssuanceRequest {
    private Long cardId;
    private String cpf;
    private String address;
    private BigDecimal approvedLimit;
}
