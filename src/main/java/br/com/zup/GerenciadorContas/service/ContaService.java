package br.com.zup.GerenciadorContas.service;

import br.com.zup.GerenciadorContas.repository.GerenciamentoContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaService {

    @Autowired
    private GerenciamentoContaRepository gerenciamentoContaRepository;



}
