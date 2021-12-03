package controller.productos;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ProductoService;

@WebServlet("/producto/list.do")
public class ListProductServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = -2978092874230647675L;
	ProductoService productoService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		productoService = new ProductoService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("products", productoService.list());
		getServletContext()
			.getRequestDispatcher("/views/productos/productos.jsp")
			.forward(req, resp);
	}
}