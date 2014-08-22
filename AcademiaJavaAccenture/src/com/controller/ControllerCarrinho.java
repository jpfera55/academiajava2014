package com.controller;

import java.util.List;

import com.domain.Carrinho;
import com.exceptions.CarrinhoException;
import com.impl.repository.CarrinhoRepositorio;
import com.impl.repository.CompraRepositorio;

public class ControllerCarrinho {

	public void adicionarCarrinho(Carrinho carrinho) throws CarrinhoException {
		boolean encontrou = false;

		List<Carrinho> lista = this.listarCarrinho(carrinho);
		
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getProduto().getId() == carrinho.getProduto().getId()) {
				encontrou = true;
				break;
			}

		}

		if (encontrou == true) {

			throw new CarrinhoException("Produtos duplicados no carrinho");
		}

		CarrinhoRepositorio dados = CarrinhoRepositorio.obterEstancia();
		dados.adicionarCarrinho(carrinho);

	}

	public void updateCarrinho(Carrinho carrinho) throws CarrinhoException {

		boolean encontrou = false;

		List<Carrinho> lista = this.listarCarrinho(carrinho);
	
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getProduto().getId() == carrinho.getProduto().getId()) {
				encontrou = true;
				break;
			}

		}

		if (encontrou == true) {

			throw new CarrinhoException("Produtos duplicados no carrinho");
		}

		CarrinhoRepositorio carro = CarrinhoRepositorio.obterEstancia();
		carro.updateCarrinho(carrinho);

	}

	public void deletarCarrinho(Carrinho carrinho) throws CarrinhoException {
		CarrinhoRepositorio carro = CarrinhoRepositorio.obterEstancia();
		carro.removerCarrinho(carrinho);
	}

	public List<Carrinho> listarCarrinho(Carrinho carrinho)
			throws CarrinhoException {
		CarrinhoRepositorio carro = CarrinhoRepositorio.obterEstancia();

		return carro.listarCarrinho(carrinho);
	}

}
