package br.com.zup.GerenciadorContas.service;

import br.com.zup.GerenciadorContas.enun.Status;
import br.com.zup.GerenciadorContas.enun.Tipo;
import br.com.zup.GerenciadorContas.exception.IdNaoEnctrdoException;
import br.com.zup.GerenciadorContas.model.GerenciamentoContas;
import br.com.zup.GerenciadorContas.repository.GerenciamentoContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ContaService {

    @Autowired
    private GerenciamentoContaRepository gerenciamentoContaRepository;

    public GerenciamentoContas cadastrarConta(GerenciamentoContas gerenciamentoContas){
        if (gerenciamentoContas.getDataDeVencimento().isBefore(LocalDate.now())){
            gerenciamentoContas.setStatus(Status.VENCIDA);
        }else{
            gerenciamentoContas.setStatus(Status.AGUARDANDO);
        }
        return gerenciamentoContaRepository.save(gerenciamentoContas);
    }

    public List<GerenciamentoContas> exibirContas(){
        List<GerenciamentoContas> gerenciamentoContas = (List<GerenciamentoContas>) gerenciamentoContaRepository.findAll();
        return gerenciamentoContas;
    }

    public GerenciamentoContas indentificador (int id){
        Optional<GerenciamentoContas> gerenciamentoContas = gerenciamentoContaRepository.findById(id);
        if (gerenciamentoContas.isEmpty()){
            throw new IdNaoEnctrdoException("Inválido, não foi encontrado");

        }
        return gerenciamentoContas.get();
    }

    public GerenciamentoContas atualizarConta (int id) {
        GerenciamentoContas gerenciamentoContas = indentificador(id);
        gerenciamentoContas.setDataDePagamento(LocalDateTime.now());
        gerenciamentoContas.setStatus(Status.PAGO);
        gerenciamentoContaRepository.save(gerenciamentoContas);
        return gerenciamentoContas;

    }

    public void deletarConta(int id) {
        if (gerenciamentoContaRepository.existsById(id)) {
            gerenciamentoContaRepository.deleteById(id);
        } else {
            throw new IdNaoEnctrdoException("Cadastro não encontrado!");
        }

    }

    public List<GerenciamentoContas> aplicarFiltros(Status status, Tipo tipo) {
        if (status != null) {
            return gerenciamentoContaRepository.findAllByStatus(status);
        } else if (tipo != null) {
            return gerenciamentoContaRepository.findAllByTipo(tipo);
        }
        List<GerenciamentoContas> gerenciamentoContas = (List<GerenciamentoContas>) gerenciamentoContaRepository.findAll();
        return gerenciamentoContas;
    }

}
