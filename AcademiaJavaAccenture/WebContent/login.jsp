<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--Érica Rodrigues-->
<html xmlns="http://www.w3.org/1999/xhtml" lang="pt-br" xml:lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

	<br />

	<center>
		<form id="form" name="form" method="post" action="ServletLogin">
			<table border="1px" id="login">

				<tr>

					<td colspan="2"><h2>Login do Usuário</h2></td>

				</tr>

				<tr>

					<td>Usuário: <input type="text" name="email"></td>


					<td>Senha: <input type="password" name="senha"></td>

				</tr>

				<tr>
					<td><input type="reset" value="Limpar"></td>
					<td><input type="submit" name="acessar" value="Acessar"
						id="botao"></td>
				</tr>
				<tr>

					<td colspan="2"><a href="cadastroCliente.jsp">Abrir uma
							Conta</a></td>

				</tr>

			</table>
		</form>

	</center>
</body>
</html>