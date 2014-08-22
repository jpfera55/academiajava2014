package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import com.domain.ItensCarrinho;
import com.fachada.Fachada;
import com.impl.repository.AdicionaCarrinhoAction;
import com.impl.repository.Conexao;

/**
 * Servlet implementation class ServletCarrinhos
 */
@WebServlet("/ServletCarrinhos")
public class ServletCarrinhos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCarrinhos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub,
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=ISO-8859-1");
		
		PrintWriter out = response.getWriter();
		try{

		    Conexao con = new Conexao();
		    AdicionaCarrinhoAction  dao = new AdicionaCarrinhoAction ();
		   ItensCarrinho  c = new ItensCarrinho();
		   

		
		c.setIdCarrinho(new Integer(request.getParameter("idCarrinho")));
		c.getProdutoCarrinho().setIdProduto(Integer.parseInt(request.getParameter("idCarrinho")));
		c.setQuantidadeCarrinho(new Integer(request.getParameter("quantidate")));
		c.getProdutoCarrinho().setPrecoProduto(Integer.parseInt(request.getParameter("PrecoUnitario")));
		c.getProdutoCarrinho().setPrecoProduto((Integer.parseInt(request.getParameter("total"))));
		
		

		dao.adicionarCarrinho(c);
		out.println();
		 response.sendRedirect("index.jsp");
		 
		 	 
		} finally {
		   out.close();
		}	
	
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	
	}

}