package br.com.zup.GerenciadorContas.repository;

import br.com.zup.GerenciadorContas.model.GerenciamentoContas;
import org.springframework.data.repository.CrudRepository;

public interface GerenciamentoContaRepository extends CrudRepository<GerenciamentoContas, Integer> {

}
