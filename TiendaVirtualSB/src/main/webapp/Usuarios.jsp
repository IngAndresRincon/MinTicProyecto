<%@ page
    import="
        java.io.*,
        java.util.*,
        com.BO.TiendaVirtualSB.*,
        com.DTO.TiendaVirtualSB.*"
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%
   // ClienteVO cli = new ClienteVO();
	
	UsuarioController uc=new UsuarioController();
	UsuarioVO usu=new UsuarioVO();	

    
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
		 //  	out.println("location='Usuarios.jsp';");
		   	out.println("</script>");
			
		}
		catch (Exception ex)
		{			
			out.println("<script type=\"text/javascript\">");
		   	out.println("alert('Error al actualizar usuario');");
		 //  	out.println("location='Usuarios.html';");
		   	out.println("</script>");
		}
		
	}
	else if (boton.equals("Consultar"))
	{	
		int id = Integer.parseInt(request.getParameter("num_cedula"));        
	       usu =uc.ConsultarUsuario(id);
	
	}
    
%>
<head>
	<title>Tienda Genérica</title>

</head>
<style type="text/css">
	*{
		margin:0px;
	}
	div{
		border: 0px solid black;
		width: 1364px;
		height: 50px;
		margin: 0 auto;
	}
	.titulo2{	
		background-color:dimgray ;
		color: white;
	}
	.barra_navegacion{
		background-color: white;
		color:thistle;
	}
	h1{
		padding-top: 10px;
		padding-left: 10px
	}
	ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: darkslategrey;
	}

	li {
		float: left;
		border-right: 1px solid white;
	}	
	li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 30px;
    text-decoration: none;
	}

	li a:hover {
		background-color: #111;
	}
	li a:active
	{
    background-color:teal;
	}
	.form_usuarios{
		margin: 50px auto;
	}
	td{
		padding: 25px 30px;
	}
	h3{
		font-size: 20px;
		color: darkgray;
	}

	.boton input{
		width: 100px;
		height: 30px;
		background-color: darkgrey;
		color: beige;
		border-radius: 5px 5px ;
	}
	.boton{
		padding-top: 20px;
	}

</style>

     <body>
     
    <div class="titulo2">
	<h1>Tienda Genérica</h1>
	</div>
	<div class="barra_navegacion">
		<ul>
			<li><a href="Usuarios.html">Usuarios</a></li>
			<li><a href="Clientes.html">Clientes</a></li>
			<li><a href="Proveedores.html">Proveedores</a></li>
			<li><a href="Productos.html">Productos</a></li>
			<li><a href="Ventas.html">Ventas</a></li>
			<li><a href="Reporte1.html">Reportes</a></li>
		</ul>
	</div>
	<% if(request.getParameter("num_cedula")==null){  System.out.println("Entro al if"); %> 
	
	<form action = "Usuarios.jsp" method = "GET">
		<table class="form_usuarios" style="border: 2px solid darkslategrey;">
			<tr>
				<td><h3>Cédula:</h3></td>
				<td><input type="text" name="num_cedula"></td>
				<td><h3>Usuario:</h3></td>
				<td><input type="text" name="usuarios"></td>
			</tr>
			<tr>
				<td><h3>Nombre Completo:</h3></td>
				<td><input type="text" name="nombre"></td>
				<td><h3>Contraseña:</h3></td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td><h3>Correo Electrónico:</h3></td>
				<td><input type="email" name="correo"></td>
			</tr>
			<tr>
				<td class="boton"><input type="submit" name="boton" value="Consultar"></td>
				<td class="boton"><input type="submit" name="boton" value="Crear" ></td>
				<td class="boton"><input type="submit" name="boton" value="Actualizar"></td>
				<td class="boton"><input type="submit" name="boton" value="Borrar"></td>
			</tr>
		</table>

	</form>
	 <%  } else { System.out.println("Entro al Else"); %>
     
     
     <form action = "Usuarios.jsp" method = "GET">
		<table class="form_usuarios" style="border: 2px solid darkslategrey;">
			<tr>
				<td><h3>Cédula:</h3></td>
				<td><input type="text" name="num_cedula" value="<%= usu.getDocumento() %>"></td>
				<td><h3>Usuario:</h3></td>
				<td><input type="text" name="usuarios" value="<%= usu.getUsuario() %>"></td>
			</tr>
			<tr>
				<td><h3>Nombre Completo:</h3></td>
				<td><input type="text" name="nombre" value="<%= usu.getNombre() %>"></td>
				<td><h3>Contraseña:</h3></td>
				<td><input type="password" name="password" value="<%= usu.getPassword() %>"></td>
			</tr>
			<tr>
				<td><h3>Correo Electrónico:</h3></td>
				<td><input type="email" name="correo" value="<%= usu.getEmail() %>"></td>
			</tr>
			<tr>
				<td class="boton"><input type="submit" name="boton" value="Consultar"></td>
				<td class="boton"><input type="submit" name="boton" value="Crear" ></td>
				<td class="boton"><input type="submit" name="boton" value="Actualizar"></td>
				<td class="boton"><input type="submit" name="boton" value="Borrar"></td>
			</tr>
		</table>

	</form>
     
     
     
     <% } %>
     
     
     
     
   </body>
</html>