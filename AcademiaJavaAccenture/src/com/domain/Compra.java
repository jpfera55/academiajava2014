package com.domain;

public class Compra {

	private int idCompra;
	private ContadoCliente idCliente;
	private ItensCarrinho idCarrinho;
	private float valorTotal;
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
	public ItensCarrinho getIdCarrinho() {
		return idCarrinho;
	}
	public void setIdCarrinho(ItensCarrinho idCarrinho) {
		this.idCarrinho = idCarrinho;
	}
	public float getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}
	public String getDesconto() {
		return desconto;
	}
	public void setDesconto(String desconto) {
		this.desconto = desconto;
	}
	

	
	
	
	
}
