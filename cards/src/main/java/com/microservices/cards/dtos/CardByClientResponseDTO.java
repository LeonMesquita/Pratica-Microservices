package com.microservices.cards.dtos;

import com.microservices.cards.models.ClientCardModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardByClientResponseDTO {
    private String name;
    private String flag;
    private BigDecimal approvedLimit;

    public static CardByClientResponseDTO fromModel(ClientCardModel model) {
        return new CardByClientResponseDTO(
                model.getCard().getName(),
                model.getCard().getCardFlag().toString(),
                model.getApprovedLimit()
        );
    }
}
