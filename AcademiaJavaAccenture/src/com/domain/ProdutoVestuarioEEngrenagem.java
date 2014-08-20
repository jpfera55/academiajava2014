package com.domain;

//Bruno Monteiro -- 18/08/2014

public class ProdutoVestuarioEEngrenagem extends Produto{
	
	private int IdProdutoVestuarioEEngrenagem;
	private String tamanhoProduto;
	private String corProduto;
	
	public int getIdProdutoVestuarioEEngrenagem() {
		return IdProdutoVestuarioEEngrenagem;
	}
	public void setIdProdutoVestuarioEEngrenagem(
			int idProdutoVestuarioEEngrenagem) {
		IdProdutoVestuarioEEngrenagem = idProdutoVestuarioEEngrenagem;
	}
	public String getTamanhoProduto() {
		return tamanhoProduto;
	}
	public void setTamanhoProduto(String tamanhoProduto) {
		this.tamanhoProduto = tamanhoProduto;
	}
	public String getCorProduto() {
		return corProduto;
	}
	public void setCorProduto(String corProduto) {
		this.corProduto = corProduto;
	}
	

}
