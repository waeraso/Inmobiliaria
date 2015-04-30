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

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        
        <title>resultados</title>
    </head>
    <body> 
        <jsp:include page="Header.html" flush="true" />
        <br/><br/>
        <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Mensajes Inmobiliaria su Kza</h3>
                </div>
            <div class="panel-body">
                <h2 align="center" ><%=mensaje %></h2>
                <div class="col-sm-12 col-sm-8 col-md-8 col-sm-offset-2 col-md-offset-2">
                    <input type="submit" value="Aceptar" name="btn_aceptar" onclick="<%=url%>" class="btn btn-success btn-block btn-lg"/>        
                </div>
            </div>

            </div>
        </div>      
    </body>
</html>
