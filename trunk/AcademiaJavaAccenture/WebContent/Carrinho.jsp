<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.fachada.Fachada"%>
<%@page import="com.domain.Carrinho"%>
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
		<form id="form" name="form" method="post" action="ServletCarrinho">
			<table border="1px" id="login">

				<tr>
					<td colspan="2"><h2>Carrinho de Compra</h2></td>
				</tr>
				<tr>
					<td>Codigo Carrinho: <input type="text" name="cod"></td>
                    <td>Id Produto:      <input type="text" name="id"></td>
					<td>Nome Produto:    <input type="text" name="produto"></td>
					<td>Unitario:        <input type="text" name="unitario"></td>
					<td>Quantidade:       <input type="text" name="qtd"></td>
					<td>Total     :       <input type="text" name="total"></td>
			
				</tr>

				<tr>
					<td><input type="reset" value="Limpar"></td>
					<td><input type="submit" name="acessar" value="Fechar Compra" id="botao"></td>
				</tr>
				
			</table>
		</form>

	</center>
</body>
</html>