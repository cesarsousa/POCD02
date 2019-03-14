package br.com.empresa.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.empresa.domain.NaturezaServico;
import br.com.empresa.entity.DocumentoPagamento;
import br.com.empresa.entity.GruRecuperacao;
import br.com.empresa.entity.ServicoGuia;
import br.com.empresa.repository.TabelaGruRecuperacaoRepository;

@Service
public class TabelaGruRecuperacaoServiceImpl implements TabelaGruRecuperacaoService {
	private static final String ERR_MSG_COD_NATUREZA_INVALIDO = "Código de natureza inválido.";
	private static final String ERR_MSG_GRU_NAO_CORRESPONDE_SERVICO_DI = "GRU não corresponde ao serviço de DI (Desenho Industrial).";
	private static final String ERR_MSG_GRU_JA_RECUPERADA = "GRU já recuperada.";
	private static final String ERR_MSG_GRU_NAO_ENCONTRADA = "GRU não encontrada";
	private static final String NOME_LOGIN_DEFAULT = "poc_calma";
	
	@Autowired
	TabelaGruRecuperacaoRepository repository;
	
	@Override
	public boolean correspondeServicoDI(GruRecuperacao gru) {
		if(gru == null) {
			return false;
		}
		return gru.getCodigoServico() == 100;
	}

	@Override
	public boolean isGruRecuperada(GruRecuperacao gru) {
		if(gru == null) {
			return false;
		}
		return gru.getDocumentoPagamento() != null && gru.getDocumentoPagamento().getDataRecuperacao() != null;
	}
	
	@Override
	public boolean isNotGruRecuperada(GruRecuperacao gru) {
		return !this.isGruRecuperada(gru);
	}

	@Override
	public void atualizarGru(String numeroGru, String codigoNaturezaServico) {
		GruRecuperacao gru = repository.findByNumeroGru(numeroGru);
		if(gru == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ERR_MSG_GRU_NAO_ENCONTRADA);
		}
		
		if(this.isGruRecuperada(gru)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ERR_MSG_GRU_JA_RECUPERADA);
		}
		
		if(!this.correspondeServicoDI(gru)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ERR_MSG_GRU_NAO_CORRESPONDE_SERVICO_DI);
		}
		
		Integer codNatureza = Integer.parseInt(codigoNaturezaServico);
		NaturezaServico naturezaServico = NaturezaServico.getByCodigo(codNatureza);
		if(naturezaServico == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ERR_MSG_COD_NATUREZA_INVALIDO);
		}
		
		Date dataRecuperacao = new Date();
		Date dataCadastro = new Date();
		DocumentoPagamento documentoPagamento = new DocumentoPagamento(gru.getNumeroGru(), NOME_LOGIN_DEFAULT, naturezaServico.getCodigo(), dataCadastro, dataRecuperacao);
		ServicoGuia servicoGuia = new ServicoGuia(gru.getNumeroGru(), gru.getCodigoServico(), naturezaServico.getCodigo());
		gru.setDocumentoPagamento(documentoPagamento);
		gru.setServicoGuia(servicoGuia);
		repository.save(gru);
	}

	@Override
	public GruRecuperacao findByNumero(String numeroGru) {
		GruRecuperacao gru = repository.findByNumeroGru(numeroGru);
		if (!this.correspondeServicoDI(gru)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ERR_MSG_GRU_NAO_CORRESPONDE_SERVICO_DI);
		} else if (this.isGruRecuperada(gru)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ERR_MSG_GRU_JA_RECUPERADA);
		} else {
			return gru;
		}
	}
}
