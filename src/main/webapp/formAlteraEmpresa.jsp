<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/alteraEmpresa" var="linkServletNovaEmpresa"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="${linkServletNovaEmpresa }" method="post">
	
	Nome: <input type="text" name="name" value="${empresa.name }"/> <br />
	Data Abertura: <input type="text" name="data" 
		value="<fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy"/>"/> <br />
	<input type="hidden" name="id" value="${empresa.id }"/><br />
	<input type="submit" />
	</form>

</body>
</html>