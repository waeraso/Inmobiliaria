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

<jsp:include page="Header.html" flush="true" />
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Cliente</title>
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
                        <td>Cedula de Ciudadania:<span style="color: #F00">*</span></td>
                        <td><input name="txt_cedula" type="text" autofocus="autofocus" required="required" value="" maxlength="10" /></td>
                    </tr>
                    <tr>
                        <td>Nombres:<span style="color: #F00">*</span></td>
                        <td><input name="txt_nombre" type="text" autofocus="autofocus" required="required" value="" /></td>
                    </tr>
                    <tr>
                        <td>Apellidos:<span style="color: #F00">*</span></td>
                        <td><input name="txt_apellidos" type="text" autofocus="autofocus" required="required" value="" /></td>
                    </tr>
                    <tr>
                        <td>Email:<span style="color: #F00">*</span></td>
                        <td><input name="txt_email" type="email" autofocus="autofocus" required="required" value="" /></td>
                    </tr>                    
                    <tr>
                        <td>Telefono:<span style="color: #F00">*</span></td>
                        <td><input name="txt_telefono" type="tel" autofocus="autofocus" required="required" value="" maxlength="10" /></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="right" style="text-align: center"><input type="submit" value="Agregar" name="btn_aceptar" />                          <input type="reset" value="Cancelar" name="btn_cancelar" /></td>
                    </tr>
                  </tbody>
            </table>
                <h4><span style="color: #F00">*campos requeridos</span></h4>
            </div>
        </form>
        <jsp:include page="Fooder.html" flush="true" />
    </body>
</html>
