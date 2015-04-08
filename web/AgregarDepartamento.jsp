<%-- 
    Document   : AgregarCiudad
    Created on : 23/03/2015, 03:34:18 PM
    Author     : SoftTeam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="Header.html" flush="true" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Departamento</title>
    </head>
    <body>
         <form action="ControladorDepartamento"> 
             <div align="center">
             <h1>Agregar Departamento</h1>
                <table width="20%" border="0" align="center" cellpadding="3" cellspacing="0">
                    <tr>
                        <td>Nombre:<span style="color: #F00">*</span></td>
                        <td><input name="txt_nombre" type="text" autofocus="autofocus" required="required" size="20" maxlength="30"></td>
                    </tr>                                                            
                    <tr>
                        <td colspan="2" style="text-align: center"><input type="submit" value="Agregar" name="btn_aceptar"/>                          <input type="reset" value="Limpiar" /></td>
                    </tr>
                </table>
                <p><span style="color: #F00">*campos requeridos</span>
                </p>
             </div>
        </form>
        <jsp:include page="Fooder.html" flush="true" />
    </body>
</html>
