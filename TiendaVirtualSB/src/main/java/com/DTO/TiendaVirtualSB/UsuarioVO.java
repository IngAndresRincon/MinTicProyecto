package com.DTO.TiendaVirtualSB;

public class UsuarioVO {

	private Integer Documento;
	private String Email;
	private String Nombre;
	private String Password;
	private String Usuario;
	public static Integer Contador;
	
	

	public Integer getDocumento() {
		return Documento;
	}
	public void setDocumento(Integer documento) {
		Documento = documento;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getUsuario() {
		return Usuario;
	}
	public void setUsuario(String usuario) {
		Usuario = usuario;
	}

	
}
