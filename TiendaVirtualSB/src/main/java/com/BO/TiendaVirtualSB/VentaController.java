package com.BO.TiendaVirtualSB;

import org.springframework.web.bind.annotation.RequestMapping;

import com.DAO.TiendaVirtualSB.VentaDAO;
import com.DTO.TiendaVirtualSB.VentaVO;

public class VentaController {

@RequestMapping("/Ventas")
	
	public void IngresarVenta(VentaVO Venta) 
	 {
		VentaDAO Dao=new VentaDAO(); 
	    Dao.IngresarVenta(Venta);
	    
	 }
	
	
}
