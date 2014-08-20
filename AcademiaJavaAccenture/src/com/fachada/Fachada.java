package com.fachada;

import java.util.List;

import com.domain.Compra;
import com.domain.Produto;
import com.domain.ProdutoCamping;
import com.domain.ProdutoVestuarioEEngrenagem;
import com.exceptions.CompraException;
import com.impl.repository.CompraRepositorio;
import com.impl.repository.ProdutoRepositorio;
import com.interfaces.repository.InterfaceCompra;
import com.interfaces.repository.InterfaceProduto;

//Bruno Monteiro -- 19/08/2014

public class Fachada {
	
	private static Fachada instancia;
	private InterfaceProduto IProduto;
	private InterfaceCompra ICompra;
	
	public Fachada(){
		IProduto = new ProdutoRepositorio();
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
	
	public List<ProdutoCamping> listaProdutoCampings(){
		return IProduto.listaDeProdutoCamping();
	}
	
	public List<ProdutoVestuarioEEngrenagem> listaProdutoVestuarioEEngrenagem(){
		return IProduto.listaDeProdutoVestuarioEEngrenagem();
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
