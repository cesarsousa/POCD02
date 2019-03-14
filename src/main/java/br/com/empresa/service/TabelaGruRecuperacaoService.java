package br.com.empresa.service;

import org.springframework.stereotype.Service;

import br.com.empresa.entity.GruRecuperacao;

/**
 * Interface com regras de negocio para validacao e operacoes em GRU
 * @author andre.ghigo
 */
@Service
public interface TabelaGruRecuperacaoService {
	/**
	 * Verifica se a GRU corresponde ao servico de DI (Desenho Industrial)
	 * @param gru objeto de dominio da GRU
	 * @return true, se gru for correspondente. false, caso contrario
	 */
	boolean correspondeServicoDI(GruRecuperacao gru);
	
	/**
	 * Verifica se a GRU foi recuperada
	 * @param gru
	 * @return true, se a GRU foi recuperada. false, caso a GRU não for recuperada.
	 */
	boolean isNotGruRecuperada(GruRecuperacao gru);
	
	/**
	 * Verifica se a GRU não foi recuperada
	 * @param gru
	 * @return true, se a GRU não foi recuperada. false, caso a GRU foi recuperada.
	 */
	boolean isGruRecuperada(GruRecuperacao gru);
	
	/**
	 * Obtem a GRU com base no numero
	 * @param numeroGru
	 * @return Instancia de GRU com base no numero
	 */
	GruRecuperacao findByNumero(String numeroGru);
	
	/**
	 * Atualiza a GRU com o status de recuperado
	 * @param numeroGru numero da GRU que vai ser atualizada
	 * @param codigoNaturezaServico natureza do serviço
	 * @throws Exception 
	 */
	void atualizarGru(String numeroGru, String codigoNaturezaServico);
}
