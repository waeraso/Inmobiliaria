<%-- 
    Document   : AgregarDepartamento
    Created on : 23/03/2015, 08:36:47 PM
    Author     : andre_000
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
        <h1>Hello World!</h1>
        <form align="center" id="formulario" action="enviado.php" method="post" name="Adicionar Departamento">
            <fieldset>
                <legend>Adicionar Departamento</legend>
                <div><label>Nombre:*</label>
                    <input id="nombre_departamento" name="nombre_departamento" type="text" /></div>
                <div align="center"><input id="Aceptar" name="enviar" type="submit" value="Aceptar" /></div>
            </fieldset>
        </form>     
        <jsp:include page="Fooder.html" flush="true" />
        

    </body>
</html>
