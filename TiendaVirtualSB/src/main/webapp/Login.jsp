
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
	uc.LoginUsuario(usu);

%>
<head>
<title>Page Redirection</title>
</head>
<body>
	<h1>Using GET Method to Read Form Data</h1>
	<ul>
		<li><p>
				<b>User:</b>
				<%= request.getParameter("user_id")%>
			</p></li>
		<li><p>
				<b>Password:</b>
				<%= request.getParameter("password")%>
			</p></li>
		
	</ul>
	
</body>
</html>