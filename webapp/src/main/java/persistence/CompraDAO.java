package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Compra;
import model.Producto;
import persistence.commons.GenericDAO;

public interface CompraDAO extends GenericDAO<Compra>{

	public abstract List<Producto> findAllByUser(Integer id);
	public abstract Compra toCompra(ResultSet res) throws SQLException;
}
