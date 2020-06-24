package br.com.tga.microservice.pagamentospringbootms.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import br.com.tga.microservice.pagamentospringbootms.model.Pagamento;

public interface PagamentoRepository extends CrudRepository<Pagamento, Long>{
    List<Pagamento> findAllByCartaoId(Long cartao_id);
}