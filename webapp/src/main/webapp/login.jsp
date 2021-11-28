<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ingresar</title>
</head>
<body>
	<c:if test='${ flash != null }'>
		<c:out value='${ flash }'></c:out>
	</c:if>
	
	<form action="/webapp/login" method="post">
		<label for="username">Nombre de usuario: </label>
		<input type="text" name="username" placeholder="pepito" required minlength="3"/>
		<br/>
		
		<label for="password">Contraseña: </label>
		<input type="password" name="password" placeholder="pepito" required minlength="5"/>
		<br/>

		<input type="submit" value="Ingresar"/>
	</form>
</body>
</html>