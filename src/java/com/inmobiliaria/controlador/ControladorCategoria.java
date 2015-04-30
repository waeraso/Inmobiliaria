/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.controlador;

import com.inmobiliaria.mundo.Categoria;
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
@WebServlet(name = "ControladorCategoria", urlPatterns = {"/ControladorCategoria"})
public class ControladorCategoria extends HttpServlet {

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
            ArrayList<Categoria> categorias = new ArrayList<Categoria>();                       
            
            if(inmobiliaria==null) inmobiliaria = Inmobiliaria.darObjeto();
            
            session.setAttribute("inmobiliaria", inmobiliaria);
            
            String operacion =  request.getParameter("btn_aceptar");            
            String mensaje = "";
            String url = "";
            
            //agregar Categoria            
            if (operacion.equals("Agregar"))
            {                
            try
            {            
                //variables de campos de texto:                  
                String descrip = request.getParameter("txt_descripcion");              
                
                inmobiliaria.adicionarCategoria(descrip);
                categorias.add(new Categoria(0,descrip));

                mensaje = inmobiliaria.getMensaje();
                url = "AgregarCategoria.jsp";
                
                session.setAttribute("url", url);
                session.setAttribute("mensaje", mensaje);
                response.sendRedirect("./Mensajes.jsp");
            }
            catch( Exception e )
            {
               out.println(e.getMessage());
            }
        }
        
        String descripGlobal = (String) session.getAttribute("descripGlobal");
        //buscar categoria             
        if (operacion.equals("Buscar"))
        {                  
            descripGlobal = request.getParameter("txt_descripcion");                                
            Categoria categoria = null;
            categoria = inmobiliaria.buscarCategoria(descripGlobal);
            
            if(categoria!=null){
                session.setAttribute("descripGlobal", descripGlobal); //declarar variable de sesion
                session.setAttribute("categoria", categoria); //declarar variable de sesion
                request.getRequestDispatcher("./MostrarCategorias.jsp").forward(request, response);                                     
            }
            else{
                mensaje = "La Categoria no Existe";
                url = "AdministrarCategoria.jsp";
                session.setAttribute("url", url);
                
                session.setAttribute("mensaje", mensaje);
                response.sendRedirect("./Mensajes.jsp"); 
            }                                                         
        }
        
        //modificar una categoria:
        if(operacion.equals("Modificar")){
            //variables de campos de texto:                                
                String descrip = request.getParameter("dpd_descripcion");
                
                Categoria categoria = inmobiliaria.buscarCategoria(descripGlobal);                
                
                inmobiliaria.modificarCategoria(descripGlobal, descrip);
                
                mensaje = inmobiliaria.getMensaje();
                url = "AdministrarCategoria.jsp";
                
                session.setAttribute("url", url);                
                session.setAttribute("mensaje", mensaje);
                response.sendRedirect("./Mensajes.jsp");                    
        }
        
        if(operacion.equals("Eliminar")){
            
            inmobiliaria.eliminarCategoria(descripGlobal);
           
            mensaje = inmobiliaria.getMensaje();
            url = "AdministrarCategoria.jsp";
                
            session.setAttribute("url", url);                 
            session.setAttribute("mensaje", mensaje);
            
            response.sendRedirect("./Mensajes.jsp");
        }
        
        //operacion volver de pagina mostrarDeptos
        if(operacion.equals("Volver")){
            response.sendRedirect("./AdministrarCategoria.jsp");                            
        }
            
            
            
        
        //---------------------            
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
