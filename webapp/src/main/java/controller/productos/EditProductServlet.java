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
		
		
		if(productoService.update(id, name, price, stock) != null) {
			// succes
			resp.sendRedirect("list.do");
		} else {
			// error
			req.setAttribute("producto", new Producto(id, name, price, stock));

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/productos/edit.jsp");
			dispatcher.forward(req, resp);			
		}
	}
}