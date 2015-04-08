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
    </head>
    <body> 
        <jsp:include page="Header.html" flush="true" />
        <form id="formu" action="ControladorCliente">
            <input type ="hidden" name="val">
            
        <div align="center">
        <h2>Lista Clientes</h2>          
        
        <table border="1" id="tabla">
            <tr>
                <td>IdCliente</td>
                <td>Cedula</td>
                <td>Nombres</td>
                <td>Apellidos</td>
                <td>Email</td>
                <td>Telefono</td>
            </tr>
            <%int i=0;
                %>
        <c:forEach var="cliente" items="${sessionScope.clientes}">
            <tr>
                <td>${cliente.idCliente}</td>
                <td>${cliente.cedula}</td>
                <td>${cliente.nombre}</td>
                <td>${cliente.apellidos}</td>
                <td>${cliente.email}</td>
                <td>${cliente.telefono}</td>
                <%i=i+1;
                %>
                <td><input type="submit" value="Editar" name="btn_aceptar" onclick="modificar(<%=i%>)"/>
                <input type="submit" value="Eliminar" name="btn_aceptar" onclick="modificar(<%=i%>)"/></td>
                
            </tr>            
        </c:forEach> 
        </table>
        <input type="submit" value="Regresar" name="btn_regresar" onclick="javascript:window.history.back();"/>
        <jsp:include page="Fooder.html" flush="true" />
       </div>
        </form>                       
    </body>
    
    <script type="text/javascript">
        function modificar(p1) {
            var x = document.getElementById("tabla").rows[p1].cells[1].innerHTML ;                                   
            document.forms["formu"].elements[0].value = x;                                   
        }                
    </script>

</html>