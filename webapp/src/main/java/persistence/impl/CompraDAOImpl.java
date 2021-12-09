package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Compra;
import model.Producto;
import persistence.CompraDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;

public class CompraDAOImpl implements CompraDAO {


	@Override
	public int insert(Compra t) {
		try {
			String sql = "INSERT INTO compra (usuario_fk, producto_fk, price) VALUES (?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, t.getUsuario());
			statement.setInt(2, t.getProducto());
			statement.setDouble(3, t.getPrice());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	//----------------------------------------
	
	@Override
	public Compra toCompra(ResultSet res) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Compra find(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Compra> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Compra t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Producto> findAllByUser(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
