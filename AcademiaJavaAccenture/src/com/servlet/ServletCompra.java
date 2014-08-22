package com.servlet;

import java.io.IOException;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.spi.http.HttpContext;

import com.domain.Compra;
import com.domain.Produto;
import com.fachada.Fachada;

/**
 * Servlet implementation class ServletCompra
 */

@WebService("/ServletCompra")
public class ServletCompra extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public ServletCompra() {
        super();
        
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		
		Compra compra = new Compra();
		
		compra.getIdCarrinho().setIdCarrinho(Integer.parseInt(request.getParameter("Id_Carrinho")));

		Fachada f = new Fachada();
		f.novaCompra(compra);
		
		response.sendRedirect("index.jsp");
	}
	
}
