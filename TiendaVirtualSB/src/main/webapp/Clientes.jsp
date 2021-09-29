
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
		cli.setCedula(Integer.parseInt(request.getParameter("num_cedula")));
		cli.setDireccion(request.getParameter("direccion"));
		cli.setEmail(request.getParameter("correo"));
		cli.setNombre(request.getParameter("nombre"));
		cli.setNombre(request.getParameter("telefono"));
		cc.RegistrarCliente(cli);	
	}
	else if (boton.equals("Borrar"))
	{
		long Documento =  Integer.parseInt(request.getParameter("num_cedula"));
		uc.BorrarUsuario(Documento);	
	}
	else if (boton.equals("Actualizar"))
	{
		usu.setDocumento(Integer.parseInt(request.getParameter("num_cedula")));
		usu.setUsuario(request.getParameter("usuarios"));
		usu.setNombre(request.getParameter("nombre"));
		usu.setPassword(request.getParameter("password"));
		usu.setEmail(request.getParameter("correo"));
		uc.ActualizarUsuario(usu);	
	}
		
	

		
	%>	
</body>
</html>