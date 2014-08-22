package com.domain;

import java.util.List;

public class Carrinho {
	private Produto produto;
	private int quantidade;
	private int codCarrinho;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produtoCarrinho) {
		this.produto = produtoCarrinho;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidadeCarrinho) {
		this.quantidade = quantidadeCarrinho;
	}

	public int getcodCarrinho() {
		return codCarrinho;
	}

	public void setCodCarrinho(int idCarrinho) {
		this.codCarrinho = idCarrinho;
	}

}
