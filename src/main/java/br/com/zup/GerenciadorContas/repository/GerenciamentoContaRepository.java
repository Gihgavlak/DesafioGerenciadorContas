package br.com.zup.GerenciadorContas.repository;

import br.com.zup.GerenciadorContas.enun.Status;
import br.com.zup.GerenciadorContas.enun.Tipo;
import br.com.zup.GerenciadorContas.model.GerenciamentoContas;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GerenciamentoContaRepository extends CrudRepository<GerenciamentoContas, Integer> {
    List<GerenciamentoContas> findAllByStatus(Status status);

    List<GerenciamentoContas> findAllByTipo(Tipo tipo);


}
