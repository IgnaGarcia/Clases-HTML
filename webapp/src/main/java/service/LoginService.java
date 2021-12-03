package service;

import model.Usuario;
import persistence.UsuarioDAO;
import persistence.commons.DAOFactory;

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
