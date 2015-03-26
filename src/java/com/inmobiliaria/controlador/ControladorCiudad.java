/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.controlador;

import com.inmobiliaria.mundo.Ciudad;
import com.inmobiliaria.mundo.Departamento;
import com.inmobiliaria.mundo.Inmobiliaria;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author KMILO
 */
@WebServlet(name = "ControladorCiudad", urlPatterns = {"/ControladorCiudad"})
public class ControladorCiudad extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession(true);            
            
            Inmobiliaria inmobiliaria= (Inmobiliaria) session.getAttribute("inmobiliaria");                           
            ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();                       
            
            if(inmobiliaria==null) inmobiliaria = Inmobiliaria.darObjeto();
            
            session.setAttribute("inmobiliaria", inmobiliaria);                                  
            
            String operacion =  request.getParameter("btn_aceptar");            
            String mensaje = "";
            
            //agregar ciudad            
            if (operacion.equals("Agregar"))
            {                
            try
            {            
                //variables de campos de texto:  
                int id =0;
                String nombre = request.getParameter("txt_nombre");              
                String depto = request.getParameter("dpd_departamento");              
                
                inmobiliaria.adicionarCiudad(nombre, depto);
                ciudades.add(new Ciudad(id,nombre,depto));

                mensaje = "La Ciudad fue registrado con éxito";
                session.setAttribute("mensaje", mensaje);
                response.sendRedirect("./Mensajes.jsp");
            }
            catch( Exception e )
            {
               out.println(e.getMessage());
            }
        }
            
         String nombreCiudad = (String) session.getAttribute("nombreCiudad");
        //buscar ciudad             
        if (operacion.equals("Buscar"))
        {                  
            nombreCiudad = request.getParameter("txt_nombre");                                
            Ciudad ciudad = null;
            ciudad = inmobiliaria.buscarCiudad(nombreCiudad);            
           
            session.setAttribute("ciudad", ciudad); //declarar variable de sesion
            session.setAttribute("nombreCiudad", nombreCiudad); //declarar variable de sesion
           request.getRequestDispatcher("./MostrarCiudades.jsp").forward(request, response);                     
                                   
        }
                    
        //modificar una ciudad:
        if(operacion.equals("Modificar")){
            //variables de campos de texto:                                
                String nombre = request.getParameter("txt_nombre");
                String depto = request.getParameter("txt_departamento");
                
                Ciudad ciudad = inmobiliaria.buscarCiudad(nombreCiudad);
                
                int idCiudad = ciudad.getIdCiudad();
                inmobiliaria.modificarCiudad(nombre, depto, nombreCiudad);
                
                mensaje = "La Ciudad fue modificada con éxito";
                session.setAttribute("mensaje", mensaje);
                response.sendRedirect("./Mensajes.jsp");                    
        }
        
        //eliminar ciudad:
        if(operacion.equals("Eliminar")){
            
            inmobiliaria.eliminarCiudad(nombreCiudad);
            mensaje = "La Ciudad fue eliminada con éxito";
            session.setAttribute("mensaje", mensaje);
            response.sendRedirect("./Mensajes.jsp");
        }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
