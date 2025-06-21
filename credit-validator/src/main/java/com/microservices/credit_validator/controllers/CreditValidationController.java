package com.microservices.credit_validator.controllers;


import com.microservices.credit_validator.dtos.*;
import com.microservices.credit_validator.services.ClientValidatorService;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/credit-validations")
public class CreditValidationController {

    @Autowired
    ClientValidatorService clientValidatorService;

    @GetMapping(value = "client-situation", params = "cpf")
    public ResponseEntity<ClientSituation> consultClientSituation(@RequestParam("cpf") String cpf) {


            return ResponseEntity.ok(clientValidatorService.getClientSituation(cpf));


    }

    @PostMapping ResponseEntity makeValidation(@RequestBody DataValidation data) {
            ReturnClientValidation returnClientValidation = clientValidatorService
                    .makeValidation(data.getCpf(), data.getIncome());
            return ResponseEntity.ok(returnClientValidation);

    }

    @PostMapping("card-request")
    public ResponseEntity requesCard(@RequestBody DataCardIssuanceRequest data) {
        ProtocolCardRequest protocolCardRequest = clientValidatorService.requestCardIssuance(data);
        return ResponseEntity.ok(protocolCardRequest);
    }



}
