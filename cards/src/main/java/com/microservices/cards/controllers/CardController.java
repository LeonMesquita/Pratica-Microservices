package com.microservices.cards.controllers;

import com.microservices.cards.dtos.CardByClientResponseDTO;
import com.microservices.cards.dtos.CardDTO;
import com.microservices.cards.models.CardModel;
import com.microservices.cards.models.ClientCardModel;
import com.microservices.cards.services.CardService;
import com.microservices.cards.services.ClientCardService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cards")
public class CardController {
    @Autowired
    CardService cardService;

    @Autowired
    ClientCardService clientCardService;

    @PostMapping
    public ResponseEntity<CardModel> createCard(@RequestBody CardDTO body) {
        return ResponseEntity.ok(cardService.save(body));
    }

    @GetMapping(params = "income")
    public ResponseEntity<List<CardModel>> getByLessThenEqualIncome(@RequestParam Long income) {
        return ResponseEntity.ok(cardService.getCardsByRentLessEqual(income));
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<CardByClientResponseDTO>> getCardsByClient(@RequestParam String cpf) {
        List<ClientCardModel> cards = clientCardService.findAllByCpf(cpf);
        List<CardByClientResponseDTO> resultList = cards.stream()
                .map(CardByClientResponseDTO::fromModel)
                .collect(Collectors.toList());
        return ResponseEntity.ok(resultList);
    }




}
