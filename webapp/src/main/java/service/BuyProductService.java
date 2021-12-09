package service;

import model.Compra;
import model.Producto;
import model.Usuario;
import persistence.commons.DAOFactory;

public class BuyProductService {

	public boolean buy(Usuario user, Producto prod) {
		// verificaciones
		if(!user.puedePagar(prod) || !prod.puedeOfertarse())
			return false;
		
		// actualizar instancias
		user.comprar(prod);
		prod.venderse();
		
		if(user.isValid() && prod.isValid()) {
			// guardar en db instancias
			new UsuarioService().update(user);
			new ProductoService().update(prod);

			// guardar en db compra
			return DAOFactory.getCompraDAO().insert(
					new Compra(user.getId(), prod.getId(), prod.getPrice())) == 1? true : false;
		} else {
			return false;
		}
	}
}
