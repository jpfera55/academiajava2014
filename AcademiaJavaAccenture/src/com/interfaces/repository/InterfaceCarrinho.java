package com.interfaces.repository;

import java.util.List;

import com.domain.ItensCarrinho;

public interface InterfaceCarrinho {
	
	public void adicionarCarrinho(ItensCarrinho ic);
	public void updateCarrinho (ItensCarrinho ic);
	public void removerCarrinho (ItensCarrinho ic);
	public List <ItensCarrinho> listarCarrinho (ItensCarrinho ic);
	

}
