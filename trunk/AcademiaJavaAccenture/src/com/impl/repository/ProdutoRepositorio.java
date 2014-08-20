package com.impl.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.domain.Produto;
import com.domain.ProdutoCamping;
import com.domain.ProdutoVestuarioEEngrenagem;
import com.interfaces.repository.InterfaceProduto;

//Bruno Monteiro -- 18/11/2014

public class ProdutoRepositorio implements InterfaceProduto {

	private int chavePrimariaInserida;

	@Override
	public void inserirProduto(Produto produto) {
		try {
			Connection con = Conexao.getConexao();
			con.setAutoCommit(false);
			PreparedStatement pStmt = null;
			
			//Produto
			pStmt = con.prepareStatement("INSERT INTO PRODUTO (product_name, product_description, "
			+ "product_image, product_price, product_type) VALUE (?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);

			pStmt.setString(1, produto.getNomeProduto());
			pStmt.setString(2, produto.getDescricaoProduto());
			pStmt.setString(3, produto.getImagemProduto());
			pStmt.setFloat(4, produto.getPrecoProduto());
			pStmt.setString(5, produto.getTipoProduto());
			
			pStmt.executeUpdate();
			chavePrimariaInserida = RepositorioUtil.retornarChavePrimariaInserida(pStmt.getGeneratedKeys());

			//Produto Camping
			if (produto instanceof ProdutoCamping) {
				pStmt = con.prepareStatement("INSERT INTO produtocamping " + 
				"(Product_Id, Product_registraction) VALUE (?,?)");

				pStmt.setInt(1, chavePrimariaInserida);
				pStmt.setString(2, ((ProdutoCamping) produto).getRegistroDaAgenciaAmbiental());

				pStmt.executeUpdate();
			}else if(produto instanceof ProdutoVestuarioEEngrenagem){
				pStmt = con.prepareStatement("INSERT INTO produtoapparel " + 
				"(product_id, product_size, product_color) VALUE (?,?,?)");

				pStmt.setInt(1, chavePrimariaInserida);
				pStmt.setString(2, ((ProdutoVestuarioEEngrenagem) produto).getTamanhoProduto());
				pStmt.setString(3, ((ProdutoVestuarioEEngrenagem) produto).getCorProduto());

				pStmt.executeUpdate();
			}

			con.commit();
			pStmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void alterarProduto(Produto produto) {
		try {
			Connection con = Conexao.getConexao();
			con.setAutoCommit(false);
			PreparedStatement pStmt = null;
			
			//Produto 
			pStmt = con.prepareStatement("UPDATE PRODUTO SET product_name = ?, "
			+ "product_description = ?, product_image = ?, product_price = ?, product_type = ? WHERE product_id = ?");

			pStmt.setString(1, produto.getNomeProduto());
			pStmt.setString(2, produto.getDescricaoProduto());
			pStmt.setString(3, produto.getImagemProduto());
			pStmt.setFloat(4, produto.getPrecoProduto());
			pStmt.setString(5, produto.getTipoProduto());
			pStmt.setInt(6, produto.getIdProduto());

			pStmt.executeUpdate();
			
			//Produto camping
			if(produto instanceof ProdutoCamping){
				pStmt = con.prepareStatement("UPDATE PRODUTOCAMPING SET "
				+ "Product_registraction = ? WHERE product_id = ? and Id_produtoCamping = ?");

				pStmt.setString(1, ((ProdutoCamping) produto).getRegistroDaAgenciaAmbiental());
				pStmt.setInt(2, produto.getIdProduto());
				pStmt.setInt(3, ((ProdutoCamping) produto).getIdProdutoCamping());

				pStmt.executeUpdate();	
			}else if(produto instanceof ProdutoVestuarioEEngrenagem){
				pStmt = con.prepareStatement("UPDATE produtoapparel SET "
				+ "Product_Size = ?, Product_Color = ? WHERE product_id = ? and Id_produtoApparel = ?");

				pStmt.setString(1, ((ProdutoVestuarioEEngrenagem) produto).getTamanhoProduto());
				pStmt.setString(2, ((ProdutoVestuarioEEngrenagem) produto).getCorProduto());
				pStmt.setInt(3, produto.getIdProduto());
				pStmt.setInt(4, ((ProdutoVestuarioEEngrenagem) produto).getIdProdutoVestuarioEEngrenagem());

				pStmt.executeUpdate();
			}
			
			con.commit();
			pStmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void deletarProduto(Produto produto) {
		try {
			Connection con = Conexao.getConexao();
			con.setAutoCommit(false);
			PreparedStatement pStmt = null;
			
			//Produto Camping
			if(produto instanceof ProdutoCamping){
				pStmt = con.prepareStatement("DELETE FROM produtocamping WHERE product_id = ?");

				pStmt.setInt(1, produto.getIdProduto());
				
				pStmt.executeUpdate();
			}else if (produto instanceof ProdutoVestuarioEEngrenagem){
				pStmt = con.prepareStatement("DELETE FROM produtoapparel WHERE product_id = ?");

				pStmt.setInt(1, produto.getIdProduto());
				
				pStmt.executeUpdate();	
			}
			
			//Produto
			pStmt = con.prepareStatement("DELETE FROM PRODUTO WHERE product_id = ?");
			
			pStmt.setInt(1, produto.getIdProduto());
			
			pStmt.executeUpdate();
			
			con.commit();
			pStmt.close();
			con.close();
		} catch (SQLException e) {
			e.getMessage();
		}

	}

	@Override
	public List<Produto> listaDeProduto() {
		ResultSet rs;
		List<Produto> lista = new ArrayList<Produto>();
		Produto produto = null;

		try {
			Connection con = Conexao.getConexao();

			con.setAutoCommit(false);

			PreparedStatement pStmt = con.prepareStatement("SELECT * FROM PRODUTO");

			rs = pStmt.executeQuery();

			while (rs.next()) {
				produto = new Produto();

				produto.setIdProduto(rs.getInt("product_id"));
				produto.setNomeProduto(rs.getString("product_name"));
				produto.setDescricaoProduto(rs.getString("product_description"));
				produto.setImagemProduto(rs.getString("product_image"));
				produto.setPrecoProduto(rs.getFloat("product_price"));
				produto.setTipoProduto(rs.getString("product_type"));

				lista.add(produto);
			}

			pStmt.close();
			con.close();
		} catch (SQLException e) {
			e.getMessage();
		}
		return lista;
	}

	@Override
	public List<ProdutoCamping> listaDeProdutoCamping() {
		ResultSet rs;
		List<ProdutoCamping> lista = new ArrayList<ProdutoCamping>();
		ProdutoCamping produtoCamping = null;

		try {
			Connection con = Conexao.getConexao();

			con.setAutoCommit(false);

			PreparedStatement pStmt = con.prepareStatement("select * from produto right join " + 
			"produtocamping on produto.Product_Id = produtocamping.Product_Id");

			rs = pStmt.executeQuery();

			while (rs.next()) {
				produtoCamping = new ProdutoCamping();

				produtoCamping.setIdProduto(rs.getInt("product_id"));
				produtoCamping.setNomeProduto(rs.getString("product_name"));
				produtoCamping.setDescricaoProduto(rs.getString("product_description"));
				produtoCamping.setImagemProduto(rs.getString("product_image"));
				produtoCamping.setPrecoProduto(rs.getFloat("product_price"));
				produtoCamping.setTipoProduto(rs.getString("product_type"));
				produtoCamping.setIdProdutoCamping(rs.getInt("Id_produtoCamping"));
				produtoCamping.setRegistroDaAgenciaAmbiental(rs.getString("Product_registraction"));

				lista.add(produtoCamping);
			}

			pStmt.close();
			con.close();
		} catch (SQLException e) {
			e.getMessage();
		}
		return lista;
	}

	@Override
	public List<ProdutoVestuarioEEngrenagem> listaDeProdutoVestuarioEEngrenagem() {
		ResultSet rs;
		List<ProdutoVestuarioEEngrenagem> lista = new ArrayList<ProdutoVestuarioEEngrenagem>();
		ProdutoVestuarioEEngrenagem produtoVestuarioEEngrenagem = null;

		try {
			Connection con = Conexao.getConexao();

			con.setAutoCommit(false);

			PreparedStatement pStmt = con.prepareStatement("select * from produto right join " + 
			"produtoapparel on produto.Product_Id = produtoapparel.Product_Id");

			rs = pStmt.executeQuery();

			while (rs.next()) {
				produtoVestuarioEEngrenagem = new ProdutoVestuarioEEngrenagem();

				produtoVestuarioEEngrenagem.setIdProduto(rs.getInt("product_id"));
				produtoVestuarioEEngrenagem.setNomeProduto(rs.getString("product_name"));
				produtoVestuarioEEngrenagem.setDescricaoProduto(rs.getString("product_description"));
				produtoVestuarioEEngrenagem.setImagemProduto(rs.getString("product_image"));
				produtoVestuarioEEngrenagem.setPrecoProduto(rs.getFloat("product_price"));
				produtoVestuarioEEngrenagem.setTipoProduto(rs.getString("product_type"));
				produtoVestuarioEEngrenagem.setIdProdutoVestuarioEEngrenagem(rs.getInt("Id_produtoApparel"));
				produtoVestuarioEEngrenagem.setCorProduto(rs.getString("Product_Color"));
				produtoVestuarioEEngrenagem.setTamanhoProduto(rs.getString("Product_Size"));

				lista.add(produtoVestuarioEEngrenagem);
			}

			pStmt.close();
			con.close();
		} catch (SQLException e) {
			e.getMessage();
		}
		return lista;
	}

}
