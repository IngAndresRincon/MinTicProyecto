package com.DAO.TiendaVirtualSB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.DTO.TiendaVirtualSB.VentaVO;

public class VentaDAO {

	
	
	public void IngresarVenta(VentaVO Venta1,VentaVO Venta2, VentaVO Venta3,int CantProductos) {
		Conexion conex = new Conexion();
		Connection cn;
		System.out.println("Ingreso al Insert "+ CantProductos);
		try {
			cn = conex.getConnection();
			//Statement estatuto = conex.getConnection().createStatement();
			CallableStatement cStmt = cn.prepareCall("{call SP_InsertarVenta(?, ?, ?, ?, ?, ?, ?, ?)}"); 
			
			//int temp1 = (Venta1.getCodigo_producto().toString().length());
			//int temp2 = (Venta2.getCodigo_producto().toString().length());
			//int temp3 = (Venta3.getCodigo_producto().toString().length());
			
			//System.out.print("Val1: "+temp1+" Val2: "+temp2+" Val3: "+temp3);
			
			switch(CantProductos)
			{
			
			case 1:
				
				try
				{
					System.out.println("Primer caso");
					cStmt.setInt(1, Venta1.getCedula_cliente());
					cStmt.setInt(2, Venta1.getCodigo_producto());
					cStmt.setInt(3, Venta1.getCantidad());
					cStmt.setInt(4, 0);
					cStmt.setInt(5, 0);
					cStmt.setInt(6, 0);
					cStmt.setInt(7, 0);
					cStmt.setInt(8, CantProductos);
					cStmt.execute();
				}
				catch(Exception ex)
				{
					System.out.print(ex.toString()+"---"+ex.getMessage());
					
				}
				
				
				break;
				
			case 2:
				
				try {
					
				
				cStmt.setInt(1, Venta1.getCedula_cliente());
				cStmt.setInt(2, Venta1.getCodigo_producto());
				cStmt.setInt(3, Venta1.getCantidad());
				cStmt.setInt(4, Venta2.getCodigo_producto());
				cStmt.setInt(5, Venta2.getCantidad());
				cStmt.setInt(6, 0);
				cStmt.setInt(7, 0);
				cStmt.setInt(8, CantProductos);
				cStmt.execute();
				}
				catch(Exception ex)
				{
					System.out.print(ex.toString()+"---"+ex.getMessage());
					
				}
				
				break;
				
			case 3:
				
				try {
					
				cStmt.setInt(1, Venta1.getCedula_cliente());
				cStmt.setInt(2, Venta1.getCodigo_producto());
				cStmt.setInt(3, Venta1.getCantidad());
				cStmt.setInt(4, Venta2.getCodigo_producto());
				cStmt.setInt(5, Venta2.getCantidad());
				cStmt.setInt(6, Venta3.getCodigo_producto());
				cStmt.setInt(7, Venta3.getCantidad());
				cStmt.setInt(8, CantProductos);
				cStmt.execute();
				
				}
				catch(Exception ex)
				{
					System.out.print(ex.toString()+"---"+ex.getMessage());
					
				}
				break;
				
			default:
				break;
				
				
			}
			

			
			cn.close();
			
			
			System.out.println("Finaliza Insert");
              
              // Definimos los tipos de los parametros de salida del procedimiento almacenado
//		
//			
//			estatuto.executeUpdate(
//					"   INSERT INTO ventas"
//					+ "(cedula_cliente,"
//					+ "cedula_usuario,"
//					+ "ivaventa,"
//					+ "total_venta,"
//					+ "valor_venta)"
//					+ "VALUES"
//					+ "("+Venta1.cedula_cliente
//					+ ",(SELECT cedula_usuario From usuarios Where nombre_usuario='admin')"
//					+ ",(SELECT ivacompra from productos where codigo_producto = "+Venta1.codigo_producto+")"
//					+ ",(SELECT ((precio_venta*"+Venta1.cantidad +")*ivacompra)+(precio_venta*"+Venta1.cantidad+") as total_venta from productos where codigo_producto = "+Venta1.codigo_producto+")"
//					+ ",(SELECT (precio_venta*"+Venta1.cantidad +") as total_venta from productos where codigo_producto = "+Venta1.codigo_producto+")"
//					+ ")"
//					//"Insert into usuarios values(123456,'admininicial@gmail.com','Admin','admin123456','admininicial');"
//					);
			/*JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente", "Información",
					JOptionPane.INFORMATION_MESSAGE);*/
			
			//estatuto.close();
			conex.desconectar();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			//JOptionPane.showMessageDialog(null, "No se Registro la persona");
		}
		
		//IngresarDetalleVenta(Venta1);
	}
	
	private void IngresarDetalleVenta(VentaVO venta )
	{
		Conexion conex = new Conexion();
		try {
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate(
					"   INSERT INTO detalle_ventas "					
					+ "(cantidad_producto,"
					+ "codigo_producto,"
					+ "codigo_venta,"
					+ "valor_total,"
					+ "valor_venta,"
					+ "valoriva)"
					+ "VALUES"
					+ "("
					+ venta.getCantidad() +","
					+ venta.getCodigo_producto()+","
					+ "(Select MAX(codigo_venta) from ventas),"
					+ "(Select total_venta from ventas Where codigo_venta = (Select MAX(codigo_venta) from ventas)),"
					+ "(Select precio_venta from productos Where codigo_producto = "+venta.getCodigo_producto()+"),"
					+ "(Select ivacompra from productos Where codigo_producto = "+venta.getCodigo_producto()+")"
					+ ")"
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
