package br.com.empresa.service;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.empresa.application.TestConfig;
import br.com.empresa.entity.DocumentoPagamento;
import br.com.empresa.entity.GruRecuperacao;
import br.com.empresa.entity.ServicoGuia;
import br.com.empresa.service.TabelaGruRecuperacaoServiceImpl;


@SpringBootTest(classes = TestConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TabelaGruRecuperacaoServiceImplTest {
	@Autowired
	private TabelaGruRecuperacaoServiceImpl service;
	
	@Test
	public void validarCorrespondeServicoDI_sucesso() {
		GruRecuperacao gru = new GruRecuperacao();
		gru.setCodigoServico(100);
		gru.setNumeroGru("123");
		
		boolean result = service.correspondeServicoDI(gru);
		
		Assert.assertTrue(result);
	}
	
	@Test
	public void validarCorrespondeServicoDI_falso() {
		GruRecuperacao gru = new GruRecuperacao();
		gru.setCodigoServico(200);
		gru.setNumeroGru("111");
		
		boolean result = service.correspondeServicoDI(gru);
		
		Assert.assertFalse(result);
	}
	
	@Test
	public void validarCorrespondeServicoDI_nulo() {
		boolean result = service.correspondeServicoDI(null);
		
		Assert.assertFalse(result);
	}
	
	@Test
	public void isGruRecuperada_gruIsNull() {
		boolean result = service.isGruRecuperada(null);
		Assert.assertFalse(result);
	}

	@Test
	public void isGruRecuperada_documentoPagamentoIsNull() {
		GruRecuperacao gru = new GruRecuperacao();
		gru.setDocumentoPagamento(null);
		boolean result = service.isGruRecuperada(gru);
		Assert.assertFalse(result);
	}
	
	@Test
	public void isGruRecuperada_true() {
		final GruRecuperacao gru = generateMockGruRecuperacao();
		final boolean result = service.isGruRecuperada(gru);
		Assert.assertTrue(result);
	}

	@Test
	public void isGruRecuperada_false_documentoPagamentoNulo() {
		final GruRecuperacao gru = generateMockGruRecuperacao();
		gru.setDocumentoPagamento(null);
		final boolean result = service.isGruRecuperada(gru);
		Assert.assertFalse(result);
	}
	
	@Test
	public void isGruRecuperada_false_dataRecuperacaoNulo() {
		final GruRecuperacao gru = generateMockGruRecuperacao();
		gru.getDocumentoPagamento().setDataRecuperacao(null);
		final boolean result = service.isGruRecuperada(gru);
		Assert.assertFalse(result);
	}
	
	@Test
	public void isGruRecuperada_false() {
		final GruRecuperacao gru = generateMockGruRecuperacao();
		gru.setDocumentoPagamento(null);
		final boolean result = service.isGruRecuperada(gru);
		Assert.assertFalse(result);
	}
	
	private static GruRecuperacao generateMockGruRecuperacao() {
		final DocumentoPagamento documentoPagamento = generateDocumentoPagamento();
		final int codigoServico = 111;
		final ServicoGuia servicoGuia = new ServicoGuia();
		return new GruRecuperacao(null, codigoServico, documentoPagamento, servicoGuia);
	}
	
	private static DocumentoPagamento generateDocumentoPagamento() {
		final Date dataCadastro = new Date();
		final Date dataRecuperacao = new Date();
		final String numeroGru = "123";
		final String nomeLogin = "nomeLogin";
		final int codigoCliente = 111;
		return new DocumentoPagamento(numeroGru, nomeLogin, codigoCliente, dataCadastro, dataRecuperacao);
	}
}
