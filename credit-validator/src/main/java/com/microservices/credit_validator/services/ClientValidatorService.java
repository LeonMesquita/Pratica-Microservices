package com.microservices.credit_validator.services;

import com.microservices.credit_validator.clients.CardsResourceClient;
import com.microservices.credit_validator.clients.ClientResourceClient;
import com.microservices.credit_validator.dtos.*;
import feign.FeignException;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.ServerErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientValidatorService {
    @Autowired
    ClientResourceClient clientResourceClient;

    @Autowired
    CardsResourceClient cardsResourceClient;

    public ClientSituation getClientSituation(String cpf) throws  NotFoundException {
        //obter dados do cliente - microserviço clients
        //obter cartões do cliente - microserviço cards
        try {
            ResponseEntity<ClientData> clientDataResponse = clientResourceClient.getClientByCpf(cpf);
            ResponseEntity<List<ClientCard>> cardsResponse = cardsResourceClient.getCardsByClient(cpf);

            return ClientSituation
                    .builder()
                    .client(clientDataResponse.getBody())
                    .cards(cardsResponse.getBody())
                    .build();
        } catch (FeignException.FeignClientException e) {
            int status = e.status();
            //if (HttpStatus.NOT_FOUND.value() == status) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!");
//            } else {
//                throw Badreq("");
//            }
        }
    }

    public ReturnClientValidation makeValidation(String cpf, Long income)throws  NotFoundException {
        try{
            ResponseEntity<ClientData> clientDataResponse = clientResourceClient.getClientByCpf(cpf);
            ResponseEntity<List<Card>> cardsResponse = cardsResourceClient.getByLessThenEqualIncome(income);

            List<Card> cards = cardsResponse.getBody();

            var approvedCards = cards.stream().map(card -> {
                ClientData clientData = clientDataResponse.getBody();

                BigDecimal basicLimit = card.getBasicLimit();
                BigDecimal incomeBD = BigDecimal.valueOf(income);
                BigDecimal ageBD = BigDecimal.valueOf(clientData.getAge());
                BigDecimal fator = ageBD.divide(BigDecimal.valueOf(10));

                BigDecimal approvedLimit = fator.multiply(basicLimit);


                ApprovedCard approvedCard = new ApprovedCard();
                approvedCard.setCard(card.getName());
                approvedCard.setFlag(card.getCardFlag());
                approvedCard.setApprovedLimit(approvedLimit);

                return approvedCard;
            }).collect(Collectors.toList());

            return new ReturnClientValidation(approvedCards);

        } catch (FeignException.FeignClientException e) {
            int status = e.status();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!");
        }
    }
}
