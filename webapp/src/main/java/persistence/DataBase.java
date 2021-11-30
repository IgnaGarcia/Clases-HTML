package persistence;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import model.Producto;
import model.Usuario;

public class DataBase {
	private static DataBase instance = null;
	public Integer lastProductId = 0;
	
	public Map<String, Usuario> users;
	public List<Producto> products;
	
	private DataBase() { 
		users = new HashMap<String, Usuario>();
		products = new LinkedList<Producto>();
		initUsers();
		initProducts();
	}
	
	public static DataBase getInstance() {
		if(instance == null) {
			instance = new DataBase();	
		}
		return instance;
	}
	
	private void initUsers() {
		users.put("ignag", new Usuario("ignag", "mypass123", true));
		users.put("pepe", new Usuario("pepe", "admin123", true));
		users.put("lore", new Usuario("lore", "abcdef", false));
		users.put("cami", new Usuario("cami", "password", false));
	}
	
	public void initProducts() {
		products.add(new Producto(1, "coca", 120.0, 12));
		products.add(new Producto(2, "guaymallen", 30.0, 40));
		products.add(new Producto(3, "doritos", 150.0, 6));
		products.add(new Producto(4, "fideos", 70.0, 24));
		this.lastProductId = 4;
	}
}
