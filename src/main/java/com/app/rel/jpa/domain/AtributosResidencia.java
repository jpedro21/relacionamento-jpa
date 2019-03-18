package com.app.rel.jpa.domain;

public enum AtributosResidencia {
	
	GARAGEM("Garagem"), COZINHA("Cozinha"), BANHEIRO("Banheiro");
	
	private String atributo;
	
	AtributosResidencia(String valor) {
		this.atributo = valor;
	}
	
	@Override
	public String toString() {
		return this.atributo;
	}

}
