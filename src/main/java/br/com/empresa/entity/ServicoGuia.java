package br.com.empresa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_SERVICOGUIA")
public class ServicoGuia implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NUMNOSSONUMERO")
	private String numeroGru;
	
	@Column(name="CODSERVICO")
	private Integer codigoServico;
	
	@Column(name="CODNATUREZA")
	private Integer codigoNatureza;
		
	@OneToOne
	@JoinColumn(name = "NUMNOSSONUMERO", referencedColumnName = "NUMNOSSONUMERO")
	private GruRecuperacao gruRecuperacao;

	public ServicoGuia() {
		super();
	}

	public ServicoGuia(String numeroGru, Integer codigoServico, Integer codigoNatureza) {
		super();
		this.numeroGru = numeroGru;
		this.codigoServico = codigoServico;
		this.codigoNatureza = codigoNatureza;
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

	public Integer getCodigoNatureza() {
		return codigoNatureza;
	}

	public void setCodigoNatureza(Integer codigoNatureza) {
		this.codigoNatureza = codigoNatureza;
	}

}
