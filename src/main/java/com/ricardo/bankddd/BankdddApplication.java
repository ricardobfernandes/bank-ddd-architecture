package com.ricardo.bankddd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "Bank Domain Driven Design POC", version = "1.0",description = "RESTful banking operations API built with Spring Boot"))
@SpringBootApplication
public class BankdddApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankdddApplication.class, args);
	}

}
