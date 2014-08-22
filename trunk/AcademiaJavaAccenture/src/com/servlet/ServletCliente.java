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

import com.domain.ContadoCliente;
import com.impl.repository.ClienteDao;
import com.impl.repository.Conexao;

@WebServlet("/ServletCliente")
public class ServletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCliente() {
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

		   Conexao con = new Conexao();
		   ClienteDao dao = new ClienteDao();
		   ContadoCliente cliente = new ContadoCliente();
		   
		   cliente.setNome(request.getParameter("nome"));
		   cliente.setSobrenome(request.getParameter("sobrenome"));
		   cliente.setEndereço1(request.getParameter("endereco1"));
		   cliente.setEndereço2(request.getParameter("endereco2"));
		   cliente.setCidade(request.getParameter("cidade"));
		   cliente.setEstado(request.getParameter("estado"));
		   cliente.setCep(request.getParameter("cep"));
		   cliente.setPais(request.getParameter("pais"));
		   cliente.setSenha(request.getParameter("senha"));
		   cliente.setEmail(request.getParameter("email"));
		   
		   dao.novoCliente(cliente);


		   response.sendRedirect("login.jsp");
		 	 
		} finally {
		   out.close();
		}	
	
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	
	}

}
