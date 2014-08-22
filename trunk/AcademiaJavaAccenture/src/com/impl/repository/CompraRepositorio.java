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
	public void novaCompra(Compra compra) throws CompraException {
		try {
			Connection conexao = Conexao.getConexao();

			conexao.setAutoCommit(false);
			
			
			
			PreparedStatement pStmt = conexao.prepareStatement("INSERT INTO Compra VALUES(?,?,?,'?');");

			pStmt.setInt(1, compra.getCliente().getId());
			pStmt.setInt(2, compra.getCarrinho().getcodCarrinho());
			pStmt.setDouble(3, compra.getValorTotal());
			pStmt.setString(4, compra.getDesconto());

			pStmt.executeUpdate();
			conexao.commit();
			pStmt.close();
			conexao.close();
		}catch (SQLException e) {
			throw new CompraException("Erro: " + e.getMessage());	
		}catch (Exception e){
			System.out.println("Erro: " + e.getMessage());
		}finally{
			
		}

	}

	@Override
	public void alterarCompra(Compra compra) throws CompraException{
		try {
			Connection conexao = Conexao.getConexao();

			conexao.setAutoCommit(false);

			PreparedStatement pStmt = conexao.prepareStatement("UPDATE Compra SET ID_ContaUsuario = ?, ID_carrinho = ?, PrecoTotal = ?, TipoDesconto = '?' WHERE ID = ?;");

			pStmt.setInt(1, compra.getCliente().getId());
			pStmt.setInt(2, compra.getCarrinho().getcodCarrinho());
			pStmt.setDouble(3, compra.getValorTotal());
			pStmt.setString(4, compra.getDesconto());
            pStmt.setInt(5, compra.getIdCompra());

			
			
			pStmt.executeUpdate();
			conexao.commit();
			pStmt.close();
			conexao.close();
		} catch (SQLException e) {
			throw new CompraException(e.getMessage());
		}catch (Exception e){
			System.out.println("Erro: " + e.getMessage());
		}finally{
			
		}


	}

	@Override
	public void deletarCompra(Compra compra) throws CompraException{
		try {
			Connection conexao = Conexao.getConexao();

			conexao.setAutoCommit(false);

			PreparedStatement pStmt = conexao.prepareStatement("DELETE FROM Compra WHERE ID = ? ;");

			pStmt.setInt(1, compra.getIdCompra());

			pStmt.executeUpdate();
			conexao.commit();
			pStmt.close();
			conexao.close();
		} catch (SQLException e) {
			throw new CompraException(e.getMessage());
		}catch (Exception e){
			System.out.println("Erro: " + e.getMessage());
		}finally{
			
		}


	}
	
	@Override
	public List<Compra> listarCompras(Compra compra) throws CompraException{
		ResultSet rs;
		List<Compra> listaTudo = new ArrayList<Compra>();
		
		try {
			Connection conexao = Conexao.getConexao();

			conexao.setAutoCommit(false);
            compra = null;
			PreparedStatement pStmt = conexao.prepareStatement("select compra.ID, compra.ID_carrinho, compra.ID_ContaUsuario, compra.PrecoTotal, compra.TipoDescontocontausuario from compra Where compra.ID = ?");

			pStmt.setInt(1, compra.getIdCompra());
			
			rs = pStmt.executeQuery();
			
			while (rs.next()) {
				compra = new Compra();
				
				compra.setIdCompra(rs.getInt("ID"));
				compra.getCliente().setNome(rs.getString("Nome"));
				compra.getCarrinho().setCodCarrinho(rs.getInt("PrecoTotal"));
				compra.setDesconto(rs.getString("TipoDescontocontausuario"));
				
				listaTudo.add(compra);
			}
			conexao.commit();
			pStmt.close();
			conexao.close();
			
			
		} catch (SQLException e) {
			throw new CompraException(e.getMessage());
		} catch (Exception e) {
			throw new CompraException(e.getMessage());
		}finally{
			
		}

		
		return listaTudo;
	}

	@Override
	public List<Compra> listarCompraEspecifica(Compra compra) throws CompraException{
		ResultSet rs;
		List<Compra> lista = new ArrayList<Compra>();
		
		
		try {
			Connection conexao = Conexao.getConexao();

			conexao.setAutoCommit(false);
            compra = null;
			PreparedStatement pStmt = conexao.prepareStatement("select compra.ID, contausuario.Nome, compra.PrecoTotal, compra.TipoDescontocontausuario from compra inner join contausuario on compra.ID_ContaUsuario = ? inner join carrinho on compra.ID_carrinho = ?;");

			pStmt.setString(1, compra.getCliente().getNome());
			pStmt.setInt(2, compra.getCarrinho().getcodCarrinho());
			
			rs = pStmt.executeQuery();
			
			while (rs.next()) {
				compra = new Compra();
				
				compra.setIdCompra(rs.getInt("ID"));
				compra.getCliente().setNome(rs.getString("Nome"));
				compra.getCarrinho().setCodCarrinho(rs.getInt("PrecoTotal"));
				compra.setDesconto(rs.getString("TipoDescontocontausuario"));
				
				lista.add(compra);
			}
			conexao.commit();
			pStmt.close();
			conexao.close();
			
			
		} catch (SQLException e) {
			throw new CompraException(e.getMessage());
		} catch (Exception e) {
			throw new CompraException(e.getMessage());
		}finally{
			
		}

		return lista;
	}
	
	
}