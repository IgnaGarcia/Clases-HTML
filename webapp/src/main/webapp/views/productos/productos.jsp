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
		<a href="create.adm"> Crear nuevo Producto </a>
	</c:if>	
	
	<c:if test="${ flash != null }">
		<c:out value="${ flash }"></c:out>
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
						<td>
						<c:choose>
							<c:when test="${ user.isAdmin() }">
								<a href="edit.adm?id=${ product.getId() }">Editar</a>
								<a href="delete.adm?id=${ product.getId() }">Borrar</a>
							</c:when>
							<c:when test="${ user.puedePagar(product) && product.puedeOfertarse() }">
								<a href="buy.do?id=${ product.getId() }">Comprar</a>							
							</c:when>
							<c:otherwise>
								<span>No disponible</span>
							</c:otherwise>
						</c:choose>
						</td>
					</tr>
				</c:if>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>