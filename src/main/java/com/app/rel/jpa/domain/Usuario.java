package com.app.rel.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_user;
	private String nome;
	
	public Usuario(Long id, String nome) {
		this.id_user = id;
		this.nome = nome;
	}
	
	public Usuario() {
		
	}
	
	public Long getIdUser() {
		return id_user;
	}
	public void setIdUser(Long id) {
		this.id_user = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id_user + ", nome=" + nome + "]";
	}
}
