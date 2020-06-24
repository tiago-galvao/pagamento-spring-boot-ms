package br.com.tga.microservice.pagamentospringbootms.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.tga.microservice.pagamentospringbootms.exception.dto.Erro;

@RestControllerAdvice
public class ErroFormValidationHandler {
    
    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<Erro> handle(MethodArgumentNotValidException exception){
        List<Erro> erros = new ArrayList<>();
        exception.getBindingResult().getFieldErrors().forEach(e -> {
            String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            Erro erro = new Erro(e.getField(), mensagem);
            erros.add(erro);
        });
        return erros;
    }
}