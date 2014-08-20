package com.exceptions;

public enum MensagemErro {
	
	//Produto
	ERRO_DUPLICIDADE("Produto ja existe na base de dados!"),
	ERRO_PRODUTO_NAO_LOCALIZAO("Produto não existe na base, por favor verificar se o produto pesquisado realmente existe!"),
	ERRO_PRODUTO_NULO("Preencha os campos para poder cadastrar o produto!");
	
	
	private final String msg;
	
	MensagemErro(String msg){
		this.msg = msg;
	}
	
	public String getMsg(){
		return this.msg;
	}
}
