package com.interfaces.repository;

import java.util.List;

import com.domain.Produto;

public interface InterfaceProduto {
	
	public void inserirProduto(Produto p);
	public void alterarProduto(Produto p);
	public void deletarProduto(Produto p);
	public List<Produto> listaDeProduto();
}
