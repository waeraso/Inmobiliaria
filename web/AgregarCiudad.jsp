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

<jsp:include page="Header.html" flush="true" />

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Ciudad</title>
    </head>
    <body>
        <form action="ControladorCiudad"> 
             <div align="center">
             <h1>Agregar Ciudad</h1>
                <table width="25%" border="0" align="center" cellpadding="7" cellspacing="0">
                    <tr>
                        <td>Nombre:<span style="color: #F00">*</span></td>
                        <td><input type="text" name="txt_nombre" size="20" required="required" maxlength="30"></td>
                    </tr>                                                            
                    <tr>
                        <td>Departamento:<span style="color: #F00">*</span></td>
                        <td><select name="dpd_departamento">
                                <c:forEach var="departamento" items="${sessionScope.departamentos}">
                                    <option>${departamento.nombre} </option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <td colspan="2" style="text-align: center"><input type="submit" value="Agregar" name="btn_aceptar"/>                          <input type="reset" value="Limpiar" /></td>
                    </tr>
                </table>
                <p><span style="color: #F00">*campos requeridos</span>
                </p>
             </div>
        </form>
        <jsp:include page="Fooder.html" flush="true" />
    </body>
</html>
