package controller.productos;

import java.io.IOException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Producto;
import service.ProductoService;

@WebServlet("/producto/create.do")
public class CreateProductServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = -4953157559512379392L;
	ProductoService productoService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		productoService = new ProductoService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext()
			.getRequestDispatcher("/views/productos/create.jsp")
			.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		Double price = Double.parseDouble(req.getParameter("price"));
		Integer stock = Integer.parseInt(req.getParameter("stock"));
			
		Producto prod = productoService.create(name, price, stock);
		
		if(prod.isValid()) {
			resp.sendRedirect("list.do");
		} else {
			req.setAttribute("producto", prod);

			getServletContext()
				.getRequestDispatcher("/views/productos/create.jsp")
				.forward(req, resp);			
		}
	}
}
