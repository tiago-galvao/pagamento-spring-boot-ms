package br.com.tga.microservice.pagamentospringbootms.model.create;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.tga.microservice.pagamentospringbootms.model.Pagamento;
import lombok.Getter;
import lombok.Setter;

public class CreatePagamentoResponse {

    @Getter @Setter private Long id;
    @Getter @Setter private String descricao;
    @Getter @Setter private Double valor;

    @JsonProperty("cartao_id")
    @Getter @Setter private Long cartaoId;

    public CreatePagamentoResponse(){}

    public CreatePagamentoResponse(Pagamento pagamento){
        this.id = pagamento.getId();
        this.descricao = pagamento.getDescricao();
        this.valor = pagamento.getValor();
        this.cartaoId = pagamento.getCartaoId();
    }

    public static List<CreatePagamentoResponse> convertList(List<Pagamento> pagamentos) {
        return pagamentos.stream().map(CreatePagamentoResponse::new).collect(Collectors.toList());
      }
}