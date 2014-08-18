package com.impl.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

			PreparedStatement pStmt = con.prepareStatement(" SQL ");

			// Colocar os atributos

			pStmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.getMessage();
		}

	}

	@Override
	public void alterarProduto(Produto p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletarProduto(int idProduto) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Produto> listaDeProduto() {
		// TODO Auto-generated method stub
		return null;
	}

}
