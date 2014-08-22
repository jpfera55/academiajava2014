package com.impl.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.domain.ItensCarrinho;
import com.exceptions.CarrinhoException;
import com.interfaces.repository.InterfaceCarrinho;
import com.mysql.jdbc.PreparedStatement;

public class AdicionaCarrinhoAction implements InterfaceCarrinho {

	// Adiciona itens no carrinho
	private static AdicionaCarrinhoAction istancia;

	public static AdicionaCarrinhoAction obterEstancia() {

		if (istancia == null) {
			istancia = new AdicionaCarrinhoAction();
		}

		return istancia;
	}

	@Override
	public void adicionarCarrinho(ItensCarrinho ic){

		try {

			Connection con = Conexao.getConexao();
			con.setAutoCommit(false);
			
			java.sql.PreparedStatement pStmt = con.prepareStatement("INSERT INTO CARRINHO (id_carrinho,quantidade,product_id) VALUE (?,?,?)");

			pStmt.setInt(1, ic.getIdCarrinho());
			pStmt.setInt(3, ic.getQuantidadeCarrinho());
			pStmt.setInt(2, ic.getProdutoCarrinho().getIdProduto());

			pStmt.executeUpdate();
			con.commit();
			pStmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void updateCarrinho(ItensCarrinho ic) {
		try {
			Connection con = Conexao.getConexao();
			con.setAutoCommit(false);
			java.sql.PreparedStatement pStmt = con
					.prepareStatement("UPDATE CARRINHO SET id_carrinho=?,quantidade=?,product_id=? WHERE id_carrinho=?");

			pStmt.setInt(1, ic.getIdCarrinho());
			pStmt.setInt(2, ic.getQuantidadeCarrinho());
			pStmt.setInt(3, ic.getProdutoCarrinho().getIdProduto());

			pStmt.executeUpdate();
			con.commit();
			pStmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void removerCarrinho(ItensCarrinho ic)  throws CarrinhoException{
		try {
			Connection con = Conexao.getConexao();
			con.setAutoCommit(false);
			java.sql.PreparedStatement pStmt = con
					.prepareStatement("DELETE FROM CARRINHO WHERE id_carrinho=?");

			pStmt.setInt(1, ic.getIdCarrinho());

			pStmt.executeUpdate();
			con.commit();
			pStmt.close();
			con.close();
		} catch (SQLException e) {
			throw new CarrinhoException(e.getMessage());
		}
	}

	@Override
	public List<ItensCarrinho> listarCarrinho()  throws CarrinhoException{
		ResultSet rs;
		List<ItensCarrinho> lista = new ArrayList<ItensCarrinho>();
		ItensCarrinho itens = null;
		
		try {
			Connection con = Conexao.getConexao();

			con.setAutoCommit(false);

			java.sql.PreparedStatement pStmt = con.prepareStatement("SELECT * FROM CARRINHO");

			rs = pStmt.executeQuery();
			
			while (rs.next()) {
			ItensCarrinho carrinho = new ItensCarrinho();
			carrinho.setIdCarrinho(rs.getInt("id_carrinho"));
			carrinho.setQuantidadeCarrinho(rs.getInt("quantidade"));
			carrinho.getProdutoCarrinho().setIdProduto(rs.getInt("Product_id"));
			
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
		



