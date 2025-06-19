package com.microservice.clients.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ClientDTO {
    @NotBlank
    @Size(min = 11, max = 11)
    private String cpf;

    @NotBlank
    @Size(min = 4, max = 30)
    private String name;

    @NotNull
    private int age;
}
