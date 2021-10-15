package com.BO.TiendaVirtualSB;

import org.springframework.web.bind.annotation.RequestMapping;

import com.DAO.TiendaVirtualSB.VentaDAO;
import com.DTO.TiendaVirtualSB.VentaVO;

public class VentaController {

@RequestMapping("/Ventas")
	
	public void IngresarVenta(VentaVO Venta1, VentaVO Venta2, VentaVO Venta3,int CantProductos) 
	 {
		VentaDAO Dao=new VentaDAO(); 
	    Dao.IngresarVenta(Venta1,Venta2,Venta3,CantProductos);
	    
	 }


	
	
}
