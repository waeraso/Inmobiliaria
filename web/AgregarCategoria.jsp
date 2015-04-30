<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : AgregarCategoria
    Created on : 25/04/2015, 03:02:07 PM
    Author     : WILMER
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.inmobiliaria.mundo.Inmobiliaria"%>
<%@page import="com.inmobiliaria.mundo.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>       
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Categoria</title>
    </head>    
    
    <body>
        <jsp:include page="Header.html" flush="true" />
        <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
            <form role="form" action="ControladorCategoria">
                <h2>Agregar Categoria <small>Todos los Campos Requeridos</small></h2>
                <hr class="colorgraph">                                                    
                        <div class="form-group">
                            <label for="txt_descripcion">Descripcion:</label>                            
                            <input type="text" name="txt_descripcion" >                        
                        </div>                   
                
                <hr class="colorgraph">
		<div class="row">
                    <div class="col-xs-6 col-md-6"><input type="submit" value="Agregar" name="btn_aceptar" class="btn btn-success btn-block btn-lg" tabindex="7"></div>                    
		</div>
            </form>
        </div>
        
    </body>
</html>
