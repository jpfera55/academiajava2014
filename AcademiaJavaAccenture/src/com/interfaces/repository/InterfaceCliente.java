package com.interfaces.repository;

import java.util.List;

import com.domain.ContadoCliente;
import com.exceptions.ClienteException;

public interface InterfaceCliente {
	
	
	public void alterarCliente(ContadoCliente cliente);
	public void deletarCliente(int cliente);
	public List<ContadoCliente> listaDeContadoCliente() ;
	public void novoCliente(ContadoCliente cliente);
	public List<ContadoCliente> loginCliente() ;
	
	
}
