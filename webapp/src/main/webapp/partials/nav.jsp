<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav>
	<h2><a href="/webapp/home.jsp">Inicio</a></h2>
	<ul>
		<li><a href="/webapp/producto/list.do">Productos</a></li>
		<c:if test="${ user.isAdmin() }">
			<li><a href="/webapp/usuario/list.adm">Usuarios</a></li>
		</c:if>
		<li><a href="/webapp/logout">Cerrar Sesion</a></li>
	</ul>
</nav>