package com.microservices.credit_validator.dtos;

import lombok.Data;

@Data
public class ClientCard {

    private String name;
    private String flag;
    private String approvedLimit;
}
