package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuario;
import persistence.commons.GenericDAO;

public interface UsuarioDAO extends GenericDAO<Usuario> {
	
	public abstract Usuario findByUsername(String username);	
	public abstract Usuario toUsuario(ResultSet res) throws SQLException;
}
