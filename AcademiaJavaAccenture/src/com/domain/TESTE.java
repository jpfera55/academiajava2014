package com.domain;

import com.fachada.Fachada;

public class TESTE {

	public static void main(String[] args) {
		
		Produto produto = new Produto();
		produto.setIdProduto(8);
		produto.setNomeProduto("Monitor LED");
		produto.setDescricaoProduto("22 polegadas");
		produto.setPrecoProduto(450.90f);
		produto.setTipoProduto("Monitores");
		
		Fachada.getInstancia().inserirProduto(produto);
	}

}
