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
<head>
<meta charset="ISO-8859-1">
<script src="/path/to/jquery.js" type="text/javascript"></script>
<script src="/path/to/jquery.ui.draggable.js" type="text/javascript"></script>

<script src="/path/to/jquery.alerts.js" type="text/javascript"></script>
<link href="/path/to/jquery.alerts.css" rel="stylesheet" type="text/css" media="screen" />

<title>Page Redirection</title>

		<% 
		
		  
			String boton=request.getParameter("boton");
		
			switch(boton)
			{
			case "ListadodeUsuarios":
				//System.out.println("No hay nada");
				
				out.println("<script type=\"text/javascript\">");
			   	out.println("location='ListarUsuarios.jsp';");
			   	out.println("</script>");
				
				break;
				
			case "ListadodeClientes":
				
				out.println("<script type=\"text/javascript\">");
			   	out.println("location='ListarClientes.jsp';");
			   	out.println("</script>");
				
				break;
				
			case "VentasporCliente":

				out.println("<script type=\"text/javascript\">");
			   	out.println("location='ListaTotalVentas.jsp';");
			   	out.println("</script>");
				
				break;
				
			default:
				break;
			
			}
		
	
		
		%>


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
    .boton input{
		width: 350px;
		height: 35px;
		background-color: darkgrey;
		color: beige;
		border-radius: 5px 5px ;
	}
	.boton{
		padding-top: 20px;
	}
    table{
        margin: 0% auto;
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
    <div>
		<form action="Reporte1.jsp " method="get">
        <table action="">
            <tr><td class="boton"><input type="submit" value="ListadodeUsuarios" name="boton"></td></tr>
            <tr><td class="boton"><input type="submit" value="ListadodeClientes" name="boton"></td></tr>
            <tr><td class="boton"><input type="submit" value="VentasporCliente" name="boton"></td></tr>
        </table>
	</form>
    </div>
</body>
</html>