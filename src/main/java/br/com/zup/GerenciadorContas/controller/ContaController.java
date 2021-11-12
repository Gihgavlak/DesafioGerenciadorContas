package br.com.zup.GerenciadorContas.controller;

import br.com.zup.GerenciadorContas.dto.AtualizarStatusContaDTO;
import br.com.zup.GerenciadorContas.dto.EntradaContaDTO;
import br.com.zup.GerenciadorContas.dto.ExibirEntradaContaDto;
import br.com.zup.GerenciadorContas.dto.SaidaContaDTO;
import br.com.zup.GerenciadorContas.enun.Status;
import br.com.zup.GerenciadorContas.enun.Tipo;
import br.com.zup.GerenciadorContas.exception.StatusInvalidoException;
import br.com.zup.GerenciadorContas.model.GerenciamentoContas;
import br.com.zup.GerenciadorContas.service.ContaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public SaidaContaDTO cadastrarConta(@RequestBody @Valid EntradaContaDTO entradaContaDTO){
        GerenciamentoContas gerenciamentoContas = modelMapper.map(entradaContaDTO, GerenciamentoContas.class);
        return modelMapper.map(contaService.cadastrarConta(gerenciamentoContas),SaidaContaDTO.class);
    }

    @GetMapping
    List<ExibirEntradaContaDto> exibirContas (@RequestParam(required = false) Status status,
                                              @RequestParam(required = false) Tipo tipo,
                                              @RequestParam(required = false) Double valor){
        List<ExibirEntradaContaDto> listaConta = new ArrayList<>();
        for (GerenciamentoContas gerenciamentoContas: contaService.exibirContas()){
            ExibirEntradaContaDto exibirEntradaContaDTO = modelMapper.map(gerenciamentoContas, ExibirEntradaContaDto.class);
            listaConta.add(exibirEntradaContaDTO);
        }
        return listaConta;

    }

    @GetMapping("/{id}")
    public SaidaContaDTO buscarPorId(@PathVariable int id) {
        GerenciamentoContas gerenciamentoContas = contaService.indentificador(id);
        return modelMapper.map(gerenciamentoContas, SaidaContaDTO.class);

    }


    @PutMapping("/id}")
    public SaidaContaDTO atualizarConta (@PathVariable int id, @RequestBody AtualizarStatusContaDTO atualizarStatusContaDTO) {
        if (atualizarStatusContaDTO.getStatus() == Status.PAGO) {
            return modelMapper.map(contaService.atualizarConta(id), SaidaContaDTO.class);
        }
        throw new StatusInvalidoException("Inválido");
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarConta(@PathVariable int id) {
        contaService.deletarConta(id);


    }


}
