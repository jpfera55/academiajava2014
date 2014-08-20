package com.fachada;

import java.util.List;

import com.controller.ControllerCompra;
import com.controller.ControllerProduto;
import com.domain.Compra;
import com.domain.Produto;
import com.domain.ProdutoCamping;
import com.domain.ProdutoVestuarioEEngrenagem;
import com.exceptions.CompraException;

//Bruno Monteiro -- 19/08/2014

public class Fachada {
	
	private static Fachada instancia;
	private ControllerProduto ControlProduto;
	private ControllerCompra controllerCompra;
	
	public Fachada(){
		ControlProduto = new ControllerProduto();
		controllerCompra = new ControllerCompra();
	}
	
	public static Fachada getInstancia(){
		if(instancia == null){
			instancia = new Fachada();
		}
		return instancia;
	}
	
	//Métodos de Produto
	
	public void inserirProduto(Produto produto){
		ControlProduto.inserirProduto(produto);
	}
	
	public void deletarProduto(Produto produto){
		ControlProduto.deletarProduto(produto);
	}
	
	public void alterarProduto(Produto produto){
		ControlProduto.alterarProduto(produto);
	}
	
	public List<Produto> listaProduto(){
		return ControlProduto.listaDeProduto();
	}
	
	public List<ProdutoCamping> listaProdutoCampings(){
		return ControlProduto.listaDeProdutoCamping();
	}
	
	public List<ProdutoVestuarioEEngrenagem> listaProdutoVestuarioEEngrenagem(){
		return ControlProduto.listaDeProdutoVestuarioEEngrenagem();
	}
	
	public Produto pesquisarProdutoPorNome(String nome){
		return ControlProduto.pesquisarProdutoPeloNome(nome);
	}
	//----
	
	//Métodos de Compra
	
	public void novaCompra(Compra compra) throws CompraException{
		controllerCompra.cadastrarCompra(compra);
	}
	
	public void updateCompra(Compra compra) throws CompraException{
		controllerCompra.updateCompra(compra);
	}
	
	public void removerCompra(Compra compra) throws CompraException{
		controllerCompra.deletarCompra(compra);
	}
	
	public List<Compra> listarCompras(Compra compra) throws CompraException{
		return controllerCompra.listarCompras(compra);
	}
	
}
