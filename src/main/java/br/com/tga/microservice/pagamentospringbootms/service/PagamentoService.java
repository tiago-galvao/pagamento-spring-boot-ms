package br.com.tga.microservice.pagamentospringbootms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tga.microservice.pagamentospringbootms.client.CartaoClient;
import br.com.tga.microservice.pagamentospringbootms.exception.CartaoNotFoundException;
import br.com.tga.microservice.pagamentospringbootms.model.Pagamento;
import br.com.tga.microservice.pagamentospringbootms.model.create.CreatePagamentoRequest;
import br.com.tga.microservice.pagamentospringbootms.model.create.CreatePagamentoResponse;
import br.com.tga.microservice.pagamentospringbootms.repository.PagamentoRepository;
import feign.FeignException;

@Service
public class PagamentoService {
    
    @Autowired
    private CartaoClient cartaoClient;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Transactional
    public CreatePagamentoResponse create(final CreatePagamentoRequest createPagamentoRequest) {

        try {
            cartaoClient.findById(createPagamentoRequest.getCartaoId());
            final Pagamento pagamento = new Pagamento();
            
            pagamento.setCartaoId(createPagamentoRequest.getCartaoId());
            pagamento.setDescricao(createPagamentoRequest.getDescricao());
            pagamento.setValor(createPagamentoRequest.getValor());
            return new CreatePagamentoResponse(pagamentoRepository.save(pagamento));

        } catch (final FeignException.NotFound e) {
            throw new CartaoNotFoundException();
        }
    }

    public List<CreatePagamentoResponse> listByCartao(Long cartaoId) {
        cartaoClient.findById(cartaoId);
        return CreatePagamentoResponse.convertList(pagamentoRepository.findAllByCartaoId(cartaoId));
    }
}