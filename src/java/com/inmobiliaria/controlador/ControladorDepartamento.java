/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.controlador;

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
@WebServlet(name = "ControladorDepartamento", urlPatterns = {"/ControladorDepartamento"})
public class ControladorDepartamento extends HttpServlet {

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
            ArrayList<Departamento> departamentos = new ArrayList<Departamento>();                       
            
            if(inmobiliaria==null) inmobiliaria = Inmobiliaria.darObjeto();
            
            session.setAttribute("inmobiliaria", inmobiliaria);
            
            String operacion =  request.getParameter("btn_aceptar");            
            String mensaje = "";
            
            //agregar departamento            
            if (operacion.equals("Agregar"))
            {                
            try
            {            
                //variables de campos de texto:  
                int id =0;
                String nombre = request.getParameter("txt_nombre");              
                
                inmobiliaria.adicionarDepartamento(nombre);
                departamentos.add(new Departamento(id,nombre));

                mensaje = "El Departamento fue registrado con éxito";
                session.setAttribute("mensaje", mensaje);
                response.sendRedirect("./Mensajes.jsp");
            }
            catch( Exception e )
            {
               out.println(e.getMessage());
            }
        }
         String nombreDepto = (String) session.getAttribute("nombreDepto");
        //buscar departamento             
        if (operacion.equals("Buscar"))
        {                  
            nombreDepto = request.getParameter("txt_nombre");                                
            Departamento departamento = null;
            departamento = inmobiliaria.buscarDepartamento(nombreDepto);
            
           session.setAttribute("nombreDepto", nombreDepto); //declarar variable de sesion
            session.setAttribute("departamento", departamento); //declarar variable de sesion
           request.getRequestDispatcher("./MostrarDepartamentos.jsp").forward(request, response);                     
                                   
        }
                     
        //modificar un departamento:
        if(operacion.equals("Modificar")){
            //variables de campos de texto:                                
                String nombre = request.getParameter("txt_nombre");
                
                Departamento depto = inmobiliaria.buscarDepartamento(nombreDepto);
                
                int idDep = depto.getIdDepartamento();
                inmobiliaria.modificarDepartamento(idDep, nombre, nombreDepto);
                
                mensaje = "El departamento fue modificado con éxito";
                session.setAttribute("mensaje", mensaje);
                response.sendRedirect("./Mensajes.jsp");                    
        }
        
        //eliminar departamento:
        if(operacion.equals("Eliminar")){
            
            inmobiliaria.eliminarDepartamento(nombreDepto);
            mensaje = "El Departamento fue eliminado con éxito";
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
