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
	<%@include file="menu.jsp"%>
	<center>
		<form>
			<br>
			<table border="1">
				<tr>
					<h3>Audio/Video</h3>
				</tr>
				<tr>
					<td>Id</td>
					<td>Nome</td>
					<td>Descri��o</td>
					<td>Pre�o</td>
				</tr>
				<%
					List<Produto> lista = Fachada.getInstancia()
							.pesquisarProdutoPorTipo("Audio/Video");
					for (Produto produto : lista) {
				%>
				<tr>
					<td><%=produto.getId()%></td>
					<td><%=produto.getNome()%></td>
					<td><%=produto.getDescricao()%></td>
					<td>R$<%=produto.getPreco()%></td>
					<td><img alt="Adicionar ao carrinho" src="Imagens/carrinho.png">
				</tr>
				<%
					}
				%>
			</table>
		</form>
	</center>
</body>
</html>