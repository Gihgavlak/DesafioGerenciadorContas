package br.com.zup.GerenciadorContas.dto;

import br.com.zup.GerenciadorContas.enun.Tipo;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class EntradaContaDTO {
    @Size(min = 3, message = "O nome deve conter 3 caracteres")
    private String nome;
    @DecimalMin(value = "0.01", message = "Digite um valor que tenha 2 depois do ponto e maior que 0")
    private double valor;
    private Tipo tipo;
    @NotNull(message = "Preencha a data de vencimento")
    private LocalDate dataDeVencimento;

    public EntradaContaDTO() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public LocalDate getDataDeVencimento() {
        return dataDeVencimento;
    }

    public void setDataDeVencimento(LocalDate dataDeVencimento) {
        this.dataDeVencimento = dataDeVencimento;
    }

}
