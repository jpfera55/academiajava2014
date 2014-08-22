
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--Érica Rodrigues-->
<html lang="pt-br" >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro do Cliente</title>
</head>
<body>

<a href="login.jsp" alight="left" >Voltar a Página</a>

<center>
		<form action=" ServletCliente" method="post" >
		<table border="1px" id="tabela1" width="400px" height="500px">

			<tr>

			<td colspan="2" ><h2>Cadastro de Usuário</h2></td>

           </tr>
           <tr>	

		   <td>     Nome: <input  type="text" name ="nome"  size="40" maxlength="30"></td>
								
           </tr>
           <tr>
		    <td>Sobrenome: <input   type="text" name="sobrenome"  size="35" maxlength="30" ></td>
					
			</tr>	
			 <tr>
		    <td>Endereço1: <input   type="text" name="endereco1" size="35" maxlength="30" ></td>
					
			</tr>
			 <tr>
		    <td>Endereço2: <input   type="text" name="endereco2"  size="35" maxlength="30"></td>
					
			</tr>
		    <tr>
		    <td>Cidade: <input   type="text" name="cidade"  size="39" maxlength="30" ></td>
					
			</tr>
			<tr>
		    <td>Estado: <input   type="text" name="estado"  size="39" maxlength="30"></td>
					
			</tr>
			<tr>
		    <td>Cep: <input   type="text" name="cep"  size="42" maxlength="30"></td>
					
			</tr>
			<tr>
		    <td>País: <input   type="text" name="pais"  size="42" maxlength="30"></td>
					
			</tr>
			<tr>	

		   <td>Usuario: <input required="true" type="text" name ="email"   size="38" maxlength="30" ></td>
								
           </tr>
            <tr>
		    <td>Senha: <input   type="password" name="senha"  size="42" maxlength="30"></td>
					
			</tr>				
	
			<tr>
			<td><input type="reset" value="Limpar">
			<input type="submit" name="acessar" value="Acessar" ></td>
			</tr>
			
			</table>
		 </form>

</center>

</body>
</html>