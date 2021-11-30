package persistence;

import java.util.List;

import model.Producto;

public class ProductoDAO {
	private DataBase dbInstance = DataBase.getInstance();
	
	public List<Producto> getProducts() {
		return dbInstance.products;
	}

	public int deleteProduct(String name) {
		for (int i = 0; i < dbInstance.products.size(); i++) {
			if (dbInstance.products.get(i).getName().equals(name)) {
				dbInstance.products.get(i).setActive(false);
				return 0;
			}
		}
		return 1;
	}

	public Producto createProduct(Producto producto) {
		producto.setId(getLastProductId()+1);
		dbInstance.products.add(producto);
		dbInstance.lastProductId++;
		return getProduct(dbInstance.lastProductId);
	}

	public Producto getProduct(String name) {
		for (int i = 0; i < dbInstance.products.size(); i++) {
			if (dbInstance.products.get(i).getName().equals(name)) {
				return dbInstance.products.get(i);
			}
		}
		return null;
	}

	public Producto getProduct(Integer id) {
		for (int i = 0; i < dbInstance.products.size(); i++) {
			if (dbInstance.products.get(i).getId() == id) {
				return dbInstance.products.get(i);
			}
		}
		return null;
	}

	public Producto updateProduct(Integer id, String name, Double price, Integer stock) {
		Producto p;
		for (int i = 0; i < dbInstance.products.size(); i++) {
			p = dbInstance.products.get(i);
			if (p.getId() == id) {
				p.setName(name);
				p.setPrice(price);
				p.setStock(stock);

				return p;
			}
		}
		return null;
	}

	public Integer getLastProductId() {
		return dbInstance.lastProductId;
	}
}
