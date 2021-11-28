package servlets.productos;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import db.DataBase;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Producto;

@WebServlet("/producto/list")
public class ListProductServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = -2978092874230647675L;
	List<Producto> products;
	
	@Override
	public void init() throws ServletException {
		// Consultamos a la DB los productos
		products = DataBase.getInstance().getProducts();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("products", products);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/productos.jsp");
		dispatcher.forward(req, resp);
	}
}