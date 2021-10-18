package com.DTO.TiendaVirtualSB;

public class ClienteVO {
	
	 private static Integer Cedula;
	 private String Telefono;
	 private static String Nombre;
	 private String Email;
	 private String Direccion;
	 
	 
	public Integer getCedula() {
		return Cedula;
	}
	
	/**
	  * @param Cedula the idCliente to set
	  */
	public void setCedula(Integer cedula) {
		Cedula = cedula;
	}
	public String getTelefono() {
		return Telefono;
	}
	/**
	  * @param Telefono the idCliente to set
	  */
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	public String getNombre() {
		return Nombre;
	}
	 /**
	  * @param Nombre the nombreCliente to set
	  */
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getEmail() {
		return Email;
	}
	/**
	  * @param Email the idCliente to set
	  */
	public void setEmail(String email) {
		Email = email;
	}
	public String getDireccion() {
		return Direccion;
	}
	 /**
	  * @param Direccion the nombreCliente to set
	  */
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	 
	 
	 
	 

}
