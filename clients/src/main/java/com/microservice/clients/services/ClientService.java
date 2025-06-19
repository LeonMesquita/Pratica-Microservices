package com.microservice.clients.services;

import com.microservice.clients.dtos.ClientDTO;
import com.microservice.clients.models.ClientModel;
import com.microservice.clients.repositories.ClientRepository;
import jakarta.ws.rs.NotFoundException;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;


    public ClientModel save(ClientDTO dto) {
        //TODO: Adicionar validação de cpf
        ClientModel clientModel = new ClientModel();
        BeanUtils.copyProperties(dto, clientModel);
        return clientRepository.save(clientModel);
    }

    public ClientModel findByCpf(String cpf) {
        return clientRepository.findByCpf(cpf).orElseThrow(
                () -> new NotFoundException("Cliente não encontrado!")
        );
    }
}

