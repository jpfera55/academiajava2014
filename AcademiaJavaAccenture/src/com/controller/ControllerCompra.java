package com.controller;

import java.util.List;

import com.domain.Compra;
import com.exceptions.CompraException;
import com.impl.repository.CompraRepositorio;

public class ControllerCompra {

	public void cadastrarCompra(Compra c) throws CompraException{
		
		List<Compra> lista= this.listarCompras(c);
		boolean achou = false;
		
		for(int i = 0; i< lista.size(); i++){
			if (lista.get(i).getIdCarrinho().getIdCarrinho() == c.getIdCarrinho().getIdCarrinho()){
				achou = true;
				break;
			}
			
		}
		
		if(achou == true){
			throw new CompraException("Este carrinho já está na compra.");
		}
		
		if(c.getDesconto() != "NewToGroup" || c.getDesconto() != "Regular" || c.getDesconto() != "Premium"){
			throw new CompraException("Você não tem desconto disponivel.");
		}
		
		
		CompraRepositorio dados = CompraRepositorio.obterInstancia();
		dados.novaCompra(c);
	}
	
	public void updateCompra(Compra c) throws CompraException{
		
		
		
		CompraRepositorio dados = CompraRepositorio.obterInstancia();
		dados.alterarCompra(c);
	}
	
	public void deletarCompra(Compra c) throws CompraException{
		
		
		CompraRepositorio dados = CompraRepositorio.obterInstancia();
		dados.deletarCompra(c.getIdCompra());
	}
	
	public List<Compra> listarCompras(Compra c) throws CompraException{
		
		
		
		CompraRepositorio dados = CompraRepositorio.obterInstancia();
		return dados.listaDeCompra();
	}
	
}
