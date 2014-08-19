package com.interfaces.repository;

import java.util.List;

import com.domain.ProdutoCamping;
import com.domain.ProdutoVestuarioEEngrenagem;

//Bruno Monteiro -- 19/08/2014

public interface InterfaceProdutoVestuarioEEngrenagem {

	public void inserirProdutoVestuarioEEngrenagem(ProdutoVestuarioEEngrenagem p);
	public void alterarProdutoVestuarioEEngrenagem(ProdutoVestuarioEEngrenagem p);
	public void deletarProdutoVestuarioEEngrenagem(ProdutoVestuarioEEngrenagem p);
	public List<ProdutoVestuarioEEngrenagem> listaDeProdutoVestuarioEEngrenagem();
}
