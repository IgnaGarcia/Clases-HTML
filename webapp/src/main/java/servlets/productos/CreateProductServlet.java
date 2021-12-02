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
		String name;
		Double price;
		Integer stock;
		try {
			name = req.getParameter("name");
			String priceString = req.getParameter("price");
			String stockString = req.getParameter("stock");
			
			req.setAttribute("name", name);
			req.setAttribute("price", priceString);
			req.setAttribute("stock", stockString);
			
			if(name.isBlank() || priceString.isBlank() || stockString.isBlank()) {
				throw new Exception("Hay campos en blanco");
			}
			
			price = Double.parseDouble(priceString);
			stock = Integer.parseInt(stockString);

			if(price < 0 || stock < 0) {
				throw new Exception("El PRECIO y el STOCK deben ser positivos");				
			}
			
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
		} catch(NumberFormatException e) {
			req.setAttribute("flash", "Formato de numero invalido");
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/create.jsp");
			dispatcher.forward(req, resp);
		} catch(Exception e) {
			req.setAttribute("flash", e.getMessage());
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/create.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
