package br.com.tga.microservice.pagamentospringbootms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.tga.microservice.pagamentospringbootms.model.create.CreatePagamentoRequest;
import br.com.tga.microservice.pagamentospringbootms.model.create.CreatePagamentoResponse;
import br.com.tga.microservice.pagamentospringbootms.service.PagamentoService;

@RestController
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping("/pagamento")
    public CreatePagamentoResponse create(@RequestBody @Valid CreatePagamentoRequest createPagamentoRequest) {
        return pagamentoService.create(createPagamentoRequest);
    }

    @GetMapping("/pagamentos/{cartaoId}")
    public List<CreatePagamentoResponse> listByCartao(@PathVariable Long cartaoId) {
        return pagamentoService.listByCartao(cartaoId);
    }
    
}