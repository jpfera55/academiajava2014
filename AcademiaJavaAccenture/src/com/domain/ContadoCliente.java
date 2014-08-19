package com.domain;

public class ContadoCliente {

	private String nome,sobrenome, endereço1, endereço2, cidade, estado, cep , pais;
    private int id;
    
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getEndereço1() {
		return endereço1;
	}
	public void setEndereço1(String endereço1) {
		this.endereço1 = endereço1;
	}
	public String getEndereço2() {
		return endereço2;
	}
	public void setEndereço2(String endereço2) {
		this.endereço2 = endereço2;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	} 
}
