package com.fachada;

import java.util.List;

import com.controller.ControleCliente;
import com.domain.ContadoCliente;
import com.exceptions.ClienteException;
import com.exceptions.CompraException;

//Érica Rodrigues 20/08/2014

public class FachadaCliente {
  
	private static FachadaCliente instancia;
	private ControleCliente cliente;
	
	public FachadaCliente(){
		
		cliente = new ControleCliente();
		
	}
	
	public static FachadaCliente getInstancia(){
		
		if(instancia == null){
			
			instancia = new FachadaCliente();
		}
		return instancia;
	}
	
	//Métodos de Contato do cliente
	
	public void novoCliente(ContadoCliente c) throws ClienteException{
		
         cliente.novoCliente(c);
	}
	public void updateCliente(ContadoCliente c) throws ClienteException{
		
		cliente.updateCliente(c);
	} 
	public void deletarCliente(ContadoCliente c) throws ClienteException{
		
		cliente.deletarCliente(c);
		
	}
	public List<ContadoCliente> listarContadoCliente(ContadoCliente c) throws ClienteException{
		
     return cliente.listarContadoCliente(c);
   
	}
}
