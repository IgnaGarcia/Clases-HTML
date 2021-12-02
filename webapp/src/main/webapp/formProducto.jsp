<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		
<label for="name">Nombre: </label>
<input type="text" name="name" value="${ producto == null? name : producto.getName() }" required/>
<br/>

<label for="price">Precio: </label>
<input type="number" name="price" value="${ producto == null? price : producto.getPrice() }" required/>
<br/>

<label for="stock">Stock: </label>
<input type="number" name="stock" value="${ producto == null? stock : producto.getStock() }" required/>
<br/>

<input type="submit" value="Enviar"/>
<button onclick="window.history.back();">Cancelar</button>