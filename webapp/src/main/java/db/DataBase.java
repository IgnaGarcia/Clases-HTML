package db;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import model.Producto;
import model.Usuario;

public class DataBase {
	private static DataBase instance = null;
	private Integer lastProductId = 0;
	
	private Map<String, Usuario> users;
	private List<Producto> products;
	
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
	
	public Map<String, Usuario> getUsers(){
		return users;
	}
	
	
	//----- PRODUCTOS 
	public void initProducts() {
		products.add(new Producto(1, "coca", 120.0, 12));
		products.add(new Producto(2, "guaymallen", 30.0, 40));
		products.add(new Producto(3, "doritos", 150.0, 6));
		products.add(new Producto(4, "fideos", 70.0, 24));
		this.lastProductId = 4;
	}
	
	public List<Producto> getProducts(){		
		return products;
	}

	public int deleteProduct(String name) {
		for(int i=0; i<products.size(); i++) {
			if( products.get(i).getName().equals(name) ) {
				products.get(i).setActive(false);
				return 0;
			}
		}
		return 1;
	}
	
	public int createProduct(Producto producto) {
		products.add(producto);
		this.lastProductId++;
		return 0;
	}
	
	public Producto getProduct(String name) {
		for(int i=0; i<products.size(); i++) {
			if( products.get(i).getName().equals(name) ) {
				return products.get(i);
			}
		}
		return null;		
	}
	
	public Producto getProduct(Integer id) {
		for(int i=0; i<products.size(); i++) {
			if( products.get(i).getId() == id ) {
				return products.get(i);
			}
		}
		return null;		
	}
	
	public int updateProduct(Integer id, String name, Double price, Integer stock) {
		for(int i=0; i<products.size(); i++) {
			if( products.get(i).getId() == id ) {
				products.get(i).setName(name);
				products.get(i).setPrice(price);
				products.get(i).setStock(stock);
				
				return 0;
			}
		}
		return 0;
	}
	
	public Integer getLastProductId() {
		return this.lastProductId;
	}
}
