<html>
<body>
	<h2>Hello World!</h2>
	
	<!-- Expresiones JSP -->
	<p> <%= new java.util.Date() %> </p>
	<span> 10% de 20500 es <%= 20500 * 0.1 %></span>
	
	<!-- Scriptlets JSP -->
	<ul>
	<%
		for(int i=0; i<5; i++){
			%>
			<li> <%= i %> </li>
			<%
		}
	%>
	</ul>
	
	<!-- Declaraciones JSP -->
	<%! int[] numeros = {15, 30, 27, 40, 150}; %>
		
	<ul>
	<%
		for(int i=0; i<numeros.length; i++){
			%>
			<li> 
				<%= new service.ToItemService().toItem(numeros[i]) %> 
				- 
				<%= new service.MathService().porcentaje(numeros[i], 50) %> 
			</li>
			<%
		}
	%>
	</ul>
</body>
</html>
