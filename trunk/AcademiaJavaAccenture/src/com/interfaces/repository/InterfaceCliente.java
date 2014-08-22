package com.interfaces.repository;

import java.util.List;

import com.domain.Cliente;
import com.exceptions.ClienteException;

public interface InterfaceCliente {
	
	
	public void alterarCliente(Cliente cliente);
	public void deletarCliente(int cliente);
	public List<Cliente> listarCliente() ;
	public void novoCliente(Cliente cliente);
	public Cliente loginCliente(String email, String senha) ;
	
	
}
