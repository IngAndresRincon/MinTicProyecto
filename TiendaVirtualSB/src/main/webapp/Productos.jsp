<%@ page
 language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="
		java.io.*,
		java.util.*,
		com.BO.TiendaVirtualSB.*,
		com.DTO.TiendaVirtualSB.*"

    %>
    
    <%@ page import="java.util.*" %>
<%@ page import="org.apache.commons.fileupload.*" %>
<%@ page import="org.apache.commons.fileupload.disk.*" %>
<%@ page import="org.apache.commons.fileupload.servlet.*" %>
<%@ page import="org.apache.commons.io.*" %>
<%@ page import="java.io.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	
	<%=request.getParameterValues("archivo") %>
	<%	
	
	try
	{
		
		String rootPath = "D:/Documentos/NetBeans/MinTic Ciclo 3/Documentos Desarrollo/productos.csv";
		//rootPath = rootPath + request.getParameter("file");
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