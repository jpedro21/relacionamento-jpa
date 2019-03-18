package com.app.rel.jpa.domain;

import java.util.List;

public class InteresseVaga {
	
	private Vaga vaga;
	private List<Usuario> usuario;
	
	public Vaga getVaga() {
		return vaga;
	}
	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}
	public List<Usuario> getUsuario() {
		return usuario;
	}
	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}
	
	

}
