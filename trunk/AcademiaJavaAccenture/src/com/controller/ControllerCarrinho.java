package com.controller;

import java.util.List;

import com.domain.Carrinho;
import com.exceptions.CarrinhoException;
import com.impl.repository.AdicionarCarrinho;
import com.impl.repository.CompraRepositorio;

public class ControllerCarrinho {

	public void adicionarCarrinho(Carrinho c) throws CarrinhoException {
		boolean encontrou = false;

		List<Carrinho> lista = this.listarCarrinho(c);
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).codCarrinho() == c.codCarrinho()) {
				encontrou = true;
				break;
			}
		}

		if (encontrou == true) {

			throw new CarrinhoException("Carrinho  já existe");
		}

		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getProduto().getId() == c
					.getProduto().getId()) {
				encontrou = true;
				break;
			}

		}

		if (encontrou == true) {

			throw new CarrinhoException("Produtos duplicados no carrinho");
		}

		AdicionarCarrinho dados = AdicionarCarrinho.obterEstancia();
		dados.adicionarCarrinho(c);

	}

	public void updateCarrinho(Carrinho c) throws CarrinhoException {

		boolean encontrou = false;

		List<Carrinho> lista = this.listarCarrinho(c);
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).codCarrinho() == c.codCarrinho()) {
				encontrou = true;
				break;
			}
		}

		if (encontrou == true) {

			throw new CarrinhoException("Carrinho  já existe");
		}

		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getProduto().getId() == c
					.getProduto().getId()) {
				encontrou = true;
				break;
			}

		}

		if (encontrou == true) {

			throw new CarrinhoException("Produtos duplicados no carrinho");
		}

		AdicionarCarrinho carrinho = AdicionarCarrinho
				.obterEstancia();
		carrinho.updateCarrinho(c);

	}

	public void deletarCarrinho(Carrinho c) throws CarrinhoException {
		AdicionarCarrinho carrinho = AdicionarCarrinho
				.obterEstancia();
		carrinho.removerCarrinho(c);
	}

	public List<Carrinho> listarCarrinho(Carrinho c)
			throws CarrinhoException {
		AdicionarCarrinho carrinho = AdicionarCarrinho
				.obterEstancia();

		return carrinho.listarCarrinho();
	}

}
