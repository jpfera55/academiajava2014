package com.interfaces.repository;

import java.util.List;

import com.domain.Produto;
import com.domain.ProdutoCamping;
import com.domain.ProdutoVestuarioEEngrenagem;

//Bruno Monteiro -- 19/08/2014

public interface InterfaceProduto {
	
	public void inserirProduto(Produto p);
	public void alterarProduto(Produto p);
	public void deletarProduto(Produto p);
	public List<Produto> listaDeProduto();
	public List<ProdutoCamping> listaDeProdutoCamping();
	public List<ProdutoVestuarioEEngrenagem> listaDeProdutoVestuarioEEngrenagem();
	public Produto pesquisarProdutoPeloNome(String nome);
}
