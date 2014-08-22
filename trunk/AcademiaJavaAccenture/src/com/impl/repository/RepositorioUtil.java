package com.impl.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.domain.Produto;
import com.exceptions.MensagemErro;
import com.exceptions.ProdutoComOIdZerado;

//Bruno Monteiro -- 19/08/2014

public class RepositorioUtil {
	
	public static int retornarChavePrimariaInserida(ResultSet rs) throws SQLException, ProdutoComOIdZerado{
		rs.next();
		int idRetornado = rs.getInt(1);
		if(idRetornado != 0){
			return rs.getInt(1);
		}else{
			throw new ProdutoComOIdZerado(MensagemErro.ERRO_PRODUTO_ID_ZERADO.getMsg());
		}
	}
	
	public static List<String> listarTiposDePorudto(){
		ResultSet rs;
		List<String> lista = new ArrayList<String>();
		Produto produto = null;

		try {
			Connection con = Conexao.getConexao();

			con.setAutoCommit(false);

			PreparedStatement pStmt = con.prepareStatement("SELECT Product_Type FROM produto group by Product_Type");

			rs = pStmt.executeQuery();

			while (rs.next()) {
				lista.add(rs.getString("Product_Type"));
			}

			pStmt.close();
			con.close();
		} catch (SQLException e) {
			e.getMessage();
		}
		return lista;
	}
}
