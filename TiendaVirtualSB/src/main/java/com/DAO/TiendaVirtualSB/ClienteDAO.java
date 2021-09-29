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

 /**
  * Permite registrar un Cliente nuevo
  * @param persona
  */
	
//	
// public void registrarPersona(ClienteVO persona) 
// {
//  Conexion conex= new Conexion();
//  try {
//   Statement estatuto = conex.getConnection().createStatement();
//   estatuto.executeUpdate("INSERT INTO cliente VALUES ('"+persona.getIdCliente()+"', '"
//     +persona.getNombreCliente()+"', '"+persona.getApellidoCliente()+"')");
//   JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
//   estatuto.close();
//   conex.desconectar();
//   
//  } catch (SQLException e) {
//            System.out.println(e.getMessage());
//   JOptionPane.showMessageDialog(null, "No se Registro la persona");
//  }
// }
//   
// 
// 
///**
// * permite consultar el Cliente asociado al documento enviado
// * como parametro 
// * @param documento 
// * @return
// */
//public ArrayList<ClienteVO> consultarPersona(int documento) {
//  ArrayList< ClienteVO> miCliente = new ArrayList< ClienteVO>();
//  Conexion conex= new Conexion();
//    
//  try {
//   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM cliente where idCliente = ? ");
//   consulta.setInt(1, documento);
//   ResultSet res = consulta.executeQuery();
//   
//  if(res.next()){
//    ClienteVO persona= new ClienteVO();
//    persona.setIdCliente(Integer.parseInt(res.getString("idcliente")));
//    persona.setNombreCliente(res.getString("Nombre"));
//    persona.setApellidoCliente(res.getString("Apellido"));
// 
//    miCliente.add(persona);
//          }
//          res.close();
//          consulta.close();
//          conex.desconectar();
//   
//  } catch (Exception e) {
//   JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n"+e);
//  }
//  return miCliente;
// }
//
//
//
///**
// * permite consultar la lista de Clientes
// * @return
// */
//public ArrayList< ClienteVO> listaDePersonas() {
//  ArrayList< ClienteVO> miCliente = new ArrayList< ClienteVO>();
//  Conexion conex= new Conexion();
//    
//  try {
//   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM cliente");
//   ResultSet res = consulta.executeQuery();
//   while(res.next()){
//    ClienteVO persona= new ClienteVO();
//    persona.setIdCliente(Integer.parseInt(res.getString("idcliente")));
//    persona.setNombreCliente(res.getString("Nombre"));
//    persona.setApellidoCliente(res.getString("Apellido"));
//  
//    miCliente.add(persona);
//          }
//          res.close();
//          consulta.close();
//          conex.desconectar();
//   
//  } catch (Exception e) {
//   JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n"+e);
//  }
//  return miCliente;
// }
//
//public void modificarPersona(ClienteVO persona) {
//	Conexion conex = new Conexion();
//	try {
//		Statement estatuto = conex.getConnection().createStatement();
//		estatuto.executeUpdate(
//				"UPDATE cliente " + 
//				" SET nombre ='"+persona.getNombreCliente()+"', "+
//				" apellido ='" + persona.getApellidoCliente()+"' "+
//				"WHERE idcliente=" + persona.getIdCliente()
//				);
//		/*JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente", "Información",
//				JOptionPane.INFORMATION_MESSAGE);*/
//		estatuto.close();
//		conex.desconectar();
//	} catch (SQLException e) {
//		System.out.println(e.getMessage());
//		//JOptionPane.showMessageDialog(null, "No se Registro la persona");
//	}
//}
//


	public void RegistrarCliente(ClienteVO Cliente) {
		Conexion conex = new Conexion();
		try {
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate(
					"INSERT INTO Cliente VALUES("+
							Cliente.getCedula()+
							",'"+
							Cliente.getDireccion()+
							"','"+
							Cliente.getEmail()+
							"','"+
							Cliente.getNombre()+
							"','"
							+Cliente.getTelefono()+"');"
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
	
	
	public void ActualizarCliente(ClienteVO Cliente) {
		Conexion conex = new Conexion();
		try {
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate(
					"UPDATE usuarios SET direccion_cliente= '"+Cliente.getDireccion()+"'"+
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