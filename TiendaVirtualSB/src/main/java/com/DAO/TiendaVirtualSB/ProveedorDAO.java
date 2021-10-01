package com.DAO.TiendaVirtualSB;

import java.sql.SQLException;
import java.sql.Statement;

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

	
}
