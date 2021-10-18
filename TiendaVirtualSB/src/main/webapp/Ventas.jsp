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
    VentaController vc =new VentaController();
    ClienteVO clienteJSP = new ClienteVO();
    
    
    ProductoVO pro1 = new ProductoVO();
    ProductoVO1 pro2 = new ProductoVO1();
    ProductoVO2 pro3 = new ProductoVO2();
    
   	String NombreCliente;
    VentaVO ven1=new VentaVO();
    VentaVO ven2=new VentaVO();
    VentaVO ven3=new VentaVO();
    //cli.setIdCliente(id);	cli.setApellidoCliente(request.getParameter("apellido"));
        
    String boton=request.getParameter("boton");
    
    System.out.println("Inicia programa");
    
    
    switch(boton)
    {
    	case "Consultar1":
    		
    		
    	System.out.println("Entro a consultar1");
        	
      	  try
            {
             
  	    	int Documento = Integer.parseInt(request.getParameter("cedula"));
  	    	System.out.println("Cedula:" +Documento);
  	    	clienteJSP = vc.ConsultarCliente(Documento);
  	    	System.out.println("Retorno al JSP" +clienteJSP.getNombre());
            
            }
      	  catch(Exception ex)
      	  {
      		  System.out.println("Error 2 es: "+ex.getMessage());    		  
      	  }
    		
    		
    		break;
    	
    	case "Consultar2":
    		
    		
    		
    		System.out.println("Entro a consultar2");
        	
        	  try
              {
               
        		
    	    	int producto = Integer.parseInt(request.getParameter("cod1"));
    	    	int cantidad = Integer.parseInt(request.getParameter("cant1"));
    	    	pro1 = vc.ConsultarProducto(producto, cantidad);
    	    	              
              }
        	  catch(Exception ex)
        	  {
        		  System.out.println("Error 2 es: "+ex.getMessage());    		  
        	  }
    		
    		
    		break;
    	
    	case "Consultar3":
    		
    		System.out.println("Entro a consultar3");
        	
      	  try
            {
             
      		
  	    	int producto = Integer.parseInt(request.getParameter("cod2"));
  	    	int cantidad = Integer.parseInt(request.getParameter("cant2"));
  	    	pro2 = vc.ConsultarProducto2(producto, cantidad);
  	    	              
            }
      	  catch(Exception ex)
      	  {
      		  System.out.println("Error 2 es: "+ex.getMessage());    		  
      	  }
  		
    		
    		break;
    		
    	case "Consultar4":
    		
	   		
    		System.out.println("Entro a consultar4");
        	
      	  try
            {
             
      		
  	    	int producto = Integer.parseInt(request.getParameter("cod3"));
  	    	int cantidad = Integer.parseInt(request.getParameter("cant3"));
  	    	pro3 = vc.ConsultarProducto3(producto, cantidad);
  	    	              
            }
      	  catch(Exception ex)
      	  {
      		  System.out.println("Error 2 es: "+ex.getMessage());    		  
      	  }
    		
    		break;
    	
    		default:
    			
    			
    			
    		    
    		     if ((request.getParameter("cod1").length()) < 1 && boton.equals("Confirmar") )
    		     {
    		               out.println("<script type=\"text/javascript\">");
    		               out.println("alert('Ingrese un producto');");
    		               out.println("location='Ventas.html';");
    		               out.println("</script>");
    		               
    		     }
    		     if(Integer.parseInt(request.getParameter("cod1")) > 0 && boton.equals("Confirmar"))
    		     {
    		         System.out.println("Hay un producto asdsa");
    		         
    		         if ((request.getParameter("cod2").length()) > 0 && boton.equals("Confirmar") && Integer.parseInt((request.getParameter("cod2")))> 0)
    		         {
    		             System.out.println("Hay dos producto asdsa");
    		             if ((request.getParameter("cod3")).length() > 0 && boton.equals("Confirmar") && Integer.parseInt((request.getParameter("cod3")))> 0)	 
    		             {
    		                 System.out.println("Hay tres productos");
    		                 try
    		                    {
    		                         ven1.cedula_cliente = Integer.parseInt(request.getParameter("cedula"));
    		                        ven1.codigo_producto = Integer.parseInt(request.getParameter("cod1"));
    		                        ven1.cantidad = Integer.parseInt(request.getParameter("cant1"));	
    		                        
    		                        ven2.codigo_producto = Integer.parseInt(request.getParameter("cod2"));
    		                        ven2.cantidad = Integer.parseInt(request.getParameter("cant2"));	
    		                        
    		                        ven3.codigo_producto = Integer.parseInt(request.getParameter("cod3"));
    		                        ven3.cantidad = Integer.parseInt(request.getParameter("cant3"));	
    		                        
    		                        
    		                        vc.IngresarVenta(ven1,ven2,ven3,3);		
    		                        
    		                   		pro1 = null;
    		                   		pro2 = null;
    		                   		pro3 = null;
    		                   		
    		                           out.println("<script type=\"text/javascript\">");
    		                           out.println("alert('Venta registrada');");
    		                           out.println("location='Ventas.html';");
    		                           out.println("</script>");
    		                        
    		                        
    		                    }
    		                    catch (Exception ex)
    		                    {
    		                           out.println("<script type=\"text/javascript\">");
    		                           out.println("alert('Error al registrar venta');");
    		                           out.println("location='Ventas.html';");
    		                           out.println("</script>");
    		                        
    		                    }
    		             }
    		             else
    		             {
    		                 System.out.println("Hay dos productos");
    		                 try
    		                    {
    		                        ven1.cedula_cliente = Integer.parseInt(request.getParameter("cedula"));
    		                        ven1.codigo_producto = Integer.parseInt(request.getParameter("cod1"));
    		                        ven1.cantidad = Integer.parseInt(request.getParameter("cant1"));	
    		                        
    		                        ven2.codigo_producto = Integer.parseInt(request.getParameter("cod2"));
    		                        ven2.cantidad = Integer.parseInt(request.getParameter("cant2"));	
    		                        
    		                    	pro1 = null;
    		                   		pro2 = null;
    		                   		pro3 = null;
    		                   		
    		                        
    		                        vc.IngresarVenta(ven1,ven2,null,2);		
    		                           out.println("<script type=\"text/javascript\">");
    		                           out.println("alert('Venta registrada');");
    		                           out.println("location='Ventas.html';");
    		                           out.println("</script>");
    		                        
    		                    }
    		                    catch (Exception ex)
    		                    {
    		                           out.println("<script type=\"text/javascript\">");
    		                           out.println("alert('Error al registrar venta');");
    		                           out.println(ex);
    		                           out.println("location='Ventas.html';");
    		                           out.println("</script>");
    		                        
    		                    }
    		                 
    		             }
    		             
    		            
    		             
    		         }
    		         else
    		         {
    		             System.out.println("Hay un productos");
    		             try
    		                {
    		                    ven1.cedula_cliente = Integer.parseInt(request.getParameter("cedula"));
    		                    ven1.codigo_producto = Integer.parseInt(request.getParameter("cod1"));
    		                    ven1.cantidad = Integer.parseInt(request.getParameter("cant1"));			
    		                    vc.IngresarVenta(ven1,null,null,1);	
    		                    
    		                	pro1 = null;
		                   		pro2 = null;
		                   		pro3 = null;
		                   		
    		                       out.println("<script type=\"text/javascript\">");
    		                       out.println("alert('Venta registrada');");
    		                       out.println("location='Ventas.html';");
    		                       out.println("</script>");
    		                    
    		                }
    		                catch (Exception ex)
    		                {
    		                       out.println("<script type=\"text/javascript\">");
    		                       out.println("alert('Error al registrar venta 1 ');");
    		                       out.println(ex);
    		                       out.println("location='Ventas.html';");
    		                       out.println("</script>");
    		                    
    		                }
    		             
    		         }
    		        
    		     }
    			
    			break;
    
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
		padding: 15px 10px;
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
			<li><a href="Reportes1.html">Reportes</a></li>
		</ul>
	</div>
	<% System.out.println("Acá es antes del IF");
	if(request.getParameter("cedula")==null){  System.out.println("Entro al if"); %>
	<form action = "Ventas.jsp" method = "POST">
		<table class="form_usuarios" style="border: 2px solid darkslategrey;">
			<tr>
				<td><h3>Cédula:</h3></td>
				<td><input type="text" name="cedula"></td>
                <td class="boton"><input type="submit" name="boton" value="Consultar1"></td>
				<td><h3>Cliente:</h3></td>
				<td style="text-align: center;"><input type="text" name="cliente" style="width: 250px;"></td>
				<td><h3>Consec:</h3></td>
				<td><input type="text" name="consecutivo"></td>
			</tr>
			<tr>
                <td colspan="3" style="text-align: center;"><h3>Cod. Producto</h3></td>
                <td><h3>Nombre Producto</h3></td>
                <td style="text-align: center;"><h3>Cant</h3></td>
                <td colspan="2" style="text-align: center;"><h3>Vlr. Total</h3></td>
			</tr>
            <tr>
                <td colspan="2" style="text-align: right;"><input type="text" name="cod1"></td>
                <td class="boton"><input type="submit" name="boton" value="Consultar2"></td>
                <td><input type="text" name="producto1" style="width: 200px;"></td>
                <td style="text-align: center;"><input type="text" name="cant1" style="width: 60px;"></td>
                <td colspan="2" style="text-align: center;"><input type="text" name="vlr1"></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: right;"><input type="text" name="cod2"></td>
                <td class="boton"><input type="submit" name="boton" value="Consultar3"></td>
                <td><input type="text" name="producto2" style="width: 200px;"></td>
                <td style="text-align: center;"><input type="text" name="cant2" style="width: 60px;"></td>
                <td colspan="2" style="text-align: center;"><input type="text" name="vlr2"></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: right;"><input type="text" name="cod3"></td>
                <td class="boton"><input type="submit" name="boton" value="Consultar4"></td>
                <td><input type="text" name="producto3" style="width: 200px;"></td>
                <td style="text-align: center;"><input type="text" name="cant3" style="width: 60px;"></td>
                <td colspan="2" style="text-align: center;"><input type="text" name="vlr3"></td>
            </tr>
            <tr>
                <td colspan="5" style="text-align: right;"><h3>Total Venta</h3></td>
                <td colspan="2" style="text-align: center;"><input type="text" name="vlr4"></td>
            </tr>
            <tr>
                <td colspan="5" style="text-align: right;"><h3>Total IVA</h3></td>
                <td colspan="2" style="text-align: center;"><input type="text" name="vlr5"></td>
            </tr>
            <tr>
                <td colspan="4" class="boton" style="text-align: right;"><input type="submit" name="boton" value="Confirmar"></td>
                <td style="text-align: right;"><h3>Total con IVA</h3></td>
                <td colspan="2" style="text-align: center;"><input type="text" name="vlr6"></td>
            </tr>            

		</table>

	</form>
	<%  } else { System.out.println("Entro al Else"); %>
	
		<form action = "Ventas.jsp" method = "POST">
		<table class="form_usuarios" style="border: 2px solid darkslategrey;">
			<tr>
				<td><h3>Cédula:</h3></td>
				<td><input type="text" name="cedula" value="<%= clienteJSP.getCedula()  %>"></td>
                <td class="boton"><input type="button" name="boton" value="Consultar1"></td>
				<td><h3>Cliente:</h3></td>
				<td style="text-align: center;"><input type="text" name="cliente" value="<%=  clienteJSP.getNombre() %>" style="width: 250px; "></td>
				<td><h3>Consec:</h3></td>
				<td><input type="text" name="consecutivo"></td>
			</tr>
			<tr>
                <td colspan="3" style="text-align: center;"><h3>Cod. Producto</h3></td>
                <td><h3>Nombre Producto</h3></td>
                <td style="text-align: center;"><h3>Cant</h3></td>
                <td colspan="2" style="text-align: center;"><h3>Vlr. Total</h3></td>
			</tr>
            <tr>
                <td colspan="2" style="text-align: right;"><input type="text" name="cod1" value="<%= pro1.getCodigo_producto() %>"></td>
                <td class="boton"><input type="submit" name="boton" value="Consultar2"></td>
                <td><input type="text" name="producto1" value="<%= pro1.getNombre_producto() %>" style="width: 200px;"></td>
                <td style="text-align: center;"><input type="text" name="cant1" value="<%= pro1.getCantidad() %>" style="width: 60px;"></td>
                <td colspan="2" style="text-align: center;"><input type="text" name="vlr1"   value="<%= pro1.getPrecioventa() %>" ></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: right;"><input type="text" name="cod2" value="<%= pro2.getCodigo_producto() %>"></td>
                <td class="boton"><input type="submit" name="boton" value="Consultar3"></td>
                <td><input type="text" name="producto2"  value="<%= pro2.getNombre_producto() %>"  style="width: 200px;"></td>
                <td style="text-align: center;"><input type="text" name="cant2" value="<%= pro2.getCantidad() %>"  style="width: 60px;"></td>
                <td colspan="2" style="text-align: center;"><input type="text" name="vlr2"  value="<%= pro2.getPrecioventa() %>" ></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: right;"><input type="text" name="cod3"  value="<%= pro3.getCodigo_producto() %>"></td>
                <td class="boton"><input type="submit" name="boton" value="Consultar4"></td>
                <td><input type="text" name="producto3" value="<%= pro3.getNombre_producto() %>"  style="width: 200px;"></td>
                <td style="text-align: center;"><input type="text" name="cant3" value="<%= pro3.getCantidad() %>" style="width: 60px;"></td>
                <td colspan="2" style="text-align: center;"><input type="text" name="vlr3" value="<%= pro3.getPrecioventa() %>"></td>
            </tr>
            <tr>
                <td colspan="5" style="text-align: right;"><h3>Total Venta</h3></td>
                <td colspan="2" style="text-align: center;"><input type="text" name="vlr4" value="<%= pro1.getPrecioventa() + pro2.getPrecioventa() + pro3.getPrecioventa() %>"></td>
            </tr>
            <tr>
                <td colspan="5" style="text-align: right;"><h3>Total IVA</h3></td>
                <td colspan="2" style="text-align: center;"><input type="text" name="vlr5" value="<% System.out.println("El valor de producto1: "+pro1.getIvacompra() + "El valor del producto dos es: "+pro2.getIvacompra() +"El valor del producto dos es: "+pro3.getIvacompra() ); if( (double)(pro1.getIvacompra()) > 0 && (double)(pro2.getIvacompra()) == 0 && (double)(pro3.getIvacompra()) == 0 ){%> <%= pro1.getIvacompra() %> <%}else if((double)(pro1.getIvacompra()) > 0 && (double)(pro2.getIvacompra()) > 0 && (double)(pro3.getIvacompra()) == 0 ){%> <%=((double)pro1.getIvacompra()+ (double)pro2.getIvacompra())/2  %> <% } else if( (double)(pro1.getIvacompra()) > 0 && (double)(pro2.getIvacompra()) > 0 && (double)(pro3.getIvacompra()) > 0 ) { %> <%= ((double)pro1.getIvacompra()+ (double)pro2.getIvacompra() + (double)pro3.getIvacompra())/3 %> <% }%>"></td>
            </tr>
            <tr>
                <td colspan="4" class="boton" style="text-align: right;"><input type="submit" name="boton" value="Confirmar"></td>
                <td style="text-align: right;"><h3>Total con IVA</h3></td>
                <td colspan="2" style="text-align: center;"><input type="text" name="vlr6" value="<% if( (double)(pro1.getIvacompra()) > 0 && (double)(pro2.getIvacompra()) == 0 && (double)(pro3.getIvacompra()) == 0 ){%> <%=((pro1.getPrecioventa() + pro2.getPrecioventa() + pro3.getPrecioventa())*pro1.getIvacompra())+(pro1.getPrecioventa() + pro2.getPrecioventa() + pro3.getPrecioventa()) %> <%}else if((double)(pro1.getIvacompra()) > 0 && (double)(pro2.getIvacompra()) > 0 && (double)(pro3.getIvacompra()) == 0 ){%> <%= ((pro1.getPrecioventa() + pro2.getPrecioventa() + pro3.getPrecioventa())*(((double)pro1.getIvacompra()+ (double)pro2.getIvacompra())/2 ))+(pro1.getPrecioventa() + pro2.getPrecioventa() + pro3.getPrecioventa())%> <% } else if( (double)(pro1.getIvacompra()) > 0 && (double)(pro2.getIvacompra()) > 0 && (double)(pro3.getIvacompra()) > 0 ) { %> <%=((pro1.getPrecioventa() + pro2.getPrecioventa() + pro3.getPrecioventa())*( ((double)pro1.getIvacompra()+ (double)pro2.getIvacompra() + (double)pro3.getIvacompra())/3 ))+(pro1.getPrecioventa() + pro2.getPrecioventa() + pro3.getPrecioventa())  %> <% }%>"></td>
            </tr>            

		</table>

	</form>
	
	<%} %>
	
	
</body>
</html>