<%-- 
    Document   : AdministrarClientes
    Created on : 23/03/2015, 04:11:07 PM
    Author     : SoftTeam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="Header.html" flush="true" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrar Clientes</title>
    </head>
    <body>
        <form>
            <div align="center">
                <h1>
                    Buscar Cliente
                </h1>
                <table border="0">
                
                <tbody>
                    <tr>
                        <td>Cedula de Ciudadania:</td>
                        <td><input type="text" name="txt_cedula" value=""/></td>
                    </tr>
                    <tr>
                        <td>Nombres:</td>
                        <td><input type="text" name="txt_nombre" value="" /></td>
                    </tr>
                    <tr>
                        <td>Apellidos:</td>
                        <td><input type="text" name="txt_apellidos" value="" /></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="right" style="text-align: center"><input type="submit" value="Aceptar" name="btn_aceptar" />                          <input type="reset" value="Cancelar" name="btn_cancelar" /></td>
                    </tr>
                
                </tbody>
            </table>
              </div>
        </form>
        <jsp:include page="Fooder.html" flush="true" />
    </body>
</html>
