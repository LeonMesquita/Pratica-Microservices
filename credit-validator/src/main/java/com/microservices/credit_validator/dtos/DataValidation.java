package com.microservices.credit_validator.dtos;

import lombok.Data;

@Data
public class DataValidation {
    private String cpf;
    private Long income;
}
