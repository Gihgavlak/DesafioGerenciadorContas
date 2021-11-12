package br.com.zup.GerenciadorContas.controller;

import br.com.zup.GerenciadorContas.dto.EntradaContaDTO;
import br.com.zup.GerenciadorContas.dto.SaidaContaDTO;
import br.com.zup.GerenciadorContas.model.GerenciamentoContas;
import br.com.zup.GerenciadorContas.service.ContaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    ContaService contaService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SaidaContaDTO cadastrarConta(@RequestBody EntradaContaDTO entradaContaDTO){
        GerenciamentoContas gerenciamentoContas = modelMapper.map(entradaContaDTO, GerenciamentoContas.class);
        return modelMapper.map(contaService.cadastrarConta(gerenciamentoContas),SaidaContaDTO.class);
    }

}
