package com.impl.service;

import java.sql.SQLException;
import java.util.List;

import com.domain.Produto;

public interface InterfaceProduto {
	
	public void inserirProduto(Produto p) throws SQLException;
	public void alterarProduto(Produto p);
	public void deletarProduto(int idProduto);
	public List<Produto> listaDeProduto();
}
