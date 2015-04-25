<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : MostrarClientes
    Created on : 25/03/2015, 08:15:19 AM
    Author     : KMILO
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.inmobiliaria.mundo.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        
    </head>
    <body> 
        <jsp:include page="Header.html" flush="true" />
        
        <div class="col-sm-12 col-sm-8 col-md-7 col-sm-offset-2 col-md-offset-3">
        <form id="formu" action="ControladorCliente">
            <input type ="hidden" name="val">
            
        <div align="center">
        <h2>Lista Clientes</h2>          
        
        <table class="table table-bordered table-hover" id="tabla">
            <tr class="success">
                <td>IdCliente</td>
                <td>Cedula</td>
                <td>Nombres</td>
                <td>Apellidos</td>
                <td>Email</td>
                <td>Telefono</td>
                <td>Acción</td>
            </tr>
            <%int i=0;
                %>
        <c:forEach var="cliente" items="${sessionScope.clientes}">
            <tr class="active">
                <td>${cliente.idCliente}</td>
                <td>${cliente.cedula}</td>
                <td>${cliente.nombre}</td>
                <td>${cliente.apellidos}</td>
                <td>${cliente.email}</td>
                <td>${cliente.telefono}</td>                
                <%i=i+1;
                %>
                <td>                                      
                    <input type="submit" class="btn btn-primary btn-xs" value="Editar" name="btn_aceptar" onclick="modificar(<%=i%>)"/>                                                                                  
                    <input type="submit" class="btn btn-danger btn-xs" value="Eliminar" name="btn_aceptar" onclick="modificar(<%=i%>)"/>                                       
                </td>               
            </tr>            
        </c:forEach> 
        </table>
        <input type="submit" value="Regresar" name="btn_regresar" onclick="javascript:window.history.back();"/>
        
       </div>
        </form> 
        </div>
        
    </body>    
    
    <script type="text/javascript">
        function modificar(p1) {
            var x = document.getElementById("tabla").rows[p1].cells[1].innerHTML ;                                   
            document.forms["formu"].elements[0].value = x;                                   
        }                
    </script>

</html>