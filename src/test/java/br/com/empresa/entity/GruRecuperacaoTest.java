package br.com.empresa.entity;

import org.junit.Assert;
import org.junit.Test;

import br.com.empresa.entity.DocumentoPagamento;
import br.com.empresa.entity.GruRecuperacao;
import br.com.empresa.entity.ServicoGuia;

public class GruRecuperacaoTest {
	@Test
	public void noArgsContructorTest() {
		String numeroGru = "123";
		Integer codigoServico = 1;
		DocumentoPagamento documentoPagamento = new DocumentoPagamento();
		ServicoGuia servicoGuia = new ServicoGuia();
		
		GruRecuperacao gru = new GruRecuperacao();
		gru.setNumeroGru(numeroGru);
		gru.setCodigoServico(codigoServico);
		gru.setDocumentoPagamento(documentoPagamento);
		gru.setServicoGuia(servicoGuia);
		
		Assert.assertNotNull(gru);
	}
	
	@Test
	public void allArgsConstructorTest() {
		String numeroGru = "123";
		Integer codigoServico = 1;
		DocumentoPagamento documentoPagamento = new DocumentoPagamento();
		ServicoGuia servicoGuia = new ServicoGuia();
		GruRecuperacao gru = new GruRecuperacao(numeroGru, codigoServico, documentoPagamento, servicoGuia);
		Assert.assertEquals(numeroGru, gru.getNumeroGru());
		Assert.assertEquals(codigoServico, gru.getCodigoServico());
		Assert.assertEquals(documentoPagamento, gru.getDocumentoPagamento());
		Assert.assertEquals(servicoGuia, gru.getServicoGuia());
	}
}
