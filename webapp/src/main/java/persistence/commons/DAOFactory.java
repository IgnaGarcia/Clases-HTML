package persistence.commons;

import persistence.ProductoDAO;
import persistence.UsuarioDAO;
import persistence.impl.ProductoDAOImpl;
import persistence.impl.UsuarioDAOImpl;

public class DAOFactory {
	
	public static UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAOImpl();
	}
	
	public static ProductoDAO getProductoDAO() {
		return new ProductoDAOImpl();
	}
}
