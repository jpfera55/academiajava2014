package com.interfaces.repository;

import java.util.List;

import com.domain.Carrinho;
import com.exceptions.CarrinhoException;

public interface InterfaceCarrinho {
	
	public void adicionarCarrinho(Carrinho ic) ;
	public void updateCarrinho (Carrinho ic) throws CarrinhoException;
	public void removerCarrinho (Carrinho ic) throws CarrinhoException;
	public List <Carrinho> listarCarrinho () throws CarrinhoException;
	

}
