<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		
<label for="name">Nombre: </label>
<input type="text" name="name" value="${ producto.getName() }" required/>
<c:if test='${ errors.containsKey("name") }'>
	<br/>
	<span><c:out value='${ errors.get("name") }'></c:out></span>
</c:if>
<br/>

<label for="price">Precio: </label>
<input type="number" name="price" value="${ producto.getPrice() }" required/>
<c:if test='${ errors.containsKey("price") }'>
	<br/>
	<span><c:out value='${ errors.get("price") }'></c:out></span>
</c:if>
<br/>

<label for="stock">Stock: </label>
<input type="number" name="stock" value="${ producto.getStock() }" required/>
<c:if test='${ errors.containsKey("stock") }'>
	<br/>
	<span><c:out value='${ errors.get("stock") }'></c:out></span>
</c:if>
<br/>

<input type="submit" value="Enviar"/>
<button onclick="window.history.back();">Cancelar</button>