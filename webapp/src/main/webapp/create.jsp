<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crear producto</title>
</head>
<body>
	<nav>
		<a href="home.jsp">Inicio</a>
		<a href="producto/list.do">Productos</a>
		<a href="/webapp/logout">Cerrar Sesion</a>
	</nav>
	
	<h2> Crear el Producto </h2>
			
	<form action="create.do" method="post">
		<jsp:include page="formProducto.jsp"></jsp:include>
	</form>
	<c:if test="${ flash != null }">
		<p><b> <c:out value="${ flash }"></c:out> </b></p>
	</c:if>
</body>
</html>