/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.controlador;

import com.inmobiliaria.mundo.Cliente;
import com.inmobiliaria.mundo.Inmobiliaria;
import com.inmobiliaria.mundo.Inmueble;
import com.inmobiliaria.mundo.Transaccion;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.servlet.RequestDispatcher;
import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadException;
import javazoom.upload.UploadFile;


/**
 *
 * @author KMILO
 */
@WebServlet(name = "ControladorInmueble", urlPatterns = {"/ControladorInmueble"})
public class ControladorInmueble extends HttpServlet {

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
            
            
            if(inmobiliaria==null) inmobiliaria = Inmobiliaria.darObjeto();
            
            session.setAttribute("inmobiliaria", inmobiliaria);
            
            String operacion =  request.getParameter("btn_aceptar");            
            String mensaje = "";
            String url = "";                       
            
        //buscar clientes             
        if (operacion.equals("Buscar"))
        {  
                String barrio = request.getParameter("txt_barrio");      
                String dir = request.getParameter("txt_direccion");                    
                String tipo = request.getParameter("txt_tipo"); 
                
                try {
                    ArrayList<Inmueble> inmuebles= inmobiliaria.buscarInmueblesXParam(barrio, dir, tipo);                    
                    if(inmuebles!=null){                        
                        session.setAttribute("inmuebles", inmuebles); //declarar variable de sesion
                        request.getRequestDispatcher("./MostrarInmuebles.jsp").forward(request, response);
                    }
                    else out.write("no existen datos");
                        
                } catch (Exception e) {
                }                                                                                      
        }
        
        String direccion=null;
        if (operacion.equals("Editar"))
        {            
            direccion = request.getParameter("val");           
            
            session.setAttribute("direccion", direccion);
            
            Inmueble inmueble = inmobiliaria.buscarInmueble(direccion);
            if(inmueble!=null){
                request.setAttribute("inmueble", inmueble); //declarar variable de sesion
                request.getRequestDispatcher("ModificarInmueble.jsp").forward(request, response);               
                
            }                                            
        }
        
        //eliminar inmueble:
        if(operacion.equals("Eliminar")){            
            direccion = request.getParameter("val");
            String imagen;
            Inmueble miInm = inmobiliaria.buscarInmueble(direccion);
            imagen = miInm.getImagen();  
            
            inmobiliaria.eliminarInmueble(direccion);
            
            //eliminar imagen del inmueble:
            String ruta="D:/DOCUMENTOS/UMARIANA/proyNetbeans/Inmobiliaria/web/images/inmuebles/"+imagen;
            inmobiliaria.eliminarArchivo(ruta);
            
            mensaje = "El Inmueble fue eliminado con éxito";
            
            url = "AdministrarInmuebles.jsp";
            
            session.setAttribute("mensaje", mensaje);
            session.setAttribute("url", url);
            
            response.sendRedirect("./Mensajes.jsp");
        }
        
        //buscar clientes             
        if (operacion.equals("BuscarNegocio"))
        {  
                String barrio = request.getParameter("txt_barrio");      
                String dir = request.getParameter("txt_direccion");                    
                String tipo = request.getParameter("txt_tipo"); 
                
                try {
                    ArrayList<Inmueble> todosInmuebles= inmobiliaria.buscarInmueblesXParam(barrio, dir, tipo);                                                                                
                    ArrayList<Inmueble> inmuebles= new ArrayList<Inmueble>();
                    
                    if(todosInmuebles!=null){                        
                        ArrayList<Transaccion> transacciones = inmobiliaria.getTransacciones();                                                                       
                        if(transacciones!=null){
                            for(int i=0;i<todosInmuebles.size();i++){
                                
                                boolean b=false;
                                for(int y=0; y<transacciones.size() && !b; y++){                                
                                    if(todosInmuebles.get(i).getIdInmueble() == transacciones.get(y).getIdInmueble()){                                        
                                        b=true;
                                    }                                                                  
                                }
                                if(b==false){
                                    Inmueble pInmueble = todosInmuebles.get(i);
                                    inmuebles.add(pInmueble);                                                                                                           
                                }
                                
                            }
                        }
                        
                        session.setAttribute("inmuebles", inmuebles); //declarar variable de sesion
                        request.getRequestDispatcher("./MostrarInmueblesNegocio.jsp").forward(request, response);
                    }
                    else out.write("no existen datos");
                        
                } catch (Exception e) {
                }                                                                                      
        }
        
        //lista de inmuebles disponibles que lleva al registrarNegocio:
        if(operacion.equals("Vender/Arrendar")){ 
            direccion = request.getParameter("val");            
            session.setAttribute("direccion", direccion);
            
            Inmueble inmueble = inmobiliaria.buscarInmueble(direccion);            
            request.setAttribute("inmueble", inmueble); //declarar variable de sesion
            request.getRequestDispatcher("RegistrarNegocio.jsp").forward(request, response);               
            
                       
        }
        
        //registrarNegocio:
        if(operacion.equals("Aceptar")){                         
            direccion = (String) session.getAttribute("direccion");            
            String cedulaCliente = request.getParameter("dpd_cliente");
            String tipoNegocio = request.getParameter("opciones");
            
            //obtener la cedula de la cadena del cliente:
            int pos=0;
            boolean ban=false;
            for(int i=0; i<cedulaCliente.length() &&!ban; i++){                                
                String car = String.valueOf(cedulaCliente.charAt(i));
                
                if(car.equals(".")){
                   pos=i+2;                    
                   ban=true;
                }
                
            }            
            cedulaCliente = cedulaCliente.substring(pos,cedulaCliente.length());
            int cedula = Integer.parseInt(cedulaCliente);
            //-----------------------------------------------------                       
            
            Inmueble inmueble = inmobiliaria.buscarInmueble(direccion);
            Cliente cliente = inmobiliaria.buscarCliente(cedula);
            
            inmobiliaria.registrarTransaccion(cliente.getIdCliente(), inmueble.getIdInmueble(), tipoNegocio);
            
            if(tipoNegocio=="Venta") mensaje = "El Inmueble fue vendido correctamente";
            if(tipoNegocio=="Arriendo") mensaje = "El Inmueble fue Arrendado correctamente";
            
            
            
            url = "BuscarInmuebleNegocio.jsp";
            
            session.setAttribute("mensaje", mensaje);
            session.setAttribute("url", url);
            
            response.sendRedirect("./Mensajes.jsp");                       
        }
        
        //lista de inmuebles disponibles por ciudad:
        if(operacion.equals("BuscarDisponibles")){
            
            String nombreCiudad = request.getParameter("txt_ciudad");                     
                
                try {
                    ArrayList<Inmueble> todosInmuebles= inmobiliaria.buscarInmueblesXCiudad(nombreCiudad);
                    ArrayList<Inmueble> inmuebles= new ArrayList<Inmueble>();
                    if(inmuebles!=null){ 
                        ArrayList<Transaccion> transacciones = inmobiliaria.getTransacciones();
                        for(int i=0;i<todosInmuebles.size();i++){
                                
                                boolean b=false;
                                for(int y=0; y<transacciones.size() && !b; y++){                                
                                    if(todosInmuebles.get(i).getIdInmueble() == transacciones.get(y).getIdInmueble()){                                        
                                        b=true;
                                    }                                                                  
                                }
                                if(b==false){
                                    Inmueble pInmueble = todosInmuebles.get(i);
                                    inmuebles.add(pInmueble);                                                                                                           
                                }
                                
                            }
                        
                        session.setAttribute("inmuebles", inmuebles); //declarar variable de sesion
                        request.getRequestDispatcher("InmueblesDisponibles.jsp").forward(request, response);               
                    }
                    else out.write("no existen datos");
                        
                } catch (Exception e) {
                }     
                
            
            
            
        }
        
        
        
                                   
           }//try                                    
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
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            
            HttpSession session = request.getSession(true);   
            Inmobiliaria inmobiliaria= (Inmobiliaria) session.getAttribute("inmobiliaria");                           
            if(inmobiliaria==null) inmobiliaria = Inmobiliaria.darObjeto();            
            session.setAttribute("inmobiliaria", inmobiliaria);
        
            MultipartFormDataRequest mrequest = null;            
            RequestDispatcher dispatcher = null;            
            UploadBean upBean = null;//UploadBean es una libreria que se usa para poder llevar objetos al servidor en este caso  la imagen                        
            
            String operacion = null;  
            String mensaje = null;
            String url = null;
            
            try{          
                           
                 mrequest=   new MultipartFormDataRequest(request); //le indicamos que recoga todo lo que nos esta mandando el .jsp                   
                 operacion = mrequest.getParameter("btn_aceptar");
                 
                 if ((operacion != null) && (operacion.equalsIgnoreCase("Agregar"))) {                     
                     
                     //recuperar campos de texto:
                     String dir = mrequest.getParameter("txt_direccion");                    
                     String barrio = mrequest.getParameter("txt_barrio"); 
                     String tel = mrequest.getParameter("txt_telefono"); 
                     String tipo = mrequest.getParameter("dpd_tipoInmueble"); 
                     String categoria = mrequest.getParameter("dpd_categoria"); 
                     String tamanio = mrequest.getParameter("txt_tamano"); 
                     int precio = Integer.parseInt(mrequest.getParameter("txt_precio")); 
                     String ciudad = mrequest.getParameter("dpd_ciudad"); 
                     
                     String imagen = dir.replaceAll(" ","")+".jpg";                     
                     //--------------------                                                               
                     
                     //enviar datos:
                     try {
                         
                         inmobiliaria.adicionarInmueble(barrio, dir, tel, tipo, tamanio, precio, imagen, categoria, ciudad);                         
                         mensaje = inmobiliaria.getMensaje();  
                         
                        if(mensaje.equals("El inmueble se adicionó con Exito")){
                            //recuperar archivo (imagen):                            
                            Hashtable files = mrequest.getFiles();
                            if ((files != null) && (!files.isEmpty())) {                    
                                UploadFile file = (UploadFile) files.get("uploadfile");
                                
                                file.setFileName(imagen);
                                upBean = new UploadBean();  

                                upBean.setFolderstore("D:\\DOCUMENTOS\\UMARIANA\\proyNetbeans\\Inmobiliaria\\web\\images\\inmuebles\\");                                                
                                upBean.store(mrequest, "uploadfile"); //Con el Store le decimos al MultipartFormRequest que obtenta tambien la imagen                                 

                            } else {
                                   System.out.println("<li>No uploaded files");
                            }
                            //-----------------------------------------------------                         
                         }
                         
                     } catch (Exception e) {
                         out.println(e.getMessage());
                     }
                     
                     
                     url = "AgregarInmueble.jsp";
                               
                session.setAttribute("mensaje", mensaje);
                session.setAttribute("url", url);

                response.sendRedirect("./Mensajes.jsp");                                                                                                     
                     
            }//if de (operacion)   
                 
            //modificar un inmueble:
            if ((operacion != null) && (operacion.equalsIgnoreCase("Modificar"))) {
                String dirOriginal = mrequest.getParameter("txt_dir_original"); //direccion original del inmueble                
                
                String dir = mrequest.getParameter("txt_direccion");                    
                String barrio = mrequest.getParameter("txt_barrio"); 
                String tel = mrequest.getParameter("txt_telefono"); 
                String tipo = mrequest.getParameter("dpd_tipoInmueble");                                
                String categoria = mrequest.getParameter("dpd_categoria"); 
                String tamanio = mrequest.getParameter("txt_tamano"); 
                int precio = Integer.parseInt(mrequest.getParameter("txt_precio")); 
                String ciudad = mrequest.getParameter("dpd_ciudad"); 
                String imagenOriginal = dirOriginal.replaceAll(" ","")+".jpg";
                String imagenNueva = dir.replaceAll(" ","")+".jpg";
                
                try {
                    //eliminar archivo anterior:
                    String imagenCambiada = mrequest.getParameter("imagenCambiada");                                
                    if(imagenCambiada.equals("1")){
                        String ruta="D:/DOCUMENTOS/UMARIANA/proyNetbeans/Inmobiliaria/web/images/inmuebles/"+imagenOriginal;
                        inmobiliaria.eliminarArchivo(ruta);
                    } 
                    else imagenNueva = imagenOriginal;
                                
                     inmobiliaria.modificarInmueble(barrio, dir, tel, tipo, categoria, tamanio, precio, ciudad, imagenNueva, dirOriginal);                                       
                                                                               
                    //recuperar archivo (imagen):                            
                            Hashtable files = mrequest.getFiles();
                            if ((files != null) && (!files.isEmpty())) {                                                     
                                UploadFile file = (UploadFile) files.get("uploadfile");                                                                                                                                                                                                                                                                                                                                                                                                         
                                file.setFileName(imagenNueva);
                                upBean = new UploadBean();                                                                                                                                                                                                                                            
                                upBean.setFolderstore("D:\\DOCUMENTOS\\UMARIANA\\proyNetbeans\\Inmobiliaria\\web\\images\\inmuebles\\");                                                
                                upBean.store(mrequest, "uploadfile"); //Con el Store le decimos al MultipartFormRequest que obtenga tambien la imagen                                 

                            } else {
                                   out.write("es null");
                            }             
                    
                } catch (Exception e) {
                }
                
                mensaje = inmobiliaria.getMensaje();
                url = "AdministrarInmuebles.jsp";
                
                session.setAttribute("url", url);
                session.setAttribute("mensaje", mensaje);
                
                response.sendRedirect("./Mensajes.jsp");     
                                                                       
                
            }//if(modificar)
                 
            }catch( UploadException exc){
                System.out.println("Error en lo primero: "+exc.getMessage());
            }           
            
    }
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

//establecer la imagen como variable de sesion
                             /*if (file != null) {
                                 imagen = file.getFileName();

                                 request.setAttribute("imagen", "D:\\DOCUMENTOS\\UMARIANA\\proyNetbeans\\Inmobiliaria\\web\\images\\inmuebles\\"+imagen);                                                       

                                 request.setAttribute("nombre", imagen);
                                 request.setAttribute("tipo",file.getContentType() );
                                 request.setAttribute("tamanio", file.getFileSize());                            
                             } */    
