package com.microservices.cards.controllers;

import com.microservices.cards.dtos.CardDTO;
import com.microservices.cards.models.CardModel;
import com.microservices.cards.services.CardService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {
    @Autowired
    CardService cardService;

    @PostMapping
    public ResponseEntity<CardModel> createCard(@RequestBody CardDTO body) {
        return ResponseEntity.ok(cardService.save(body));
    }

    @GetMapping
    public ResponseEntity<List<CardModel>> getByLessThenEqualIncome(@RequestParam Long income) {
        return ResponseEntity.ok(cardService.getCardsByRentLessEqual(income));
    }
}
