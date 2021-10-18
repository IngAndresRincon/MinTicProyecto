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
		else if (boton.equals("Consultar"))
		{			
			int id = Integer.parseInt(request.getParameter("nit"));        
		       pro =pc.ConsultarProveedor(id);
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
	<% if(request.getParameter("nit")==null){  System.out.println("Entro al if"); %>
	<form action = "Proveedores.jsp" method = "POST">
		<table class="form_usuarios" style="border: 2px solid darkslategrey;">
			<tr>
				<td><h3>NIT:</h3></td>
				<td><input type="text" name="nit"></td>
				<td><h3>Teléfono:</h3></td>
				<td><input type="text" name="telefono"></td>
			</tr>
			<tr>
				<td><h3>Nombre Proveedor:</h3></td>
				<td><input type="text" name="nombre"></td>
				<td><h3>Ciudad:</h3></td>
				<td><input type="text" name="ciudad"></td>
			</tr>
			<tr>
				<td><h3>Dirección:</h3></td>
				<td><input type="text" name="direccion"></td>
			</tr>
			<tr>
				<td class="boton"><input type="submit" name="boton" value="Consultar"></td>
				<td class="boton"><input type="submit" name="boton" value="Crear"></td>
				<td class="boton"><input type="submit" name="boton" value="Actualizar"></td>
				<td class="boton"><input type="submit" name="boton" value="Borrar"></td>
			</tr>

		</table>

	</form>
	<%  } else { System.out.println("Entro al Else"); %>
		<form action = "Proveedores.jsp" method = "POST">
		<table class="form_usuarios" style="border: 2px solid darkslategrey;">
			<tr>
				<td><h3>NIT:</h3></td>
				<td><input type="text" name="nit" value="<%=pro.getNit() %>"></td>
				<td><h3>Teléfono:</h3></td>
				<td><input type="text" name="telefono" value="<%=pro.getTelefono() %>"></td>
			</tr>
			<tr>
				<td><h3>Nombre Proveedor:</h3></td>
				<td><input type="text" name="nombre" value="<%=pro.getNombre() %>"></td>
				<td><h3>Ciudad:</h3></td>
				<td><input type="text" name="ciudad" value="<%=pro.getCiudad() %>"></td>
			</tr>
			<tr>
				<td><h3>Dirección:</h3></td>
				<td><input type="text" name="direccion" value="<%=pro.getDireccion() %>"></td>
			</tr>
			<tr>
				<td class="boton"><input type="submit" name="boton" value="Consultar"></td>
				<td class="boton"><input type="submit" name="boton" value="Crear"></td>
				<td class="boton"><input type="submit" name="boton" value="Actualizar"></td>
				<td class="boton"><input type="submit" name="boton" value="Borrar"></td>
			</tr>

		</table>

	</form>
	
	<%} %>
	
</body>
</html>