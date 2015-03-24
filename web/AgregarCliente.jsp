<%-- 
    Document   : AgregarCliente
    Created on : 23/03/2015, 02:58:18 PM
    Author     : WILMER
--%>

<%@page import="com.inmobiliaria.mundo.Inmobiliaria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%  Inmobiliaria inmobiliaria = (Inmobiliaria) session.getAttribute("inmobiliaria");
    if (inmobiliaria == null)
        inmobiliaria = new Inmobiliaria();
    
    session.setAttribute("inmobiliaria", inmobiliaria);
%>

<jsp:include page="index.html" flush="true" />
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="ControladorCliente">
            <div align="center">
                <h1>
                    Agregar Cliente
                </h1>
                <table border="0">
                
                <tbody>
                    <tr>
                        <td>Cedula de Ciudadania:*</td>
                        <td><input type="text" name="txt_cedula" value="" /></td>
                    </tr>
                    <tr>
                        <td>Nombres:*</td>
                        <td><input type="text" name="txt_nombre" value="" /></td>
                    </tr>
                    <tr>
                        <td>Apellidos:*</td>
                        <td><input type="text" name="txt_apellidos" value="" /></td>
                    </tr>
                    <tr>
                        <td>Email:*</td>
                        <td><input type="email" name="txt_email" value="" /></td>
                    </tr>                    
                    <tr>
                        <td>Telefono:*</td>
                        <td><input type="tel" name="txt_telefono" value="" /></td>
                    </tr>
                    <tr>
                        <td align="right"><input type="submit" value="Aceptar" name="btn_aceptar" /></td>
                        <td><input type="reset" value="Cancelar" name="btn_cancelar" /></td>
                    </tr>
                
                </tbody>
            </table>
                <h4>*campos requeridos</h4>
            </div>
        </form>
        <jsp:include page="Fooder.html" flush="true" />
    </body>
</html>
