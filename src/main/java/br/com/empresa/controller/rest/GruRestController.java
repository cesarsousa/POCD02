package br.com.empresa.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.empresa.entity.GruRecuperacao;
import br.com.empresa.repository.TabelaGruRecuperacaoRepository;
import br.com.empresa.service.TabelaGruRecuperacaoServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class GruRestController {
	private TabelaGruRecuperacaoRepository repository;

	private TabelaGruRecuperacaoServiceImpl service;

	@Autowired
	public GruRestController(TabelaGruRecuperacaoServiceImpl service, TabelaGruRecuperacaoRepository repository) {
		this.service = service;
		this.repository = repository;
	}

	@GetMapping(value = "/grus", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> findAllGRUs() {
		List<GruRecuperacao> grus = this.repository.findAll();
		return ResponseEntity.ok(grus);
	}

	@GetMapping(value = "/grus/{numeroGru}")
	public ResponseEntity<Object> findByNumero(@PathVariable("numeroGru") String numeroGru) {
		GruRecuperacao gru = this.service.findByNumero(numeroGru);
		return ResponseEntity.ok(gru);
	}

	@PutMapping(value = "/grus/{numeroGru}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateGruRecuparada(@PathVariable("numeroGru") String numeroGru, @RequestParam("codigoNaturezaServico") String codigoNaturezaServico) {
		this.service.atualizarGru(numeroGru, codigoNaturezaServico);
		return ResponseEntity.ok().build();
	}
}
