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
  String url = (String) session.getAttribute("url"); 
  url = "location='"+url+"'";
%>
<jsp:include page="Header.html" flush="true" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>resultados</title>
    </head>
    <body>  
        <div align="center">
            <br/><br/>
        <h1><%=mensaje %></h1>
        <!--<input type="submit" value="Aceptar" name="btn_aceptar" onclick="location='index.jsp'"/>        -->
        <input type="submit" value="Aceptar" name="btn_aceptar" onclick="<%=url%>"/>        
        </div>
    </body>
</html>
