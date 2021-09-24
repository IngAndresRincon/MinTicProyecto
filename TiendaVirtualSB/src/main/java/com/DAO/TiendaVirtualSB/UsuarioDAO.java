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

public class UsuarioDAO {
	
	public void LoginUsuario(UsuarioVO Usuario) {
		Conexion conex= new Conexion();
	    
		  try {
		   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT COUNT(cedula_usuario) As Contador FROM usuarios where usuario ='" + Usuario.getUsuario() +
					"' and password = '"+ Usuario.getPassword()+"'");
		   ResultSet res = consulta.executeQuery();
		   
		  
		   while(res.next()){
		    UsuarioVO user= new UsuarioVO();
		    user.Contador = Integer.parseInt(res.getString("Contador"));

		          }
		   		res.close();
			    consulta.close();
			    conex.desconectar();
		   
		  } catch (Exception e) {
		   JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n"+e);
		   
		  }
		

	}
	
	
	public void RegistrarUsuario(UsuarioVO Usuario) {
		Conexion conex = new Conexion();
		try {
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate(
					"INSERT INTO usuarios VALUES("+
							Usuario.getDocumento()+
							",'"+
							Usuario.getEmail()+
							"','"+
							Usuario.getNombre()+
							"','"+
							Usuario.getPassword()+
							"','"
							+Usuario.getUsuario()+"');"
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

	public void BorrarUsuario(long Documento)
	{
		
		Conexion conex = new Conexion();
		try {
			Statement Query = conex.getConnection().createStatement();
			Query.executeUpdate("Delete from usuarios where cedula_usuario = " + Documento
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

}
