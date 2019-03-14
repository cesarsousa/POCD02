package br.com.empresa.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_GRU_RECUPERACAO")
public class GruRecuperacao implements Serializable {	
	private static final long serialVersionUID = 2L;

	@Id
	@Column(name="NU_GRU")
	private String numeroGru;
	
	@Column(name="CD_SERVICO")
	private Integer codigoServico;
	
	@OneToOne(mappedBy="gruRecuperacao", cascade = CascadeType.PERSIST,  fetch = FetchType.EAGER)
	private DocumentoPagamento documentoPagamento;
	
	@OneToOne(mappedBy="gruRecuperacao", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private ServicoGuia servicoGuia;

	public GruRecuperacao() {
		super();
	}

	public GruRecuperacao(String numeroGru, Integer codigoServico, DocumentoPagamento documentoPagamento, ServicoGuia servicoGuia) {
		super();
		this.numeroGru = numeroGru;
		this.codigoServico = codigoServico;
		this.documentoPagamento = documentoPagamento;
		this.servicoGuia = servicoGuia;
	}

	public GruRecuperacao(String numeroGru, Integer codigoServico) {
		this.numeroGru = numeroGru;
		this.codigoServico = codigoServico;
	}

	public String getNumeroGru() {
		return numeroGru;
	}

	public void setNumeroGru(String numeroGru) {
		this.numeroGru = numeroGru;
	}

	public Integer getCodigoServico() {
		return codigoServico;
	}

	public void setCodigoServico(Integer codigoServico) {
		this.codigoServico = codigoServico;
	}

	public DocumentoPagamento getDocumentoPagamento() {
		return documentoPagamento;
	}

	public void setDocumentoPagamento(DocumentoPagamento documentoPagamento) {
		this.documentoPagamento = documentoPagamento;
	}

	public ServicoGuia getServicoGuia() {
		return servicoGuia;
	}

	public void setServicoGuia(ServicoGuia servicoGuia) {
		this.servicoGuia = servicoGuia;
	}
}
