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
	<jsp:include page="/partials/nav.jsp"></jsp:include>
	
	<h2> Bienvenid@ 
		<i> 
			<c:out value='${ user.getUsername() }'></c:out>! 
		</i>
	</h2>
	
	<c:if test="${ flash != null }">
		<c:out value="${ flash }"></c:out>
	</c:if>
	
	<a href="producto/list.do"> Ver productos </a>
</body>
</html>