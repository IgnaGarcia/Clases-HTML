<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Productos</title>
</head>
<body>
	<jsp:include page="/partials/nav.jsp"></jsp:include>
	
	<h2> Estos son los Productos </h2>
		
	<c:if test="${ user.isAdmin() }">
		<a href="create.do"> Crear nuevo Producto </a>
	</c:if>	
	
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
			<c:forEach items="${ products }" var="product">
				<c:if test="${ product.isActive() }">
					<tr>
						<td> <c:out value="${ product.getName() }"></c:out> </td>
						<td> <c:out value="${ product.getPrice() }"></c:out> </td>
						<td> <c:out value="${ product.getStock() }"></c:out> </td>
						<c:choose>
							<c:when test="${ user.isAdmin() }">
								<td>
									<a href="edit.do?id=${ product.getId() }">Editar</a>
									<a href="delete.do?name=${ product.getName() }">Borrar</a>
								</td>
							</c:when>
							<c:otherwise>
								<td>
									<a href="#">Comprar</a>
								</td>
							</c:otherwise>
						</c:choose>
					</tr>
				</c:if>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>