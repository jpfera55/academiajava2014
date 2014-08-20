package com.interfaces.repository;

import java.util.List;

import com.domain.ContadoCliente;
import com.exceptions.ClienteException;

public interface InterfaceCliente {
	
	
	public void alterarCliente(ContadoCliente cliente) throws ClienteException;
	public void deletarCliente(int cliente) throws ClienteException;
	public List<ContadoCliente> listaDeContadoCliente() throws ClienteException;
	public void novoCliente(ContadoCliente cliente) throws ClienteException;
	
	
}
