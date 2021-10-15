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

	<%= "Longitud uno"+ request.getParameter("cod1").length()%>
	<%= "Valor uno"+request.getParameter("cod1")%>
	<%= "Longitud dos"+request.getParameter("cod2").length()%>
	<%= "Valor dos"+request.getParameter("cod2")%>
	<%= "Longitud tres"+request.getParameter("cod3").length()%>
	<%= "Valor tres"+request.getParameter("cod3")%>
	<%
		VentaController vc =new VentaController();
		VentaVO ven1=new VentaVO();
		VentaVO ven2=new VentaVO();
		VentaVO ven3=new VentaVO();
		//cli.setIdCliente(id);	cli.setApellidoCliente(request.getParameter("apellido"));
		
		 if ((request.getParameter("cod1").length()) < 1 )
		 {
			   	out.println("<script type=\"text/javascript\">");
			   	out.println("alert('Ingrese un producto');");
			   	out.println("location='Ventas.html';");
			   	out.println("</script>");
			   	
		 }
		 else if(Integer.parseInt(request.getParameter("cod1")) > 0 )
		 {
			 
			 if (Integer.parseInt(request.getParameter("cod2")) > 0 )
			 {
				 
				 if (Integer.parseInt(request.getParameter("cod3")) > 0 )	 
				 {
					 System.out.println("Hay tres productos");
					 try
						{
						 	ven1.cedula_cliente = Integer.parseInt(request.getParameter("cedula"));
							ven1.codigo_producto = Integer.parseInt(request.getParameter("cod1"));
							ven1.cantidad = Integer.parseInt(request.getParameter("cant1"));	
							
							ven2.codigo_producto = Integer.parseInt(request.getParameter("cod2"));
							ven2.cantidad = Integer.parseInt(request.getParameter("cant2"));	
							
							ven3.codigo_producto = Integer.parseInt(request.getParameter("cod3"));
							ven3.cantidad = Integer.parseInt(request.getParameter("cant3"));	
							
							
							vc.IngresarVenta(ven1,ven2,ven3,3);		
						   	out.println("<script type=\"text/javascript\">");
						   	out.println("alert('Venta registrada');");
						   	out.println("location='Ventas.html';");
						   	out.println("</script>");
							
						}
						catch (Exception ex)
						{
						   	out.println("<script type=\"text/javascript\">");
						   	out.println("alert('Error al registrar venta');");
						   	out.println("location='Ventas.html';");
						   	out.println("</script>");
							
						}
				 }
				 else
				 {
					 System.out.println("Hay dos productos");
					 try
						{
							ven1.cedula_cliente = Integer.parseInt(request.getParameter("cedula"));
							ven1.codigo_producto = Integer.parseInt(request.getParameter("cod1"));
							ven1.cantidad = Integer.parseInt(request.getParameter("cant1"));	
							
							ven2.codigo_producto = Integer.parseInt(request.getParameter("cod2"));
							ven2.cantidad = Integer.parseInt(request.getParameter("cant2"));	
							
							
							vc.IngresarVenta(ven1,ven2,null,2);		
						   	out.println("<script type=\"text/javascript\">");
						   	out.println("alert('Venta registrada');");
						   	out.println("location='Ventas.html';");
						   	out.println("</script>");
							
						}
						catch (Exception ex)
						{
						   	out.println("<script type=\"text/javascript\">");
						   	out.println("alert('Error al registrar venta');");
						   	out.println(ex);
						   	out.println("location='Ventas.html';");
						   	out.println("</script>");
							
						}
					 
				 }
				 
				
				 
			 }
			 else
			 {
				 System.out.println("Hay un productos");
				 try
					{
						ven1.cedula_cliente = Integer.parseInt(request.getParameter("cedula"));
						ven1.codigo_producto = Integer.parseInt(request.getParameter("cod1"));
						ven1.cantidad = Integer.parseInt(request.getParameter("cant1"));			
						vc.IngresarVenta(ven1,null,null,1);		
					   	out.println("<script type=\"text/javascript\">");
					   	out.println("alert('Venta registrada');");
					   	out.println("location='Ventas.html';");
					   	out.println("</script>");
						
					}
					catch (Exception ex)
					{
					   	out.println("<script type=\"text/javascript\">");
					   	out.println("alert('Error al registrar venta 1 ');");
					   	out.println(ex);
					   	out.println("location='Ventas.html';");
					   	out.println("</script>");
						
					}
				 
			 }
			
		 }

		
		


		
		 %>

</body>
</html>