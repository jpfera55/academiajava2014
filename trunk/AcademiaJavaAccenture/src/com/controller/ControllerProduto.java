package com.controller;

import java.util.List;

import com.domain.Produto;
import com.domain.ProdutoCamping;
import com.domain.ProdutoVestuarioEEngrenagem;
import com.exceptions.ProdutoDuplicadoException;
import com.exceptions.ProdutoNaoLocalizadoException;
import com.exceptions.ProdutoNuloException;
import com.impl.repository.ProdutoRepositorio;
import com.interfaces.repository.InterfaceProduto;

//Bruno Monteiro -- 20/08/2014

public class ControllerProduto {

	private InterfaceProduto IRepProduto;
	
	public ControllerProduto(){
		IRepProduto = new ProdutoRepositorio();
	}
	
	public void inserirProduto(Produto produto) {
		try {
			if(verificarDuplicidadeProduto(produto.getNomeProduto()) && verificarSeProdutoNaoENulo(produto)){
				IRepProduto.inserirProduto(produto);
			}
		} catch (ProdutoDuplicadoException e) {
			System.out.println(e.getMessage());
		} catch (ProdutoNuloException e1){
			System.out.println(e1.getMessage());
		}
	}
	
	public void alterarProduto(Produto produto){
		try {
			if(verificarDuplicidadeProduto(produto.getNomeProduto()) && verificarSeProdutoNaoENulo(produto)){
				IRepProduto.alterarProduto(produto);
			}
		} catch (ProdutoDuplicadoException e) {
			System.out.println(e.getMessage());
		} catch (ProdutoNuloException e1) {
			System.out.println(e1.getMessage());
		}
	}
	
	public void deletarProduto(Produto produto){
		try {
			if(verificarSeProdutoNaoENulo(produto)){
				IRepProduto.deletarProduto(produto);
			}
		} catch (ProdutoNuloException e) {
			System.out.println(e.getMessage());
		}
	}

	public List<Produto> listaDeProduto(){
		return IRepProduto.listaDeProduto();
	}
	
	public List<ProdutoCamping> listaDeProdutoCamping(){
		return IRepProduto.listaDeProdutoCamping();
	}
	
	public List<ProdutoVestuarioEEngrenagem> listaDeProdutoVestuarioEEngrenagem(){
		return IRepProduto.listaDeProdutoVestuarioEEngrenagem();
	}
	
	public Produto pesquisarProdutoPeloNome(String nome){
		return IRepProduto.pesquisarProdutoPeloNome(nome);
	}
	
	//M�todos auxiliares das valida��es
	
	public boolean verificarSeProdutoNaoENulo(Produto produto) throws ProdutoNuloException{
		if(produto == null){
			throw new ProdutoNuloException("Preencha os campos para poder cadastrar o produto!");
		}
		return true;
	}
	
	public boolean verificarSeExisteProduto(String nome) throws ProdutoNaoLocalizadoException{
		Produto produto = IRepProduto.pesquisarProdutoPeloNome(nome);
		if(produto == null){
			throw new ProdutoNaoLocalizadoException("Produto n�o existe na base, por favor verificar se o produto pesquisado realmente existe!");
		}
		return true;
	}
	
	public boolean verificarDuplicidadeProduto(String nome) throws ProdutoDuplicadoException{
		Produto produto = IRepProduto.pesquisarProdutoPeloNome(nome);
		if((produto.getNomeProduto()).toUpperCase() == (nome).toUpperCase()){
			throw new ProdutoDuplicadoException("Preencha os campos para poder cadastrar o produto!");
		}
		
		return true;
	}
	
}