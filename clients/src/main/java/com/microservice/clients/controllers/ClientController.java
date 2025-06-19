package com.microservice.clients.controllers;

import com.microservice.clients.dtos.ClientDTO;
import com.microservice.clients.models.ClientModel;
import com.microservice.clients.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientModel> createClient(@RequestBody @Valid ClientDTO body) {
        return ResponseEntity.ok(clientService.save(body));
    }

    @GetMapping
    public ResponseEntity<ClientModel> getClientByCpf(@RequestParam String cpf) {
        return ResponseEntity.ok(clientService.findByCpf(cpf));
    }
}
