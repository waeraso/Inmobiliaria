<%-- 
    Document   : Mensajes
    Created on : 23/03/2015, 10:19:15 PM
    Author     : KMILO
--%>

<%@page import="com.inmobiliaria.mundo.Inmobiliaria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
  Inmobiliaria inmobiliaria = (Inmobiliaria) session.getAttribute("inmobiliaria");
  
  session.setAttribute("inmobiliaria", inmobiliaria);
  
  String mensaje = (String) session.getAttribute("mensaje");  
%>
<jsp:include page="index.html" flush="true" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>  
        <div align="center">
        <h2><%=mensaje %></h2>
        <input type="submit" value="Aceptar" name="btn_aceptar" onclick="javascript:window.history.back();"/>        
        <jsp:include page="Fooder.html" flush="true" />
        </div>
    </body>
</html>
