package com.microservices.cards.dtos;

import com.microservices.cards.models.enums.CardFlagEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CardDTO {
    @NotBlank
    private String name;

    @NotNull
    private CardFlagEnum cardFlag;

    @NotNull
    private BigDecimal income;

    @NotNull
    private BigDecimal basicLimit;
}
