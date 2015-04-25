<%-- 
    Document   : MostrarDepartamentos
    Created on : 26/03/2015, 12:05:01 AM
    Author     : KMILO
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.inmobiliaria.mundo.Departamento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        
        <title>Mostrar Departamento</title>
    </head>
    <body>        
        <jsp:include page="Header.html" flush="true" />
        
    <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
        <form role="form" action="ControladorDepartamento">             
                <h2>Datos Departamento <small>Modificar o Eliminar</small></h2>
                                <jsp:useBean id="departamento" scope="session" class="com.inmobiliaria.mundo.Departamento"/>        
                <hr class="colorgraph">                                
                
		<div class="form-group">
                    <input type="text" name="txt_nombre" required="required" class="form-control input-lg"  value="<%=departamento.getNombre()%>" maxlength="30" tabindex="3"/>
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
