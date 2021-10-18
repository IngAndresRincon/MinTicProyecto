package com.DAO.TiendaVirtualSB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.DTO.TiendaVirtualSB.ClienteVO;
import com.DTO.TiendaVirtualSB.VentaVO;

import com.DTO.TiendaVirtualSB.ProductoVO;
import com.DTO.TiendaVirtualSB.ProductoVO1;
import com.DTO.TiendaVirtualSB.ProductoVO2;

public class VentaDAO {

	
	
	public void IngresarVenta(VentaVO Venta1,VentaVO Venta2, VentaVO Venta3,int CantProductos) {
		Conexion conex = new Conexion();
		Connection cn;
		System.out.println("Ingreso al Insert "+ CantProductos);
		try {
			cn = conex.getConnection();
			//Statement estatuto = conex.getConnection().createStatement();
			CallableStatement cStmt = cn.prepareCall("{call SP_InsertarVenta(?, ?, ?, ?, ?, ?, ?, ?)}"); 
			
			//int temp1 = (Venta1.getCodigo_producto().toString().length());
			//int temp2 = (Venta2.getCodigo_producto().toString().length());
			//int temp3 = (Venta3.getCodigo_producto().toString().length());
			
			//System.out.print("Val1: "+temp1+" Val2: "+temp2+" Val3: "+temp3);
			
			switch(CantProductos)
			{
			
			case 1:
				
				try
				{
					System.out.println("Primer caso");
					cStmt.setInt(1, Venta1.getCedula_cliente());
					cStmt.setInt(2, Venta1.getCodigo_producto());
					cStmt.setInt(3, Venta1.getCantidad());
					cStmt.setInt(4, 0);
					cStmt.setInt(5, 0);
					cStmt.setInt(6, 0);
					cStmt.setInt(7, 0);
					cStmt.setInt(8, CantProductos);
					cStmt.execute();
				}
				catch(Exception ex)
				{
					System.out.print(ex.toString()+"---"+ex.getMessage());
					
				}
				
				
				break;
				
			case 2:
				
				try {
					
				
				cStmt.setInt(1, Venta1.getCedula_cliente());
				cStmt.setInt(2, Venta1.getCodigo_producto());
				cStmt.setInt(3, Venta1.getCantidad());
				cStmt.setInt(4, Venta2.getCodigo_producto());
				cStmt.setInt(5, Venta2.getCantidad());
				cStmt.setInt(6, 0);
				cStmt.setInt(7, 0);
				cStmt.setInt(8, CantProductos);
				cStmt.execute();
				}
				catch(Exception ex)
				{
					System.out.print(ex.toString()+"---"+ex.getMessage());
					
				}
				
				break;
				
			case 3:
				
				try {
					
				cStmt.setInt(1, Venta1.getCedula_cliente());
				cStmt.setInt(2, Venta1.getCodigo_producto());
				cStmt.setInt(3, Venta1.getCantidad());
				cStmt.setInt(4, Venta2.getCodigo_producto());
				cStmt.setInt(5, Venta2.getCantidad());
				cStmt.setInt(6, Venta3.getCodigo_producto());
				cStmt.setInt(7, Venta3.getCantidad());
				cStmt.setInt(8, CantProductos);
				cStmt.execute();
				
				}
				catch(Exception ex)
				{
					System.out.print(ex.toString()+"---"+ex.getMessage());
					
				}
				break;
				
			default:
				break;
				
				
			}
			
			cn.close();			
			System.out.println("Finaliza Insert");
			
			ProductoVO pro1 = new ProductoVO();
			ProductoVO1 pro2 = new ProductoVO1();
			ProductoVO2 pro3 = new ProductoVO2();
			
			pro1.setCantidad(0);
			pro1.setCodigo_producto(0);
			pro1.setIvacompra(0);
			pro1.setNit_proveedor(0);
			pro1.setNombre_producto("");
			pro1.setPrecioventa(0);
			
			pro2.setCantidad(0);
			pro2.setCodigo_producto(0);
			pro2.setIvacompra(0);
			pro2.setNit_proveedor(0);
			pro2.setNombre_producto("");
			pro2.setPrecioventa(0);
			
			pro3.setCantidad(0);
			pro3.setCodigo_producto(0);
			pro3.setIvacompra(0);
			pro3.setNit_proveedor(0);
			pro3.setNombre_producto("");
			pro3.setPrecioventa(0);
			
			
  
			//estatuto.close();
			conex.desconectar();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			//JOptionPane.showMessageDialog(null, "No se Registro la persona");
		}
		
		//IngresarDetalleVenta(Venta1);
	}
	
	public ClienteVO ConsultarCliente(long Documento)
	{
	
		ClienteVO cliente= new ClienteVO();
		String strNombreCLiente = "";
		Conexion conex= new Conexion();
		System.out.println("LLego al mètodo");
		try {
		PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT nombre_cliente FROM clientes Where cedula_cliente = ?");
		consulta.setLong(1, Documento);
		ResultSet res = consulta.executeQuery();
		cliente.setCedula((int)(Documento));
		System.out.println("LLego a consultar ");	
			  if(res.next()){
				
				cliente.setNombre(res.getString("nombre_cliente"));
				System.out.println(cliente.getNombre());	  		 
				System.out.println(cliente.getCedula());	  		 
				
			  	}
			  System.out.println("Salio del if");
	          res.close();
	          consulta.close();
	          conex.desconectar();
	          System.out.println("Desconecto la conexión");
			  } catch (Exception e) {
			   //JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n"+e);
				  System.out.println("Error 1: "+e.getMessage());
			  }
		System.out.println("Retornara "+cliente.getNombre());
			  return cliente;
			

		
	}
	
	
	public ProductoVO ConsultarProducto(long Producto, int Cantidad)
	{
	
		
		ProductoVO producto= new ProductoVO();
		Conexion conex= new Conexion();
		System.out.println("LLego al mètodo");
		if (Producto == 0)
		{
			producto.setCantidad(0);
			producto.setIvacompra(0);
			producto.setNombre_producto("");
			producto.setPrecioventa(0);
			producto.setCantidad(0);
			
		}
		
		try {
		PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT codigo_producto,nombre_producto,precio_venta,ivacompra FROM productos where codigo_producto = ?");
		consulta.setLong(1, Producto);
		ResultSet res = consulta.executeQuery();
		producto.setCodigo_producto((int)(Producto));
		producto.setCantidad(Cantidad);
		System.out.println("LLego a consultar ");	
			  if(res.next()){
				
				producto.setNombre_producto(res.getString("nombre_producto"));  
				producto.setPrecioventa( res.getDouble("precio_venta")*Cantidad);  
				producto.setIvacompra(res.getDouble("ivacompra"));
				
			  	}
			  System.out.println("Salio del if");
	          res.close();
	          consulta.close();
	          conex.desconectar();
	          System.out.println("Desconecto la conexión");
			  } catch (Exception e) {
			   //JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n"+e);
				  System.out.println("Error 1: "+e.getMessage());
			  }
		
		return producto;
			
		
		
	}
	
	

	public ProductoVO1 ConsultarProducto2(long Producto, int Cantidad)
	{
		
		
		ProductoVO1 producto2= new ProductoVO1();
		
		//ProductoVO productoiva= new ProductoVO();
		
		Conexion conex= new Conexion();
		System.out.println("LLego al mètodo");
		
		if (Producto == 0)
		{
			producto2.setCantidad(0);
			producto2.setIvacompra(0);
			producto2.setNombre_producto("");
			producto2.setPrecioventa(0);
			producto2.setCantidad(0);
			
		}
		try {
		PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT codigo_producto,nombre_producto,precio_venta,ivacompra FROM productos where codigo_producto = ?");
		consulta.setLong(1, Producto);
		ResultSet res = consulta.executeQuery();
		producto2.setCodigo_producto((int)(Producto));
		producto2.setCantidad(Cantidad);
		System.out.println("LLego a consultar ");	
			  if(res.next()){
				
				  producto2.setNombre_producto(res.getString("nombre_producto"));  
				  producto2.setPrecioventa( res.getDouble("precio_venta")*Cantidad);  
				  producto2.setIvacompra(res.getDouble("ivacompra"));
				  //productoiva.setIvacompra((productoiva.getIvacompra()+producto2.getIvacompra())/2);
				
			  	}
			  System.out.println("Salio del if");
	          res.close();
	          consulta.close();
	          conex.desconectar();
	          System.out.println("Desconecto la conexión");
			  } catch (Exception e) {
			   //JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n"+e);
				  System.out.println("Error 1: "+e.getMessage());
			  }
		
		return producto2;
			
		
		
	}
	


	public ProductoVO2 ConsultarProducto3(long Producto, int Cantidad)
	{
		
		
		ProductoVO2 producto3= new ProductoVO2();
		
		//ProductoVO productoiva = new ProductoVO();
		Conexion conex= new Conexion();
		System.out.println("LLego al mètodo");
		
		
		if (Producto == 0)
		{
			producto3.setCantidad(0);
			producto3.setIvacompra(0);
			producto3.setNombre_producto("");
			producto3.setPrecioventa(0);
			producto3.setCantidad(0);
			
		}
		try {
		PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT codigo_producto,nombre_producto,precio_venta,ivacompra FROM productos where codigo_producto = ?");
		consulta.setLong(1, Producto);
		ResultSet res = consulta.executeQuery();
		producto3.setCodigo_producto((int)(Producto));
		producto3.setCantidad(Cantidad);
		System.out.println("LLego a consultar ");	
			  if(res.next()){
				
				  producto3.setNombre_producto(res.getString("nombre_producto"));  
				  producto3.setPrecioventa( res.getDouble("precio_venta")*Cantidad);
				  producto3.setIvacompra(res.getDouble("ivacompra"));
				 // productoiva.setIvacompra((productoiva.getIvacompra()+producto3.getIvacompra())/3);
			  	}
			  System.out.println("Salio del if");
	          res.close();
	          consulta.close();
	          conex.desconectar();
	          System.out.println("Desconecto la conexión");
			  } catch (Exception e) {
			   //JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n"+e);
				  System.out.println("Error 1: "+e.getMessage());
			  }
		
		return producto3;
			
		
		
	}
	
}
