package com.domain;

//Bruno Monteiro -- 18/08/2014

public class ProdutoCamping extends Produto {
	
	private String registroDaAgenciaAmbiental;
	private int idProdutoCamping;
	
	public int getIdProdutoCamping() {
		return idProdutoCamping;
	}

	public void setIdProdutoCamping(int idProdutoCamping) {
		this.idProdutoCamping = idProdutoCamping;
	}

	public String getRegistroDaAgenciaAmbiental() {
		return registroDaAgenciaAmbiental;
	}

	public void setRegistroDaAgenciaAmbiental(String registroDaAgenciaAmbiental) {
		this.registroDaAgenciaAmbiental = registroDaAgenciaAmbiental;
	}
	
	
}
