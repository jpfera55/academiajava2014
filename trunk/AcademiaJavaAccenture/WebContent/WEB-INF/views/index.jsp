

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
	<ui:composition template="/Template.jsp">
		<ui:define name="central">
			<table border="1">
		<tr>
			<td>Id</td>
			<td>Nome</td>
			<td>Descri��o</td>
			<td>Pre�o</td>
		</tr>
		
			<%
				List<Produto> lista = Fachada.getInstancia().listaProduto();
				for(Produto produto : lista){
					%>
					<tr>
					<td><%=produto.getIdProduto() %></td>
					<td><%=produto.getNomeProduto() %></td>
					<td><%=produto.getDescricaoProduto() %></td>
					<td><%=produto.getPrecoProduto() %></td>
					</tr>			
				<%
				}
			%>
		
	</table>
		</ui:define>
	</ui:composition>
</body>
</html>