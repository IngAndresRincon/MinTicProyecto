
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
		usu.setDocumento(Integer.parseInt(request.getParameter("num_cedula")));
		usu.setUsuario(request.getParameter("usuarios"));
		usu.setNombre(request.getParameter("nombre"));
		usu.setPassword(request.getParameter("password"));
		usu.setEmail(request.getParameter("correo"));
		uc.RegistrarUsuario(usu);	
	}
	else if (boton.equals("Borrar"))
	{
		long Documento =  Integer.parseInt(request.getParameter("num_cedula"));
		uc.BorrarUsuario(Documento);	
	}
	

		
	%>	
</body>
</html>