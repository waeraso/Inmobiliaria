<%@page import="com.inmobiliaria.mundo.Ciudad"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : AgregarInmueble
    Created on : 25/04/2015, 03:41:14 PM
    Author     : KMILO
--%>
<%@page import="com.inmobiliaria.mundo.Inmobiliaria"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.inmobiliaria.mundo.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Inmobiliaria inmobiliaria= (Inmobiliaria) session.getAttribute("inmobiliaria");
    if(inmobiliaria==null) inmobiliaria = Inmobiliaria.darObjeto();
    //lista de categorias
    ArrayList<Categoria> categorias = new ArrayList<Categoria>(); 
    categorias = inmobiliaria.getCategorias();            
    
    session.setAttribute("categorias", categorias);
    
    //lista de ciudades:
    ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();
    ciudades = inmobiliaria.getCiudades();
    
    session.setAttribute("ciudades", ciudades);           
    
%>

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
            
            <form role="form" action="ControladorInmueble" method="post" enctype="multipart/form-data">             
                
                <h2>Agregar Inmueble <small>Todos los Campos Requeridos</small></h2>
                <hr class="colorgraph">                                
                
		<!--imagen--> 
                <div class="form-group">
                     <img id="imgInmueble" width="280" class="img-thumbnail" tabindex="1">   
                </div> 
                <div class="form-group">
                    <label for="uploadfile">Cargar Imagen:</label>
                        <input type="file" id="btnImagen" name="uploadfile" onChange="probarformato()" tabindex="2">                            
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
                
                <div class="row">
                    <div class="col-xs-6 col-sm-6 col-md-6">
			<div class="form-group">
                            <div class="form-group">
                                <label for="dpd_tipoInmueble">Tipo:</label>
                                <select class="form-control" name="dpd_tipoInmueble">                                                                              
                                    <option>Venta</option>                            
                                    <option>Arriendo</option>                                                        
                                </select>
                            </div>                            
			</div>
                    </div>
                    <div class="col-xs-6 col-sm-6 col-md-6">
                        <div class="form-group">
                            <label for="dpd_categoria">Categoria:</label>                            
                            <select class="form-control" name="dpd_categoria">                                                  
                                <c:forEach var="categoria" items="${sessionScope.categorias}">
                                        <option>${categoria.descripcion} </option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
		</div>
                
                <div class="row">
                    <div class="col-xs-6 col-sm-6 col-md-6">
			<div class="form-group">
                            <input type="number" name="txt_tamano" min="1" max="9999999" required="required" class="form-control input-lg" placeholder="Tamaño (m2)" tabindex="7">                            
			</div>
                    </div>                    
                    <div class="col-xs-6 col-sm-6 col-md-6">
                        <div class="form-group">
                            <input type="number" name="txt_precio" min="1" max="9999999999" required="required" class="form-control input-lg" placeholder="Precio" tabindex="8">
                        </div>
                    </div>
		</div> 
                
                <div class="form-group">
                    <label for="dpd_ciudad">Ciudad:</label>                            
                            <select class="form-control" name="dpd_ciudad">                                                  
                                <c:forEach var="ciudad" items="${sessionScope.ciudades}">
                                        <option>${ciudad.nombre} </option>
                                </c:forEach>
                            </select>
                    
                </div>                                             
                
		<hr class="colorgraph">
		<div class="row">
                    <div class="col-xs-6 col-md-6"><input type="submit" value="Agregar" name="btn_aceptar" class="btn btn-success btn-block btn-lg" tabindex="9"></div>
                    <div class="col-xs-6 col-md-6"><input type="reset" value="Limpiar" name="btn_cancelar" class="btn btn-danger btn-block btn-lg"/></div>
		</div>   
                
        </form>
                
      </div> 
        
        <script type="text/javascript" >
        function probarformato() {

            var filehide = document.getElementById("btnImagen");

            if (filehide.value.length > 0) {
                var extencion = '';
                var aux;
                var ruta = filehide.value;
                var lim = filehide.value.length - 6;
                for (var i = filehide.value.length - 1; i > lim; i--) {
                    aux = ruta.charAt(i);
                    if (aux == '.') {
                        i = 3;
                    }
                    else {
                        if (i > lim) {
                            extencion = aux + extencion;
                        }
                    }
                }

                if (extencion == 'png' || extencion == 'jpg' || extencion == 'jpeg' || extencion == 'jpg' || extencion == 'gif') {
                    //alert('Formato de Imagen Correcto');                   
                    var fReader = new FileReader();
                    fReader.readAsDataURL(filehide.files[0]);
                    fReader.onloadend = function (event) {
                        var img = document.getElementById('imgInmueble');
                        img.src = event.target.result;
                    }
                }
                else {
                    alert('Formato Invalido, solo se admite .jpg, .jpeg, .png y .gif');
                    filehide.value = null;
                }
            }

        }        
</script>
        
    </body>
</html>
