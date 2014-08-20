<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" type="text/css" href="estilo.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Loja Web</title>
</head>
<body>
<center>
<div id="todos">

<div id="cabecalho"><br/>

<h1 >SISTEMA JAVA WEB</h1>

</div>

<div id="conteudo">

<div id="menu">
<ol>
	<br><li><a href="link1.jsp">link1</a></li></br>
	
	<br><li><a href="link2.jsp">link2</a></li></br>
	
	<br><li><a href="link3.jsp">link3</a></li></br>
	
	<br><li><a href="link4.jsp">link4</a></li></br>
	
	<br><li><a href="login.jsp">Login</a></li></br>
</ol>
</div>

<div id="central">


</div>
	<ui:insert name="central"/>
</div>
<div id="rodape"></div>

</div></center>
</body>
</html>