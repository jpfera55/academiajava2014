package com.domain;
//Érica Rodrigues 18/08/2014
public class Cliente {

	private String nome,sobrenome, endereçoPrincipal, endereçoAlternativo, cidade, estado, cep , pais, senha, email ;
 	private int id;
    public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
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
	public String getEndereçoPrincipal() {
		return endereçoPrincipal;
	}
	public void setEndereçoPrincipal(String endereçoPrincipal) {
		this.endereçoPrincipal = endereçoPrincipal;
	}
	public String getEndereçoAlternativo() {
		return endereçoAlternativo;
	}
	public void setEndereçoAlternativo(String endereçoAlternativo) {
		this.endereçoAlternativo = endereçoAlternativo;
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
