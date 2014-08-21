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
		<form action="ServletProduto" method="post">
			<h2>Cadastro de produtos</h2>
			<table>
				<tr>
					<td><label>Nome:</label></td>
					<td><input type="text" name="nomeProduto"></td>
				</tr>
				<tr>
					<td><label>Descrição:</label></td>
					<td><input type="text" name="descricaoProduto"></td>
				</tr>
				<tr>
					<td><label>Preço:</label></td>
					<td><input type="text" name="precoProduto"></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td><label>Tipo:</label></td>
					<td><select name="tipoProduto">
							<option value="Vestuario">Vestuario</option>
							<option value="Engrenagem">Engrenagem</option>
							<option value="Camping">Camping</option>
							<option value="Audio/Video">Audio/Video</option>
							<option value="Livro">Livro</option>
					</select></td>
				</tr>
				<tr>
					<td>
						<input type="submit" value="Cadastrar">
					</td>	
				</tr>
			</table>

			
		</form>
	</center>
</body>
</html>