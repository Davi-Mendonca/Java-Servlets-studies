<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="br.com.alura.gerenciador.modelo.Empresa, java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
		<!-- Definindo condicional -->
	<c:if test="${not empty empresa }">
	Empresa ${ empresa } cadastrada com sucesso ! <br />
	</c:if>

	Lista de Empresas: <br />
	<ul>
		<!-- PERCORRENDO A LISTA DE EMPRESAS CADASTRADAS -->
		<c:forEach  items="${empresas }" var="empresa">
			<li>
			Id: ${empresa.id } - ${empresa.name } - <fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy"/><!-- <-- FORMATANDO A SAÍDA DA DATA -->
			<a href="/gerenciador/entrada?acao=mostraEmpresa&id=${empresa.id }">Editar</a>
			<a href="/gerenciador/entrada?acao=removeEmpresa&id=${empresa.id }">Remover</a>
			</li> 
			<br />
						
		</c:forEach>
		<a href="/gerenciador/formNovaEmpresa.jsp">Adicionar nova empresa</a>
	</ul>

</body>
</html>