package br.com.tga.microservice.pagamentospringbootms.model.create;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.tga.microservice.pagamentospringbootms.model.Pagamento;
import lombok.Getter;
import lombok.Setter;

public class CreatePagamentoRequest {

    @NotBlank @NotNull
    @Getter @Setter private String descricao;
    
    @NotNull
    @Getter @Setter private Double valor;

    @NotNull
    @JsonProperty("cartao_id")
    @Getter @Setter private Long cartaoId;

    public Pagamento converter(){
        return new Pagamento(descricao, valor, cartaoId);
    }
    
}