package com.interfaces.repository;

import java.util.List;

import com.domain.Produto;
import com.domain.ProdutoCamping;

public interface InterfaceProdutoCamping {
	
	public void inserirProdutoCamping(ProdutoCamping p);
	public void alterarProdutoCamping(ProdutoCamping p);
	public void deletarProdutoCamping(ProdutoCamping p);
	public List<ProdutoCamping> listaDeProdutoCamping();
}
