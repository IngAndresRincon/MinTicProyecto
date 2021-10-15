package com.DTO.TiendaVirtualSB;

public class ProductoVO {

	private int codigo_producto;
	private double ivacompra;
	private int nit_proveedor;
	private String nombre_producto;
	private double precio_compra;
	private double precioventa;
	
	
	
	public ProductoVO(int codigo_producto, double ivacompra, int nit_proveedor, String nombre_producto,
			double precio_compra, double precioventa) {
		super();
		this.codigo_producto = codigo_producto;
		this.ivacompra = ivacompra;
		this.nit_proveedor = nit_proveedor;
		this.nombre_producto = nombre_producto;
		this.precio_compra = precio_compra;
		this.precioventa = precioventa;
	}
	public int getCodigo_producto() {
		return codigo_producto;
	}
	public void setCodigo_producto(int codigo_producto) {
		this.codigo_producto = codigo_producto;
	}
	public double getIvacompra() {
		return ivacompra;
	}
	public void setIvacompra(double ivacompra) {
		this.ivacompra = ivacompra;
	}
	public int getNit_proveedor() {
		return nit_proveedor;
	}
	public void setNit_proveedor(int nit_proveedor) {
		this.nit_proveedor = nit_proveedor;
	}
	public String getNombre_producto() {
		return nombre_producto;
	}
	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}
	public double getPrecio_compra() {
		return precio_compra;
	}
	public void setPrecio_compra(double precio_compra) {
		this.precio_compra = precio_compra;
	}
	public double getPrecioventa() {
		return precioventa;
	}
	public void setPrecioventa(double precioventa) {
		this.precioventa = precioventa;
	}
	
	
}
