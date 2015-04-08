/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.controlador;

import com.inmobiliaria.mundo.Cliente;
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
            
            Inmobiliaria inmobiliaria= (Inmobiliaria) session.getAttribute("inmobiliaria");                           
            ArrayList<Cliente> clientes = new ArrayList<Cliente>();                       
            
            if(inmobiliaria==null) inmobiliaria = Inmobiliaria.darObjeto();
            
            session.setAttribute("inmobiliaria", inmobiliaria);
            
            String operacion =  request.getParameter("btn_aceptar");            
            String mensaje = "";
            String url = "";
            
            if (operacion.equals("Agregar"))
            {
            try
            {            
                //variables de campos de texto:
                int id=0;
                int cedula = Integer.parseInt(request.getParameter("txt_cedula"));
                String nombre = request.getParameter("txt_nombre");
                String apellidos = request.getParameter("txt_apellidos");
                String email = request.getParameter("txt_email");
                String telefono = request.getParameter("txt_telefono");
                
                inmobiliaria.adicionarCliente(id, cedula, nombre, apellidos, email, telefono);                
                clientes.add(new Cliente(id, cedula, nombre, apellidos, email, telefono));

                mensaje = inmobiliaria.getMensaje();    
                url = "AgregarCliente.jsp";
                               
                session.setAttribute("mensaje", mensaje);
                session.setAttribute("url", url);

                response.sendRedirect("./Mensajes.jsp");
            }
            catch( Exception e )
            {
               out.println(e.getMessage());
            }
        }
            
        //buscar clientes             
        if (operacion.equals("Buscar"))
        {  
                int cedula=0;
                try{
                    cedula = Integer.parseInt(request.getParameter("txt_cedula"));
                }
                catch(Exception e){
                    cedula =0;
                }
                
                String nombre = request.getParameter("txt_nombre");                                
           
            clientes = inmobiliaria.buscarClientes(cedula, nombre);
            
            if(clientes != null){
                session.setAttribute("clientes", clientes); //declarar variable de sesion
                request.getRequestDispatcher("./MostrarClientes.jsp").forward(request, response);                                  
            }
            else{
                mensaje = "El cliente no Existe";
                url = "AdministrarClientes.jsp";
                session.setAttribute("url", url);
                
                session.setAttribute("mensaje", mensaje);
                response.sendRedirect("./Mensajes.jsp");
            }                                                                                      
        }
        
        //llevar a pagina de modificar un clinte
        int cedula =0;        
        if (operacion.equals("Editar"))
        {            
            cedula = Integer.parseInt(request.getParameter("val"));           
            session.setAttribute("cedula", cedula);
            
            Cliente cliente = inmobiliaria.buscarCliente(cedula);                      
            if(cliente!=null){
                request.setAttribute("cliente", cliente); //declarar variable de sesion
                request.getRequestDispatcher("ModificarCliente.jsp").forward(request, response);                          
            }                                            
        }
        
        //modificar un cliente:
        if(operacion.equals("Modificar")){
            //variables de campos de texto:                              
                cedula = (int) session.getAttribute("cedula");
                
                String nombre = request.getParameter("txt_nombre");
                String apellidos = request.getParameter("txt_apellidos");
                String email = request.getParameter("txt_email");
                String telefono = request.getParameter("txt_telefono");
                
                inmobiliaria.modificarCliente(cedula, nombre, apellidos, email, telefono);
                
                mensaje = "El Cliente fue modificado con éxito";
                url = "AdministrarClientes.jsp";
                
                session.setAttribute("url", url);
                session.setAttribute("mensaje", mensaje);
                
                response.sendRedirect("./Mensajes.jsp");                    
        }
        
        //eliminar cliente:
        if(operacion.equals("Eliminar")){            
            cedula = Integer.parseInt(request.getParameter("val"));
            
            inmobiliaria.eliminarCliente(cedula);    
            mensaje = "El Cliente fue eliminado con éxito";
            
            url = "AdministrarClientes.jsp";
            
            session.setAttribute("mensaje", mensaje);
            session.setAttribute("url", url);
            
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
