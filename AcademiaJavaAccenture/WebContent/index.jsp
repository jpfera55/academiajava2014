<%@page import="com.domain.Fachada"%>
<%@page import="com.domain.Produto"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Extreme</title>
</head>
<body>
	<table border="1">
		<tr>
			<td> Nome </td>
			<td> Descrição </td>
			<td> Preço </td>
		</tr>
		<%
			List<Produto> lista = Fachada.getInstancia().listaProduto();
			for(Produto produto : lista){%>
				
				<tr>
					<td><%= produto.getNomeProduto() %></td>
					<td><%= produto.getDescricaoProduto() %></td>
					<td><%= produto.getPrecoProduto() %></td>
				</tr>
		<%	}
				%>
	</table>
</body>
</html>