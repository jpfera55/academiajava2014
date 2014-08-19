package com.fachada;

import java.util.List;

import com.domain.Compra;
import com.domain.Produto;
import com.domain.ProdutoCamping;
import com.domain.ProdutoVestuarioEEngrenagem;
import com.exceptions.CompraException;
import com.impl.repository.CompraRepositorio;
import com.impl.repository.ProdutoCampingRepositorio;
import com.impl.repository.ProdutoRepositorio;
import com.interfaces.repository.InterfaceCompra;
import com.interfaces.repository.InterfaceProduto;
import com.interfaces.repository.InterfaceProdutoCamping;

//Bruno Monteiro -- 19/08/2014

public class Fachada {
	
	private static Fachada instancia;
	private InterfaceProduto IProduto;
	private InterfaceProdutoCamping IProdutoCamping;
	private InterfaceCompra ICompra;
	
	public Fachada(){
		IProduto = new ProdutoRepositorio();
		IProdutoCamping = new ProdutoCampingRepositorio();
		ICompra = new CompraRepositorio();
		
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
		if (produto instanceof ProdutoCamping){
			produto.setIdProduto(ProdutoRepositorio.chavePrimariaInserida);
			IProdutoCamping.inserirProdutoCamping((ProdutoCamping) produto);
		}else if (produto instanceof ProdutoVestuarioEEngrenagem){
			
		}
	}
	
	public void deletarProduto(Produto produto){
		if (produto instanceof ProdutoCamping){
			IProdutoCamping.deletarProdutoCamping((ProdutoCamping) produto);
		}else if (produto instanceof ProdutoVestuarioEEngrenagem){
			
		}
		
		IProduto.deletarProduto(produto);
	}
	
	public void alterarProduto(Produto produto){
		IProduto.alterarProduto(produto);
		if(produto instanceof ProdutoCamping){
			IProdutoCamping.alterarProdutoCamping((ProdutoCamping) produto);
		}else if(produto instanceof ProdutoVestuarioEEngrenagem){
			
		}
	}
	
	public List<Produto> listaProduto(){
		return IProduto.listaDeProduto();
	}
	
	public List<ProdutoCamping> listaProdutoCamping(){
		return IProdutoCamping.listaDeProdutoCamping();
	}
	
	//----
	
	//Métodos de Compra
	
	public void novaCompra(Compra compra) throws CompraException{
		ICompra.novaCompra(compra);
	}
	
	public void updateCompra(Compra compra) throws CompraException{
		ICompra.alterarCompra(compra);
	}
	
	public void removerCompra(Compra compra) throws CompraException{
		ICompra.deletarCompra(compra.getIdCompra());
	}
	
	public List<Compra> listarCompras(Compra compra) throws CompraException{
		return ICompra.listaDeCompra();
	}
	
}
