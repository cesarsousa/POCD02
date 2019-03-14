package br.com.empresa.controller.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import br.com.empresa.application.TestConfig;
import br.com.empresa.controller.rest.GruRestController;
import br.com.empresa.entity.DocumentoPagamento;
import br.com.empresa.entity.GruRecuperacao;
import br.com.empresa.entity.ServicoGuia;
import br.com.empresa.repository.TabelaGruRecuperacaoRepository;
import br.com.empresa.service.TabelaGruRecuperacaoServiceImpl;

@SpringBootTest(classes = TestConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class GruRestControllerTest {
	private MockMvc mockMvc;
    
    @Autowired
    protected WebApplicationContext wac;
    
    @Autowired
    protected TabelaGruRecuperacaoRepository repository;
    
    @Autowired
    protected TabelaGruRecuperacaoServiceImpl service;
    
    @Autowired
    protected GruRestController GRUController;
    
    private static final Date DATA_CADASTRO = new Date();
    private static final Date DATA_RECUPERACAO = new Date();
   
    private static final Integer CODIGO_CLIENTE = 123;
    private static final Integer CODIGO_SERVICO = 100;
    private static final Integer CODIGO_NATUREZA = 2;
    
    private static final String NOME_LOGIN = "USUARIO";
    private static final String NUMERO_GRU_RECUPERADA = "222";
    private static final String NUMERO_GRU_NAO_RECUPERADA = "555";
    
    public GruRestControllerTest() {}
    
    @Before
    public void setup() throws Exception {
        this.mockMvc = standaloneSetup(this.GRUController).build();
        this.criarGruRecuperada();
        this.criarGruNaoRecuperada();
    }
    
    private void criarGruRecuperada() {
    	GruRecuperacao gruRecuperacao = new GruRecuperacao();
        gruRecuperacao.setCodigoServico(CODIGO_SERVICO);
        gruRecuperacao.setNumeroGru(NUMERO_GRU_RECUPERADA);
        DocumentoPagamento documentoPagamento = new DocumentoPagamento(NUMERO_GRU_RECUPERADA, NOME_LOGIN, CODIGO_CLIENTE, DATA_CADASTRO, DATA_RECUPERACAO);
        gruRecuperacao.setDocumentoPagamento(documentoPagamento);
        ServicoGuia servicoGuia = new ServicoGuia(NUMERO_GRU_RECUPERADA, CODIGO_SERVICO, CODIGO_NATUREZA);
        gruRecuperacao.setServicoGuia(servicoGuia);
        this.repository.save(gruRecuperacao);
    }
    
    private void criarGruNaoRecuperada() {
    	GruRecuperacao gruRecuperacao = new GruRecuperacao();
        gruRecuperacao.setCodigoServico(CODIGO_SERVICO);
        gruRecuperacao.setNumeroGru(NUMERO_GRU_NAO_RECUPERADA);
        DocumentoPagamento documentoPagamento = new DocumentoPagamento(NUMERO_GRU_NAO_RECUPERADA, NOME_LOGIN, CODIGO_CLIENTE, DATA_CADASTRO, null);
        gruRecuperacao.setDocumentoPagamento(documentoPagamento);
        ServicoGuia servicoGuia = new ServicoGuia(NUMERO_GRU_NAO_RECUPERADA, CODIGO_SERVICO, CODIGO_NATUREZA);
        gruRecuperacao.setServicoGuia(servicoGuia);
        this.repository.save(gruRecuperacao);
    }
    
    @Test
    public void findAllGRUs_successful() throws Exception {
        mockMvc.perform(get("/grus").contentType(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful());
    }
    
    @Test
    public void findByNumero_successful() throws Exception {
    	mockMvc.perform(get("/grus/" + NUMERO_GRU_NAO_RECUPERADA).contentType(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful());
    }
    
    @Test
    public void findByNumero_badRequest() throws Exception {
    	mockMvc.perform(get("/grus/" + NUMERO_GRU_RECUPERADA).contentType(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful());
    }
    
    @Test
    public void findByNumero_NotFound() throws Exception {
    	mockMvc.perform(get("/grus/0").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());
    }
    
    @Test
    public void updateGruRecuparada_successful() throws Exception {
    	mockMvc.perform(put("/grus/" + NUMERO_GRU_NAO_RECUPERADA + "?codigoNaturezaServico=1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful());
    }
    
    @Test
    public void updateGruRecuperada_badRequest() throws Exception {
    	mockMvc.perform(put("/grus/0").contentType(MediaType.APPLICATION_JSON)).andExpect(status().is(HttpStatus.BAD_REQUEST.value()));
    }
}

