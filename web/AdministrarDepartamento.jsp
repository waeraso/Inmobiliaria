<%-- 
    Document   : AdministrarDepartamento
    Created on : 23/03/2015, 09:11:42 PM
    Author     : andre_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrar Departamentos</title>
    </head>
    <body>   
        <jsp:include page="Header.html" flush="true" />
       <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
         <form role="form" align="center" action="ControladorDepartamento">                       
            <h2>Buscar Departamento</h2>
             <hr class="colorgraph"> 
             
                <div class="input-group">
                  <input type="text" name="txt_nombre" required maxlength="30" class="form-control" placeholder="Nombre" id="srch-term">
                  <div class="input-group-btn">
                    <button value="Buscar" name="btn_aceptar" class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
                  </div>
                </div>               
         </form> 
       </div>        
    </body>
</html>
