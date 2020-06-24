package br.com.tga.microservice.pagamentospringbootms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Cartão não encontrado")
public class CartaoNotFoundException extends RuntimeException {}