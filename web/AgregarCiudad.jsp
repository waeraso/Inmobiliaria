<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : AgregarCiudad
    Created on : 23/03/2015, 03:34:18 PM
    Author     : KMILO
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.inmobiliaria.mundo.Inmobiliaria"%>
<%@page import="com.inmobiliaria.mundo.Departamento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Inmobiliaria inmobiliaria= (Inmobiliaria) session.getAttribute("inmobiliaria");
    if(inmobiliaria==null) inmobiliaria = Inmobiliaria.darObjeto();
    //lista de departamentos
    ArrayList<Departamento> departamentos = new ArrayList<Departamento>();
    departamentos = inmobiliaria.getDepartamentos();
    //departamentos.add(new Departamento(1,"narino"));
    //departamentos.add(new Departamento(2,"cauca"));
    session.setAttribute("departamentos", departamentos);
%>

<html>
    <head>
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
                        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Ciudad</title>
    </head>
    <body>
        <jsp:include page="Header.html" flush="true" />
        <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
            <form role="form" action="ControladorCiudad"> 
                <h2>Agregar Ciudad <small>Todos los Campos Requeridos</small></h2>
                <hr class="colorgraph">             
                
                <div class="row">
                    <div class="col-xs-6 col-sm-6 col-md-6">
			<div class="form-group">
                            <label for="txt_nombre">Nombre:</label>
                            <input type="text" name="txt_nombre" required="required" maxlength="30" class="form-control input-lg" placeholder="Nombre" tabindex="1">
			</div>
                    </div>
                    <div class="col-xs-6 col-sm-6 col-md-6">
                        <label for="dpd_departamento">Departamento:</label>
                        <select class="form-control" name="dpd_departamento">                                                  
                            <c:forEach var="departamento" items="${sessionScope.departamentos}">
                                    <option>${departamento.nombre} </option>
                            </c:forEach>
                        </select>                                                   
                    </div>
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
