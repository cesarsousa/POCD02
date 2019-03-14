package br.com.empresa.entity;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.empresa.application.TestConfig;
import br.com.empresa.entity.ServicoGuia;

@SpringBootTest(classes = TestConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ServicoGuiaTest {
	private ServicoGuia servicoGuia;
	
	public ServicoGuiaTest() {
		this.servicoGuia = new ServicoGuia("213", 100, 2);
	}
	
	@Test
	public void getNumeroGru() {
		this.servicoGuia.setNumeroGru("111");
		String numeroGru = this.servicoGuia.getNumeroGru();
		Assert.assertEquals("111", numeroGru);
	}
	
	@Test
	public void setNumeroGru() {
		this.servicoGuia.setNumeroGru("222");
		Assert.assertEquals("222", this.servicoGuia.getNumeroGru());
	}
	
	@Test
	public void getCodigoServico() {
		this.servicoGuia.setCodigoServico(100);
		int codigoServico = this.servicoGuia.getCodigoServico();
		Assert.assertEquals(100, codigoServico);
	}

	@Test
	public void setCodigoServico() {
		this.servicoGuia.setCodigoServico(200);
		int codigoServico = this.servicoGuia.getCodigoServico();
		Assert.assertEquals(200, codigoServico);
	}

	@Test
	public void getCodigoNatureza() {
		this.servicoGuia.setCodigoNatureza(1);
		int codigoNatureza = this.servicoGuia.getCodigoNatureza();
		Assert.assertEquals(1, codigoNatureza);
	}
	
	@Test
	public void setCodigoNatureza() {
		this.servicoGuia.setCodigoNatureza(2);
		int codigoNatureza = this.servicoGuia.getCodigoNatureza();
		Assert.assertEquals(2, codigoNatureza);
	}
}
