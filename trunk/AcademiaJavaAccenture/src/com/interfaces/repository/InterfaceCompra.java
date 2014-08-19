package com.interfaces.repository;

import java.util.List;

import com.domain.Compra;

public interface InterfaceCompra {

	public void novaCompra(Compra c);
	public void alterarCompra(Compra c);
	public void deletarCompra(int idCompra);
	public List<Compra> listaDeCompra();
	
	
}
