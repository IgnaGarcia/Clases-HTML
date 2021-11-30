package model;

public class Producto {
	private Integer id;
	private String name;
	private Double price;
	private Integer stock;
	private boolean active;
	
	public Producto(Integer id, String name, Double price, Integer stock) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.active = true;
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
}
