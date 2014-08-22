package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.Produto;
import com.fachada.Fachada;

/**
 * Servlet implementation class ServletPesquisarProduto
 */
@WebServlet("/ServletPesquisarProduto")
public class ServletPesquisarProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPesquisarProduto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		String  nomeProduto;
		
		nomeProduto = request.getParameter("nomeProduto");
				
		Fachada.getInstancia().pesquisarProdutoPorNome(nomeProduto);
		
		response.sendRedirect("produtoPesquisa.jsp?nome=nomeProduto");
	}

}
