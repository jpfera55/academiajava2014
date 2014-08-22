package com.impl.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.domain.Carrinho;
import com.exceptions.CarrinhoException;
import com.interfaces.repository.InterfaceCarrinho;
import com.mysql.jdbc.PreparedStatement;

public class CarrinhoRepositorio implements InterfaceCarrinho {

	// Adiciona itens no carrinho
	private static CarrinhoRepositorio istancia;

	public static CarrinhoRepositorio obterEstancia() {

		if (istancia == null) {
			istancia = new CarrinhoRepositorio();
		}

		return istancia;
	}

	@Override
	public void adicionarCarrinho(Carrinho carrinho){

		try {

			Connection con = Conexao.getConexao();
			con.setAutoCommit(false);
			
			java.sql.PreparedStatement pStmt = con.prepareStatement("INSERT INTO CARRINHO (CodCarrinho,quantidade,produto) VALUE (?,?,?)");

			pStmt.setInt(1, carrinho.codCarrinho());
			pStmt.setInt(3, carrinho.getQuantidade());
			pStmt.setInt(2, carrinho.getProduto().getId());

			pStmt.executeUpdate();
			con.commit();
			pStmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void updateCarrinho(Carrinho carrinho) {
		try {
			Connection con = Conexao.getConexao();
			con.setAutoCommit(false);
			java.sql.PreparedStatement pStmt = con
					.prepareStatement("UPDATE CARRINHO SET codCarrinho=?,quantidade=?,produto=? WHERE CodCarrinho=?");

			pStmt.setInt(1, carrinho.codCarrinho());
			pStmt.setInt(2, carrinho.getQuantidade());
			pStmt.setInt(3, carrinho.getProduto().getId());

			pStmt.executeUpdate();
			con.commit();
			pStmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void removerCarrinho(Carrinho carrinho)  throws CarrinhoException{
		try {
			Connection con = Conexao.getConexao();
			con.setAutoCommit(false);
			java.sql.PreparedStatement pStmt = con
					.prepareStatement("DELETE FROM CARRINHO WHERE codCarrinho=?");

			pStmt.setInt(1, carrinho.codCarrinho());

			pStmt.executeUpdate();
			con.commit();
			pStmt.close();
			con.close();
		} catch (SQLException e) {
			throw new CarrinhoException(e.getMessage());
		}
	}

	@Override
	public List<Carrinho> listarCarrinho()  throws CarrinhoException{
		ResultSet rs;
		List<Carrinho> lista = new ArrayList<Carrinho>();
		Carrinho itens = null;
		
		try {
			Connection con = Conexao.getConexao();

			con.setAutoCommit(false);

			java.sql.PreparedStatement pStmt = con.prepareStatement("SELECT * FROM CARRINHO");

			rs = pStmt.executeQuery();
			
			while (rs.next()) {
			Carrinho carrinho = new Carrinho();
			carrinho.setCodCarrinho(rs.getInt("cod_carrinho"));
			carrinho.setQuantidade(rs.getInt("quantidade"));
			carrinho.getProduto().setId(rs.getInt("Produto"));
			
			lista.add(carrinho);
			}
			
			pStmt.close();
			con.close();
		} catch (SQLException e) {
			throw new CarrinhoException(e.getMessage());
		}
		return lista;
	}
	
				
				
}
		



