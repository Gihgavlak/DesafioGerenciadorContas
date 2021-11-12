package br.com.zup.GerenciadorContas.controller;

import br.com.zup.GerenciadorContas.dto.AtualizarStatusContaDTO;
import br.com.zup.GerenciadorContas.dto.EntradaContaDTO;
import br.com.zup.GerenciadorContas.dto.ExibirEntradaContaDto;
import br.com.zup.GerenciadorContas.dto.SaidaContaDTO;
import br.com.zup.GerenciadorContas.model.GerenciamentoContas;
import br.com.zup.GerenciadorContas.service.ContaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping
    List<ExibirEntradaContaDto> exibirContas (){
        List<ExibirEntradaContaDto> listaConta = new ArrayList<>();
        for (GerenciamentoContas gerenciamentoContas: contaService.exibirContas()){
            ExibirEntradaContaDto exibirEntradaContaDTO = modelMapper.map(gerenciamentoContas, ExibirEntradaContaDto.class);
            listaConta.add(exibirEntradaContaDTO);
        }
        return listaConta;

    }

    @PutMapping("{id}")
    public SaidaContaDTO atualizarConta (int id, @RequestBody AtualizarStatusContaDTO atualizarStatusContaDTO){
        return modelMapper.map(contaService.atualizarConta(id), SaidaContaDTO.class);
    }

}
