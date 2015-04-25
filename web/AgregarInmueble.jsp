<%-- 
    Document   : AgregarInmueble
    Created on : 25/04/2015, 03:41:14 PM
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
        
        <title>Agregar Inmueble</title>
    </head>
    <body>
        <jsp:include page="Header.html" flush="true" />
        <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
            <form role="form" action="ControladorInmueble">             
                <h2>Agregar Inmueble <small>Todos los Campos Requeridos</small></h2>
                <hr class="colorgraph">                                
                
		<!--imagen-->
                <div class="row">
                    <div class="col-xs-6 col-sm-6 col-md-6">
			<div class="form-group">
                            <img class="img-thumbnail" tabindex="1">                            
			</div>
                    </div>
                    <div class="col-xs-6 col-sm-6 col-md-6">
                        <div class="form-group">                            
                                Cargar Imagen <input type="file" tabindex="2">                            
                        </div>
                    </div>
		</div>  
                <!--Fin imagen-->
                
                <div class="row">
                    <div class="col-xs-6 col-sm-6 col-md-6">
			<div class="form-group">
                            <input type="text" name="txt_direccion" required="required" class="form-control input-lg" placeholder="Direccion" tabindex="3">
			</div>
                    </div>
                    <div class="col-xs-6 col-sm-6 col-md-6">
                        <div class="form-group">
                            <input type="text" name="txt_barrio"  required="required" class="form-control input-lg" placeholder="Barrio" tabindex="4">
                        </div>
                    </div>
		</div>
                
                <div class="form-group">
                        <input type="number" name="txt_telefono" min="1" max="9999999999" required="required" class="form-control input-lg" placeholder="Telefono" tabindex="5">
                </div> 
                
                <div class="form-group">
                    <label for="dpd_tipoInmueble">Tipo:</label>
                        <select class="form-control" name="dpd_tipoInmueble">                                                                              
                            <option>Apartamento</option>                            
                            <option>Casa</option>                            
                            <option>Finca</option>                            
                        </select>
                </div>
                
                <div class="row">
                    <div class="col-xs-6 col-sm-6 col-md-6">
			<div class="form-group">
                            <input type="text" name="txt_tamano" required="required" class="form-control input-lg" placeholder="Tamaño" tabindex="7">
			</div>
                    </div>
                    <div class="col-xs-6 col-sm-6 col-md-6">
                        <div class="form-group">
                            <input type="number" name="txt_precio" min="1" max="9999999999" required="required" class="form-control input-lg" placeholder="Precio" tabindex="8">
                        </div>
                    </div>
		</div>                                            
                
		<hr class="colorgraph">
		<div class="row">
                    <div class="col-xs-6 col-md-6"><input type="submit" value="Agregar" name="btn_aceptar" class="btn btn-success btn-block btn-lg" tabindex="9"></div>
                    <div class="col-xs-6 col-md-6"><input type="reset" value="Limpiar" name="btn_cancelar" class="btn btn-danger btn-block btn-lg"/></div>
		</div>   
                
        </form>
      </div>   
    </body>
</html>
