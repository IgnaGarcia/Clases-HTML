package servlets.productos;

import java.io.IOException;

import db.DataBase;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Producto;

@WebServlet("/producto/create.do")
public class CreateProductServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = -4953157559512379392L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/create.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		Double price = Double.parseDouble(req.getParameter("price"));
		Integer stock = Integer.parseInt(req.getParameter("stock"));
		
		Producto prod = new Producto(name, price, stock);
		
		if(DataBase.getInstance().createProduct(prod) == 0) {
			// succes
			resp.sendRedirect("list.do");
		} else {
			// error
			req.setAttribute("producto", prod);

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/create.jsp");
			dispatcher.forward(req, resp);			
		}
	}
}
