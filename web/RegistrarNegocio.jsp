<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : RegistrarNegocio
    Created on : 29/04/2015, 06:27:25 PM
    Author     : KMILO
--%>
<%@page import="com.inmobiliaria.mundo.Cliente"%>
<%@page import="com.inmobiliaria.mundo.Inmobiliaria"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Inmobiliaria inmobiliaria= (Inmobiliaria) session.getAttribute("inmobiliaria");
    if(inmobiliaria==null) inmobiliaria = Inmobiliaria.darObjeto();
    
    ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    clientes = inmobiliaria.getClientes();
    
    session.setAttribute("clientes", clientes);
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>         
        
    </head>
    <body>
        <jsp:include page="Header.html" flush="true" />
        
        <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
            <form role="form" action="ControladorInmueble">                                                        
                <h2>Negociar Inmueble <small>Arrendar o Vender</small></h2>
                <jsp:useBean id="inmueble" scope="request" class="com.inmobiliaria.mundo.Inmueble"/>                
                
             <div class="panel panel-default">
             <div class="panel-body">                                		
                 
                 <h2>Inmueble:</h2>
                 <img id="imgInmueble" width="150" src="images/inmuebles/${inmueble.imagen}" class="img-thumbnail" tabindex="1">
                <div class="row">
                    <div class="col-md-6"><label for="txt_direccion">Direccion:</label>                            
                            <input type="text" name="txt_direccion" disabled class="form-control input-lg" placeholder="Direccion" value="<%=inmueble.getDireccion()%>" tabindex="3"></div>
                    <div class="col-md-6"><label for="txt_barrio">Barrio:</label>                            
                            <input type="text" name="txt_barrio"  disabled class="form-control input-lg" value="<%=inmueble.getBarrio()%>" placeholder="Barrio" tabindex="4"></div>
                </div> 
                <hr class="colorgraph">                                                             
                    
                <div class="row">                    
                    <div class="col-md-6"><h2>Cliente:</h2>
                        <select class="form-control" id="dpd_cliente" name="dpd_cliente">                                                  
                            <c:forEach var="cliente" items="${sessionScope.clientes}">
                                <option>${cliente.nombre}, cc. ${cliente.cedula} </option>
                            </c:forEach>
                            </select>
                    </div> 
                </div>                
                
                <hr class="colorgraph">                                                             
                    
                    <div class="row">
                        <div class="col-md-6"><h2>Tipo de Negocio:</h2>
                        <div class="radio">
                            <label>
                              <input type="radio" name="opciones" id="opciones_1" value="Venta" checked>
                              Venta
                            </label>
                          </div>
                          <div class="radio">
                            <label>
                              <input type="radio" name="opciones" id="opciones_2" value="Arriendo">
                              Arriendo
                            </label>
                          </div>
                    </div>
                    <div class="col-md-6"></div>
                </div>                                                                                                                       
		<hr class="colorgraph">
                
		<div class="row">
                    <div class="col-xs-6 col-md-6"><input type="submit" value="Aceptar" name="btn_aceptar" class="btn btn-success btn-block btn-lg" tabindex="7"></div>
                    <div class="col-xs-6 col-md-6"><input type="submit" value="Cancelar" name="btn_cancelar" onclick="javascript:window.history.back();" class="btn btn-danger btn-block btn-lg"/></div>
		</div>    
                
               </div> 
                </div>
        </form>
      </div>                       
    </body>
</html>
