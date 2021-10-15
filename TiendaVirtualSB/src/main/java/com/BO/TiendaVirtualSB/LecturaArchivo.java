package com.BO.TiendaVirtualSB;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.DAO.TiendaVirtualSB.UsuarioDAO;
import com.DAO.TiendaVirtualSB.ProductosDAO;


public class LecturaArchivo {

	
	@PostMapping("/Usuarios")
	public void EnviarProductos(String Archivo)
	{
			ProductosDAO DAO = new ProductosDAO();
			DAO.InsertarProductos(Archivo);
	}
	
}
