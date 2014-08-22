package com.controller;

import java.util.List;

import com.domain.ItensCarrinho;
import com.exceptions.CarrinhoException;
import com.impl.repository.AdicionaCarrinhoAction;
import com.impl.repository.CompraRepositorio;

public class ControllerCarrinho {

	public void adicionarCarrinho(ItensCarrinho c) throws CarrinhoException {
		boolean encontrou = false;

		List<ItensCarrinho> lista = this.listarCarrinho(c);
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getIdCarrinho() == c.getIdCarrinho()) {
				encontrou = true;
				break;
			}
		}

		if (encontrou == true) {

			throw new CarrinhoException("Carrinho  já existe");
		}

		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getProdutoCarrinho().getId() == c
					.getProdutoCarrinho().getId()) {
				encontrou = true;
				break;
			}

		}

		if (encontrou == true) {

			throw new CarrinhoException("Produtos duplicados no carrinho");
		}

		AdicionaCarrinhoAction dados = AdicionaCarrinhoAction.obterEstancia();
		dados.adicionarCarrinho(c);

	}

	public void updateCarrinho(ItensCarrinho c) throws CarrinhoException {

		boolean encontrou = false;

		List<ItensCarrinho> lista = this.listarCarrinho(c);
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getIdCarrinho() == c.getIdCarrinho()) {
				encontrou = true;
				break;
			}
		}

		if (encontrou == true) {

			throw new CarrinhoException("Carrinho  já existe");
		}

		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getProdutoCarrinho().getId() == c
					.getProdutoCarrinho().getId()) {
				encontrou = true;
				break;
			}

		}

		if (encontrou == true) {

			throw new CarrinhoException("Produtos duplicados no carrinho");
		}

		AdicionaCarrinhoAction carrinho = AdicionaCarrinhoAction
				.obterEstancia();
		carrinho.updateCarrinho(c);

	}

	public void deletarCarrinho(ItensCarrinho c) throws CarrinhoException {
		AdicionaCarrinhoAction carrinho = AdicionaCarrinhoAction
				.obterEstancia();
		carrinho.removerCarrinho(c);
	}

	public List<ItensCarrinho> listarCarrinho(ItensCarrinho c)
			throws CarrinhoException {
		AdicionaCarrinhoAction carrinho = AdicionaCarrinhoAction
				.obterEstancia();

		return carrinho.listarCarrinho();
	}

}
