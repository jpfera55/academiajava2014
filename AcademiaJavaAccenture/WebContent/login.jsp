
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="estilo.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login de Usuário</title>
</head>

<body>
<center>
	<div id="todos">

<div id="cabecalho"><br/>



</div>

<div id="conteudo">

<center>
		<form action="ServeltLogar" methor="get" >
		<table border="1px" id="tabela">

			<tr>

			<td colspan="2"><h2>Login do Usuário</h2></td>

           </tr>
							
		   <tr>

		   <td>Usuario: <input placebolder="usuario" autocomplete="on" required="true" type="text" name="usuario"></td>
								

		    <td>Senha: <input placebolder="senha" autocomplete="on" required="true" type="password" name="senha"></td>
								
			</tr>
			<tr>
			<td><input type="reset" value="Limpar"></td>
			<td><input type="submit" name="acessar" value="Acessar"></td>
			</tr>
			<tr>

			<td colspan="2"><a  href="cadastro.jsp">Abrir uma Conta</a></td>

			</tr>

			</table>
		 </form>



</center>

</div>
<div id="rodape"></div>

</div>
</center>				

</body>
</html>