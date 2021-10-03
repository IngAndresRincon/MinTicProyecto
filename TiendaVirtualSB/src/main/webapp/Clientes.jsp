
<%@ page
	import="
		java.io.*,
		java.util.*,
		com.BO.TiendaVirtualSB.*,
		com.DTO.TiendaVirtualSB.*"
%>
<html>

<head>
<title>Page Redirection</title>
</head>
<body>
	<% 
	ClienteController cc=new ClienteController();
	ClienteVO cli=new ClienteVO();	
	//cli.setIdCliente(id);	cli.setApellidoCliente(request.getParameter("apellido"));
	String boton=request.getParameter("boton"); 
	
	if (boton.equals("Crear"))
	{
		try
		{
			cli.setCedula(Integer.parseInt(request.getParameter("num_cedula")));
			cli.setDireccion(request.getParameter("direccion"));
			cli.setEmail(request.getParameter("correo"));
			cli.setNombre(request.getParameter("nombre"));
			cli.setTelefono(request.getParameter("telefono"));
			cc.RegistrarCliente(cli);
			out.println("<script type=\"text/javascript\">");
		   	out.println("alert('Cliente creado');");
		   	out.println("location='Clientes.html';");
		   	out.println("</script>");
		}		
		catch (Exception ex)
		{
			out.println("<script type=\"text/javascript\">");
		   	out.println("alert('Error al crear cliente');");
		   	out.println("location='Clientes.html';");
		   	out.println("</script>");
			
		}

	}
	else if (boton.equals("Borrar"))
	{
		try
		{
			long Documento =  Integer.parseInt(request.getParameter("num_cedula"));
			cc.BorrarCliente(Documento);
			out.println("<script type=\"text/javascript\">");
		   	out.println("alert('Cliente eliminado');");
		   	out.println("location='Clientes.html';");
		   	out.println("</script>");
		}
		catch (Exception ex)
		{
			out.println("<script type=\"text/javascript\">");
		   	out.println("alert('Error al eliminar cliente');");
		   	out.println("location='Clientes.html';");
		   	out.println("</script>");
			
		}
		

	}
	else if (boton.equals("Actualizar"))
	{
		try
		{
			cli.setCedula(Integer.parseInt(request.getParameter("num_cedula")));
			cli.setDireccion(request.getParameter("direccion"));
			cli.setEmail(request.getParameter("correo"));
			cli.setNombre(request.getParameter("nombre"));
			cli.setTelefono(request.getParameter("telefono"));
			cc.ActualizarCliente(cli);	
			out.println("<script type=\"text/javascript\">");
		   	out.println("alert('Cliente Actualizado');");
		   	out.println("location='Clientes.html';");
		   	out.println("</script>");
		}
		catch (Exception ex)
		{
			out.println("<script type=\"text/javascript\">");
		   	out.println("alert('Error al actualizar cliente');");
		   	out.println("location='Clientes.html';");
		   	out.println("</script>");
			
		}
	
	}
		
	

		
	%>	
</body>
</html>