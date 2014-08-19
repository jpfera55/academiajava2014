package com.interfaces.repository;

import java.util.List;

import com.domain.Produto;
import com.domain.ProdutoCamping;

// Bruno Monteiro -- 19/08/2014

public interface InterfaceProdutoCamping {
	
	public void inserirProdutoCamping(ProdutoCamping p);
	public void alterarProdutoCamping(ProdutoCamping p);
	public void deletarProdutoCamping(ProdutoCamping p);
	public List<ProdutoCamping> listaDeProdutoCamping();
}
