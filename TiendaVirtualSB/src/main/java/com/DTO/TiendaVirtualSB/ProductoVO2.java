package com.DTO.TiendaVirtualSB;

public class ProductoVO2 {

	private static int codigo_producto;
	private static double ivacompra;
	private static int nit_proveedor;
	private static String nombre_producto;
	private static double precio_compra;
	private static double precioventa;
	
	private static int Cantidad;
	


	public ProductoVO2()
	{
		
	}
	
	public ProductoVO2(int codigo_producto, double ivacompra, int nit_proveedor, String nombre_producto,
			double precio_compra, double precioventa) {
		super();
		this.codigo_producto = codigo_producto;
		this.ivacompra = ivacompra;
		this.nit_proveedor = nit_proveedor;
		this.nombre_producto = nombre_producto;
		this.precio_compra = precio_compra;
		this.precioventa = precioventa;
	}

	public static int getCodigo_producto() {
		return codigo_producto;
	}

	public static void setCodigo_producto(int codigo_producto) {
		ProductoVO2.codigo_producto = codigo_producto;
	}

	public static double getIvacompra() {
		return ivacompra;
	}

	public static void setIvacompra(double ivacompra) {
		ProductoVO2.ivacompra = ivacompra;
	}

	public static int getNit_proveedor() {
		return nit_proveedor;
	}

	public static void setNit_proveedor(int nit_proveedor) {
		ProductoVO2.nit_proveedor = nit_proveedor;
	}

	public static String getNombre_producto() {
		return nombre_producto;
	}

	public static void setNombre_producto(String nombre_producto) {
		ProductoVO2.nombre_producto = nombre_producto;
	}

	public static double getPrecio_compra() {
		return precio_compra;
	}

	public static void setPrecio_compra(double precio_compra) {
		ProductoVO2.precio_compra = precio_compra;
	}

	public static double getPrecioventa() {
		return precioventa;
	}

	public static void setPrecioventa(double precioventa) {
		ProductoVO2.precioventa = precioventa;
	}

	public static int getCantidad() {
		return Cantidad;
	}

	public static void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}


	
}
