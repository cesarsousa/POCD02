package br.com.empresa.controller.mvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import br.com.empresa.application.TestConfig;
import br.com.empresa.controller.mvc.GruMvcController;
import br.com.empresa.repository.TabelaGruRecuperacaoRepository;
import br.com.empresa.service.TabelaGruRecuperacaoServiceImpl;

@SpringBootTest(classes = TestConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class GruMvcControllerTest {
	private MockMvc mockMvc;
    
    @Autowired
    protected WebApplicationContext wac;
    
    @Autowired
    protected TabelaGruRecuperacaoRepository repository;
    
    @Autowired
    protected TabelaGruRecuperacaoServiceImpl service;
    
    @Autowired
    protected GruMvcController controller;
   
    public GruMvcControllerTest() {}
    
    @Before
    public void setUp() throws Exception {
        this.mockMvc = standaloneSetup(this.controller).build();
    }
    
    @Test
    public void getIndex_successful() throws Exception {
    	mockMvc.perform(get("/")).andExpect(status().is2xxSuccessful());
    }
}

