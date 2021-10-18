package com.DAO.TiendaVirtualSB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.DTO.TiendaVirtualSB.ClienteVO;
import com.DTO.TiendaVirtualSB.ProveedorVO;

public class ProveedorDAO {

	
	

	public void RegistrarProveedor(ProveedorVO Proveedor) {
		Conexion conex = new Conexion();
		try {
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate(
					"INSERT INTO proveedores VALUES('"+Proveedor.getNit()+
							"','"+Proveedor.getCiudad()+"','"+Proveedor.getDireccion()+"','"+Proveedor.getNombre()+"','"+Proveedor.getTelefono()+"');"
					//"Insert into usuarios values(123456,'admininicial@gmail.com','Admin','admin123456','admininicial');"
					);
			/*JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente", "Información",
					JOptionPane.INFORMATION_MESSAGE);*/
			
			estatuto.close();
			conex.desconectar();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			//JOptionPane.showMessageDialog(null, "No se Registro la persona");
		}
	}

	public void BorrarProveedor(long Nit)
	{
		
		Conexion conex = new Conexion();
		try {
			Statement Query = conex.getConnection().createStatement();
			Query.executeUpdate("Delete from proveedores where nitproveedor = " + Nit
					);
			/*JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente", "Información",
					JOptionPane.INFORMATION_MESSAGE);*/
			Query.close();
			conex.desconectar();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			//JOptionPane.showMessageDialog(null, "No se Registro la persona");
		}
	}
	
	
	public void ActualizarProveedor(ProveedorVO Proveedor) {
		Conexion conex = new Conexion();
		try {
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate(
					"UPDATE proveedores SET ciudad_proveedor= '"+Proveedor.getCiudad()+"'"+
							",direccion_proveedor= '"+Proveedor.getDireccion()+"'"+
							",nombre_proveedor= '"+Proveedor.getNombre()+"'"+
							",telefono_proveedor= '"+Proveedor.getTelefono()+"'"+
					" Where nitproveedor = "+Proveedor.getNit()
					//"Insert into usuarios values(123456,'admininicial@gmail.com','Admin','admin123456','admininicial');"
					);
			/*JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente", "Información",
					JOptionPane.INFORMATION_MESSAGE);*/
			
			estatuto.close();
			conex.desconectar();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			//JOptionPane.showMessageDialog(null, "No se Registro la persona");
		}
	}
	

	public  ProveedorVO ConsultarProveedor (long Nit) {
		  ArrayList<ProveedorVO> MiProveedor = new ArrayList<ProveedorVO>();
		  ProveedorVO proveedor= new ProveedorVO();
		  Conexion conex= new Conexion();
		  System.out.println("LLego al mètodo");
		  try {
		   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM proveedores Where nitproveedor = ?");
		   consulta.setLong(1, Nit);
		   ResultSet res = consulta.executeQuery();
		   proveedor.setNit((int)(Nit));
		   System.out.println("LLego a consultar ");
		   
		  if(res.next()){
			
			  proveedor.setCiudad(res.getString("ciudad_proveedor"));
			  proveedor.setDireccion(res.getString("direccion_proveedor"));
			  proveedor.setNombre(res.getString("nombre_proveedor"));
			  proveedor.setTelefono(res.getString("telefono_proveedor"));
			  		 
			  MiProveedor.add(proveedor);
		  	}
		          res.close();
		          consulta.close();
		          conex.desconectar();
		   
		  } catch (Exception e) {
		   //JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n"+e);
			  System.out.println(e.getMessage());
		  }
		  return proveedor;
		 }
	

	
}
