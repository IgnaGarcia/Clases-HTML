package service;

import model.Producto;
import model.Usuario;

public class BuyProductService {

	public boolean buy(Usuario user, Producto prod) {
		// verificaciones
		if(!user.puedePagar(prod) || !prod.puedeOfertarse())
			return false;
		
		// actualizar instancias
		
		// guardar en db instancias
		// guardar en db compra
		return true;
	}
}
