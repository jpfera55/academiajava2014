package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.ContadoCliente;
import com.fachada.Fachada;
import com.impl.repository.ClienteDao;
import com.impl.repository.Conexao;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		

		   
		   ContadoCliente cliente = new ContadoCliente();
		   
		   cliente.setEmail(request.getParameter("email"));
		   cliente.setSenha(request.getParameter("senha"));
	   
		   if(Fachada.getInstancia().loginCliente(cliente)){
			   response.sendRedirect("menu.jsp");
		   }else{
			   response.sendRedirect("Erro.jsp");
		   }

		   
		 	 
			
	}

}
