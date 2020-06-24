package br.com.tga.microservice.pagamentospringbootms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Long id;

    @Column
    @Getter @Setter private Long cartaoId;

    @Column
    @Getter @Setter private String descricao;

    @Column
    @Getter @Setter private Double valor;

    public Pagamento(){}

    public Pagamento(Long id, Long cartao_id, String descricao, Double valor){
        this.id = id;
        this.cartaoId = cartao_id;
        this.descricao = descricao;
        this.valor = valor;
    }

	public Pagamento(String descricao, Double valor, Long cartaoId) {
        this.cartaoId = cartaoId;
        this.descricao = descricao;
        this.valor = valor;
	}

}