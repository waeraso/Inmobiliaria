<%-- 
    Document   : AgregarCiudad
    Created on : 23/03/2015, 03:34:18 PM
    Author     : KMILO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="index.html" flush="true" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <form > 
             <div align="center">
             <h1>Agregar Ciudad</h1>
                <table width="50%" border="0" align="center" cellpadding="7" cellspacing="0">
                    <tr>
                        <td>Nombre: </td>
                        <td><input type="text" name="txt_nombre" size="20" maxlength="30"></td>
                    </tr>                                                            
                    <tr>
                        <td>Departamento: </td>
                        <td><select name="dpd_departamento">
                            <option value="0">Seleccionar</option>
                            <option value="Antioquia">Antioquia</option>
                            <option value="Boyacá">Boyacá</option>
                            <option value="Cauca">Cauca</option>
                            <option value="Nariño">Nariño</option></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Agregar" /></td>
                        <td><input type="reset" value="Cancelar" /></td>
                    </tr>
                </table>
             </div>
        </form>
        <jsp:include page="Fooder.html" flush="true" />
    </body>
</html>