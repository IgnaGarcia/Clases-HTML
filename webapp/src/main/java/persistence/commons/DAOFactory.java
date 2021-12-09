package persistence.commons;

import persistence.CompraDAO;
import persistence.ProductoDAO;
import persistence.UsuarioDAO;
import persistence.impl.CompraDAOImpl;
import persistence.impl.ProductoDAOImpl;
import persistence.impl.UsuarioDAOImpl;

public class DAOFactory {
	
	public static UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAOImpl();
	}
	
	public static ProductoDAO getProductoDAO() {
		return new ProductoDAOImpl();
	}
	
	public static CompraDAO getCompraDAO() {
		return new CompraDAOImpl();
	}
}
