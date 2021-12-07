package controller.productos;

import java.io.IOException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Producto;
import model.Usuario;
import service.BuyProductService;
import service.ProductoService;

@WebServlet("/producto/buy.do")
public class BuyProductServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1446711580290564602L;
	BuyProductService buyService;
	ProductoService productService;

	@Override
	public void init() throws ServletException {
		super.init();
		buyService = new BuyProductService();
		productService = new ProductoService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Usuario user = (Usuario) req.getSession().getAttribute("user");
		Producto prod = productService.find(Integer.parseInt(req.getParameter("id")));
		
		if(buyService.buy(user, prod)) {
			// la compra se realizo
		} else {
			//la compra no se realizo
			req.setAttribute("flash", "No se pudo realizar");

			getServletContext()
					.getRequestDispatcher("/views/productos/productos.jsp")
					.forward(req, resp);
		}
	}
}
