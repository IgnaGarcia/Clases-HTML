package model;

public class Compra {
	private Integer usuario;
	private Integer producto;
	private Double price;

	public Compra(Integer usuario, Integer producto, Double price) {
		this.usuario = usuario;
		this.producto = producto;
		this.price = price;
	}	
	
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		price = price;
	}
	public Integer getUsuario() {
		return usuario;
	}
	public Integer getProducto() {
		return producto;
	}	
}
