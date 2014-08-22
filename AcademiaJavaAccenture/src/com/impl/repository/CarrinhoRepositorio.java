package com.impl.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.domain.Carrinho;
import com.exceptions.CarrinhoException;
import com.interfaces.repository.InterfaceCarrinho;

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
	public void adicionarCarrinho(Carrinho carrinho) {

		try {

			Connection con = Conexao.getConexao();
			con.setAutoCommit(false);

			PreparedStatement pStmt = con
					.prepareStatement("INSERT INTO CARRINHO (CodCarrinho,quantidade,produto) VALUE (?,?,?)");

			pStmt.setInt(1, carrinho.getcodCarrinho());
			pStmt.setInt(3, carrinho.getQuantidade());
			pStmt.setInt(2, carrinho.getProduto().getId());

			pStmt.executeUpdate();
			con.commit();
			pStmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			fechar();
		}
	}

	@Override
	public void updateCarrinho(Carrinho carrinho) {
		try {
			Connection con = Conexao.getConexao();
			con.setAutoCommit(false);
			java.sql.PreparedStatement pStmt = con
					.prepareStatement("UPDATE CARRINHO SET codCarrinho=?,quantidade=?,produto=? WHERE CodCarrinho=?");

			pStmt.setInt(1, carrinho.getcodCarrinho());
			pStmt.setInt(2, carrinho.getQuantidade());
			pStmt.setInt(3, carrinho.getProduto().getId());

			pStmt.executeUpdate();
			con.commit();
			pStmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			fechar();
		}

	}

	@Override
	public void removerCarrinho(Carrinho carrinho) throws CarrinhoException {
		try {
			Connection con = Conexao.getConexao();
			con.setAutoCommit(false);
			PreparedStatement pStmt = con
					.prepareStatement("DELETE FROM CARRINHO WHERE codCarrinho=?");

			pStmt.setInt(1, carrinho.getcodCarrinho());

			pStmt.executeUpdate();
			con.commit();
			pStmt.close();
			con.close();
		} catch (SQLException e) {
			throw new CarrinhoException(e.getMessage());
		} catch (Exception e) {

			throw new CarrinhoException(e.getMessage());
		} finally {

			fechar();

		}
	}
	
	private void fechar() {

	}

	@Override
	public List<Carrinho> listarCarrinho(Carrinho carrinho)
			throws CarrinhoException {
		ResultSet rs;
		List<Carrinho> lista = new ArrayList<Carrinho>();
		Carrinho itens = null;

		try {
			Connection con = Conexao.getConexao();

			con.setAutoCommit(false);

			PreparedStatement pStmt = con
					.prepareStatement("SELECT * FROM CARRINHO WHERE Product_Id = ?");
			pStmt.setInt(1, carrinho.getProduto().getId());

			rs = pStmt.executeQuery();

			while (rs.next()) {
				Carrinho carro = new Carrinho();
				carro.setCodCarrinho(rs.getInt("cod_carrinho"));
				carro.setQuantidade(rs.getInt("quantidade"));
				carro.getProduto().setId(rs.getInt("Produto"));

				lista.add(carro);
			}

			pStmt.close();
			con.close();
		} catch (SQLException e) {
			throw new CarrinhoException(e.getMessage());
		}
		return lista;
	}

}
