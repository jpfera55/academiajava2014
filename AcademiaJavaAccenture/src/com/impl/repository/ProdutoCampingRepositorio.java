package com.impl.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.domain.Produto;
import com.domain.ProdutoCamping;
import com.interfaces.repository.InterfaceProdutoCamping;

public class ProdutoCampingRepositorio implements InterfaceProdutoCamping {

	@Override
	public void inserirProdutoCamping(ProdutoCamping p) {
		try {
			Connection con = Conexao.getConexao();

			con.setAutoCommit(false);

			PreparedStatement pStmt = con.prepareStatement(
					"INSERT INTO produtocamping (Product_Id, Product_registraction"
							+ ") VALUE (?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);

			pStmt.setInt(1, p.getIdProduto());
			pStmt.setString(2, p.getRegistroDaAgenciaAmbiental());

			pStmt.executeUpdate();
			con.commit();

			pStmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void alterarProdutoCamping(ProdutoCamping p) {
		try {
			Connection con = Conexao.getConexao();

			con.setAutoCommit(false);

			PreparedStatement pStmt = con
					.prepareStatement("UPDATE PRODUTO SET "
							+ "Product_registraction = ? WHERE product_id = ? and Id_produtoCamping = ?");

			pStmt.setString(1, p.getRegistroDaAgenciaAmbiental());
			pStmt.setInt(2, p.getIdProduto());
			pStmt.setInt(3, p.getIdProdutoCamping());

			pStmt.executeUpdate();
			con.commit();

			pStmt.close();
			con.close();
		} catch (SQLException e) {
			e.getMessage();
		}

	}

	@Override
	public void deletarProdutoCamping(ProdutoCamping produto) {
		try {
			Connection con = Conexao.getConexao();

			con.setAutoCommit(false);

			PreparedStatement pStmt = con
					.prepareStatement("DELETE FROM produtocamping WHERE product_id = ?");

			pStmt.setInt(1, produto.getIdProduto());

			pStmt.executeUpdate();
			con.commit();

			pStmt.close();
			con.close();
		} catch (SQLException e) {
			e.getMessage();
		}

	}

	@Override
	public List<ProdutoCamping> listaDeProdutoCamping() {
		ResultSet rs;
		List<ProdutoCamping> lista = new ArrayList<ProdutoCamping>();
		ProdutoCamping produto = null;

		try {
			Connection con = Conexao.getConexao();

			con.setAutoCommit(false);

			PreparedStatement pStmt = con.prepareStatement("select * from produto right join " + 
			"produtocamping on produto.Product_Id = produtocamping.Product_Id");

			rs = pStmt.executeQuery();

			while (rs.next()) {
				produto = new ProdutoCamping();

				produto.setIdProduto(rs.getInt("product_id"));
				produto.setNomeProduto(rs.getString("product_name"));
				produto.setDescricaoProduto(rs.getString("product_description"));
				produto.setImagemProduto(rs.getString("product_image"));
				produto.setPrecoProduto(rs.getFloat("product_price"));
				produto.setTipoProduto(rs.getString("product_type"));
				produto.setIdProdutoCamping(rs.getInt("Id_produtoCamping"));
				produto.setRegistroDaAgenciaAmbiental(rs.getString("Product_registraction"));

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
