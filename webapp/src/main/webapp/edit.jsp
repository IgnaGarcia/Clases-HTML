<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar producto</title>
</head>
<body>
	<nav>
		<a href="home.jsp">Inicio</a>
		<a href="producto/list.do">Productos</a>
		<a href="/webapp/logout">Cerrar Sesion</a>
	</nav>
	
	<h2> Editar el Producto </h2>
			
	<form action="edit.do" method="post">
			<input type="hidden" name="id" value="${ producto.getId() }">
		<jsp:include page="formProducto.jsp"></jsp:include>
	</form>
</body>
</html>