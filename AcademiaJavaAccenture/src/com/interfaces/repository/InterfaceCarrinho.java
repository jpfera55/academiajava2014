package com.interfaces.repository;

import java.util.List;

import com.domain.Carrinho;
import com.exceptions.CarrinhoException;

public interface InterfaceCarrinho {
	
	public void adicionarCarrinho(Carrinho carrinho) ;
	public void updateCarrinho (Carrinho carrinho) throws CarrinhoException;
	public void removerCarrinho (Carrinho carrinho) throws CarrinhoException;
	public List <Carrinho> listarCarrinho (Carrinho carrinho) throws CarrinhoException;
	

}
