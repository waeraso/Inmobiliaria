<%-- 
    Document   : AdministrarClientes
    Created on : 23/03/2015, 04:11:07 PM
    Author     : SoftTeam
--%>
<%-- 
    Document   : AdministrarClientes
    Created on : 23/03/2015, 04:11:07 PM
    Author     : SoftTeam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrar Clientes</title>
    </head>
    <body>
        <jsp:include page="Header.html" flush="true" />
        <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
            <form role="form" action="ControladorCliente">
                
                <h2>Buscar Clientes</h2>
                <hr class="colorgraph"> 
            
                <div class="form-group">
                    <input type="text" name="txt_cedula" class="form-control input-lg" placeholder="Cedula" tabindex="1">
		</div>
                
                <div class="form-group">
                    <input type="text" name="txt_nombre"  class="form-control input-lg" placeholder="Nombre" tabindex="2">
		</div>		
                
		<hr class="colorgraph">
		<div class="row">
                    <div class="col-xs-6 col-md-6"><input type="submit" value="Buscar" name="btn_aceptar" class="btn btn-success btn-block btn-lg" tabindex="7"></div>
                    <div class="col-xs-6 col-md-6"><input type="reset" value="Limpiar" name="btn_cancelar" class="btn btn-danger btn-block btn-lg"/></div>
		</div>  
            </form>        
        </div>
    </body>
</html>
