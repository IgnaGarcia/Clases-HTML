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
		Integer productId = Integer.parseInt(req.getParameter("id"));
		Producto prod = productService.find(productId);
		
		if(buyService.buy(user, prod)) {
			// la compra se realizo
			req.setAttribute("flash", "Comprado Exitosamente");
		} else {
			//la compra no se realizo
			req.setAttribute("flash", "No se pudo realizar");
		}
		
		getServletContext()
			.getRequestDispatcher("/producto/list.do")
			.forward(req, resp);
	}
}
