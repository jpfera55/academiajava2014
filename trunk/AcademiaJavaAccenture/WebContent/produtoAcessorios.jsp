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
					<h3>Acessórios de camping</h3>
				</tr>
				<tr>
					<td>Id</td>
					<td>Nome</td>
					<td>Descrição</td>
					<td>Preço</td>
				</tr>
				<%
					List<Produto> lista = Fachada.getInstancia()
							.pesquisarProdutoPorTipo("Camping");
					for (Produto produto : lista) {
				%>
				<tr>
					<td><%=produto.getIdProduto()%></td>
					<td><%=produto.getNomeProduto()%></td>
					<td><%=produto.getDescricaoProduto()%></td>
					<td>R$<%=produto.getPrecoProduto()%></td>
					<td><img alt="Mais informações>" src="Imagens/plus.png">
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