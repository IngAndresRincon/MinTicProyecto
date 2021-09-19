package com.BO.TiendaVirtualSB;

import org.springframework.web.bind.annotation.RequestMapping;


import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.boot.json.GsonJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.DAO.TiendaVirtualSB.ClienteDAO;
import com.DAO.TiendaVirtualSB.UsuarioDAO;
import com.DTO.TiendaVirtualSB.ClienteVO;
import com.DTO.TiendaVirtualSB.UsuarioVO;
import com.fasterxml.jackson.databind.JsonNode;



public class UsuarioController {

	
	@RequestMapping("/Login")
	
	public void LoginUsuario(UsuarioVO Usuario) 
	 {
		UsuarioDAO Dao=new UsuarioDAO(); 
	    Dao.LoginUsuario(Usuario);
	    
	 }
	
	@RequestMapping("/Login")
	
	public void RegistrarUsuario(UsuarioVO Usuario) 
	 {
		UsuarioDAO Dao=new UsuarioDAO(); 
	    Dao.RegistrarUsuario(Usuario);
	    
	 }
	
	
	
}