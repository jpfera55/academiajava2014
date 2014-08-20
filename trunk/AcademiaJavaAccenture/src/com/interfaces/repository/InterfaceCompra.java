package com.interfaces.repository;

import java.util.List;

import com.domain.Compra;
import com.exceptions.CompraException;

public interface InterfaceCompra {

	public void novaCompra(Compra c) throws CompraException;
	public void alterarCompra(Compra c) throws CompraException;
	public void deletarCompra(Compra c) throws CompraException;
	public List<Compra> listaDeCompra() throws CompraException;
	
	
}
