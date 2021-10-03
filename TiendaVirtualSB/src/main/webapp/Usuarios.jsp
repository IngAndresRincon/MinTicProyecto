
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
	UsuarioController uc=new UsuarioController();
	UsuarioVO usu=new UsuarioVO();	
	//cli.setIdCliente(id);	cli.setApellidoCliente(request.getParameter("apellido"));
	String boton=request.getParameter("boton"); 
	
	if (boton.equals("Crear"))
	{
		
		try
		{
			usu.setDocumento(Integer.parseInt(request.getParameter("num_cedula")));
			usu.setUsuario(request.getParameter("usuarios"));
			usu.setNombre(request.getParameter("nombre"));
			usu.setPassword(request.getParameter("password"));
			usu.setEmail(request.getParameter("correo"));
			uc.RegistrarUsuario(usu);	
		   	out.println("<script type=\"text/javascript\">");
		   	out.println("alert('Usuario Creado');");
		   	out.println("location='Usuarios.html';");
		   	out.println("</script>");
		}
		catch (Exception ex)
		{
			   out.println("<script type=\"text/javascript\">");
			   out.println("alert('Error al crear usuario');");
			   out.println("location='Usuarios.html';");
			   out.println("</script>");
			
		}
		
		
		
	
	}
	else if (boton.equals("Borrar"))
	{
		try
		{
			long Documento =  Integer.parseInt(request.getParameter("num_cedula"));
			uc.BorrarUsuario(Documento);
		   	out.println("<script type=\"text/javascript\">");
		   	out.println("alert('Usuario Eliminado');");
		   	out.println("location='Usuarios.html';");
		   	out.println("</script>");
		}
		catch (Exception ex)
		{
		   	out.println("<script type=\"text/javascript\">");
		   	out.println("alert('Usuario no encontrado');");
		   	out.println("location='Usuarios.html';");
		   	out.println("</script>");
			
		}
		

	}
	else if (boton.equals("Actualizar"))
	{
		
		try
		{
			usu.setDocumento(Integer.parseInt(request.getParameter("num_cedula")));
			usu.setUsuario(request.getParameter("usuarios"));
			usu.setNombre(request.getParameter("nombre"));
			usu.setPassword(request.getParameter("password"));
			usu.setEmail(request.getParameter("correo"));
			uc.ActualizarUsuario(usu);	
			out.println("<script type=\"text/javascript\">");
		   	out.println("alert('Usuario actualizado');");
		   	out.println("location='Usuarios.html';");
		   	out.println("</script>");
			
		}
		catch (Exception ex)
		{			
			out.println("<script type=\"text/javascript\">");
		   	out.println("alert('Error al actualizar usuario');");
		   	out.println("location='Usuarios.html';");
		   	out.println("</script>");
		}
		
	}
	else if (boton.equals("Consultar"))
	{	

			request.setAttribute("nombre","nombre");
			out.println("<script type=\"text/javascript\">");
			out.println("location='Usuarios.html';");
			out.println("</script>");	
			out.println("nombres");
	
	}

		
	%>	
</body>
</html>