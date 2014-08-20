package com.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.domain.Produto;
import com.domain.ProdutoCamping;
import com.domain.ProdutoVestuarioEEngrenagem;
import com.exceptions.MensagemErro;
import com.exceptions.ProdutoDuplicadoException;
import com.exceptions.ProdutoNaoLocalizadoException;
import com.exceptions.ProdutoNuloException;
import com.impl.repository.ProdutoRepositorio;
import com.interfaces.repository.InterfaceProduto;

//Bruno Monteiro -- 20/08/2014

@Controller
@RequestMapping("/views/*.htm")
public class ControllerProduto {

	private InterfaceProduto IRepProduto;
	
	public ControllerProduto(){
		IRepProduto = new ProdutoRepositorio();
	}
	
	@RequestMapping("inserirProduto.htm")
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
	
	@RequestMapping("alterarProduto.htm")
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
	
	@RequestMapping("deletarProduto.htm")
	public void deletarProduto(Produto produto){
		try {
			if(verificarSeProdutoNaoENulo(produto)){
				IRepProduto.deletarProduto(produto);
			}
		} catch (ProdutoNuloException e) {
			System.out.println(e.getMessage());
		}
	}

	@RequestMapping("listaDeProduto.htm")
	public List<Produto> listaDeProduto(){
		return IRepProduto.listaDeProduto();
	}
	
	@RequestMapping("listaDeProdutoCamping.htm")
	public List<ProdutoCamping> listaDeProdutoCamping(){
		return IRepProduto.listaDeProdutoCamping();
	}
	
	@RequestMapping("listaDeProdutoVestuarioEEngrenagem.htm")
	public List<ProdutoVestuarioEEngrenagem> listaDeProdutoVestuarioEEngrenagem(){
		return IRepProduto.listaDeProdutoVestuarioEEngrenagem();
	}
	
	@RequestMapping("pesquisarProdutoPeloNome.htm")
	public Produto pesquisarProdutoPeloNome(String nome){
		return IRepProduto.pesquisarProdutoPeloNome(nome);
	}
	
	//Métodos auxiliares das validações
	
	public boolean verificarSeProdutoNaoENulo(Produto produto) throws ProdutoNuloException{
		if(produto == null){
			throw new ProdutoNuloException(MensagemErro.ERRO_PRODUTO_NULO.getMsg());
		}
		return true;
	}
	
	public boolean verificarSeExisteProduto(String nome) throws ProdutoNaoLocalizadoException{
		Produto produto = IRepProduto.pesquisarProdutoPeloNome(nome);
		if(produto == null){
			throw new ProdutoNaoLocalizadoException(MensagemErro.ERRO_PRODUTO_NAO_LOCALIZAO.getMsg());
		}
		return true;
	}
	
	public boolean verificarDuplicidadeProduto(String nome) throws ProdutoDuplicadoException{
		Produto produto = IRepProduto.pesquisarProdutoPeloNome(nome);
		if((produto.getNomeProduto()).toUpperCase().equals((nome).toUpperCase())){
			throw new ProdutoDuplicadoException(MensagemErro.ERRO_DUPLICIDADE.getMsg());
		}
		
		return true;
	}
	
}
