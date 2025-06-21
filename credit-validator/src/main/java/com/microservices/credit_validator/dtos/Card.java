package com.microservices.credit_validator.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Card {
    private Long id;
    private String name;
    private String cardFlag;
    private BigDecimal basicLimit;
}
