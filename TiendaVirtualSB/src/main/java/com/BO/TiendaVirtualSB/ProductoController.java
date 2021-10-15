package com.BO.TiendaVirtualSB;

import org.springframework.web.bind.annotation.PostMapping;
import com.DTO.TiendaVirtualSB.ProductoVO;
import com.DAO.TiendaVirtualSB.ProductosDAO;

public class ProductoController {

	@PostMapping("/registrarProducto")
	public void registrarProducto(ProductoVO producto)
	{
		ProductosDAO Dao = new ProductosDAO();
		Dao.registrarProducto(producto);
	}
	
}
