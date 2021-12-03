package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Producto;
import persistence.ProductoDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;

public class ProductoDAOImpl implements ProductoDAO {

	@Override
	public Producto find(Integer id) {
		try {
			String sql = "SELECT * FROM producto WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			
			ResultSet resultados = statement.executeQuery();

			Producto producto = null;
			if (resultados.next()) {
				producto = toProducto(resultados);
			}

			return producto;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public List<Producto> findAll() {
		try {
			String sql = "SELECT * FROM producto";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			List<Producto> productos = new LinkedList<Producto>();
			while (resultados.next()) {
				productos.add(toProducto(resultados));
			}

			return productos;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int insert(Producto t) {
		try {
			String sql = "INSERT INTO producto (name, price, stock) VALUES (?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, t.getName());
			statement.setDouble(2, t.getPrice());
			statement.setInt(3, t.getStock());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int update(Producto t) {
		try {
			String sql = "UPDATE producto SET name = ?, price = ?, stock = ? WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, t.getName());
			statement.setDouble(2, t.getPrice());
			statement.setInt(3, t.getStock());
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
			String sql = "UPDATE producto SET active = 0 WHERE ID = ?";
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
	public Producto toProducto(ResultSet res) throws SQLException {
		return new Producto(res.getInt(1), 
				res.getString(2),
				res.getDouble(3), 
				res.getInt(4), 
				res.getInt(5) == 1);
	}

}
