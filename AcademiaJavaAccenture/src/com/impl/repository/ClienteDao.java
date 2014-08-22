package com.impl.repository;

//Érica Rodrigues 19/08/2014

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.domain.Cliente;
import com.exceptions.ClienteException;
import com.impl.repository.Conexao;
import com.interfaces.repository.InterfaceCliente;

public class ClienteDao implements InterfaceCliente {

	private static ClienteDao instancia;

	public static ClienteDao obterInstancia() {
		if (instancia == null) {
			instancia = new ClienteDao();
		}
		return instancia;
	}

	@Override
	public void novoCliente(Cliente cliente) {

		Connection con = Conexao.getConexao();
		try {
			con.setAutoCommit(false);

			PreparedStatement pStmt = con
					.prepareStatement("INSERT INTO  ContaUsuario"
							+ " (ID_ContaUsuario,Nome, Sobrenome, Endereco1, Endereco2, Cidade, Estado, CEP, Pais, Email, Senha)"
							+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");

			pStmt.setInt(1, cliente.getId());
			pStmt.setString(2, cliente.getNome());
			pStmt.setString(3, cliente.getSobrenome());
			pStmt.setString(4, cliente.getEndereçoPrincipal());
			pStmt.setString(5, cliente.getEndereçoAlternativo());
			pStmt.setString(6, cliente.getCidade());
			pStmt.setString(7, cliente.getEstado());
			pStmt.setString(8, cliente.getCep());
			pStmt.setString(9, cliente.getPais());
			pStmt.setString(10, cliente.getSenha());
			pStmt.setString(11, cliente.getEmail());
			
			con.commit();
			pStmt.execute();
			pStmt.close();

			System.out.println("Cadastro realizado ");
		} catch (SQLException e) {

			System.out.println("erro ao salvar" + e.getMessage());
		} 
	}

	@Override
	public void alterarCliente(Cliente cliente) {
		try {
			Connection con = Conexao.getConexao();

			con.setAutoCommit(false);

			PreparedStatement pStmt = con
					.prepareStatement("UPDATE ContaUsuario SET ID_ContaUsuario = ?, nome = ?, sobrenome = ?, endereco1 = ?, endereco2 = ?, cidade = ?, estado = ?, cep =?, pais = ?, senha = ?, email = ?   WHERE ID_ContaUsuario = ?;");

			pStmt.setInt(1, cliente.getId());
			pStmt.setString(2, cliente.getNome());
			pStmt.setString(3, cliente.getSobrenome());
			pStmt.setString(4, cliente.getEndereçoPrincipal());
			pStmt.setString(5, cliente.getEndereçoAlternativo());
			pStmt.setString(6, cliente.getCidade());
			pStmt.setString(7, cliente.getEstado());
			pStmt.setString(8, cliente.getCep());
			pStmt.setString(9, cliente.getPais());
			pStmt.setString(10, cliente.getSenha());
			pStmt.setString(11, cliente.getEmail());

			pStmt.executeUpdate();
			con.commit();
			pStmt.close();
			con.close();
		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}

	}

	@Override
	public void deletarCliente(int cliente) {

		try {
			Connection con = Conexao.getConexao();

			con.setAutoCommit(false);

			PreparedStatement pStmt = con
					.prepareStatement("DELETE FROM ContaUsuario WHERE ID_ContaUsuario = ? ;");

			pStmt.setInt(1, cliente);

			pStmt.executeUpdate();
			con.commit();
			pStmt.close();
			con.close();
		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}

	}

	@Override
	public List<Cliente> listarCliente() {
		ResultSet rs;
		List<Cliente> lista = new ArrayList<Cliente>();
		Cliente cliente = null;

		try {
			Connection con = Conexao.getConexao();

			con.setAutoCommit(false);

			PreparedStatement pStmt = con
					.prepareStatement("SELECT * FROM ContaUsuario");

			rs = pStmt.executeQuery();

			while (rs.next()) {
				cliente = new Cliente();

				cliente.setId(rs.getInt("ID_ContaUsuario "));
				cliente.setNome(rs.getString("nome"));
				cliente.setSobrenome(rs.getString("sobrenome"));
				cliente.setEndereçoPrincipal(rs.getString("endereco1"));
				cliente.setEndereçoAlternativo(rs.getString("endereco2"));
				cliente.setCidade(rs.getString("cidade"));
				cliente.setEstado(rs.getString("estado"));
				cliente.setCep(rs.getString("cep"));
				cliente.setPais(rs.getString("pais"));
				cliente.setSenha(rs.getString("senha"));
				cliente.setEmail(rs.getString("email"));

				lista.add(cliente);
			}
			con.commit();
			pStmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}

	@Override
	public Cliente loginCliente(String email, String senha) {
		ResultSet rs;
		Cliente cliente = null;

		try {
			Connection con = Conexao.getConexao();

			PreparedStatement pStmt = con
					.prepareStatement("SELECT email, senha FROM ContaUsuario where email = ? and senha = ?");
			
			pStmt.setString(1, email);
			pStmt.setString(2, senha);

			rs = pStmt.executeQuery();

			rs.next();
			cliente = new Cliente();
			cliente.setEmail(rs.getString("email"));
			cliente.setSenha(rs.getString("senha"));

			pStmt.close();
			con.close();
			
			return cliente;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e1){
			System.out.println(e1.getMessage());
		}
		return null;
	}

}
