package com.impl.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.domain.Compra;
import com.exceptions.CompraException;
import com.interfaces.repository.InterfaceCompra;

public class CompraRepositorio implements InterfaceCompra{

	private static CompraRepositorio instancia;
	
	public static CompraRepositorio obterInstancia(){
		if(instancia == null){
			instancia = new CompraRepositorio();
		}
		return instancia;
	}
	
	
	@Override
	public void novaCompra(Compra c) throws CompraException {
		try {
			Connection con = Conexao.getConexao();

			con.setAutoCommit(false);

			PreparedStatement pStmt = con.prepareStatement("INSERT INTO Compra VALUES(?,?,?,'?');");

			pStmt.setInt(1, c.getIdCliente().getId());
			pStmt.setInt(2, c.getIdCarrinho().getIdCarrinho());
			pStmt.setFloat(3, c.getValorTotal());
			pStmt.setString(4, c.getDesconto());

			pStmt.executeUpdate();
			con.commit();
			pStmt.close();
			con.close();
		}catch (SQLException e) {
			throw new CompraException(e.getMessage());
			
		}

	}

	@Override
	public void alterarCompra(Compra c) throws CompraException{
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
			con.commit();
			pStmt.close();
			con.close();
		} catch (SQLException e) {
			throw new CompraException(e.getMessage());
		}

	}

	@Override
	public void deletarCompra(int idProduto) throws CompraException{
		try {
			Connection con = Conexao.getConexao();

			con.setAutoCommit(false);

			PreparedStatement pStmt = con.prepareStatement("DELETE FROM Compra WHERE ID = ? ;");

			pStmt.setInt(1, idProduto);

			pStmt.executeUpdate();
			con.commit();
			pStmt.close();
			con.close();
		} catch (SQLException e) {
			throw new CompraException(e.getMessage());
		}

	}

	@Override
	public List<Compra> listaDeCompra() throws CompraException{
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
			con.commit();
			pStmt.close();
			con.close();
		} catch (SQLException e) {
			throw new CompraException(e.getMessage());
		}
		return lista;
	}
	
	
}
