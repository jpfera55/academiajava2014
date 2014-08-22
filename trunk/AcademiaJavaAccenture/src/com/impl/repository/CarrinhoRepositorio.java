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
	private static AdicionarCarrinho istancia;

	public static AdicionarCarrinho obterEstancia() {

		if (istancia == null) {
			istancia = new AdicionarCarrinho();
		}

		return istancia;
	}

	@Override
	public void adicionarCarrinho(Carrinho ic){

		try {

			Connection con = Conexao.getConexao();
			con.setAutoCommit(false);
			
			java.sql.PreparedStatement pStmt = con.prepareStatement("INSERT INTO CARRINHO (id_carrinho,quantidade,product_id) VALUE (?,?,?)");

			pStmt.setInt(1, ic.codCarrinho());
			pStmt.setInt(3, ic.getQuantidade());
			pStmt.setInt(2, ic.getProduto().getId());

			pStmt.executeUpdate();
			con.commit();
			pStmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void updateCarrinho(Carrinho ic) {
		try {
			Connection con = Conexao.getConexao();
			con.setAutoCommit(false);
			java.sql.PreparedStatement pStmt = con
					.prepareStatement("UPDATE CARRINHO SET id_carrinho=?,quantidade=?,product_id=? WHERE id_carrinho=?");

			pStmt.setInt(1, ic.codCarrinho());
			pStmt.setInt(2, ic.getQuantidade());
			pStmt.setInt(3, ic.getProduto().getId());

			pStmt.executeUpdate();
			con.commit();
			pStmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void removerCarrinho(Carrinho ic)  throws CarrinhoException{
		try {
			Connection con = Conexao.getConexao();
			con.setAutoCommit(false);
			java.sql.PreparedStatement pStmt = con
					.prepareStatement("DELETE FROM CARRINHO WHERE id_carrinho=?");

			pStmt.setInt(1, ic.codCarrinho());

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
			carrinho.setCodCarrinho(rs.getInt("id_carrinho"));
			carrinho.setQuantidade(rs.getInt("quantidade"));
			carrinho.getProduto().setId(id);(rs.getInt("Product_id"));
			
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
		



