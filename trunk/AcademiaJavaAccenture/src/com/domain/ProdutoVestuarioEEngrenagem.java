package com.domain;

//Bruno Monteiro -- 18/08/2014

public class ProdutoVestuarioEEngrenagem extends Produto{
	
	private int IdVestuarioEEngrenagem;
	private String tamanho;
	private String cor;
	
	public int getIdVestuarioEEngrenagem() {
		return IdVestuarioEEngrenagem;
	}
	
	public void setIdVestuarioEEngrenagem(
			int idVestuarioEEngrenagem) {
		IdVestuarioEEngrenagem = idVestuarioEEngrenagem;
	}
	
	public String getTamanho() {
		return tamanho;
	}
	
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	
	public String getCor() {
		return cor;
	}
	
	public void setCor(String cor) {
		this.cor = cor;
	}
	

}
