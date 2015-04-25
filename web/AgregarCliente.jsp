<%-- 
    Document   : AgregarCliente
    Created on : 23/03/2015, 02:58:18 PM
    Author     : WILMER
--%>

<%@page import="com.inmobiliaria.mundo.Inmobiliaria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%  Inmobiliaria inmobiliaria = (Inmobiliaria) session.getAttribute("inmobiliaria");
    if (inmobiliaria == null)
        inmobiliaria = new Inmobiliaria();
    
    session.setAttribute("inmobiliaria", inmobiliaria);
%>


<html>
    <head>        
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>     
               
        <title>Agregar Cliente</title>
    </head>
    <body>
        <jsp:include page="Header.html" flush="true" />
    <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
        <form role="form" action="ControladorCliente">             
                <h2>Agregar Cliente <small>Todos los Campos Requeridos</small></h2>
                <hr class="colorgraph">                
                <div class="row">
                    <div class="col-xs-6 col-sm-6 col-md-6">
			<div class="form-group">
                            <input type="text" name="txt_nombre" required="required" class="form-control input-lg" placeholder="Nombre" tabindex="1">
			</div>
                    </div>
                    <div class="col-xs-6 col-sm-6 col-md-6">
                        <div class="form-group">
                            <input type="text" name="txt_apellidos"  required="required" class="form-control input-lg" placeholder="Apellidos" tabindex="2">
                        </div>
                    </div>
		</div>
                
		<div class="form-group">
                    <input type="number" name="txt_cedula" min="1" max="9999999999" required="required" class="form-control input-lg" placeholder="Cedula" tabindex="3">
		</div>
                
		<div class="form-group">
                    <input type="email" name="txt_email" required="required" class="form-control input-lg" placeholder="Email" tabindex="4">
		</div>
                
                <div class="form-group">
                    <input type="number" name="txt_telefono" min="1" max="9999999999" required="required" class="form-control input-lg" placeholder="Telefono" tabindex="4">
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
