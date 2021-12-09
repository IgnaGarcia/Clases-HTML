package service;

import java.util.List;

import model.Producto;
import persistence.commons.DAOFactory;

public class ProductoService {

	public List<Producto> list(){
		return DAOFactory.getProductoDAO().findAll();
	}
	
	public void delete(Integer id) {
		DAOFactory.getProductoDAO().delete(id);
	}
	
	public Producto update(Integer id, String name, Double price, Integer stock) {
		Producto prod = new Producto(id, name, price, stock);
		if(prod.isValid()) {
			DAOFactory.getProductoDAO().update(prod);
		}
		return prod;
	}
	
	public Producto update(Producto prod) {
		if(prod.isValid()) {
			DAOFactory.getProductoDAO().update(prod);
		}
		return prod;
	}
	
	public Producto find(Integer id) {
		return DAOFactory.getProductoDAO().find(id);
	}
	
	public Producto create(String name, Double price, Integer stock) {
		Producto prod = new Producto(name, price, stock);
		if(prod.isValid()) {
			DAOFactory.getProductoDAO().insert(prod);
		}
		return prod;
	}
}
