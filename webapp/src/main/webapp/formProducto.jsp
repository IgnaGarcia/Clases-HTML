<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crear/Editar</title>
</head>
<body>
	<nav>
		<a href="home.jsp">Inicio</a>
		<a href="producto/list">Productos</a>
		<a href="logout">Cerrar Sesion</a>
	</nav>
	
	<h2> Editar el Producto </h2>
	<h2> Crear el Producto </h2>
			
	<form action="list" method="post">
		<label for="name">Nombre: </label>
		<input type="text" name="name" placeholder="coca" required/>
		<br/>
		
		<label for="price">Precio: </label>
		<input type="number" name="price" placeholder="150" required/>
		<br/>
		
		<label for="stock">Stock: </label>
		<input type="number" name="stock" placeholder="10" required/>
		<br/>
		
		<input type="submit" value="Enviar"/>
	</form>
</body>
</html>