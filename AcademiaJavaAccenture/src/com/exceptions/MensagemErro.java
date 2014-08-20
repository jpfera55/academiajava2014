package com.exceptions;

public enum MensagemErro {
	
	//Produto
	ErroDuplicidade("Produto ja existe na base de dados!"),
	ErroNaoLocalizado("Produto não existe na base, por favor verificar se o produto pesquisado realmente existe!"),
	ErroProdutoNulo("Preencha os campos para poder cadastrar o produto!");
	
	
	private final String msg;
	
	MensagemErro(String msg){
		this.msg = msg;
	}
	
	public String getMsg(){
		return this.msg;
	}
}
