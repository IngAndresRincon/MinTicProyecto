<%@ page
	import="
		java.io.*,
		java.util.*,
		com.BO.TiendaVirtualSB.*,
		com.DTO.TiendaVirtualSB.*"
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		VentaController vc =new VentaController();
		VentaVO ven=new VentaVO();	
		//cli.setIdCliente(id);	cli.setApellidoCliente(request.getParameter("apellido"));
		
		ven.cedula_cliente = Integer.parseInt(request.getParameter("cedula"));
		ven.codigo_producto = Integer.parseInt(request.getParameter("cod1"));
		ven.cantidad = Integer.parseInt(request.getParameter("cant1"));
			
		vc.IngresarVenta(ven);
	   	out.println("<script type=\"text/javascript\">");
	   	out.println("alert('Venta registrada');");
	   	out.println("location='Ventas.html';");
	   	out.println("</script>");



		
		 %>

</body>
</html>