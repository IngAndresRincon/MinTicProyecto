package com.BO.TiendaVirtualSB;

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


@RestController
public class ClienteController {
	
	
//	@RequestMapping("/registrarPersona")
//	public void registrarPersona(ClienteVO persona) 
//	 {
//		ClienteDAO Dao=new ClienteDAO(); 
//	    Dao.registrarPersona(persona);
//	    
//	 }
//	   
//	 
//	 
//	/**
//	 * permite consultar el Cliente asociado al documento enviado
//	 * como parametro 
//	 * @param documento 
//	 * @return
//	 */
//	
//	@RequestMapping("/consultarPersona")
//	public ArrayList<ClienteVO> consultarPersona(int documento) {
//		ClienteDAO Dao=new ClienteDAO(); 
//	return 	Dao.consultarPersona(documento);
//		
//	}
//
//
//
	/**
	 * permite consultar la lista de Clientes
	 * @return
	 */
	@RequestMapping("/listarClientes")
	public ArrayList< ClienteVO> listaDeClientes() {
		ClienteDAO Dao=new ClienteDAO(); 
			
		return Dao.listaDeClientes();
		
	}
	

	
	
//
//	
//	/**
//	 * Permite modificar un Clientes
//	 * @return
//	 */
//	@RequestMapping("/modificarPersona")
//	
//	public void modificarPersona(ClienteVO persona) 
//	 {
//		ClienteDAO Dao=new ClienteDAO(); 
//	    Dao.modificarPersona(persona);
//	    
//	 }
	

	
//	@RequestMapping("/Clientes")
//	
	public void RegistrarCliente(ClienteVO Cliente) 
	 {
		ClienteDAO Dao=new ClienteDAO(); 
	    Dao.RegistrarCliente(Cliente);
	    
	 }
	
	
//	@RequestMapping("/Clientes")
//	
	public void BorrarCliente(long Documento) 
	 {
		ClienteDAO Dao=new ClienteDAO(); 
	    Dao.BorrarCliente(Documento);
	    
	 }
//	
//	@RequestMapping("/Clientes")
	
	public void ActualizarCliente(ClienteVO Documento) 
	 {
		ClienteDAO Dao=new ClienteDAO(); 
	    Dao.ActualizarCliente(Documento);
	    
	 }
	
	public ClienteVO ConsultarCliente(long Documento) 
	 {
		ClienteDAO Dao=new ClienteDAO(); 
	    return Dao.ConsultarCliente(Documento);
	    
	 }
	


}