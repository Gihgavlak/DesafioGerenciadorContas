package br.com.zup.GerenciadorContas.exception;

public class MensagemExcecao {

    private String mensagem;

    public MensagemExcecao(String defaultMessage) {

    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}
