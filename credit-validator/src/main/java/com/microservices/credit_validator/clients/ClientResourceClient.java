package com.microservices.credit_validator.clients;

import com.microservices.credit_validator.dtos.ClientData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "clients", path = "/clients")
public interface ClientResourceClient {
    @GetMapping(params = "cpf")
    ResponseEntity<ClientData> getClientByCpf(@RequestParam String cpf);
}
