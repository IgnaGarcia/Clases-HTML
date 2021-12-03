package service;

import java.util.List;

import model.Producto;
import persistence.commons.DAOFactory;

public class ProductoService {

	public List<Producto> list(){
		return DAOFactory.getProductoDAO().getProducts();
	}
	
	public void delete(String name) {
		DAOFactory.getProductoDAO().deleteProduct(name);
	}
	
	public Producto update(Integer id, String name, Double price, Integer stock) {
		return DAOFactory.getProductoDAO().updateProduct(id, name, price, stock);
	}
	
	public Producto find(String name) {
		return DAOFactory.getProductoDAO().getProduct(name);
	}
	
	public Producto find(Integer id) {
		return DAOFactory.getProductoDAO().getProduct(id);
	}
	
	public Producto create(Producto prod) {
		return DAOFactory.getProductoDAO().createProduct(prod);
	}
}
