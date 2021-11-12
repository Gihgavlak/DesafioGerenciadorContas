package br.com.zup.GerenciadorContas.service;

import br.com.zup.GerenciadorContas.enun.Status;
import br.com.zup.GerenciadorContas.model.GerenciamentoContas;
import br.com.zup.GerenciadorContas.repository.GerenciamentoContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

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


}
