package com.controller;

import java.util.List;

import com.domain.Cliente;
import com.exceptions.ClienteException;
import com.exceptions.ProdutoDuplicadoException;
import com.exceptions.ProdutoNuloException;
import com.impl.repository.ClienteDao;
import com.impl.repository.ProdutoRepositorio;
import com.interfaces.repository.InterfaceCliente;
import com.interfaces.repository.InterfaceProduto;

/*Érica Rodrigues 20/08*/

public class ControleCliente {

	private InterfaceCliente IntCliente;

	public ControleCliente() {
		IntCliente = new ClienteDao();
	}

	public void novoCliente(Cliente c) {
		ClienteDao dados = ClienteDao.obterInstancia();
		dados.novoCliente(c);

	}

	public void updateCliente(Cliente c) throws ClienteException {
		ClienteDao dados = ClienteDao.obterInstancia();
		dados.alterarCliente(c);
	}

	public void deletarCliente(Cliente c) throws ClienteException {
		ClienteDao dados = ClienteDao.obterInstancia();
		dados.deletarCliente(c.getId());
	}

	public List<Cliente> listarContadoCliente(Cliente c)
			throws ClienteException {

		ClienteDao dados = ClienteDao.obterInstancia();
		return dados.listarCliente();
	}

	public boolean login(Cliente clienteParametro) {
		Cliente cliente = null;
		try {
			cliente = ClienteDao.obterInstancia().loginCliente(clienteParametro.getEmail(),clienteParametro.getSenha());
			if(cliente != null){
				return true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
