<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.fachada.Fachada"%>
<%@page import="com.domain.Produto"%>
<%@page import="java.util.List"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Extreme</title>
</head>
<body>
	<%
	//recebe o valor digitado no campo usuario
 	Produto produto = new Produto();
	produto.setNomeProduto(request.getParameter("nomeProduto"));
	produto.setDescricaoProduto(request.getParameter("descricaoProduto"));
	produto.setPrecoProduto(new Float(request.getParameter("precoProduto")));
	produto.setTipoProduto(request.getParameter("tipoProduto"));
	
	out.println(" + " + produto.getNomeProduto());
	
	Fachada.getInstancia().inserirProduto(produto);
	/* String usuario = request.getParameter("nomeProduto");

	out.println("Seja bem vindo " + usuario); */
	   
 	%>
</body>
</html>