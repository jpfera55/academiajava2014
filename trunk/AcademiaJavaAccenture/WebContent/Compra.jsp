<%@page import="com.domain.ItensCarrinho"%>
<%@page import="com.exceptions.CarrinhoException"%>
<%@page import="org.springframework.beans.factory.ListableBeanFactory"%>
<%@page import="com.domain.Compra"%>
<%@page import="com.fachada.Fachada"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Concluir compra</title>
</head>
<body>
	<%@include file="menu.jsp"%>
	<center>
		<form>
			<table border="1">
				<tr>
					<h3>Infromações da Compra</h3>
				</tr>
				<tr>
					<td>ID da compra:</td>
					<td>Nome do cliente:</td>
					<td>Valor total da compra:</td>
					<td>Desconto:</td>
					<td>Valor com desconto:</td>
				</tr>
				<tr>



				<% Fachada f = new Fachada();%>
				<% Compra c = new Compra(); %>
				<%List<Compra>ListaCompra;%>
				<%ListaCompra = f.listarCompras(c);%>	
				<!-- 
				Mudar ao terminar a parte de carrinho
				 -->
				 <% %>
				 
				 
				<!-- 
				Mudar ao terminar a parte de carrinho
				 -->
				<%double valorComDesconto = 0;%>
				<%double valorDescontoRegular = 0.10; %>
				<%double valorDescontoPremium = 0.20; %>
				<%double valortotal = ListaCompra.get(1).getValorTotal();%>
					<td><%ListaCompra.get(1).getIdCompra();%></td>
					<td><%ListaCompra.get(1).getIdCliente().getNome();%></td>
					<td><%ListaCompra.get(1).getValorTotal();%></td>
					<td><%ListaCompra.get(1).getDesconto();%></td>
					<%if(ListaCompra.get(1).getDesconto() == "Regular"){%>
					<%valorComDesconto = valortotal * valorDescontoRegular; %>
					<%}else if(ListaCompra.get(1).getDesconto() == "Premium"){%>
					<%valorComDesconto = valortotal * valorDescontoRegular; %>
					<%} %>
					<td><%= valorComDesconto %></td>
				</tr>

			</table>






		</form>
	</center>
</body>
</html>