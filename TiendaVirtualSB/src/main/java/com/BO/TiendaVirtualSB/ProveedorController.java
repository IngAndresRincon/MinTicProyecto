package com.BO.TiendaVirtualSB;

import com.DAO.TiendaVirtualSB.ClienteDAO;
import com.DTO.TiendaVirtualSB.ClienteVO;
import com.DTO.TiendaVirtualSB.ProveedorVO;
import com.DAO.TiendaVirtualSB.ProveedorDAO;

public class ProveedorController {

	
	public void RegistrarProveedor(ProveedorVO Proveedor) 
	 {
		ProveedorDAO Dao=new ProveedorDAO(); 
	    Dao.RegistrarProveedor(Proveedor);
	    
	 }
	
	
//	@RequestMapping("/Clientes")
//	
	public void BorrarProveedor(long Nit) 
	 {
		ProveedorDAO Dao=new ProveedorDAO(); 
	    Dao.BorrarProveedor(Nit);
	    
	 }
//	
//	@RequestMapping("/Clientes")
	
	public void ActualizarProveedor(ProveedorVO Proveedor) 
	 {
		ProveedorDAO Dao=new ProveedorDAO(); 
	    Dao.ActualizarProveedor(Proveedor);
	    
	 }
	
	public ProveedorVO ConsultarProveedor(long Nit)
	{
		ProveedorDAO Dao=new ProveedorDAO(); 
	    return Dao.ConsultarProveedor(Nit);
	}
	
}
