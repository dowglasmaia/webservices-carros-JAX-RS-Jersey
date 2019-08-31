<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>Dowglas Maia</h2>

	<form method="post" action="<%=request.getContextPath()%>/hello">
	Nome: <input type="text" name="nome">
	<br/>
	
	Idade: <input type="text" name="idade">
	<br/>
	
	<input type="submit" name="enviar">
	
	</form>
	
</body>
</html>