package com.interfaces.repository;

import java.util.List;

import com.domain.ItensCarrinho;
import com.exceptions.CarrinhoException;

public interface InterfaceCarrinho {
	
	public void adicionarCarrinho(ItensCarrinho ic) ;
	public void updateCarrinho (ItensCarrinho ic) throws CarrinhoException;
	public void removerCarrinho (ItensCarrinho ic) throws CarrinhoException;
	public List <ItensCarrinho> listarCarrinho () throws CarrinhoException;
	

}
