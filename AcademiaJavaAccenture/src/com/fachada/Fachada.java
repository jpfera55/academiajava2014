package com.fachada;

import java.util.List;

import com.controller.ControleCliente;
import com.controller.ControllerCompra;
import com.controller.ControllerProduto;
import com.domain.Compra;
import com.domain.ContadoCliente;
import com.domain.Produto;
import com.domain.ProdutoCamping;
import com.domain.ProdutoVestuarioEEngrenagem;
import com.exceptions.ClienteException;
import com.exceptions.CompraException;

//Bruno Monteiro -- 19/08/2014

public class Fachada {
	
	private static Fachada instancia;
	private ControllerProduto ControlProduto;
	private ControllerCompra controllerCompra;
	private ControleCliente cliente;
	
	public Fachada(){
		ControlProduto = new ControllerProduto();
		controllerCompra = new ControllerCompra();
		cliente = new ControleCliente();
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
	
	public List<Produto> pesquisarProdutoPorTipo(String tipo){
		return ControlProduto.pesquisarProdutoPeloTipo(tipo);
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
	
	//Métodos de Contato do cliente
	
		public void novoCliente(ContadoCliente c) throws ClienteException{
			
	         cliente.novoCliente(c);
		}
		public void updateCliente(ContadoCliente c) throws ClienteException{
			
			cliente.updateCliente(c);
		} 
		public void deletarCliente(ContadoCliente c) throws ClienteException{
			
			cliente.deletarCliente(c);
			
		}
		public List<ContadoCliente> listarContadoCliente(ContadoCliente c) throws ClienteException{
			
	     return cliente.listarContadoCliente(c);
	   
		}
	
}
