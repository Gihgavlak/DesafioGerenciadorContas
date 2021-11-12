package br.com.zup.GerenciadorContas.controllerAdvice;

import br.com.zup.GerenciadorContas.exception.IdNaoEnctrdoException;
import br.com.zup.GerenciadorContas.exception.MensagemExcecao;
import br.com.zup.GerenciadorContas.exception.StatusInvalidoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
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
            MensagemExcecao mensagem = new MensagemExcecao(referencia.getDefaultMessage());
            erros.add(mensagem);
        }

        return erros;
    }

    @ExceptionHandler(StatusInvalidoException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public MensagemExcecao statusInvalidoException(StatusInvalidoException excecao) {
        return new MensagemExcecao(excecao.getLocalizedMessage());
    }

    @ExceptionHandler(IdNaoEnctrdoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MensagemExcecao idNaoEncontradoException(IdNaoEnctrdoException excecao) {
        return new MensagemExcecao(excecao.getLocalizedMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MensagemExcecao enumInvalidoException(HttpMessageNotReadableException excecao) {
        return new MensagemExcecao(excecao.getLocalizedMessage());
    }


}
