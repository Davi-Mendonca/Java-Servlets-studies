<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkEntradaEmpresa"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="${linkEntradaEmpresa }" method="post"></form>
	
	Nome: <input type="text" name="name" /> <br />
	Data Abertura: <input type="text" name="data" /> <br />
	<input type="hidden" name="acao" value="novaEmpresa"/><br />
	
	<input type="submit" />

</body>
</html>