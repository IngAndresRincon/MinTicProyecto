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

	
	
	public  ClienteVO ConsultarCliente (long documento) {
		  ArrayList<ClienteVO> MiUsuario = new ArrayList<ClienteVO>();
		  ClienteVO cliente= new ClienteVO();
		  Conexion conex= new Conexion();
		  System.out.println("LLego al mètodo");
		  try {
		   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM clientes Where cedula_cliente = ?");
		   consulta.setLong(1, documento);
		   ResultSet res = consulta.executeQuery();
		   cliente.setCedula((int)(documento));
		   System.out.println("LLego a consultar ");
		   
		  if(res.next()){
			
			cliente.setNombre(res.getString("nombre_cliente"));
			System.out.println(cliente.getNombre());
			cliente.setDireccion(res.getString("direccion_cliente"));
			System.out.println(cliente.getDireccion());
			cliente.setEmail(res.getString("email_cliente"));
			System.out.println(cliente.getEmail());
			cliente.setTelefono(res.getString("telefono_cliente"));
			System.out.println(cliente.getTelefono());
			  		 
			MiUsuario.add(cliente);
		  	}
		          res.close();
		          consulta.close();
		          conex.desconectar();
		   
		  } catch (Exception e) {
		   //JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n"+e);
			  System.out.println(e.getMessage());
		  }
		  return cliente;
		 }


	/**
	 * permite consultar la lista de Clientes
	 * @return
	 */
	public ArrayList< ClienteVO> listaDeClientes() {
	  ArrayList< ClienteVO> miCliente = new ArrayList< ClienteVO>();
	  Conexion conex= new Conexion();
	   System.out.println("Llego a la funciòn consultar");
	  try {
	   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM clientes");
	   ResultSet res = consulta.executeQuery();
	   while(res.next()){
	    ClienteVO persona= new ClienteVO();
	    persona.setCedula(Integer.parseInt(res.getString("cedula_cliente")));
	    System.out.println(persona.getCedula());
	    persona.setNombre(res.getString("nombre_cliente"));
	    System.out.println(persona.getNombre());
	    persona.setDireccion(res.getString("direccion_cliente"));
	    System.out.println(persona.getDireccion());
	    
	    persona.setEmail(res.getString("email_cliente"));
	    persona.setTelefono(res.getString("telefono_cliente"));
	  
	    miCliente.add(persona);
	          }
	          res.close();
	          consulta.close();
	          conex.desconectar();
	   
	  } catch (Exception e) {
	   //JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n"+e);
	  }
	  return miCliente;
	 }


}