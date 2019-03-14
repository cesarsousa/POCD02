package br.com.empresa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.empresa.entity.GruRecuperacao;

@Repository
public interface TabelaGruRecuperacaoRepository extends CrudRepository<GruRecuperacao, String>{
	public List<GruRecuperacao> findAll();
	public GruRecuperacao findByNumeroGru(String numeroGru);	

}
