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

@WebServlet("/producto/edit.do")
public class EditProductServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 8491472908004599342L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));

		Producto prod= DataBase.getInstance().getProduct(id);
		req.setAttribute("producto", prod);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/edit.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		Double price = Double.parseDouble(req.getParameter("price"));
		Integer stock = Integer.parseInt(req.getParameter("stock"));
		
		if(DataBase.getInstance().updateProduct(id, name, price, stock) == 0) {
			// succes
			resp.sendRedirect("list.do");
		} else {
			// error
			req.setAttribute("producto", new Producto(id, name, price, stock));

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/edit.jsp");
			dispatcher.forward(req, resp);			
		}
	}
}