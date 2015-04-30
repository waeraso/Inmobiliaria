<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : MostrarInmueblesNegocio
    Created on : 29/04/2015, 06:18:01 PM
    Author     : KMILO
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.inmobiliaria.mundo.Inmueble"%>
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
        
        <div class="col-sm-12 col-sm-8 col-md-8 col-sm-offset-2 col-md-offset-2">
        <form id="formu" action="ControladorInmueble">
            <input type ="hidden" name="val">            
        
            <div align="center"><h2>Lista Inmuebles Disponibles</h2> </div>                      
        
        <table class="table table-bordered table-hover" id="tabla">
            <tr class="success">
                <td>Imagen</td>
                <td>IdInmueble</td>
                <td>Direccion</td>
                <td>Barrio</td>
                <td>Telefono</td>
                <td>Tipo</td>
                <td>Tamaño</td>
                <td>Precio</td>                
                <td>Acción</td>
            </tr>
            <%int i=0;
                %>
        <c:forEach var="inmueble" items="${sessionScope.inmuebles}">
            <tr class="active">
                
                <td><img width="120" height="80" src="images/inmuebles/${inmueble.imagen}" alt="" class="img-thumbnail"/></td>
                <td>${inmueble.idInmueble}</td>
                <td>${inmueble.direccion}</td>
                <td>${inmueble.barrio}</td>
                <td>${inmueble.telefono}</td>
                <td>${inmueble.tipo}</td>                
                <td>${inmueble.tamanio}</td>                
                <td>${inmueble.precio}</td>                
                <%i=i+1;
                %>
                <td>                                      
                    <input type="submit" class="btn btn-success btn-xs" value="Vender/Arrendar" name="btn_aceptar" onclick="modificar(<%=i%>)"/>                                                                                                     
                </td>               
            </tr>            
        </c:forEach> 
        </table>
        <div align="center">
            <input type="submit" value="Regresar" name="btn_regresar" onclick="javascript:window.history.back();" class="btn btn-primary btn-lg"/>        
        </div>
       
        </form> 
        </div>
        
    </body>    
    
    <script type="text/javascript">
        function modificar(p1) {
            var x = document.getElementById("tabla").rows[p1].cells[2].innerHTML ;                                   
            document.forms["formu"].elements[0].value = x;                                   
        }                
    </script>
</html>
