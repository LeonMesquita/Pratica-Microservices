package com.microservices.credit_validator.clients;

import com.microservices.credit_validator.dtos.Card;
import com.microservices.credit_validator.dtos.ClientCard;
import com.microservices.credit_validator.dtos.ClientData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "cards", path = "/cards")
public interface CardsResourceClient {

    @GetMapping(params = "cpf")
    ResponseEntity<List<ClientCard>> getCardsByClient(@RequestParam String cpf);

    @GetMapping(params = "income")
    ResponseEntity<List<Card>> getByLessThenEqualIncome(@RequestParam Long income);
}
