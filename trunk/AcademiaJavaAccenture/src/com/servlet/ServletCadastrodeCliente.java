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

import com.domain.Cliente;
import com.fachada.Fachada;
import com.impl.repository.ClienteDao;
import com.impl.repository.Conexao;

@WebServlet("/ServletCliente")
public class ServletCadastrodeCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCadastrodeCliente() {
    	
        super();
     
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
	
		PrintWriter out = response.getWriter();
		
		try{

		 
		   Cliente cliente = new Cliente();
		   
		   cliente.setNome(request.getParameter("nome"));
		   cliente.setSobrenome(request.getParameter("sobrenome"));
		   cliente.setEndereçoPrincipal(request.getParameter("endereco1"));
		   cliente.setEndereçoAlternativo(request.getParameter("endereco2"));
		   cliente.setCidade(request.getParameter("cidade"));
		   cliente.setEstado(request.getParameter("estado"));
		   cliente.setCep(request.getParameter("cep"));
		   cliente.setPais(request.getParameter("pais"));
		   cliente.setSenha(request.getParameter("senha"));
		   cliente.setEmail(request.getParameter("email"));
		   
		   Fachada.getInstancia().novoCliente(cliente);


		   response.sendRedirect("login.jsp");
		 	 
		} finally {
		   out.close();
		}	
	
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	
	}

}
