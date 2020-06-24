package br.com.tga.microservice.pagamentospringbootms.client;

import lombok.Getter;
import lombok.Setter;

public class CartaoRequestMs {
    @Getter @Setter private Long id;
    @Getter @Setter private Long clienteId;
}