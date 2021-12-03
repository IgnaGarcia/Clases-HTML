package controller.productos;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Producto;
import service.ProductoService;

@WebServlet("/producto/edit.do")
public class EditProductServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 8491472908004599342L;
	ProductoService productoService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		productoService = new ProductoService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));

		req.setAttribute("producto", productoService.find(id));

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/productos/edit.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		Double price = Double.parseDouble(req.getParameter("price"));
		Integer stock = Integer.parseInt(req.getParameter("stock"));
		
		Producto prod = productoService.update(id, name, price, stock);
		if(prod.isValid()) {
			resp.sendRedirect("list.do");
		} else {
			req.setAttribute("producto", prod);

			getServletContext()
					.getRequestDispatcher("/views/productos/edit.jsp")
					.forward(req, resp);			
		}
	}
}