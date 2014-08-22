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
import com.exceptions.ProdutoComOIdZerado;
import com.interfaces.repository.InterfaceProduto;

//Bruno Monteiro -- 18/11/2014

public class ProdutoRepositorio implements InterfaceProduto {

	private Connection conexao = null;
	private PreparedStatement pStmt = null;
	ResultSet rs = null;
	
	@Override
	public void inserirProduto(Produto produto) {
		try {
			abrirConexao();
			
			this.pStmt = this.conexao.prepareStatement("INSERT INTO PRODUTO (product_name, product_description, "
			+ "product_image, product_price, product_type) VALUE (?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);

			this.pStmt.setString(1, produto.getNome());
			this.pStmt.setString(2, produto.getDescricao());
			this.pStmt.setString(3, produto.getImagem());
			this.pStmt.setFloat(4, produto.getPreco());
			this.pStmt.setString(5, produto.getTipo());
			
			this.pStmt.executeUpdate();
			
			int chavePrimariaInserida = RepositorioUtil.retornarChavePrimariaInserida(pStmt.getGeneratedKeys());

			//Produto Camping
			if (produto instanceof ProdutoCamping) {
				this.pStmt = conexao.prepareStatement("INSERT INTO produtocamping " + 
				"(Product_Id, Product_registraction) VALUE (?,?)");

				this.pStmt.setInt(1, chavePrimariaInserida);
				this.pStmt.setString(2, ((ProdutoCamping) produto).getRegistroDaAgenciaAmbiental());

				this.pStmt.executeUpdate();
			}else if(produto instanceof ProdutoVestuarioEEngrenagem){
				this.pStmt = conexao.prepareStatement("INSERT INTO produtoapparel " + 
				"(product_id, product_size, product_color) VALUE (?,?,?)");

				this.pStmt.setInt(1, chavePrimariaInserida);
				this.pStmt.setString(2, ((ProdutoVestuarioEEngrenagem) produto).getTamanho());
				this.pStmt.setString(3, ((ProdutoVestuarioEEngrenagem) produto).getCor());

				this.pStmt.executeUpdate();
			}

			commit();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ProdutoComOIdZerado e1) {
			rollback();
			System.out.println(e1.getMessage());
		} catch (Exception e2){
			System.out.println(e2.getMessage());
		} finally{
			fecharConexao();
		}

	}

	@Override
	public void alterarProduto(Produto produto) {
		try {
			abrirConexao();
			
			//Produto 
			this.pStmt = this.conexao.prepareStatement("UPDATE PRODUTO SET product_name = ?, "
			+ "product_description = ?, product_image = ?, product_price = ?, product_type = ? WHERE product_id = ?");

			this.pStmt.setString(1, produto.getNome());
			this.pStmt.setString(2, produto.getDescricao());
			this.pStmt.setString(3, produto.getImagem());
			this.pStmt.setFloat(4, produto.getPreco());
			this.pStmt.setString(5, produto.getTipo());
			this.pStmt.setInt(6, produto.getId());

			this.pStmt.executeUpdate();
			
			//Produto camping
			if(produto instanceof ProdutoCamping){
				this.pStmt = this.conexao.prepareStatement("UPDATE PRODUTOCAMPING SET "
				+ "Product_registraction = ? WHERE product_id = ? and Id_produtoCamping = ?");

				this.pStmt.setString(1, ((ProdutoCamping) produto).getRegistroDaAgenciaAmbiental());
				this.pStmt.setInt(2, produto.getId());
				this.pStmt.setInt(3, ((ProdutoCamping) produto).getIdCamping());

				this.pStmt.executeUpdate();	
			}else if(produto instanceof ProdutoVestuarioEEngrenagem){
				this.pStmt = this.conexao.prepareStatement("UPDATE produtoapparel SET "
				+ "Product_Size = ?, Product_Color = ? WHERE product_id = ? and Id_produtoApparel = ?");

				this.pStmt.setString(1, ((ProdutoVestuarioEEngrenagem) produto).getTamanho());
				this.pStmt.setString(2, ((ProdutoVestuarioEEngrenagem) produto).getCor());
				this.pStmt.setInt(3, produto.getId());
				this.pStmt.setInt(4, ((ProdutoVestuarioEEngrenagem) produto).getIdVestuarioEEngrenagem());

				this.pStmt.executeUpdate();
			}
			
			commit();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		} finally {
			fecharConexao();
		}

	}

	@Override
	public void deletarProduto(Produto produto) {
		try {
			abrirConexao();
			
			//Produto Camping
			if(produto instanceof ProdutoCamping){
				this.pStmt = this.conexao.prepareStatement("DELETE FROM produtocamping WHERE product_id = ?");

				this.pStmt.setInt(1, produto.getId());
				
				this.pStmt.executeUpdate();
			}else if (produto instanceof ProdutoVestuarioEEngrenagem){
				this.pStmt = this.conexao.prepareStatement("DELETE FROM produtoapparel WHERE product_id = ?");

				this.pStmt.setInt(1, produto.getId());
				
				this.pStmt.executeUpdate();	
			}
			
			//Produto
			this.pStmt = conexao.prepareStatement("DELETE FROM PRODUTO WHERE product_id = ?");
			
			this.pStmt.setInt(1, produto.getId());
			
			this.pStmt.executeUpdate();
			
			commit();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		} finally{
			fecharConexao();
		}

	}

	@Override
	public List<Produto> listaDeProduto() {
		
		List<Produto> lista = new ArrayList<Produto>();
		Produto produto = null;

		try {
			abrirConexao();

			this.pStmt = this.conexao.prepareStatement("SELECT * FROM PRODUTO");

			this.rs = this.pStmt.executeQuery();

			while (this.rs.next()) {
				produto = camposEmComum(this.rs);
				lista.add(produto);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		} finally{
			fecharConexao();
		}
		return lista;
	}

	@Override
	public List<ProdutoCamping> listaDeProdutoCamping() {
		List<ProdutoCamping> lista = new ArrayList<ProdutoCamping>();
		ProdutoCamping produtoCamping = null;

		try {
			abrirConexao();

			this.pStmt = this.conexao.prepareStatement("select * from produto right join " + 
			"produtocamping on produto.Product_Id = produtocamping.Product_Id");

			this.rs = this.pStmt.executeQuery();

			while (this.rs.next()) {
				produtoCamping = (ProdutoCamping) camposEmComum(this.rs);
				
				produtoCamping.setIdCamping(this.rs.getInt("Id_produtoCamping"));
				produtoCamping.setRegistroDaAgenciaAmbiental(this.rs.getString("Product_registraction"));

				lista.add(produtoCamping);
			}
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		} catch (Exception e1){
			System.out.println(e1.getMessage());
		} finally{
			fecharConexao();
		}
		return lista;
	}

	@Override
	public List<ProdutoVestuarioEEngrenagem> listaDeProdutoVestuarioEEngrenagem() {
		List<ProdutoVestuarioEEngrenagem> lista = new ArrayList<ProdutoVestuarioEEngrenagem>();
		ProdutoVestuarioEEngrenagem produtoVestuarioEEngrenagem = null;

		try {
			abrirConexao();

			this.pStmt = this.conexao.prepareStatement("select * from produto right join " + 
			"produtoapparel on produto.Product_Id = produtoapparel.Product_Id");

			this.rs = this.pStmt.executeQuery();

			while (this.rs.next()) {
				produtoVestuarioEEngrenagem = (ProdutoVestuarioEEngrenagem) camposEmComum(this.rs);
				
				produtoVestuarioEEngrenagem.setIdVestuarioEEngrenagem(this.rs.getInt("Id_produtoApparel"));
				produtoVestuarioEEngrenagem.setCor(this.rs.getString("Product_Color"));
				produtoVestuarioEEngrenagem.setTamanho(this.rs.getString("Product_Size"));

				lista.add(produtoVestuarioEEngrenagem);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}
		return lista;
	}

	@Override
	public Produto pesquisarProdutoPeloNome(String nome) {
		Produto produto = null;

		try {
			abrirConexao();

			this.pStmt = this.conexao.prepareStatement("SELECT * FROM PRODUTO WHERE Product_Name like ?");
			
			this.pStmt.setString(1, nome);

			this.rs = this.pStmt.executeQuery();

			while (this.rs.next()) {
				produto = camposEmComum(this.rs);
			}

		} catch (SQLException e) {
			e.getMessage();
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		} finally{
			fecharConexao();
		}
		return produto;
	}

	@Override
	public List<Produto> pesquisarProdutoPorTipo(String tipo) {
		Produto produto = null;
		List<Produto> lista = new ArrayList<Produto>();
		try {
			abrirConexao(); 

			this.pStmt = this.conexao.prepareStatement("SELECT * FROM PRODUTO WHERE Product_type like ?");
			
			this.pStmt.setString(1, tipo);

			this.rs = this.pStmt.executeQuery();

			while (this.rs.next()) {
				produto = camposEmComum(this.rs);
				
				lista.add(produto);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		} finally{
			fecharConexao();
		}
		return lista;
	}

	public Produto camposEmComum(ResultSet rs) throws SQLException{
		Produto produto = new Produto();
		
		produto.setId(rs.getInt("product_id"));
		produto.setNome(rs.getString("product_name"));
		produto.setDescricao(rs.getString("product_description"));
		produto.setImagem(rs.getString("product_image"));
		produto.setPreco(rs.getFloat("product_price"));
		produto.setTipo(rs.getString("product_type"));
		
		return produto;
	}

	public void abrirConexao() throws SQLException{
		this.conexao = Conexao.getConexao();
		this.conexao.setAutoCommit(false);
	}
	
	public void commit() throws SQLException{
		this.conexao.commit();
	}
	
	public void fecharConexao(){
		try {
			this.pStmt.close();
			this.conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void rollback(){
		try {
			conexao.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
