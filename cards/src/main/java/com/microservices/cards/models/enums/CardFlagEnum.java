package com.microservices.cards.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

public enum CardFlagEnum {

    MASTERCARD(1, "MASTERCARD"),
    VISA(2, "VISA");

    private final Integer code;
    private final String description;

    CardFlagEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }
}
