
<%@ page
	import="
		java.io.*,
		java.util.*,
		com.BO.TiendaVirtualSB.*,
		com.DTO.TiendaVirtualSB.*"
%>
<html>
<% 
	UsuarioController uc=new UsuarioController();
	UsuarioVO usu=new UsuarioVO();
	usu.setUsuario(request.getParameter("user_id"));
	usu.setPassword(request.getParameter("password"));
	//cli.setIdCliente(id);	cli.setApellidoCliente(request.getParameter("apellido"));
	// usu.Contador = 20;
	uc.LoginUsuario(usu);

%>
<head>
<title>Page Redirection</title>
</head>
<body>
		<% 
		if (usu.Contador > 0)
		{
			response.sendRedirect("Navegacion.html");
			//out.println("El valor del contador es: "+ usu.Contador);
		}
		else
		{
			response.sendRedirect("modificarPersona.html");
		}
					 				
		%>

</body>
</html>