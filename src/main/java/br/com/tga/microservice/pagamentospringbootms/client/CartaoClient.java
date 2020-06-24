package br.com.tga.microservice.pagamentospringbootms.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "cartao-spring-boot-ms")
public interface CartaoClient {
    
    @GetMapping("cartao/idCartao/{id}")
    public CartaoRequestMs findById(@RequestParam Long id);
    
}