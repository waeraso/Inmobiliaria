<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : InmueblesDisponibles
    Created on : 29/04/2015, 08:39:38 PM
    Author     : KMILO
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.inmobiliaria.mundo.Inmueble"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        
        <script src="//code.jquery.com/jquery.js"></script>
		<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
		<script src="//cdnjs.cloudflare.com/ajax/libs/ekko-lightbox/3.3.0/ekko-lightbox.min.js"></script>
                <script type="text/javascript">
			$(document).ready(function ($) {

				// delegate calls to data-toggle="lightbox"
				$(document).delegate('*[data-toggle="lightbox"]:not([data-gallery="navigateTo"])', 'click', function(event) {
					event.preventDefault();
					return $(this).ekkoLightbox({
						onShown: function() {
							if (window.console) {
								return console.log('Checking our the events huh?');
							}
						},
						onNavigate: function(direction, itemIndex) {
							if (window.console) {
								return console.log('Navigating '+direction+'. Current item: '+itemIndex);
							}
						}
					});
				});						

			});
		</script>
        
    </head>
    <body>
        <jsp:include page="Header.html" flush="true" />
        
        <div class="col-sm-12 col-sm-8 col-md-8 col-sm-offset-2 col-md-offset-2">
        <form id="formu" action="ControladorInmueble">            
            
        <div align="center">
        <h2>Lista de Inmuebles Disponibles por Ciudad</h2>   
        <div class="input-group">
                  <input type="text" name="txt_ciudad" class="form-control" placeholder="Ciudad" id="srch-term">
                  <div class="input-group-btn">
                    <button value="BuscarDisponibles" name="btn_aceptar" class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
                  </div>
                </div> 
        
        <table class="table table-bordered table-hover" id="tabla">
            <tr class="success">
                <td>Imagen</td>
                <td>IdInmueble</td>
                <td>Direccion</td>
                <td>Barrio</td>
                <td>Telefono</td>
                <td>Tipo</td>
                <td>Tamaño</td>
                <td>Precio</td>                                
                <td>Ciudad</td> 
            </tr>            
        <c:forEach var="inmueble" items="${sessionScope.inmuebles}">
            <tr class="active">
                <td> <a href="images/inmuebles/${inmueble.imagen}" data-toggle="lightbox" data-title="${inmueble.direccion}, ${inmueble.barrio}" data-footer="Inmobiliaria su Kza">
                        <img width="120" height="80" src="images/inmuebles/${inmueble.imagen}" class="img-responsive">
                     </a>
                </td>                        
                
                <td>${inmueble.idInmueble}</td>
                <td>${inmueble.direccion}</td>
                <td>${inmueble.barrio}</td>
                <td>${inmueble.telefono}</td>
                <td>${inmueble.tipo}</td>                
                <td>${inmueble.tamanio}</td>                
                <td>${inmueble.precio}</td>                                               
                <td>${inmueble.ciudad}</td>                                               
            </tr>            
        </c:forEach> 
        </table>              
       </div>
        </form> 
        </div>               
        
    </body>
</html>

                
		
