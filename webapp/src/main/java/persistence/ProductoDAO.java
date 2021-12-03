package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Producto;
import persistence.commons.GenericDAO;

public interface ProductoDAO extends GenericDAO<Producto>{

	public abstract Producto toProducto(ResultSet res) throws SQLException;
}
