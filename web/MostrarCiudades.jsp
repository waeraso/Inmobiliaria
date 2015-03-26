<%-- 
    Document   : MostrarCiudades
    Created on : 26/03/2015, 11:53:33 AM
    Author     : KMILO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mostrar Ciudad</title>
    </head>
    <body>       
        <jsp:include page="Header.html" flush="true" />
        <form action="ControladorCiudad"> 
             <div align="center">
             <h1>Mostrar Ciudad</h1>
             <h2>Modificar o Eliminar Ciudad</h2>
             
                <jsp:useBean id="ciudad" scope="session" class="com.inmobiliaria.mundo.Ciudad"/>        
             
                <table width="25%" border="0" align="center" cellpadding="7" cellspacing="0">
                    <tr>
                        <td>Nombre:<span style="color: #F00">*</span></td>
                        <td><input type="text" name="txt_nombre" size="20" maxlength="30" value="<%=ciudad.getNombre()%>"></td>
                    </tr>                                                            
                    <tr>
                        <td>Departamento:<span style="color: #F00">*</span></td>
                        <td><input type="text" name="txt_departamento" value="<%=ciudad.getDepartamento()%>" size="20" maxlength="30"></td>                        
                    </tr>
                    <td colspan="2" style="text-align: center"><input type="submit" value="Modificar" name="btn_aceptar"/> <input type="submit" value="Eliminar" name="btn_aceptar"/>                          <input type="reset" value="Cancelar" /></td>
                    </tr>
                </table>
                <p><span style="color: #F00">*campos requeridos</span>
                </p>
             </div>
        </form>
        <jsp:include page="Fooder.html" flush="true" />
    </body>
</html>
