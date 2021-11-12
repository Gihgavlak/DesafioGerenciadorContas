package br.com.zup.GerenciadorContas.controllerAdvice;

import br.com.zup.GerenciadorContas.exception.MensagemExcecao;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public List<MensagemExcecao> tratarErrosDeValidacao (MethodArgumentNotValidException excecao){
        List<MensagemExcecao> erros = new ArrayList<>();

        for (FieldError referencia : excecao.getFieldErrors()){
            MensagemExcecao mensagemDeErro = new MensagemExcecao(referencia.getDefaultMessage());
            erros.add(mensagemDeErro);
        }

        return erros;
    }

}
