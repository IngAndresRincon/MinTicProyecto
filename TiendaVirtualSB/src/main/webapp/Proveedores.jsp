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
		ProveedorController pc =new ProveedorController();
		ProveedorVO pro=new ProveedorVO();	
		//cli.setIdCliente(id);	cli.setApellidoCliente(request.getParameter("apellido"));
		String boton=request.getParameter("boton"); 
		
		if (boton.equals("Crear"))
		{
			try
			{
				pro.setNit(Integer.parseInt(request.getParameter("nit")));
				pro.setTelefono(request.getParameter("telefono"));
				pro.setNombre(request.getParameter("nombre"));
				pro.setCiudad(request.getParameter("ciudad"));
				pro.setDireccion(request.getParameter("direccion"));
				pc.RegistrarProveedor(pro);	
			   	out.println("<script type=\"text/javascript\">");
			   	out.println("alert('Proveedor Creado');");
			   	out.println("location='Usuarios.html';");
			   	out.println("</script>");
			}
			catch (Exception ex)
			{
			   	out.println("<script type=\"text/javascript\">");
			   	out.println("alert('Error al crear proveedor');");
			   	out.println("location='Usuarios.html';");
			   	out.println("</script>");
			}
			
		}
		else if (boton.equals("Borrar"))
		{
			try
			{
				long Nit =  Integer.parseInt(request.getParameter("nit"));
				pc.BorrarProveedor(Nit);	
			   	out.println("<script type=\"text/javascript\">");
			   	out.println("alert('Proveedor Eliminado');");
			   	out.println("location='Usuarios.html';");
			   	out.println("</script>");
			}
			catch (Exception ex)
			{
			   	out.println("<script type=\"text/javascript\">");
			   	out.println("alert('Error al eliminar proveedor');");
			   	out.println("location='Usuarios.html';");
			   	out.println("</script>");
			}

		}
		else if (boton.equals("Actualizar"))
		{
			try
			{
				pro.setNit(Integer.parseInt(request.getParameter("nit")));
				pro.setTelefono(request.getParameter("telefono"));
				pro.setNombre(request.getParameter("nombre"));
				pro.setCiudad(request.getParameter("ciudad"));
				pro.setDireccion(request.getParameter("direccion"));
				pc.ActualizarProveedor(pro);	
			   	out.println("<script type=\"text/javascript\">");
			   	out.println("alert('Proveedor actualizado');");
			   	out.println("location='Usuarios.html';");
			   	out.println("</script>");
			}
			catch (Exception ex)
			{
			   	out.println("<script type=\"text/javascript\">");
			   	out.println("alert('Error al actualizar proveedor');");
			   	out.println("location='Usuarios.html';");
			   	out.println("</script>");
			}

		}
	%>	
</body>
</html>