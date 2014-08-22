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
			pStmt.setInt(2, c.getIdCarrinho().codCarrinho());
			pStmt.setDouble(3, c.getValorTotal());
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
			pStmt.setInt(2, c.getIdCarrinho().codCarrinho());
			pStmt.setDouble(3, c.getValorTotal());
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
	public void deletarCompra(Compra compra) throws CompraException{
		try {
			Connection con = Conexao.getConexao();

			con.setAutoCommit(false);

			PreparedStatement pStmt = con.prepareStatement("DELETE FROM Compra WHERE ID = ? ;");

			pStmt.setInt(1, compra.getIdCompra());

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

			PreparedStatement pStmt = con.prepareStatement("select compra.ID, contausuario.Nome, compra.PrecoTotal, compra.TipoDescontocontausuario from compra inner join contausuario on compra.ID_ContaUsuario = ? inner join carrinho on compra.ID_carrinho = ?;");

			pStmt.setString(1, compra.getIdCliente().getNome());
			pStmt.setInt(2, compra.getIdCarrinho().codCarrinho());
			
			rs = pStmt.executeQuery();
			
			while (rs.next()) {
				compra = new Compra();
				
				compra.setIdCompra(rs.getInt("ID"));
				compra.getIdCliente().setNome(rs.getString("Nome"));
				compra.getIdCarrinho().setCodCarrinho(rs.getInt("PrecoTotal"));
				compra.setDesconto(rs.getString("TipoDescontocontausuario"));
				
				lista.add(compra);
			}
			con.commit();
			pStmt.close();
			con.close();
			
			
		} catch (SQLException e) {
			throw new CompraException(e.getMessage());
		} catch (Exception e) {
			throw new CompraException(e.getMessage());
		}
		return lista;
	}
	
	
}
