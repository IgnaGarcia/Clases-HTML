package persistence;

import java.util.Map;

import model.Usuario;

public class UsuarioDAO {
	private DataBase dbInstance = DataBase.getInstance();
	
	public Map<String, Usuario> getUsers(){
		return dbInstance.users;
	}
	
	public Usuario getByUsername(String username) {
		return dbInstance.users.get(username);
	}
}
