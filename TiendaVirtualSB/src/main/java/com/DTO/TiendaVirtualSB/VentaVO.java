package com.DTO.TiendaVirtualSB;

public class VentaVO {

		public Integer cedula_cliente;
		public Integer cedula_usuario;
		public Integer codigo_producto;
		public double total_venta;
		public double valor_venta;
		public Integer cantidad;
		
		
		public String nombreCliente;
		

		
		public String getNombreCliente() {
			return nombreCliente;
		}
		public void setNombreCliente(String nombreCliente) {
			this.nombreCliente = nombreCliente;
		}
		public Integer getCantidad() {
			return cantidad;
		}
		public void setCantidad(Integer cantidad) {
			this.cantidad = cantidad;
		}
		public Integer getCedula_cliente() {
			return cedula_cliente;
		}
		public void setCedula_cliente(Integer cedula_cliente) {
			this.cedula_cliente = cedula_cliente;
		}
		public Integer getCedula_usuario() {
			return cedula_usuario;
		}
		public void setCedula_usuario(Integer cedula_usuario) {
			this.cedula_usuario = cedula_usuario;
		}
		public Integer getCodigo_producto() {
			return codigo_producto;
		}
		public void setCodigo_producto(Integer codigo_producto) {
			this.codigo_producto = codigo_producto;
		}
		public double getTotal_venta() {
			return total_venta;
		}
		public void setTotal_venta(double total_venta) {
			this.total_venta = total_venta;
		}
		public double getValor_venta() {
			return valor_venta;
		}
		public void setValor_venta(double valor_venta) {
			this.valor_venta = valor_venta;
		}
		
		
	
}
