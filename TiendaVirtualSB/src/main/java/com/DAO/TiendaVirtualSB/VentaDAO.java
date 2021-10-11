package com.DAO.TiendaVirtualSB;

import java.sql.SQLException;
import java.sql.Statement;

import com.DTO.TiendaVirtualSB.VentaVO;

public class VentaDAO {

	
	
	public void IngresarVenta(VentaVO Venta) {
		Conexion conex = new Conexion();
		try {
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate(
					"   INSERT INTO ventas"
					+ "(cedula_cliente,"
					+ "cedula_usuario,"
					+ "ivaventa,"
					+ "total_venta,"
					+ "valor_venta)"
					+ "VALUES"
					+ "("+Venta.cedula_cliente
					+ ",(SELECT cedula_usuario From usuarios Where nombre_usuario='admin')"
					+ ",(SELECT ivacompra from productos where codigo_producto = "+Venta.codigo_producto+")"
					+ ",(SELECT ((precio_venta*"+Venta.cantidad +")*ivacompra)+(precio_venta*"+Venta.cantidad+") as total_venta from productos where codigo_producto = "+Venta.codigo_producto+")"
					+ ",(SELECT (precio_venta*"+Venta.cantidad +") as total_venta from productos where codigo_producto = "+Venta.codigo_producto+")"
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
