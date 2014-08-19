package com.impl.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.domain.Compra;
import com.interfaces.repository.InterfaceCompra;

public class CompraRepositorio implements InterfaceCompra{

	@Override
	public void novaCompra(Compra c) {
		try {
			Connection con = Conexao.getConexao();

			con.setAutoCommit(false);

			PreparedStatement pStmt = con.prepareStatement("INSERT INTO Compra VALUES(?,?,?,'?');");

			pStmt.setInt(1, c.getIdCliente().getId());
			pStmt.setInt(2, c.getIdCarrinho().getIdCarrinho());
			pStmt.setFloat(3, c.getValorTotal());
			pStmt.setString(4, c.getDesconto());

			pStmt.executeUpdate();
			pStmt.close();
			con.close();
		} catch (SQLException e) {
			e.getMessage();
		}

	}

	@Override
	public void alterarCompra(Compra c) {
		try {
			Connection con = Conexao.getConexao();

			con.setAutoCommit(false);

			PreparedStatement pStmt = con.prepareStatement("UPDATE Compra SET ID_ContaUsuario = ?, ID_carrinho = ?, PrecoTotal = ?, TipoDesconto = '?' WHERE ID = ?;");

			pStmt.setInt(1, c.getIdCliente().getId());
			pStmt.setInt(2, c.getIdCarrinho().getIdCarrinho());
			pStmt.setFloat(3, c.getValorTotal());
			pStmt.setString(4, c.getDesconto());
            pStmt.setInt(5, c.getIdCompra());
			
			
			pStmt.executeUpdate();
			pStmt.close();
			con.close();
		} catch (SQLException e) {
			e.getMessage();
		}

	}

	@Override
	public void deletarCompra(int idProduto) {
		try {
			Connection con = Conexao.getConexao();

			con.setAutoCommit(false);

			PreparedStatement pStmt = con.prepareStatement("DELETE FROM Compra WHERE ID = ? ;");

			pStmt.setInt(1, idProduto);

			pStmt.executeUpdate();
			pStmt.close();
			con.close();
		} catch (SQLException e) {
			e.getMessage();
		}

	}

	@Override
	public List<Compra> listaDeCompra() {
		ResultSet rs;
		List<Compra> lista = new ArrayList<Compra>();
		Compra compra = null;
		
		try {
			Connection con = Conexao.getConexao();

			con.setAutoCommit(false);

			PreparedStatement pStmt = con.prepareStatement("SELECT * FROM Compra");

			rs = pStmt.executeQuery();
			
			while (rs.next()) {
				compra = new Compra();
				
				compra.setIdCompra(rs.getInt("ID"));
				compra.getIdCliente().setId(rs.getInt("ID_ContaUsuario"));
				compra.getIdCarrinho().setIdCarrinho(rs.getInt("ID_carrinho"));
				compra.setValorTotal(rs.getFloat("PrecoTotal"));
				compra.setDesconto(rs.getString("TipoDesconto"));
				
				lista.add(compra);
			}
			
			pStmt.close();
			con.close();
		} catch (SQLException e) {
			e.getMessage();
		}
		return lista;
	}
	
	
}
