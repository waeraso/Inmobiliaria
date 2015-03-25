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
        <title>Clientes</title>
    </head>
    <body>
        <jsp:include page="Header.html" flush="true" />
        <div align="center">
        <h1>Lista Clientes</h1>                   
        <table border="1">
            <tr>
                <td>IdCliente</td>
                <td>Cedula</td>
                <td>Nombres</td>
                <td>Apellidos</td>
                <td>Email</td>
                <td>Telefono</td>
            </tr>
            
        <c:forEach var="cliente" items="${sessionScope.clientes}">
            <tr>
                <td>${cliente.idCliente}</td>
                <td>${cliente.cedula}</td>
                <td>${cliente.nombre}</td>
                <td>${cliente.apellidos}</td>
                <td>${cliente.email}</td>
                <td>${cliente.telefono}</td>
            </tr>            
        </c:forEach> 
        </table>
        <jsp:include page="Fooder.html" flush="true" />
        </div>
    </body>
</html>
