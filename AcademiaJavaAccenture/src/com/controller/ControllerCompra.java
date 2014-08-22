package com.controller;

import java.util.List;

import com.domain.Compra;
import com.exceptions.CompraException;
import com.impl.repository.CompraRepositorio;

public class ControllerCompra {

	public void cadastrarCompra(Compra compra) throws CompraException{
		
		List<Compra> lista = this.listarCompras(compra);
		boolean achou = false;
		
		for(int i = 0; i< lista.size(); i++){
			if (lista.get(i).getIdCarrinho().codCarrinho() == compra.getIdCarrinho().codCarrinho()){
				achou = true;
				break;
			}
			
		}
		
		if(achou == true){
			throw new CompraException("Este carrinho já está na compra.");
		}
		
		if(compra.getDesconto() != "NewToGroup" || compra.getDesconto() != "Regular" || compra.getDesconto() != "Premium"){
			throw new CompraException("Você não tem desconto disponivel.");
		}
		
		
		CompraRepositorio dados = CompraRepositorio.obterInstancia();
		dados.novaCompra(compra);
	}
	
	public void updateCompra(Compra c) throws CompraException{
		
		
		
		CompraRepositorio dados = CompraRepositorio.obterInstancia();
		dados.alterarCompra(c);
	}
	
	public void deletarCompra(Compra c) throws CompraException{
		
		
		CompraRepositorio dados = CompraRepositorio.obterInstancia();
		dados.deletarCompra(c);
	}
	
	public List<Compra> listarCompras(Compra c) throws CompraException{

		CompraRepositorio dados = CompraRepositorio.obterInstancia();
		return dados.listaDeCompra();
	}
	
}
