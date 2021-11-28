package servlets.session;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import db.DataBase;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;

@WebServlet("/login")
public class LoginServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 2374585846603349039L;
	Map<String, Usuario> usermap;
	
	@Override
	public void init() throws ServletException {
		// Consultamos a la DB los usuarios
		usermap = DataBase.getInstance().getUsers();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Capto los parametros recibidos en la request
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		RequestDispatcher dispacher;
		
		// Verificamos que el usuario y contraseña sean correctas
		if(usermap.containsKey(username) 
				&& usermap.get(username).auth(password)) {
			
			// Seteamos en la sesion el usuario y preparamos el destino
			req.getSession().setAttribute("user", usermap.get(username));
    		resp.sendRedirect("home.jsp");   
			
		} else {
			
			// Seteamos en request el mensaje y preparamos el destino
			req.setAttribute("flash", "Usuario y/o Contraseña Incorrecta");
			dispacher = getServletContext().getRequestDispatcher("/login.jsp");
			
			// Realizo el evento hacia la pagina seteada
			dispacher.forward(req, resp);
		}
	}
}
