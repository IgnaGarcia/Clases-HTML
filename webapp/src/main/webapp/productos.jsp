<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Productos</title>
</head>
<body>
	<nav>
		<a href="home.jsp">Inicio</a>
		<a href="#">Productos</a>
		<a href="logout">Cerrar Sesion</a>
	</nav>
	
	<h2> Estas son los Productos </h2>
		
	<a href="formProducto.jsp"> Crear nuevo Producto </a>	
	
	<table>
		<thead>
			<tr>
				<td>Nombre</td>
				<td>Precio</td>
				<td>Stock</td>
				<td>Acciones</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td>
					<a href="#">Comprar</a>
					<a href="formProducto.jsp">Editar</a>
					<a href="#">Borrar</a>
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>