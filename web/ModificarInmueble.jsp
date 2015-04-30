<%@page import="com.inmobiliaria.mundo.Ciudad"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : ModificarInmueble
    Created on : 25/04/2015, 04:15:12 PM
    Author     : KMILO
--%>
<%@page import="com.inmobiliaria.mundo.Inmobiliaria"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.inmobiliaria.mundo.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script> 
        
        <title>Modificar Inmueble</title>
    </head>
    <body>
        <jsp:include page="Header.html" flush="true" />
        <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
            <form role="form" action="ControladorInmueble" method="post" enctype="multipart/form-data"> 
                
                
                        
                <h2>Modificar Inmueble <small>Todos los Campos Requeridos</small></h2>
                <jsp:useBean id="inmueble" scope="request" class="com.inmobiliaria.mundo.Inmueble"/>                
                
             <div class="panel panel-default">
             <div class="panel-body">                
                
		<div class="row">
                    <div class="col-md-6"> <img id="imgInmueble" width="280" src="images/inmuebles/${inmueble.imagen}" class="img-thumbnail" tabindex="1"></div>
                    <div class="col-md-8"><label for="uploadfile">Cargar Imagen:</label>
                        <input type="file" id="btnImagen" name="uploadfile" onChange="probarformato()" tabindex="2"></div>                    
                </div>
                 <hr class="colorgraph">                                
                
                <div class="row">
                    <div class="col-md-6"><label for="txt_direccion">Direccion:</label>                            
                            <input type="text" name="txt_direccion" required="required" class="form-control input-lg" placeholder="Direccion" value="<%=inmueble.getDireccion()%>" tabindex="3"></div>
                    <div class="col-md-6"><label for="txt_barrio">Barrio:</label>                            
                            <input type="text" name="txt_barrio"  required="required" class="form-control input-lg" value="<%=inmueble.getBarrio()%>" placeholder="Barrio" tabindex="4"></div>
                </div> 
                
                <div class="row">
                    <div class="col-md-6"><label for="txt_telefono">Telefono:</label>                            
                        <input type="number" name="txt_telefono" min="1" max="9999999999" required="required" class="form-control input-lg" value="<%=inmueble.getTelefono()%>" placeholder="Telefono" tabindex="5"></div>
                    <div class="col-md-6"></div>
                </div>
                
                <div class="row">
                    <div class="col-md-4"><label for="txt_tipo">Tipo:</label>  
                            <input type="text" disabled class="form-control input-lg" id="txt_tipo" name="txt_tipo" value="<%=inmueble.getTipo()%>"> </div>
                    <div class="col-md-6">
                        <label for="dpd_tipoInmueble">Nuevo:</label>
                        <select class="form-control" id="dpd_tipoInmueble" name="dpd_tipoInmueble" onchange="cambiarTipo()">                                                                              
                                    <option>Venta</option>                            
                                    <option>Arriendo</option>                                                        
                                </select>
                    </div>
                </div>
                
                <div class="row">
                    <div class="col-md-4"><label for="txt_categoria">Categoria:</label> 
                            <input type="text" disabled id="txt_categoria" name="txt_categoria" value="<%=inmueble.getCategoria()%>"></div>
                    <div class="col-md-6"> <label for="dpd_categoria">Nueva:</label>
                        <select class="form-control" id="dpd_categoria" name="dpd_categoria" onchange="cambiarCategoria()">                                                  
                            <c:forEach var="categoria" items="${sessionScope.categorias}">
                                <option>${categoria.descripcion} </option>
                            </c:forEach>
                            </select>
                    </div>
                </div>
                
                <div class="row">
                    <div class="col-md-6"><label for="txt_tamano">Tamaño:</label>                            
                            <input type="number" name="txt_tamano"  min="1" max="9999999" required="required" value="<%=inmueble.getTamanio()%>" class="form-control input-lg" placeholder="Tamaño (m2)" tabindex="7"></div>
                    <div class="col-md-6"><label for="txt_precio">Precio:</label>                            
                            <input type="number" name="txt_precio" min="1" max="9999999999" required="required" value="<%=inmueble.getPrecio()%>" class="form-control input-lg" placeholder="Precio" tabindex="8"></div>
                </div>
                
                <div class="row">
                    <div class="col-md-4"><label for="txt_ciudad">Ciudad:</label> 
                            <input type="text" disabled id="txt_ciudad" name="txt_ciudad" value="<%=inmueble.getCiudad()%>"></div>
                    <div class="col-md-6"> <label for="dpd_ciudad">Nueva:</label>
                        <select class="form-control" id="dpd_ciudad" name="dpd_ciudad" onchange="cambiarCiudad()">                                                  
                                <c:forEach var="ciudad" items="${sessionScope.ciudades}"> 
                                    <option>${ciudad.nombre} </option>                                                                                                                                                                                                                                                                                                   
                                </c:forEach>
                            </select>
                    </div>
                </div>
                                                       
                <input type ="hidden" name="txt_dir_original" value="<%=inmueble.getDireccion()%>"> <!--campo para guardar direccion original -->
                <input type ="hidden" id="imagenCambiada" name="imagenCambiada"> <!--campo para verificar si cambia imagen -->
                
		<hr class="colorgraph">
		<div class="row">
                    <div class="col-xs-6 col-md-6"><input type="submit" value="Modificar" name="btn_aceptar" class="btn btn-success btn-block btn-lg" tabindex="7"></div>
                    <div class="col-xs-6 col-md-6"><input type="submit" value="Cancelar" name="btn_cancelar" onclick="javascript:window.history.back();" class="btn btn-danger btn-block btn-lg"/></div>
		</div>    
               </div> 
                </div>
        </form>
      </div> 
                    
        
        <script type="text/javascript" >
        function probarformato() {

            var filehide = document.getElementById("btnImagen");
            var imgHide = document.getElementById("imagenCambiada");

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
                        imgHide.value = 1;
                        
                    }
                }
                else {
                    alert('Formato Invalido, solo se admite .jpg, .jpeg, .png y .gif');
                    filehide.value = null;
                    imgHide.value = "0";
                }
            }

        } 
        //------------
        //tipo:
        function cambiarTipo() {            
            var text_tipo = document.getElementById("txt_tipo");
            text_tipo.value = document.getElementById("dpd_tipoInmueble").value;                                               
        }
        function cambiarCategoria() {            
            var text_cat = document.getElementById("txt_categoria");
            text_cat.value = document.getElementById("dpd_categoria").value;                                               
        }
        function cambiarCiudad() {            
            var text_ciudad = document.getElementById("txt_ciudad");
            text_ciudad.value = document.getElementById("dpd_ciudad").value;                                               
        }
        
</script>

    </body>
</html>

