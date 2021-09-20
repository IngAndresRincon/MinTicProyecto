
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
	usu.setDocumento(Integer.parseInt(request.getParameter("num_cedula")));
	usu.setUsuario(request.getParameter("usuarios"));
	usu.setNombre(request.getParameter("nombre"));
	usu.setPassword(request.getParameter("password"));
	usu.setEmail(request.getParameter("correo"));
	//cli.setIdCliente(id);	cli.setApellidoCliente(request.getParameter("apellido"));
	uc.RegistrarUsuario(usu);

%>
<head>
<title>Page Redirection</title>
</head>
<body>
	<h1>Using GET Method to Read Form Data</h1>
	<ul>
		<li><p>
				<b>User:</b>
				<%= request.getParameter("num_cedula")%>
			</p></li>
		<li><p>
				<b>Password:</b>
				<%= request.getParameter("password")%>
			</p></li>
		
	</ul>
	
</body>
</html>