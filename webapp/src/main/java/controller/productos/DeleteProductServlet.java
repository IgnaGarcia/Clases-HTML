package controller.productos;

import java.io.IOException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ProductoService;

@WebServlet("/producto/delete.do")
public class DeleteProductServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = -5506851070266130036L;
	ProductoService productoService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		productoService = new ProductoService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		productoService.delete(id);
		resp.sendRedirect("/webapp/producto/list.do");
	}
}
