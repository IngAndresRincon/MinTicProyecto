package com.BO.TiendaVirtualSB;

import org.springframework.web.bind.annotation.RequestMapping;

import com.DAO.TiendaVirtualSB.VentaDAO;
import com.DTO.TiendaVirtualSB.VentaVO;


import com.DAO.TiendaVirtualSB.ClienteDAO;
import com.DTO.TiendaVirtualSB.ClienteVO;

import com.DAO.TiendaVirtualSB.ProductosDAO;
import com.DTO.TiendaVirtualSB.ProductoVO;

import com.DTO.TiendaVirtualSB.ProductoVO1;
import com.DTO.TiendaVirtualSB.ProductoVO2;


public class VentaController {

@RequestMapping("/Ventas")
	
	public void IngresarVenta(VentaVO Venta1, VentaVO Venta2, VentaVO Venta3,int CantProductos) 
	 {
		VentaDAO Dao=new VentaDAO();
	    Dao.IngresarVenta(Venta1,Venta2,Venta3,CantProductos);
	    
	 }


	public ClienteVO ConsultarCliente(long documento)
	{
		VentaDAO Dao=new VentaDAO();
		ClienteVO cli = new ClienteVO();
		cli=Dao.ConsultarCliente(documento);
		return cli;
		
	}
	
	
	public ProductoVO ConsultarProducto(long producto,int cantidad)
	{
		VentaDAO Dao=new VentaDAO();
		ProductoVO pro = new ProductoVO();
		pro = Dao.ConsultarProducto(producto,cantidad);
		return pro;
		
	}
	
	public ProductoVO1 ConsultarProducto2(long producto,int cantidad)
	{
		VentaDAO Dao=new VentaDAO();
		ProductoVO1 pro2 = new ProductoVO1();
		pro2 = Dao.ConsultarProducto2(producto,cantidad);
		return pro2;		
	}
	
	public ProductoVO2 ConsultarProducto3(long producto,int cantidad)
	{
		VentaDAO Dao=new VentaDAO();
		ProductoVO2 pro3 = new ProductoVO2();
		pro3 = Dao.ConsultarProducto3(producto,cantidad);
		return pro3;		
	}
	
	
}
