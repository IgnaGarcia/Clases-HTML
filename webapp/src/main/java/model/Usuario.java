package model;

public class Usuario {
	private Integer id;
	private String username;
	private String password;
	private boolean admin;
	private Double money;
	
	public Usuario(Integer id, String username, String password, boolean admin, Double money) {
		this.id = id;
		this.setUsername(username);
		this.setPassword(password);
		this.admin = admin;
		this.setMoney(money);
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
}
