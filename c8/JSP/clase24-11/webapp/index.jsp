<html>
<body>
	<%! service.MathService math = new service.MathService(); %>
	
	<h2>Hello World!</h2>
	<!-- Expresiones JSP -->
	<p> cuadrado de 5 = <%= 5*5 %> </p>
	
	<!-- Scriptlets -->
	<%
		if(true){
			out.println("<ul> <li> algo </li> </ul>");
			%> <b>verdadero</b> <%
		} else {
			 %> <i>falso</i> <%
		}
	%>
	
	<table>
		<tr>
			<th> Nombre </th>
			<th> Precio </th>
		</tr>
		<%
			int[] precios = {150, 20, 15, 10};
			String[] nombres = math.getNames();
			
			for(int i=0; i<precios.length; i++){
				%>
				<tr>
					<td> <%= nombres[i] %> </td>
					<td> <%= precios[i] %> </td>
				</tr>
				<%
			}
		%>
	</table>
	
	<!-- Declaraciones -->
	<%!
		int cuadrado(int n){
			return n*n;
		}
	
		double porcentaje(int n, double p){
			return (n*p) / 100;	
		}
	%>
	
	<p> <%= cuadrado(5) %> </p>
	<p> <%= porcentaje(500, 10) %> </p>
	
	<!-- usando el service -->
	<p> <%= math.cuadrado(5) %> </p>
	<p> <%= math.porcentaje(500, 10) %> </p>
	
</body>
</html>