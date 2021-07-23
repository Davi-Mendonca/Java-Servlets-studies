<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada" var="linkEntradaEmpresa" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="${linkEntradaEmpresa }" method="post">

		Login: <input type="text" name="login" /> <br /> 
		Senha: <input type="password" name="senha" /> <br /> 
		<input type="hidden" name="acao" value="Login" /><br /> 
		<input type="submit" value="Entrar" />
		
		<a href="/gerenciador/entrada?acao=CadastrarUsuarioForm">Cadastrar novo usuário</a>
	</form>
	
</body>
</html>