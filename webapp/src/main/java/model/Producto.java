package model;

import java.util.HashMap;

public class Producto {
	private Integer id;
	private String name;
	private Double price;
	private Integer stock;
	private boolean active;
	
	public Producto(Integer id, String name, Double price, Integer stock, boolean active) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.active = active;
	}
	
	public Producto(Integer id, String name, Double price, Integer stock) {
		this(id, name, price, stock, true);
	}
	
	public Producto(String name, Double price, Integer stock) {
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.active = true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean state) {
		this.active = state;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isValid() {
		return validate().isEmpty();
	}
	
	public HashMap<String, String> validate(){
		HashMap<String, String> errors = new HashMap<String, String>();
		
		if(name.isBlank()) errors.put("name", "El nombre es requerido");		
		if(price <= 0) errors.put("price", "El precio debe ser positivo");
		if(stock <= 0) errors.put("stock", "El stock debe ser positivo");
		
		return errors;
	}
}
