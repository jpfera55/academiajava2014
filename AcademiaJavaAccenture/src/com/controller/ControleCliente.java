package com.controller;

import java.util.List;

import com.domain.ContadoCliente;
import com.exceptions.ClienteException;
import com.impl.repository.ClienteDao;
import com.impl.repository.ProdutoRepositorio;
import com.interfaces.repository.InterfaceCliente;
import com.interfaces.repository.InterfaceProduto;

/*Érica Rodrigues 20/08*/

public class ControleCliente {
	private InterfaceCliente IntCliente;
	
	public ControleCliente(){
		IntCliente = new ClienteDao();
	}

	public void novoCliente(ContadoCliente c){
		
		
		if (c.getEmail() == null && c.getSenha() != null && c.getEndereço1() == null ) {
			System.out.println("Preencha os Campos!!!");
         }
            else{

		System.out.println("Conta Criada com Sucesso!!!");
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
	
	public boolean login(ContadoCliente cliente) {

		List<ContadoCliente> lista;
		try {
			lista = ClienteDao.obterInstancia().loginCliente();
			 for(int i = 0; i< lista.size(); i++){
				 
					if (lista.get(i).getEmail().equals(cliente.getEmail()) && lista.get(i).getSenha().equals(cliente.getSenha())) {
						
						return true;
					
						//				throw new ClienteException("Conexao realizado com Sucesso");	
					}	else{
						//	throw new ClienteException(" Usuario não Encontrato");
						
					}
				
				}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	
	
		
		return false;	
	
      
		
	}
		
	
	
}
