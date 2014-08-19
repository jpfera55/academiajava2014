package com.impl.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.domain.Produto;
import com.interfaces.repository.InterfaceProduto;

//Bruno Monteiro -- 18/11/2014

public class ProdutoRepositorio implements InterfaceProduto {

	@Override
	public void inserirProduto(Produto p) {
		try {
			Connection con = Conexao.getConexao();

			con.setAutoCommit(false);

			PreparedStatement pStmt = con.prepareStatement("INSERT INTO ");

			pStmt.setString(1, p.getNomeProduto());
			pStmt.setString(2, p.getDescricaoProduto());
			pStmt.setString(3, p.getImagemProduto());
			pStmt.setFloat(4, p.getPrecoProduto());

			pStmt.executeUpdate();
			pStmt.close();
			con.close();
		} catch (SQLException e) {
			e.getMessage();
		}

	}

	@Override
	public void alterarProduto(Produto p) {
		try {
			Connection con = Conexao.getConexao();

			con.setAutoCommit(false);

			PreparedStatement pStmt = con.prepareStatement("UPDATE");

			pStmt.setString(1, p.getNomeProduto());
			pStmt.setString(2, p.getDescricaoProduto());
			pStmt.setString(3, p.getImagemProduto());
			pStmt.setFloat(4, p.getPrecoProduto());

			pStmt.executeUpdate();
			pStmt.close();
			con.close();
		} catch (SQLException e) {
			e.getMessage();
		}

	}

	@Override
	public void deletarProduto(int idProduto) {
		try {
			Connection con = Conexao.getConexao();

			con.setAutoCommit(false);

			PreparedStatement pStmt = con.prepareStatement("DELETE");

			pStmt.setInt(1, idProduto);

			pStmt.executeUpdate();
			pStmt.close();
			con.close();
		} catch (SQLException e) {
			e.getMessage();
		}

	}

	@Override
	public List<Produto> listaDeProduto() {
		ResultSet rs;
		List<Produto> lista = new ArrayList<Produto>();
		Produto produto = null;
		
		try {
			Connection con = Conexao.getConexao();

			con.setAutoCommit(false);

			PreparedStatement pStmt = con.prepareStatement("SELECT * FROM ");

			rs = pStmt.executeQuery();
			
			while (rs.next()) {
				produto = new Produto();
				
				produto.setIdProduto(rs.getInt(""));
				produto.setNomeProduto(rs.getString(""));
				produto.setDescricaoProduto(rs.getString(""));
				produto.setImagemProduto(rs.getString(""));
				produto.setPrecoProduto(rs.getFloat(0));
				
				lista.add(produto);
			}
			
			pStmt.close();
			con.close();
		} catch (SQLException e) {
			e.getMessage();
		}
		return lista;
	}
	

}
