package com.DAO.TiendaVirtualSB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.BO.TiendaVirtualSB.*;
import com.DTO.TiendaVirtualSB.ClienteVO;


import com.DTO.TiendaVirtualSB.UsuarioVO;
/**
 * Clase que permite el acceso a la base de datos
 * 
 *
 */
public class ClienteDAO 
{


	public void RegistrarCliente(ClienteVO Cliente) {
		Conexion conex = new Conexion();
		try {
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate(
					"INSERT INTO clientes VALUES('"+Cliente.getCedula()+
							"','"+Cliente.getDireccion()+"','"+Cliente.getEmail()+"','"+Cliente.getNombre()+"','"+Cliente.getTelefono()+"');"
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

	public void BorrarCliente(long Documento)
	{
		
		Conexion conex = new Conexion();
		try {
			Statement Query = conex.getConnection().createStatement();
			Query.executeUpdate("Delete from clientes where cedula_cliente = " + Documento
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
	
	
	public void ActualizarCliente(ClienteVO Cliente) {
		Conexion conex = new Conexion();
		try {
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate(
					"UPDATE clientes SET direccion_cliente= '"+Cliente.getDireccion()+"'"+
							",email_cliente= '"+Cliente.getEmail()+"'"+
							",nombre_cliente= '"+Cliente.getNombre()+"'"+
							",telefono_cliente= '"+Cliente.getTelefono()+"'"+
					" Where cedula_cliente = "+Cliente.getCedula()
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