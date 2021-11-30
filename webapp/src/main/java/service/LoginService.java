package service;

import model.Usuario;
import persistence.DAOFactory;
import persistence.UsuarioDAO;

public class LoginService {

	public Usuario login(String username, String password) {
		UsuarioDAO userDao = DAOFactory.getUsuarioDAO();
		Usuario user = userDao.getByUsername(username);
    	
    	if (user == null || !user.auth(password)) {
    		return null;
    	}
    	return user;
	}
}
