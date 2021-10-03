<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="
		java.io.*,
		java.util.*,
		com.BO.TiendaVirtualSB.*,
		com.DTO.TiendaVirtualSB.*"

    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	
	<%	

	try
	{
		String rootPath = "D:/Documentos/NetBeans/MinTic Ciclo 3/Documentos Desarrollo/";
		rootPath = rootPath + request.getParameter("nombre_archivo");
		LecturaArchivo la = new LecturaArchivo();
		String Archivo = rootPath;
		la.EnviarProductos(Archivo);
	   	out.println("<script type=\"text/javascript\">");
	   	out.println("alert('Inventario Actualizado');");
	   	out.println("location='Productos.html';");
	   	out.println("</script>");
	}
	catch (Exception ex)
	{
		out.println("<script type=\"text/javascript\">");
	   	out.println("alert('Error al actualizar Inventario');");
	   	out.println("location='Productos.html';");
	   	out.println("</script>");
	}
		
	%>
		
	
		
</body>
</html>