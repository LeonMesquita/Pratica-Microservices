package com.microservices.credit_validator;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
// Vai escanear onde tem annotations FeignClients e dar uma implementação para elas
@EnableFeignClients
@EnableRabbit
public class CreditValidatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditValidatorApplication.class, args);
	}

}
