<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inicio</title>
</head>
<body>
	<nav>
		<a href="#">Inicio</a>
		<a href="productos.jsp">Productos</a>
		<a href="logout">Cerrar Sesion</a>
	</nav>
	
	<h2> Bienvenid@ 
		<i> 
			<c:out value='${ user.getUsername() }'></c:out>! 
		</i>
	</h2>
	
	<a href="productos.jsp"> Ver productos </a>
</body>
</html>