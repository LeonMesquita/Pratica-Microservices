package com.microservices.credit_validator.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProtocolCardRequest {
    private String protocol;
}
