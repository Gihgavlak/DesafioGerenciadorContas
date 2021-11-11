package br.com.zup.GerenciadorContas.dto;

import br.com.zup.GerenciadorContas.enun.Status;

public class AtualizarStatusContaDTO {

    private Status status;

    public AtualizarStatusContaDTO() {
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
