package com.controller;

import java.util.List;

import com.domain.ContadoCliente;
import com.exceptions.ClienteException;
import com.impl.repository.ClienteDao;

/*�rica Rodrigues 20/08*/

public class ControleCliente {


	public void novoCliente(ContadoCliente c) throws ClienteException{
		
		List<ContadoCliente> lista= this.listarContadoCliente(c);
		boolean achou = false;
		
		for(int i = 0; i< lista.size(); i++){
			if (lista.get(i).getEmail() == c.getEmail()){
				achou = true;
				break;
			}
		}
		if(achou == true){
			throw new ClienteException(" Conta Existente! ");
		}
		
		if (c.getEmail() == null && c.getSenha() != null && c.getEndere�o1() == null ) {
			
			throw new ClienteException("Preencha os Campos!!!");
			
		}else{
		
			throw new ClienteException("Conta Criada com Sucesso!!!");
		}
		
		
	}
    public void updateCliente(ContadoCliente c) throws ClienteException{
		
		
		ClienteDao dados = ClienteDao.obterInstancia();
		dados.alterarCliente(c);
	}
    public void deletarCliente(ContadoCliente c) throws ClienteException{
		
		
		ClienteDao dados = ClienteDao.obterInstancia();
		dados.deletarCliente(c.getId());
	}

	public List<ContadoCliente> listarContadoCliente(ContadoCliente c) throws ClienteException {
		
		ClienteDao dados = ClienteDao.obterInstancia();
		return dados.listaDeContadoCliente();
	}
	
	public void loginCliente(ContadoCliente cliente) throws ClienteException {

		List<ContadoCliente> lista= this.listarContadoCliente(cliente);
		boolean achou = false;
	
		 for(int i = 0; i< lista.size(); i++){
			 
			if (lista.get(i).getEmail() == cliente.getEmail() && lista.get(i).getSenha() == cliente.getSenha()) {
				achou = true;
			
				throw new ClienteException("Conexao realizado com Sucesso");	
			}	else{
				throw new ClienteException(" Usuario n�o Encontrato");
			}
			
		}	
	
      
		
	}
		
	
	
}
