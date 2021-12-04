<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Usuarios</title>
</head>
<body>
	<jsp:include page="/partials/nav.jsp"></jsp:include>
	
	<h2> Estos son los Usuarios </h2>
		
	<c:if test="${ user.isAdmin() }">
		<a href="create.adm"> Crear nuevo Usuario </a>
	</c:if>	
	
	<table>
		<thead>
			<tr>
				<td>Nombre</td>
				<td>Dinero</td>
				<td>Admin</td>
				<td>Acciones</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ userList }" var="usuario">
				<c:if test="${ usuario.isActive() }">
					<tr>
						<td> <c:out value="${ usuario.getUsername() }"></c:out> </td>
						<td> <c:out value="${ usuario.getMoney() }"></c:out> </td>
						<td> <c:out value="${ usuario.isAdmin()? 'Si' : 'No' }"></c:out> </td>
						<td>
							<a href="edit.adm?id=${ usuario.getId() }">Editar</a>
							<a href="delete.adm?id=${ usuario.getId() }">Borrar</a>
						</td>
					</tr>
				</c:if>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>