package com.microservices.cards.services;

import com.microservices.cards.models.ClientCardModel;
import com.microservices.cards.repositories.ClientCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientCardService {
    @Autowired
    ClientCardRepository clientCardRepository;

    public List<ClientCardModel> findAllByCpf(String cpf) {
        return clientCardRepository.findByCpf(cpf);
    }
}
