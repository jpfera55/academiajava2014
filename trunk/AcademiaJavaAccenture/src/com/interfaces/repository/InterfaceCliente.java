package com.interfaces.repository;

import java.util.List;

import com.domain.ContadoCliente;

public interface InterfaceCliente {
	
	public void inserirCliente(ContadoCliente cliente);
	public void alterarProduto(ContadoCliente cliente);
	public void deletarProduto(int cliente);
	public List<ContadoCliente> listaDeContadoCliente();
	
}
