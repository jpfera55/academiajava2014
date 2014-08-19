package com.domain;

import java.util.List;

import com.impl.repository.ProdutoRepositorio;
import com.interfaces.repository.InterfaceProduto;

//Bruno Monteiro -- 19/08/2014

public class Fachada {
	
	private static Fachada instancia;
	private InterfaceProduto IProduto;
	
	public Fachada(){
		IProduto = new ProdutoRepositorio();
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
	
	public void deletarProduto(int idProduto){
		IProduto.deletarProduto(idProduto);
	}
	
	public void alterarProduto(Produto produto){
		IProduto.alterarProduto(produto);
	}
	
	public List<Produto> listaProduto(){
		return IProduto.listaDeProduto();
	}
	
}
