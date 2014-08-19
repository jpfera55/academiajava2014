package com.impl.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.domain.ItensCarrinho;
import com.interfaces.repository.InterfaceCarrinho;

public class AdicionaCarrinhoAction implements InterfaceCarrinho {

	// Adiciona itens no carrinho

	public ArrayList AdicionarCarrinho(ItensCarrinho item, ArrayList lista) {

		if (lista == null) {
			lista = new ArrayList();
		}
		lista.add(item.getProdutoCarrinho());
		return lista;
	}
	
	// percorre a lista de carrinho

	public ArrayList percorre = new ArrayList ();
	    percorre = (ArrayList) session.load("pecorre");
	    Iterator i = percorre.iterator();
	    while (i.hasNext()){
	    
	}
		@Override
		public void adicionarCarrinho(ItensCarrinho ic) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void updateCarrinho(ItensCarrinho ic) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void removerCarrinho(ItensCarrinho ic) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public List<ItensCarrinho> listarCarrinho(ItensCarrinho ic) {
			// TODO Auto-generated method stub
			return null;
		}

} 

}
    