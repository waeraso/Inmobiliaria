<%-- 
    Document   : MostrarDepartamentos
    Created on : 26/03/2015, 12:05:01 AM
    Author     : KMILO
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.inmobiliaria.mundo.Departamento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mostrar Departamento</title>
    </head>
    <body>        
        <jsp:include page="Header.html" flush="true" />
        <form action="ControladorDepartamento">
            <div align="center">
             <h1>Datos Departamento</h1>
             <h2>Modifique o Elimine el Departamento</h2>
             
                <jsp:useBean id="departamento" scope="session" class="com.inmobiliaria.mundo.Departamento"/>        
                
                <table width="20%" border="0" align="center" cellpadding="3" cellspacing="0">
                    <tr>
                        <td>Nombre:<span style="color: #F00">*</span></td>
                        <td><input name="txt_nombre" type="text" autofocus="autofocus" value="<%=departamento.getNombre()%>" required="required" size="20" maxlength="30"></td>
                    </tr>                                                            
                    <tr>
                        <td colspan="2" style="text-align: center"><input type="submit" value="Modificar" name="btn_aceptar"/> <input type="submit" value="Eliminar" name="btn_aceptar"/>                         <input type="submit" value="Volver" name="btn_aceptar"/></td>
                    </tr>
                </table>
                <p><span style="color: #F00">*campos requeridos</span>
                </p>
             </div>
            
        </form>        
        <jsp:include page="Fooder.html" flush="true" />
    </body>
</html>
