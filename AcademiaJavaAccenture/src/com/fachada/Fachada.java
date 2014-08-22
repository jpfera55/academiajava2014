package com.fachada;

import java.util.List;

import com.controller.ControleCliente;
import com.controller.ControllerCarrinho;
import com.controller.ControllerCompra;
import com.controller.ControllerProduto;
import com.domain.Carrinho;
import com.domain.Compra;
import com.domain.Cliente;
import com.domain.Produto;
import com.domain.ProdutoCamping;
import com.domain.ProdutoVestuarioEEngrenagem;
import com.exceptions.CarrinhoException;
import com.exceptions.ClienteException;
import com.exceptions.CompraException;

//Bruno Monteiro -- 19/08/2014 -- Verificado

public class Fachada {
	
	private static Fachada instancia;
	private ControllerProduto ControlProduto;
	private ControllerCompra controllerCompra;
	private ControleCliente cliente;
	private ControllerCarrinho controllerCarrinho;
	
	public Fachada(){
		ControlProduto = new ControllerProduto();
		controllerCompra = new ControllerCompra();
		cliente = new ControleCliente();
		controllerCarrinho = new ControllerCarrinho();
	}
	
	public static Fachada getInstancia(){
		if(instancia == null){
			instancia = new Fachada();
		}
		return instancia;
	}
	
	//Métodos de Produto
	
	public void inserirProduto(Produto produto){
		this.ControlProduto.inserirProduto(produto);
	}
	
	public void deletarProduto(Produto produto){
		this.ControlProduto.deletarProduto(produto);
	}
	
	public void alterarProduto(Produto produto){
		this.ControlProduto.alterarProduto(produto);
	}
	
	public List<Produto> listaProduto(){
		return this.ControlProduto.listaDeProduto();
	}
	
	public List<ProdutoCamping> listaProdutoCampings(){
		return this.ControlProduto.listaDeProdutoCamping();
	}
	
	public List<ProdutoVestuarioEEngrenagem> listaProdutoVestuarioEEngrenagem(){
		return this.ControlProduto.listaDeProdutoVestuarioEEngrenagem();
	}
	
	public Produto pesquisarProdutoPorNome(String nome){
		return this.ControlProduto.pesquisarProdutoPeloNome(nome);
	}
	
	public List<Produto> pesquisarProdutoPorTipo(String tipo){
		return this.ControlProduto.pesquisarProdutoPeloTipo(tipo);
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
	
		public void novoCliente(Cliente c){
			
	         cliente.novoCliente(c);
		}
		public void updateCliente(Cliente c) throws ClienteException{
			
			cliente.updateCliente(c);
		} 
		public void deletarCliente(Cliente c) throws ClienteException{
			
			cliente.deletarCliente(c);
			
		}
		public List<Cliente> listarCliente(Cliente c) throws ClienteException{
			
	     return cliente.listarContadoCliente(c);
	   
		}
		public boolean loginCliente(Cliente c) {
			
		     return cliente.login(c);
		   
		}
		
		//Métodos do Carrinho
		
				public void adicionarCarrinho (Carrinho carrinho) throws CarrinhoException{
					this.controllerCarrinho.adicionarCarrinho(carrinho);
				}
				
				public void updateCarrinho (Carrinho carrinho) throws CarrinhoException{
					this.controllerCarrinho.updateCarrinho(carrinho);
				}
				
				public void deletarCarrinho (Carrinho carrinho) throws CarrinhoException{
					this.controllerCarrinho.deletarCarrinho(carrinho);
				}	
				
				public List<Carrinho> listarCarrinho (Carrinho carrinho){
					return this.listarCarrinho(carrinho);
				}	
		
		
	
}
