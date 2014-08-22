package com.domain;

//Bruno Monteiro -- 18/08/2014

public class ProdutoCamping extends Produto {
	
	private int idCamping;
	private String registroDaAgenciaAmbiental;
	
	public int getIdCamping() {
		return idCamping;
	}

	public void setIdCamping(int idCamping) {
		this.idCamping = idCamping;
	}

	public String getRegistroDaAgenciaAmbiental() {
		return registroDaAgenciaAmbiental;
	}

	public void setRegistroDaAgenciaAmbiental(String registroDaAgenciaAmbiental) {
		this.registroDaAgenciaAmbiental = registroDaAgenciaAmbiental;
	}
	
	
}
