<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada" var="linkCadastrar" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="${linkCadastrar }" method="post">

		Cadastro de novo usuário:<hr/>
		Login: <input type="text" name="login" /> <br /> 
		Senha: <input type="password" name="senha" /> <br /> 
		<input type="hidden" name="acao" value="Cadastrar" /><br /> 
		<input type="submit" value="Enviar" />
		<c:import url="logout-parcial.jsp"></c:import>
	</form>
	
</body>
</html>