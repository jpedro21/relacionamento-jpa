package com.app.rel.jpa.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Residencia {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cep;
	private String estado;
	private String cidade;
	private String rua;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="vagas_id")
	private List<Vaga> vagas;

	public Residencia(Long id, String cep, String estado, String cidade, String rua) {
		this.id = id;
		this.cep = cep;
		this.estado = estado;
		this.cidade = cidade;
		this.rua = rua;
	}
	
	
	
	public Residencia(Long id, String cep, String estado, String cidade, String rua, List<Vaga> vagas) {
		this.id = id;
		this.cep = cep;
		this.estado = estado;
		this.cidade = cidade;
		this.rua = rua;
		this.vagas = vagas;
	}

	public Residencia() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public List<Vaga> getVagas() {
		return vagas;
	}
	public void setVagas(List<Vaga> vagas) {
		this.vagas = vagas;
	}

	@Override
	public String toString() {
		return "Residencia [id=" + id + ", cep=" + cep + ", estado=" + estado + ", cidade=" + cidade + ", rua=" + rua
				+ "]";
	}
}
