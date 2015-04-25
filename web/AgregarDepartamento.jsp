<%-- 
    Document   : AgregarCiudad
    Created on : 23/03/2015, 03:34:18 PM
    Author     : SoftTeam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Departamento</title>
    </head>
    <body>
 <jsp:include page="Header.html" flush="true" />
    <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
        <form role="form" action="ControladorDepartamento">             
                <h2>Agregar Departamento <small>Todos los Campos Requeridos</small></h2>
                <hr class="colorgraph">                                
                
		<div class="form-group">
                    <input type="text" name="txt_nombre" required="required" class="form-control input-lg" placeholder="Nombre" maxlength="30" tabindex="3">
		</div>               				
                
		<hr class="colorgraph">
		<div class="row">
                    <div class="col-xs-6 col-md-6"><input type="submit" value="Agregar" name="btn_aceptar" class="btn btn-success btn-block btn-lg" tabindex="7"></div>
                    <div class="col-xs-6 col-md-6"><input type="reset" value="Limpiar" name="btn_cancelar" class="btn btn-danger btn-block btn-lg"/></div>
		</div>                               
        </form>
      </div>   
    </body>
</html>
