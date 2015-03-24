<%-- 
    Document   : AdministrarDepartamento
    Created on : 23/03/2015, 09:11:42 PM
    Author     : andre_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="Header.html" flush="true" />
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrar Departamentos</title>
    </head>
    <body>        
        <form align="center" id="formulario" action="" method="post">                       
            <div align="center">
             <h1>Buscar Departamentos</h1>
                <table width="50%" border="0" align="center" cellpadding="7" cellspacing="0">
                    <tr>
                        <td>Nombre: </td>
                        <td><input type="text" name="txt_nombre" size="20" maxlength="30"></td>
                    </tr>                                                                              
                    <tr>
                        <td><input type="submit" value="Buscar" /></td>
                        <td><input type="reset" value="Cancelar" /></td>
                    </tr>                    
                </table>
             </div>
        </form>     
        <jsp:include page="Fooder.html" flush="true" />
        

    </body>
</html>
