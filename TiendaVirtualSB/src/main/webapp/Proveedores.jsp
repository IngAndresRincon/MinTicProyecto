
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
		ProveedorController pc =new ProveedorController();
		ProveedorVO pro=new ProveedorVO();	
		//cli.setIdCliente(id);	cli.setApellidoCliente(request.getParameter("apellido"));
		String boton=request.getParameter("boton"); 
		
		if (boton.equals("Crear"))
		{
			pro.setNit(Integer.parseInt(request.getParameter("nit")));
			pro.setTelefono(request.getParameter("telefono"));
			pro.setNombre(request.getParameter("nombre"));
			pro.setCiudad(request.getParameter("ciudad"));
			pro.setDireccion(request.getParameter("direccion"));
			pc.RegistrarProveedor(pro);	
		}
		else if (boton.equals("Borrar"))
		{
			long Nit =  Integer.parseInt(request.getParameter("nit"));
			pc.BorrarProveedor(Nit);	
		}
		else if (boton.equals("Actualizar"))
		{
			pro.setNit(Integer.parseInt(request.getParameter("nit")));
			pro.setTelefono(request.getParameter("telefono"));
			pro.setNombre(request.getParameter("nombre"));
			pro.setCiudad(request.getParameter("ciudad"));
			pro.setDireccion(request.getParameter("direccion"));
			pc.ActualizarProveedor(pro);	
		}
	%>	
</body>
</html>