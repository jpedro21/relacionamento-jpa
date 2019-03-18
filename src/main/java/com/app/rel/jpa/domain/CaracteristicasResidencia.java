package com.app.rel.jpa.domain;

public class CaracteristicasResidencia {
	
	private Residencia residencia;
	private AtributosResidencia atributo;
	private String valor;
	
	public Residencia getResidencia() {
		return residencia;
	}
	public void setResidencia(Residencia residencia) {
		this.residencia = residencia;
	}
	public AtributosResidencia getAtributo() {
		return atributo;
	}
	public void setAtributo(AtributosResidencia atributo) {
		this.atributo = atributo;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	
	

}
