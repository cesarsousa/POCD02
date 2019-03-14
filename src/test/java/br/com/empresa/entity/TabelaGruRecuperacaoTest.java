package br.com.empresa.entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.empresa.application.TestConfig;
import br.com.empresa.entity.GruRecuperacao;

@SpringBootTest(classes = TestConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TabelaGruRecuperacaoTest {
	private GruRecuperacao gru;
	private GruRecuperacao gru2;
	
	private static final String NUMERO_GRU = "123";
	private static final int CODIGO_SERVICO = 100;
	
	@Before
	public void setUp() {
		this.gru2 = new GruRecuperacao();
		this.gru2.setCodigoServico(CODIGO_SERVICO);
		this.gru2.setNumeroGru(NUMERO_GRU);
		this.gru = new GruRecuperacao(NUMERO_GRU, CODIGO_SERVICO);
	}
	
	@Test
	public void getNumeroGru_successful() {
		String numeroGru = gru.getNumeroGru();
		Assert.assertEquals(NUMERO_GRU, numeroGru);
	}

	@Test
	public void setNumeroGru_successful() {
		gru.setNumeroGru(NUMERO_GRU);
		Assert.assertEquals(NUMERO_GRU, gru.getNumeroGru());
	}

	@Test
	public void getCodigoServico_successful() {
		int codigoServico = gru.getCodigoServico();
		Assert.assertEquals(CODIGO_SERVICO, codigoServico);
	}
	
	@Test
	public void setCodigoServico_successful() {
		gru.setCodigoServico(CODIGO_SERVICO);
		int codigoServico = gru.getCodigoServico();
		Assert.assertEquals(CODIGO_SERVICO, codigoServico);
	}
}
