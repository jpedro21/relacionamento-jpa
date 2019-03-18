package com.app.rel.jpa.domain;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Vaga {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private BigDecimal valor;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "residencia_id")
	private Residencia residencia;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "usuario_iduser")
	private Usuario usuario;
	
	public Vaga(Long id, BigDecimal valor, Residencia residencia, Usuario usuario) {
		this.id = id;
		this.valor = valor;
		this.residencia = residencia;
		this.usuario = usuario;
	}
	
	public Vaga(Long id, BigDecimal valor, Usuario usuario) {
		this.id = id;
		this.valor = valor;
		this.usuario = usuario;
	}

	public Vaga() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public Residencia getResidencia() {
		return residencia;
	}
	public void setResidencia(Residencia casa) {
		this.residencia = casa;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Vaga [id=" + id + ", valor=" + valor + ", residencia=" + residencia + ", usuario=" + usuario + "]";
	}
}
