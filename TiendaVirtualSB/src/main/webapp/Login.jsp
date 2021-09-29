
<%@ page
	import="
		java.io.*,
		java.util.*,
		com.BO.TiendaVirtualSB.*,
		com.DTO.TiendaVirtualSB.*"
%>
<html>

<head>
<script src="/path/to/jquery.js" type="text/javascript"></script>
<script src="/path/to/jquery.ui.draggable.js" type="text/javascript"></script>

<script src="/path/to/jquery.alerts.js" type="text/javascript"></script>
<link href="/path/to/jquery.alerts.css" rel="stylesheet" type="text/css" media="screen" />

<title>Page Redirection</title>
</head>
<body>
		<% 
			UsuarioController uc=new UsuarioController();
			UsuarioVO usu=new UsuarioVO();
			usu.setUsuario(request.getParameter("user_id"));
			usu.setPassword(request.getParameter("password"));
			//cli.setIdCliente(id);	cli.setApellidoCliente(request.getParameter("apellido"));
			// usu.Contador = 20;
			uc.LoginUsuario(usu);
		
		%>

		<% 
		if (usu.Contador > 0)
		{
			   out.println("<script type=\"text/javascript\">");
			   out.println("alert('Acceso Correcto');");
			   out.println("location='Navegacion.html';");
			   out.println("</script>");
			//response.sendRedirect("Navegacion.html");
			//out.println("El valor del contador es: "+ usu.Contador);
		}
		else
		{	   out.println("<script type=\"text/javascript\">");
			   out.println("alert('Usuario o Contraseña Incorrectos');");
			   out.println("location='Login.html';");
			   out.println("</script>");

		//response.sendRedirect("Login.html");
		}
					
		%>

</body>
</html>