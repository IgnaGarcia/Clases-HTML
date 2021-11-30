package persistence;

public class DAOFactory {
	
	public static UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAO();
	}
	
	public static ProductoDAO getProductoDAO() {
		return new ProductoDAO();
	}
}
