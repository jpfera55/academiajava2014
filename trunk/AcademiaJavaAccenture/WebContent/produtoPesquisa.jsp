<%@page import="com.impl.repository.RepositorioUtil"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.fachada.Fachada"%>
<%@page import="com.domain.Produto"%>
<%@page import="java.util.*"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Extreme</title>
</head>
<body>
	<%@include file="menu.jsp"%>
	<center>
		<form action="ServletPesquisarProduto" method="post">
			<h2>Pesquisa de produtos</h2>
			<table>
				<tr>
					<td><label>Nome:</label></td>
					<td><input type="text" name="nomeProduto"></td>
				</tr>
				<tr>
					<td><%=request.getAttribute("nomeProduto")%> </td>
					<td><input type="submit" value="Pesquisar"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>