package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Usuario;
import persistence.UsuarioDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;

public class UsuarioDAOImpl implements UsuarioDAO {

	@Override
	public Usuario find(Integer id) {
		try {
			String sql = "SELECT * FROM usuario WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			
			ResultSet resultados = statement.executeQuery();

			Usuario usuario = null;
			if (resultados.next()) {
				usuario = toUsuario(resultados);
			}

			return usuario;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public List<Usuario> findAll() {
		try {
			String sql = "SELECT * FROM usuario";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			List<Usuario> usuarios = new LinkedList<Usuario>();
			while (resultados.next()) {
				usuarios.add(toUsuario(resultados));
			}

			return usuarios;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int insert(Usuario t) {
		try {
			String sql = "INSERT INTO usuario (username, password, admin, money) VALUES (?, ?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, t.getUsername());
			statement.setString(2, t.getPassword());
			statement.setInt(3, t.isAdmin()? 1 : 0);
			statement.setDouble(4, t.getMoney());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int update(Usuario t) {
		try {
			String sql = "UPDATE usuario SET name = ?, password = ?, money = ? WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, t.getUsername());
			statement.setString(2, t.getPassword());
			statement.setDouble(3, t.getMoney());
			statement.setInt(4, t.getId());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int delete(Integer id) {
		try {
			String sql = "UPDATE usuario SET active = 0 WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public Usuario findByUsername(String username) {
		try {
			String sql = "SELECT * FROM usuario WHERE name = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, username);
			
			ResultSet resultados = statement.executeQuery();

			Usuario usuario = null;
			if (resultados.next()) {
				usuario = toUsuario(resultados);
			}

			return usuario;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public Usuario toUsuario(ResultSet res) throws SQLException {
		return new Usuario(res.getInt(1), 
				res.getString(2),
				res.getString(3), 
				res.getInt(4) == 1, 
				res.getDouble(5));
	}

}
