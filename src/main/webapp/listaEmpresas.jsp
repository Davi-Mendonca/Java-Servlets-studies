<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="br.com.alura.gerenciador.servlet.Empresa, java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Lista de Empresas: <br />
	<ul>
		<!-- PERCORRENDO A LISTA DE EMPRESAS CADASTRADAS -->
		<c:forEach  items="${empresas }" var="empresa">
			<li>${empresa.name } <fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy"/></li> <!-- <-- FORMATANDO A SAÍDA DA DATA -->
		</c:forEach>
	</ul>

</body>
</html>