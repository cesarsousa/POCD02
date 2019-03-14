package br.com.empresa.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_DOCPAGAMENTO")
public class DocumentoPagamento implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NUMNOSSONUMERO")
	private String numeroGru;
	
	@Column(name="NM_LOGIN")
	private String nomeLogin;
	
	@Column(name="CODCLIENTE")
	private Integer codigoCliente;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DH_RECUPERACAO")
	private Date dataRecuperacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATCADASTRO")
	private Date dataCadastro;
	
	@OneToOne
	@JoinColumn(name = "NUMNOSSONUMERO", referencedColumnName = "NUMNOSSONUMERO")
	private GruRecuperacao gruRecuperacao;

	public DocumentoPagamento() {
		super();
	}

	public DocumentoPagamento(String numeroGru, String nomeLogin, Integer codigoCliente, Date dataCadastro, Date dataRecuperacao) {
		super();
		this.numeroGru = numeroGru;
		this.nomeLogin = nomeLogin;
		this.codigoCliente = codigoCliente;
		this.dataCadastro = dataCadastro;
		this.dataRecuperacao = dataRecuperacao;
	}

	public String getNumeroGru() {
		return numeroGru;
	}

	public void setNumeroGru(String numeroGru) {
		this.numeroGru = numeroGru;
	}

	public String getNomeLogin() {
		return nomeLogin;
	}

	public void setNomeLogin(String nomeLogin) {
		this.nomeLogin = nomeLogin;
	}

	public Date getDataRecuperacao() {
		return dataRecuperacao;
	}

	public void setDataRecuperacao(Date dataRecuperacao) {
		this.dataRecuperacao = dataRecuperacao;
	}

}
