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
	
	
	public void ActualizarUsuario(UsuarioVO Usuario) {
		Conexion conex = new Conexion();
		try {
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate(
					"UPDATE usuarios SET email_usuario= '"+Usuario.getEmail()+"'"+
							",nombre_usuario= '"+Usuario.getNombre()+"'"+
							",password= '"+Usuario.getPassword()+"'"+
							",usuario= '"+Usuario.getUsuario()+"'"+
					" Where cedula_usuario = "+Usuario.getDocumento()
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
	
	/**
	 * permite consultar el Cliente asociado al documento enviado
	 * como parametro 
	 * @param documento 
	 * @return
	 */
	//ArrayList<UsuarioVO>
	public  UsuarioVO ConsultarUsuario(long documento) {
		  ArrayList<UsuarioVO> MiUsuario = new ArrayList<UsuarioVO>();
		  UsuarioVO usuario= new UsuarioVO();
		  Conexion conex= new Conexion();
		  System.out.println("LLego al mètodo");
		  try {
		   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM usuarios Where cedula_usuario = ?");
		   consulta.setLong(1, documento);
		   ResultSet res = consulta.executeQuery();
		   usuario.setDocumento((int)(documento));
		   System.out.println("LLego a consultar ");
		   
		  if(res.next()){
			
			usuario.setNombre(res.getString("nombre_usuario"));
			usuario.setEmail(res.getString("email_usuario"));
			usuario.setUsuario(res.getString("usuario"));
			usuario.setPassword(res.getString("password"));
		 
			MiUsuario.add(usuario);
		          }
		          res.close();
		          consulta.close();
		          conex.desconectar();
		   
		  } catch (Exception e) {
		   //JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n"+e);
			  System.out.println(e.getMessage());
		  }
		  return usuario;
		 }

}
