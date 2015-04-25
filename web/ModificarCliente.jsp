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
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        
        <title>Modificar Cliente</title>
    </head>
    <body>        
        <jsp:include page="Header.html" flush="true" />
    <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
        <form role="form" action="ControladorCliente">             
                <h2>Modificar Cliente <small>Todos los Campos Requeridos</small></h2>
                    <jsp:useBean id="cliente" scope="request" class="com.inmobiliaria.mundo.Cliente"/>
                <hr class="colorgraph">                
                <div class="row">
                    <div class="col-xs-6 col-sm-6 col-md-6">
			<div class="form-group">
                            <label for="txt_nombre">Nombre:</label>
                            <input type="text" name="txt_nombre" required="required" class="form-control input-lg" placeholder="Nombre" value="<%=cliente.getNombre()%>" tabindex="1">
			</div>
                    </div>
                    <div class="col-xs-6 col-sm-6 col-md-6">
                        <div class="form-group">
                            <label for="txt_apellidos">Apellidos:</label>
                            <input type="text" name="txt_apellidos"  required="required" class="form-control input-lg" placeholder="Apellidos" value="<%=cliente.getApellidos()%>" tabindex="2">
                        </div>
                    </div>
		</div>
                
		<div class="form-group">
                    <label for="txt_cedula">Cedula:</label>
                    <input type="text" name="txt_cedula" disabled class="form-control input-lg" value="<%=cliente.getCedula()%>" tabindex="3">
		</div>
                
		<div class="form-group">
                    <label for="txt_email">Email:</label>
                    <input type="email" name="txt_email" required="required" class="form-control input-lg" placeholder="Email" value="<%=cliente.getEmail()%>" tabindex="4">
		</div>
                
                <div class="form-group">
                    <label for="txt_telefono">Telefono:</label>
                    <input type="text" name="txt_telefono" required="required" class="form-control input-lg" placeholder="Telefono" value="<%=cliente.getTelefono()%>" tabindex="4">
		</div>
		
                
		<hr class="colorgraph">
		<div class="row">
                    <div class="col-xs-6 col-md-6"><input type="submit" value="Modificar" name="btn_aceptar" class="btn btn-success btn-block btn-lg" tabindex="7"></div>
                    <div class="col-xs-6 col-md-6"><input type="submit" value="Cancelar" name="btn_cancelar" onclick="javascript:window.history.back();" class="btn btn-danger btn-block btn-lg"/></div>
		</div>                               
        </form>
      </div>    
        
    </body>
</html>
