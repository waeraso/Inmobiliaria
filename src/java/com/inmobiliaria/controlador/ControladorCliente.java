/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.controlador;

import com.inmobiliaria.mundo.Inmobiliaria;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ControladorCliente", urlPatterns = {"/ControladorCliente"})
public class ControladorCliente extends HttpServlet {

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
            Inmobiliaria inmobiliaria = (Inmobiliaria) session.getAttribute("inmobiliaria");                           
            session.setAttribute("inmobiliaria", inmobiliaria);
            
            String operacionAgregar =  request.getParameter("btn_aceptar");
            if (operacionAgregar.equals("Aceptar"))
            {
            try
            {
                int id=0;
                int cedula = Integer.parseInt(request.getParameter("txt_cedula"));
                String nombre = request.getParameter("txt_nombre");
                String apellidos = request.getParameter("txt_apellidos");
                String email = request.getParameter("txt_email");
                String telefono = request.getParameter("txt_telefono");                
                
                inmobiliaria.adicionarCliente(id, cedula, nombre, apellidos, email, telefono);                

                //mensaje = "El vehículo con placa: " + imagen + " fue registrada con éxito";

                //session.setAttribute("mensaje", mensaje);

                //response.sendRedirect("./respuesta.jsp");
            }
            catch( Exception e )
            {
               out.println(e.getMessage());
            }
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
