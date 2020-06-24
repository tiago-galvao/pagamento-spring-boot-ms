package br.com.tga.microservice.pagamentospringbootms.exception.dto;

import lombok.Getter;

public class Erro {
    
    @Getter private String campo;
    @Getter private String erro;

    public Erro(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }
    
}