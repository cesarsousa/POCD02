package br.com.empresa.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.empresa.application.TestConfig;
import br.com.empresa.entity.DocumentoPagamento;

import org.junit.Assert;

@SpringBootTest(classes = TestConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class DocumentoPagamentoTest {
	private DocumentoPagamento documentoPagamento;
	
	public DocumentoPagamentoTest() {
		this.documentoPagamento = new DocumentoPagamento();
	}
	
	@Test
	public void getNumeroGru() {
		this.documentoPagamento.setNumeroGru("123");
		String numeroGru = this.documentoPagamento.getNumeroGru();
		Assert.assertEquals("123", numeroGru);
	}
	
	@Test
	public void setNumeroGru() {
		this.documentoPagamento.setNumeroGru("123");
		Assert.assertEquals("123", this.documentoPagamento.getNumeroGru());
	}
	
	@Test
	public void getNomeLogin() {
		this.documentoPagamento.setNomeLogin("nomeLogin");
		String nomeLogin= this.documentoPagamento.getNomeLogin();
		Assert.assertEquals("nomeLogin", nomeLogin);
	}

	@Test
	public void setNomeLogin() {
		this.documentoPagamento.setNomeLogin("nomeLogin");
		Assert.assertEquals("nomeLogin", this.documentoPagamento.getNomeLogin());
	}
}
