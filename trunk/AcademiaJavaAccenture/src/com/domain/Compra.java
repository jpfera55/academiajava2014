package com.domain;

public class Compra {

	private int idCompra;
	private ContadoCliente Cliente;
	private Carrinho Carrinho;
	private double valorTotal;
	private String desconto;
	
	
	public int getIdCompra() {
		return idCompra;
	}
	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}
	public ContadoCliente getCliente() {
		return Cliente;
	}
	public void setCliente(ContadoCliente idCliente) {
		this.Cliente = idCliente;
	}
	public Carrinho getCarrinho() {
		return Carrinho;
	}
	public void setCarrinho(Carrinho idCarrinho) {
		this.Carrinho = idCarrinho;
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
