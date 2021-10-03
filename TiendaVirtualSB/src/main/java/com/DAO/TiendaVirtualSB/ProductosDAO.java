package com.DAO.TiendaVirtualSB;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class ProductosDAO {
	
	private Conexion conex= new Conexion();
	
	
	public void InsertarProductos(String Archivo)
	{
		
		String Separador = ";";
	
		 BufferedReader bufferLectura = null;
		 try {
		  // Abrir el .csv en buffer de lectura
		  bufferLectura = new BufferedReader(new FileReader(Archivo));
		  
		  // Leer una linea del archivo
		  String linea = bufferLectura.readLine();
		  
		  try
		  {
			  Statement estatuto = conex.getConnection().createStatement();
			  estatuto.executeUpdate("TRUNCATE TABLE productos");
			  estatuto.close();
		  }
		  catch (SQLException e)
		  {
			  System.out.println(e.getMessage());
		  }
		  
		  while (linea != null) {
		   // Sepapar la linea leída con el separador definido previamente
		   String[] campos = linea.split(Separador); 
		   
		   
		   try {
			   
			   Statement estatuto = conex.getConnection().createStatement();	
				estatuto.executeUpdate(
						" INSERT INTO productos (codigo_producto,ivacompra,nitproveedor,nombre_producto,precio_compra,precio_venta)"
						+ " VALUES("+campos[0]+","+campos[1]+","+campos[2]+", '"+campos[3]+"',"+campos[4]+","+campos[5]+" );"
						//"Insert into usuarios values(123456,'admininicial@gmail.com','Admin','admin123456','admininicial');"
						);
				estatuto.close();
				
			} catch (SQLException e) {
				
				//JOptionPane.showMessageDialog(null, "No se Registro la persona");
			}
					   
		   // Volver a leer otra línea del fichero
		   linea = bufferLectura.readLine();
		  }
		  conex.desconectar();
		 } 
		 catch (IOException e) {
		  e.printStackTrace();
		 }
		 finally {
		  // Cierro el buffer de lectura
			 
		  if (bufferLectura != null) {
		   try {
		    bufferLectura.close();
		   } 
		   catch (IOException e) {
		    e.printStackTrace();
		   }
		  }
		 }
	
		
	}

}
