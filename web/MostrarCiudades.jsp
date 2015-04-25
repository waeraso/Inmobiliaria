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
        <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
            <form role="form" action="ControladorCiudad"> 
                <h2>Datos de la Ciudad <small>Modificar o Eliminar</small></h2>
                    <jsp:useBean id="ciudad" scope="session" class="com.inmobiliaria.mundo.Ciudad"/>        
                <hr class="colorgraph">             
                
                <div class="row">
                    <div class="col-xs-6 col-sm-6 col-md-6">
			<div class="form-group">
                            <label for="txt_nombre">Nombre:</label>
                            <input type="text" name="txt_nombre" required="required" maxlength="30" class="form-control input-lg" value="<%=ciudad.getNombre()%>" tabindex="1">
			</div>
                    </div>
                    <div class="col-xs-6 col-sm-6 col-md-6">
                        <label for="txt_departamento">Departamento:</label>
                        <input type="text" name="txt_departamento" disabled  value="<%=ciudad.getDepartamento()%>" class="form-control input-lg" value="<%=ciudad.getNombre()%>" tabindex="1">                                                 
                    </div>
		</div>	
                                                
		<hr class="colorgraph">
		<div class="row">
                    <div class="col-xs-6 col-md-4"><input type="submit" value="Modificar" name="btn_aceptar" class="btn btn-success btn-block btn-ms" tabindex="7"></div>
                    <div class="col-xs-6 col-md-4"><input type="submit" value="Eliminar" name="btn_aceptar" class="btn btn-danger btn-block btn-ms"/></div>                    
                    <div class="col-xs-6 col-md-4"><input type="submit" value="Volver" name="btn_aceptar" class="btn btn-primary btn-block btn-ms"/></div>
		</div>                                   
            </form>
        </div>              
    </body>
</html>
