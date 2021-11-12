package br.com.zup.GerenciadorContas.exception;

public class StatusInvalidoException extends RuntimeException{
    public StatusInvalidoException (String mensagem){
        super(mensagem);
    }
}
