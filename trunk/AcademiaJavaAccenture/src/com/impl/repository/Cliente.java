package com.impl.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.domain.Compra;
import com.domain.ContadoCliente;
import com.exceptions.CompraException;
import com.impl.repository.Conexao;
import com.interfaces.repository.InterfaceCliente;

public class Cliente  implements InterfaceCliente{

	@Override
	public void inserirCliente(ContadoCliente cliente) {
		try {
			Connection con = Conexao.getConexao();

			con.setAutoCommit(false);

			PreparedStatement pStmt = con.prepareStatement("INSERT INTO ContaUsuario VALUES(?,?,?,?,?,?,?,?,?,?,?);");

			pStmt.setInt(1, cliente.getId());
			pStmt.setString(2, cliente.getNome());
			pStmt.setString(3, cliente.getSobrenome());
			pStmt.setString(4, cliente.getEndereço1());
			pStmt.setString(5, cliente.getEndereço2());
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
		}catch (SQLException e) {
		
			e.getMessage();
			
		}
		
	}

	@Override
	public void alterarProduto(ContadoCliente cliente) {
		try {
			Connection con = Conexao.getConexao();

			con.setAutoCommit(false);

			PreparedStatement pStmt = con.prepareStatement("UPDATE ContaUsuario SET ID_ContaUsuario = ?, nome = ?, sobrenome = ?, endereco1 = ?, endereco2 = ?, cidade = ?, estado = ?, cep =?, pais = ?, senha = ?, email = ?   WHERE ID_ContaUsuario = ?;");

			pStmt.setInt(1, cliente.getId());
			pStmt.setString(2, cliente.getNome());
			pStmt.setString(3, cliente.getSobrenome());
			pStmt.setString(4, cliente.getEndereço1());
			pStmt.setString(5, cliente.getEndereço2());
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

			e.getMessage();
		}

		
	}

	@Override
	public void deletarProduto(int cliente) {
	
		try {
			Connection con = Conexao.getConexao();

			con.setAutoCommit(false);

			PreparedStatement pStmt = con.prepareStatement("DELETE FROM ContaUsuario WHERE ID_ContaUsuario = ? ;");

			pStmt.setInt(1, cliente );

			pStmt.executeUpdate();
			con.commit();
			pStmt.close();
			con.close();
		} catch (SQLException e) {
		    
			e.getMessage();
		}
		
	}

	@Override
	public List<ContadoCliente> listaDeContadoCliente() {
		ResultSet rs;
		List<ContadoCliente> lista = new ArrayList<ContadoCliente>();
		ContadoCliente cliente = null;
		
		try {
			Connection con = Conexao.getConexao();

			con.setAutoCommit(false);

			PreparedStatement pStmt = con.prepareStatement("SELECT * FROM ContaUsuario");

			rs = pStmt.executeQuery();
			
			while (rs.next()) {
				cliente = new ContadoCliente();
				
				cliente.setId(rs.getInt("ID_ContaUsuario "));
				cliente.setNome(rs.getString("nome"));
				cliente.setSobrenome(rs.getString("sobrenome"));
				cliente.setEndereço1(rs.getString("endereco1"));
				cliente.setEndereço1(rs.getString("endereco2"));
				cliente.setCidade(rs.getString("cidade"));
				cliente.setEstado(rs.getString("estado"));
				cliente.setCep(rs.getString("cep"));
				cliente.setPais(rs.getString("pais"));	
				cliente.setEmail(rs.getString("email"));
				cliente.setSenha(rs.getString("senha"));
				
				
				lista.add(cliente);
			}
			con.commit();
			pStmt.close();
			con.close();
		} catch (SQLException e) {
			e.getMessage();
		}
		return lista;
	}
	

}

