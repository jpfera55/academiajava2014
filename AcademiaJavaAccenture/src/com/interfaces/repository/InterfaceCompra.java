package com.interfaces.repository;

import java.util.List;

import com.domain.Compra;
import com.exceptions.CompraException;

public interface InterfaceCompra {

	public void novaCompra(Compra compra) throws CompraException;
	public void alterarCompra(Compra compra) throws CompraException;
	public void deletarCompra(Compra compra) throws CompraException;
	public List<Compra> listarCompras(Compra compra) throws CompraException;
	public List<Compra> listarCompraEspecifica(Compra compra) throws CompraException;
	
	
}
