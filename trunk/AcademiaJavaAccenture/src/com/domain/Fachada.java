package com.domain;

public class Fachada {
	private Fachada instancia;
	
	public Fachada getInstancia(){
		if(instancia == null){
			instancia = new Fachada();
		}
		return instancia;
	}
}
