package com.fachada;

import java.util.List;

import com.domain.Produto;
import com.domain.ProdutoCamping;
import com.impl.repository.ProdutoCampingRepositorio;
import com.impl.repository.ProdutoRepositorio;
import com.interfaces.repository.InterfaceProduto;
import com.interfaces.repository.InterfaceProdutoCamping;

//Bruno Monteiro -- 19/08/2014

public class Fachada {
	
	private static Fachada instancia;
	private InterfaceProduto IProduto;
	private InterfaceProdutoCamping IProdutoCamping;
	
	public Fachada(){
		IProduto = new ProdutoRepositorio();
		IProdutoCamping = new ProdutoCampingRepositorio();
		
	}
	
	public static Fachada getInstancia(){
		if(instancia == null){
			instancia = new Fachada();
		}
		return instancia;
	}
	
	//Métodos de Produto
	
	public void inserirProduto(Produto produto){
		IProduto.inserirProduto(produto);
	}
	
	public void deletarProduto(Produto produto){
		IProduto.deletarProduto(produto);
	}
	
	public void alterarProduto(Produto produto){
		IProduto.alterarProduto(produto);
	}
	
	public List<Produto> listaProduto(){
		return IProduto.listaDeProduto();
	}
	
	public void inserirProduto(ProdutoCamping produto){
		IProdutoCamping.inserirProdutoCamping(produto);
	}
	
	public void deletarProduto(ProdutoCamping produto){		
		IProdutoCamping.deletarProdutoCamping(produto);
	}
	
	public void alterarProduto(ProdutoCamping produto){
		IProdutoCamping.alterarProdutoCamping(produto);
	}
	
	public List<ProdutoCamping> listaProdutoCamping(){
		return IProdutoCamping.listaDeProdutoCamping();
	}
	
	//----
	
}
