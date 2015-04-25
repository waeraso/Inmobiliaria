/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.mundo;

import com.inmobiliaria.datos.CiudadDAO;
import com.inmobiliaria.datos.ClienteDAO;
import com.inmobiliaria.datos.DepartamentoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KMILO clase principal de mundo que contiene los metodos para
 * gestionar departamento, ciudad, cliente, inmueble, transaccion
 */
public class Inmobiliaria {

    /**
     * Lista de los clientes que pertenecen a la inmobiliaria
     */
    private ArrayList<Cliente> clientes;
    /**
     * Lista de ciudades que pertenecen a la inmobiliaria
     */
    private ArrayList<Ciudad> ciudades;
    /**
     * Lista de los departamentos que pertenecen a la inmobiliaria
     */
    private ArrayList<Departamento> departamentos;
    
    /**
     * Lista de los departamentos que pertenecen a la inmobiliaria
     */
    private ArrayList<Categoria> categorias;
    
    /**
     * Lista de los inmuebles que pertenecen a la inmobiliaria
     */
    private ArrayList<Inmueble> inmuebles;

    //objeto de ClienteDAO 
    private ClienteDAO clienteDAO;

    //Objeto de CiudadDAO
    private CiudadDAO ciudadDAO;

    //objeto de DepartamentoDAO 
    private DepartamentoDAO departamentoDAO;
    
    //mensajes que se generan en el manejo de la clase cliente
    String mensaje;

    //constructor de clase inmobiliaria para inicializar las listas de clientes, ciudades, departamentos
    public Inmobiliaria() {
        try {
            clienteDAO = new ClienteDAO();
            departamentoDAO = new DepartamentoDAO();
            ciudadDAO = new CiudadDAO();
            clientes = clienteDAO.listado();
            ciudades = ciudadDAO.listado();
            departamentos = departamentoDAO.listado();

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Inmobiliaria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //objeto de la clase (singleton)
    private static Inmobiliaria objeto = null;

    //dar objeto de la clase

    public static Inmobiliaria darObjeto() {
        if (objeto == null) {
            objeto = new Inmobiliaria();
        }

        return objeto;
    }

    //dar mensajes de la clase cliente
    public String getMensaje() {
        return mensaje;
    }
    
    //establecer mensaje de la clase cliente
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }  
    

    //obtener lista de clientes
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    //cambiar lista de clientes recibiendo los nuevos datos como parametro
    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    //obtener lista de ciudades
    public ArrayList<Ciudad> getCiudades() {
        return ciudades;
    }

    //cambiar lista de ciudades recibiendo los nuevos datos como parametro
    public void setCiudades(ArrayList<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }

    //obtener lista de departamentos
    public ArrayList<Departamento> getDepartamentos() {
        return departamentos;
    }

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }      

    //cambiar lista de departamentos recibiendo los nuevos datos como parametro
    public void setDepartamentos(ArrayList<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    //metodo para adicionar un departamento recibiendo como parametro el id y el nombre
    public void adicionarDepartamento(String pNom) throws Exception {
        if (buscarDepartamento(pNom) == null) {
            int id = 0;
            Departamento dept = new Departamento(id, pNom);
            departamentoDAO.agregarDepartamento(dept);
            departamentos.add(dept);
            setMensaje("El Departamento se adicionó con Exito");            
        }
        else setMensaje("¡Error! El Departamento ya existe");            
    }

    //metodo de modificar un departamento recibiendo como parametro nombre
    public void modificarDepartamento(int pId, String pNom, String pNomAnterior) {
        try{
        Departamento dept = buscarDepartamento(pNomAnterior);
        if (dept != null) {
            Departamento pDept = buscarDepartamento(pNom);
            if (pDept == null) {
                dept.setNombre(pNom);
               departamentoDAO.modificarDepartamento(pId, pNom);
               setMensaje("El Departamento se modficó con Exito");            
            } else {
                setMensaje("¡Error! El Departamento ya existe");                            
            }
        } else {
            setMensaje("El Departamento se no existe");                        
        }
        }
        catch(Exception e){
            setMensaje(e.getMessage());                        
        }
    }

    //metodo buscar un departamento recibiendo el idDep como parametro
    public Departamento buscarDepartamento(String pNombre) {

        Departamento dept = null;
        boolean encontrado = false;
        for (int i = 0; i < departamentos.size() && !encontrado; i++) {
            if (departamentos.get(i).getNombre().equals(pNombre)) {
                dept = departamentos.get(i);
                encontrado = true;
            }
        }
        return dept;
    }

    //metodo eliminar un departamento recibiendo el idDep como parametro
    public void eliminarDepartamento(String pNom){        
        try{
            Departamento dept = buscarDepartamento(pNom);
            if (dept != null) {
                Ciudad pCiudad = buscarCiudadxDepto(pNom);
                if(pCiudad!=null){
                    setMensaje("¡Error! El departamento no se puede eliminar porque tiene una ciudad registrada");                     
                }
                else{             
                    departamentoDAO.eliminarDepartamento(dept);
                    departamentos.remove(dept);
                    setMensaje("El Departamento se eliminó con Exito"); 
                }
            } else {
                setMensaje("¡Error! El Departamento no existe");            
            }
        }
        catch(Exception e){
            setMensaje(e.getMessage());                                    
        }
    }

    //metodo para adicionar una recibiendo como parametro el id, el nombre y el departamento al que pertenece
    public void adicionarCiudad(String pNom, String pDep) throws Exception {
        try {
            Ciudad ciudad = buscarCiudad(pNom);
            if (ciudad == null) {
                int id=0;
                ciudad = new Ciudad(id,pNom, pDep);
                ciudadDAO.agregarCiudad(ciudad);
                ciudades.add(ciudad);
                setMensaje("La Ciudad se adicionó con Exito");
            }
            else{
                setMensaje("¡Error! La Ciudad ya se encuentra registrada");
            }
        } catch (Exception e) {
            setMensaje(e.getMessage());
        }
    }

    //metodo de modificar una Ciudad recibiendo como parametro id, nombre y el departamento al que pertenece
    public void modificarCiudad(String pNom, String pNomAnterior){
        try{
        Ciudad ciudad = buscarCiudad(pNomAnterior);
        if (ciudad != null) {
           Ciudad pCiudad = buscarCiudad(pNom);
            if (pCiudad == null) {  
                ciudad.setNombre(pNom);
                ciudadDAO.modificarCiudad(pNom, pNomAnterior);
                setMensaje("La ciudad se modificó correctamente");                            
            } else {
                setMensaje("¡Error! La ciudad con el nombre ingresado ya existe");                
            }
        } else {
            setMensaje("La ciudad ingresada no se encuentra");                            
        }
        }
        catch(Exception e){   
            setMensaje(e.getMessage());            
        }
    }

    //metodo buscar una ciudad recibiendo el idCiudad como parametro
    public Ciudad buscarCiudad(String pNombre){
        Ciudad ciudad = null;
        boolean encontrado = false;
        for (int i = 0; i < ciudades.size() && !encontrado; i++) {
            if (ciudades.get(i).getNombre().equals(pNombre)) {
                ciudad = ciudades.get(i);
                encontrado = true;
            }
        }
        return ciudad;
    }
    
    //metodo buscar una ciudad por depto
    public Ciudad buscarCiudadxDepto(String pNombre){
        Ciudad ciudad = null;
        boolean encontrado = false;
        for (int i = 0; i < ciudades.size() && !encontrado; i++) {
            if (ciudades.get(i).getDepartamento().equals(pNombre)) {
                ciudad = ciudades.get(i);
                encontrado = true;
            }
        }
        return ciudad;
    }
    
    

    //metodo eliminar una ciudad recibiendo el idCiudad como parametro
    public void eliminarCiudad(String pNombre){
        try{
        Ciudad ciudad = buscarCiudad(pNombre);
        if (ciudad != null) {
            ciudadDAO.eliminarCiudad(ciudad);
            ciudades.remove(ciudad);
            setMensaje("La ciudad se eliminó correctamente");                            
        } else {
            setMensaje("¡Error! La ciudad ingresada no se encuentra");                                        
        }
        }
        catch(Exception e){
            setMensaje(e.getMessage());                                        
        }
    }

    //metodo para adicionar un cliente como parametro la cedula, nombre, apellidos, email y telefono 
    public void adicionarCliente(int pId, int pCedula, String pNom, String pApell, String pEmail, String pTel) {
        try {
            Cliente cliente = buscarCliente(pCedula);
            if (cliente == null) {
                cliente = new Cliente(pId, pCedula, pNom, pApell, pEmail, pTel);
                clienteDAO.guardarCliente(cliente);
                clientes.add(cliente);
                setMensaje("El cliente se adicionó con Exito");
            }
            else{
                setMensaje("¡Error!, el cliente ya existe");
            }
        } catch (Exception e) {            
            setMensaje(e.getMessage());
        }
    }

    //metodo para modficar un cliente como parametro la cedula, nombre, apellidos, email y telefono 
    public void modificarCliente(int pCedula, String pNom, String pApell, String pEmail, String pTel){
        Cliente cliente = buscarCliente(pCedula);
        if (cliente != null) {
            try {
                cliente.setNombre(pNom);
                cliente.setApellidos(pApell);
                cliente.setEmail(pEmail);
                cliente.setTelefono(pTel);

                clienteDAO.modificarCliente(pCedula, cliente);
            } catch (Exception e) {
                //("El cliente ya existe");
            }

        } else {
            setMensaje("¡Error!, el cliente no existe");
        }
    }

    public Cliente buscarCliente(int pCedula) {
        Cliente cliente = null;
        boolean encontrado = false;
        for (int i = 0; i < clientes.size() && !encontrado; i++) {
            if (clientes.get(i).getCedula() == pCedula) {
                cliente = clientes.get(i);
                encontrado = true;
            }
        }
        return cliente;
    }

    //metodo buscar un cliente recibiendo la cedula como parametro
    public ArrayList<Cliente> buscarClientes(int pCedula, String pNom) {
        ArrayList<Cliente> misClientes = new ArrayList<Cliente>();
        boolean encontrado = false;

        if (pCedula != 0 && pNom != "") {
            for (int i = 0; i < clientes.size() && !encontrado; i++) {
                if (clientes.get(i).getCedula() == pCedula && clientes.get(i).getNombre().equals(pNom)) {
                    Cliente miCliente = new Cliente(clientes.get(i).getIdCliente(), clientes.get(i).getCedula(), clientes.get(i).getNombre(), clientes.get(i).getApellidos(), clientes.get(i).getEmail(), clientes.get(i).getTelefono());
                    misClientes.add(miCliente);
                    encontrado = true;
                }
            }
        } else if (pCedula != 0) {
            for (int i = 0; i < clientes.size() && !encontrado; i++) {
                if (clientes.get(i).getCedula() == pCedula) {
                    Cliente miCliente = new Cliente(clientes.get(i).getIdCliente(), clientes.get(i).getCedula(), clientes.get(i).getNombre(), clientes.get(i).getApellidos(), clientes.get(i).getEmail(), clientes.get(i).getTelefono());
                    misClientes.add(miCliente);
                    encontrado = true;
                }
            }
        } else if (pNom != "") {
            for (int i = 0; i < clientes.size(); i++) {
                if (clientes.get(i).getNombre().equals(pNom)) {
                    Cliente miCliente = new Cliente(clientes.get(i).getIdCliente(), clientes.get(i).getCedula(), clientes.get(i).getNombre(), clientes.get(i).getApellidos(), clientes.get(i).getEmail(), clientes.get(i).getTelefono());
                    misClientes.add(miCliente);  
                    encontrado = true;
                }
            }
        }
        else{
            for (int i = 0; i < clientes.size(); i++) {                
                    Cliente miCliente = new Cliente(clientes.get(i).getIdCliente(), clientes.get(i).getCedula(), clientes.get(i).getNombre(), clientes.get(i).getApellidos(), clientes.get(i).getEmail(), clientes.get(i).getTelefono());
                    misClientes.add(miCliente);                    
            }            
            encontrado = true;
        }
        
        if(encontrado==false) misClientes = null;
        return misClientes;
    }

    //metodo eliminar un cliente recibiendo la cedula como parametro
    public void eliminarCliente(int pCedula){
        Cliente cliente = buscarCliente(pCedula);
        if (cliente != null) {
            try{
            clienteDAO.eliminarCliente(cliente);
            clientes.remove(cliente);
            }
            catch(Exception e){
                
            }
        } else {
            //throw new Exception("El cliente no se encuentra Registrado");
        }
    }
    
    //metodo para adicionar una categoria recibiendo como parametro la descripcion
    public void adicionarCategoria(String pDesc) throws Exception {
        if (buscarCategoria(pDesc) == null) {
            int id =0;
            Categoria miCategoria = new Categoria(id, pDesc);
            //categoriaDAO.agregarCategoria(pDesc);
            categorias.add(miCategoria);            
            setMensaje("La categoria se adicionó con Exito");            
        }
        else setMensaje("¡Error! La Categoria ya existe");            
    }
    
    //buscar categoria enviando como parametro la descripcion
    public Categoria buscarCategoria(String pDesc) {
        Categoria categoria = null;
        boolean encontrado = false;
        for (int i = 0; i < categorias.size() && !encontrado; i++) {
            if (categorias.get(i).getDescripcion().equals(pDesc)) {
                categoria = categorias.get(i);
                encontrado = true;
            }
        }
        return categoria;
    }
    
    //metodo para modficar una categoria como parametro la descripcion
    public void modificarCategoria(String pDesc, String NuevaDesc){
        Categoria categoria = buscarCategoria(pDesc);        
        if (categoria != null) {
            try {
                categoria.setDescripcion(NuevaDesc);              
                //categoriaDAO.modificarCategoria(pDesc);                
            } catch (Exception e) {
                //("categoria ya existe");
            }

        } else {
            setMensaje("¡Error!, la categoria no existe");
        }
    }
    
    //metodo eliminar una categoria recibiendo la descripcion
    public void eliminarCategoria(String pDesc){
        Categoria categoria = buscarCategoria(pDesc);        
        if (categoria != null) {            
            try{
                //categoriaDAO.eliminarCategoria(categoria);            
                categorias.remove(categoria);
            }
            catch(Exception e){
                
            }
        } else {
            //throw new Exception("El cliente no se encuentra Registrado");
        }
    }
    
    //metodo para adicionar un Inmueble recibiendo como parametro..
    public void adicionarInmueble(String pBarrio, String pDir, String pTel, String pTipo, String pTamano, int pPrecio, String pImagen ) throws Exception {
        if (buscarInmuebles(pBarrio, pDir, pTipo) == null) {
            int id =0;
            Inmueble nInmueble = new Inmueble(id, pBarrio, pDir, pTel, pTipo, pTamano, pPrecio, pImagen);
            
            //inmuebleDAO.agregarInmueble(pBarrio, pDir, pTel, pTipo, pTamano, pPrecio, pImagen);
            inmuebles.add(nInmueble);            
            setMensaje("El inmueble se adicionó con Exito");            
        }
        else setMensaje("¡Error! El inmueble ya existe");            
    }
    
    //buscar inmueble enviando como parametro barrio, dir, tipo
    public ArrayList<Inmueble> buscarInmuebles(String pBarrio, String pDir, String pTipo) {
        ArrayList<Inmueble> misInmuebles = new ArrayList<Inmueble>();
        Inmueble miInmueble = null;
        //misInmuebles = inmuebleDAO.buscarInmuebles(pBarrio, pDir, pTipo);
        return misInmuebles;
    }
    
    //metodo para modficar un inmueble enviando como parametro..
    public void modificarInmueble(String pBarrio, String pDir, String pTel, String pTipo, String pTamano, int pPrecio, String pImagen){
        ArrayList<Inmueble> misInmuebles = buscarInmuebles(pBarrio, pDir, pTipo);
        
        if (misInmuebles != null) {
            try {                 
                    misInmuebles.get(0).setBarrio(pBarrio);
                    misInmuebles.get(0).setDireccion(pDir);
                    misInmuebles.get(0).setTelefono(pTel);
                    misInmuebles.get(0).setTipo(pTipo);
                    misInmuebles.get(0).setTamanio(pTamano);
                    misInmuebles.get(0).setPrecio(pPrecio);
                    misInmuebles.get(0).setImagen(pImagen);                                                       
                    //inmuebleDAO.modificarInmueble(pBarrio, pDir, pTel, pTipo, pTamano, pPrecio, pImagen);                
            } catch (Exception e) {
                //("inmueble ya existe");
            }

        } else {
            setMensaje("¡Error!, El inmueble no existe");
        }
    }
    
    //metodo eliminar una categoria recibiendo la descripcion
    public void eliminarInmueble(String pBarrio, String pDir, String pTipo){
        ArrayList<Inmueble> misInmuebles = buscarInmuebles(pBarrio, pDir, pTipo);
        Inmueble inmueble = null;
        
        if (misInmuebles != null) {            
            try{                 
                inmueble = misInmuebles.get(0);                
                inmuebles.remove(inmueble);
                //inmuebleDAO.eliminarInmueble();            
            }
            catch(Exception e){
                
            }
        } else {
            //throw new Exception("El cliente no se encuentra Registrado");
        }
    }
    
    
    
    
}
