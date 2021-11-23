<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<jsp:useBean id="math" class="service.MathService"></jsp:useBean>
	
	<c:set var="prueba" value="5"></c:set>
	<c:out value="${prueba + 10}"></c:out>
	
	<ul>
		<c:forEach begin="0" end="5" var="numerito">
			<li>
				<c:out value="${math.cuadrado(numerito)}"></c:out>
			</li>
		</c:forEach>
	</ul>
	
	<c:if test="${ prueba > 10 }"> es mayor </c:if>
	
	<c:choose>
		<c:when test="${ prueba < 10 }"> es menor a 10 </c:when>
		<c:when test="${ prueba < 20 }"> es menor a 20 </c:when>
		<c:when test="${ prueba < 30 }"> es menor a 30 </c:when>
		<c:when test="${ prueba < 40 }"> es menor a 40 </c:when>
		<c:otherwise> es mayor a 40 </c:otherwise>
	</c:choose>
	
	<%= request.getParameter("edad") %>
	
	<form method="get">
		<input name="edad">
		<input type="submit">
	</form>
</body>
</html>