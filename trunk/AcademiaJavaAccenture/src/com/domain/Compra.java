package com.domain;

public class Compra {

	private int idCompra;
	private ContadoCliente idCliente;
	private Carrinho idCarrinho;
	private double valorTotal;
	private String desconto;
	
	
	public int getIdCompra() {
		return idCompra;
	}
	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}
	public ContadoCliente getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(ContadoCliente idCliente) {
		this.idCliente = idCliente;
	}
	public Carrinho getIdCarrinho() {
		return idCarrinho;
	}
	public void setIdCarrinho(Carrinho idCarrinho) {
		this.idCarrinho = idCarrinho;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public String getDesconto() {
		return desconto;
	}
	public void setDesconto(String desconto) {
		this.desconto = desconto;
	}
	

	
	
	
	
}
