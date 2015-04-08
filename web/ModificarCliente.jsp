<%-- 
    Document   : ModificarCliente
    Created on : 25/03/2015, 09:27:34 PM
    Author     : KMILO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Cliente</title>
    </head>
    <body>        
        <jsp:include page="Header.html" flush="true" />
        <form action="ControladorCliente">
        <div align="center">
        <h1>MODIFICAR CLIENTE</h1>
        <jsp:useBean id="cliente" scope="request" class="com.inmobiliaria.mundo.Cliente"/>
        
        <table border="0">
                
                <tbody>
                    <tr>
                        <td>Cedula de Ciudadania:<span style="color: #F00">*</span></td>
                        <td><input name="txt_cedula" type="text" autofocus="autofocus" required="required" value="<%=cliente.getCedula()%>"/></td>                                                         
                    </tr>
                    <tr>
                        <td>Nombres:<span style="color: #F00">*</span></td>
                        <td><input name="txt_nombre" type="text" autofocus="autofocus" required="required" value=<%=cliente.getNombre()%> /></td>
                    </tr>
                    <tr>
                        <td>Apellidos:<span style="color: #F00">*</span></td>
                        <td><input name="txt_apellidos" type="text" autofocus="autofocus" required="required" value="<%=cliente.getApellidos()%>" /></td>
                    </tr>
                    <tr>
                        <td>Email:<span style="color: #F00">*</span></td>
                        <td><input name="txt_email" type="email" autofocus="autofocus" required="required" value="<%=cliente.getEmail()%>" /></td>
                    </tr>                    
                    <tr>
                        <td>Telefono:<span style="color: #F00">*</span></td>
                        <td><input name="txt_telefono" type="tel" autofocus="autofocus" required="required" value="<%=cliente.getTelefono()%>" maxlength="10" /></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="right" style="text-align: center"><input type="submit" value="Modificar" name="btn_aceptar" />                          <input type="reset" value="Cancelar" name="btn_cancelar" onclick="javascript:window.history.back();"/></td>
                    </tr>
                  </tbody>
            </table>
        </div>   
        </form>
        <jsp:include page="Fooder.html" flush="true" />
        
    </body>
</html>
