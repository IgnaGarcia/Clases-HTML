package model;

import java.util.HashMap;

public class Usuario {
	private Integer id;
	private String username;
	private String password;
	private boolean admin;
	private Double money;
	private boolean active;
	
	public Usuario(Integer id, String username, String password, boolean admin, Double money, Boolean active) {
		this.id = id;
		this.setUsername(username);
		this.setPassword(password);
		this.admin = admin;
		this.setMoney(money);
		this.active = active;
	}
	
	public Usuario(String username, String password, boolean admin, Double money) {
		this.setUsername(username);
		this.setPassword(password);
		this.admin = admin;
		this.setMoney(money);
	}
	
	public Usuario(String username, String password, Double money) {
		this(username, password, false, money);
	}

	public Usuario(Integer id, String username, String password, Double money) {
		this(id, username, password, false, money, true);
	}
	
	public boolean auth(String password) {
		return this.password.equals(password);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isAdmin() {
		return admin;
	}

	public Integer getId() {
		return id;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		if(money > 0)
			this.money = money;
	}
	
	public boolean isActive() {
		return active;
	}
	
	public boolean isValid() {
		return validate().isEmpty();
	}
	
	public HashMap<String, String> validate(){
		HashMap<String, String> errors = new HashMap<String, String>();
		
		if(username.isBlank()) errors.put("name", "El nombre es requerido");	
		if(password.isBlank()) errors.put("password", "La contraseña es requerida");
		else if(password.length() < 6) errors.put("password", "La contraseña debe tener al menos 6 caracteres");
		if(money < 0) errors.put("price", "El dinero debe ser positivo");
		
		return errors;
	}
}
