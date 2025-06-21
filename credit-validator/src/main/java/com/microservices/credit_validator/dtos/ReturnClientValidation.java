package com.microservices.credit_validator.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ReturnClientValidation {
    private List<ApprovedCard> cards;
}
