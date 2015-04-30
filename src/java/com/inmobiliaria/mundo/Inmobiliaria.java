/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.mundo;

import com.inmobiliaria.datos.CategoriaDAO;
import com.inmobiliaria.datos.CiudadDAO;
import com.inmobiliaria.datos.ClienteDAO;
import com.inmobiliaria.datos.DepartamentoDAO;
import com.inmobiliaria.datos.InmuebleDAO;
import com.inmobiliaria.datos.TransaccionDAO;
import java.io.File;
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
     * Lista de los transacciones que contienen arriendo o venta de inmueble
     */
    private ArrayList<Transaccion> transacciones;
    
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
    
    //objeto de categoriaDAO
    private CategoriaDAO categoriaDAO;
    
    //objeto de inmuebleDAO
    private InmuebleDAO inmuebleDAO;
    
    //objeto de clase transaccion
    private TransaccionDAO transaccionDAO;
    
    //mensajes que se generan en el manejo de la clase cliente
    String mensaje;

    //constructor de clase inmobiliaria para inicializar las listas de clientes, ciudades, departamentos
    public Inmobiliaria() {
        try {
            clienteDAO = new ClienteDAO();
            departamentoDAO = new DepartamentoDAO();
            ciudadDAO = new CiudadDAO();
            categoriaDAO = new CategoriaDAO();
            inmuebleDAO = new InmuebleDAO();    
            transaccionDAO = new TransaccionDAO();
            
            clientes = clienteDAO.listado();
            ciudades = ciudadDAO.listado();
            departamentos = departamentoDAO.listado();
            categorias = categoriaDAO.listado();
            inmuebles = inmuebleDAO.listado();
            transacciones = transaccionDAO.listado();                                                

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

    public ArrayList<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(ArrayList<Transaccion> transacciones) {
        this.transacciones = transacciones;
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
            categoriaDAO.agregarCategoria(miCategoria);
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
                Categoria pCat = buscarCategoria(NuevaDesc);
                if(pCat==null){
                    categoria.setDescripcion(NuevaDesc);              
                    categoriaDAO.modificarCategoria(NuevaDesc, pDesc);
                    setMensaje("La categoria se modificó correctamente"); 
                }
                else setMensaje("La categoria ya existe");                                                  
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
                categoriaDAO.eliminarCategoria(categoria);            
                categorias.remove(categoria);
                setMensaje("la categoria se eliminó correctamente");
            }
            catch(Exception e){
                
            }
        } else {
            //throw new Exception("El cliente no se encuentra Registrado");
        }
    }
    
    //metodo para adicionar un Inmueble recibiendo como parametro..
    public void adicionarInmueble(String pBarrio, String pDir, String pTel, String pTipo, String pTamano, int pPrecio, String pImagen, String categoria, String ciudad ){
        try{
                if (buscarInmueble(pDir) == null) {            
                    Inmueble nInmueble = new Inmueble(0, pBarrio, pDir, pTel, pTipo, pTamano, pPrecio, pImagen, categoria, ciudad);            
                    inmuebleDAO.guardarInmueble(nInmueble);
                    inmuebles.add(nInmueble);            
                    setMensaje("El inmueble se adicionó con Exito");            
                }
                else setMensaje("¡Error! El inmueble con esa dirección ya existe"); 
        }catch(Exception e){
            setMensaje(e.getMessage());            
        }
        
    }
    
    //buscar inmueble enviando como parametro barrio, dir, tipo
    public ArrayList<Inmueble> buscarInmueblesXParam(String pBarrio, String pDir, String pTipo) throws Exception{
        ArrayList<Inmueble> misInmuebles = new ArrayList<Inmueble>();
        //Inmueble miInmueble = null;
        misInmuebles = inmuebleDAO.buscarInmuebleXParam(pBarrio, pDir, pTipo);
        return misInmuebles;
    }
    
    //buscar inmueble por direccion:
    public Inmueble buscarInmueble(String pDir){
        Inmueble inmueble = null;
        boolean encontrado = false;
        for (int i = 0; i < inmuebles.size() && !encontrado; i++) {
            if (inmuebles.get(i).getDireccion().equals(pDir)) {
                inmueble = inmuebles.get(i);
                encontrado = true;
            }
        }
        return inmueble;
    }
    
    //metodo para modficar un inmueble enviando como parametro..
    public void modificarInmueble(String pBarrio, String pDir, String pTel, String pTipo, String pCategoria, String pTamanio, int pPrecio, String pCiudad, String pImagen, String pDirOriginal){
        Inmueble miInmueble = buscarInmueble(pDirOriginal);
        
        if (miInmueble != null) {
            try {
                Inmueble pInm = buscarInmueble(pDir);
                if(pInm==null){
                    miInmueble.setBarrio(pBarrio);
                    miInmueble.setDireccion(pDir);
                    miInmueble.setTelefono(pTel);
                    miInmueble.setTipo(pTipo);
                    miInmueble.setCategoria(pCategoria);
                    miInmueble.setTamanio(pTamanio);
                    miInmueble.setPrecio(pPrecio);
                    miInmueble.setCiudad(pCiudad);
                    miInmueble.setImagen(pImagen);                                                       
                    inmuebleDAO.modificarInmueble(pDirOriginal, miInmueble);  
                    setMensaje("El Inmueble se modificó con Exito");
                } else setMensaje("¡Error!, El inmueble con esa dirección ya existe");
            } catch (Exception e) {
                //("inmueble ya existe");
            }

        } else {
            setMensaje("¡Error!, El inmueble no existe");
        }
    }
    
    //metodo eliminar una categoria recibiendo la descripcion
    public void eliminarInmueble(String pDir){
        Inmueble miInmueble = buscarInmueble(pDir);        
        
        if (miInmueble != null) {            
            try{                                               
                inmuebleDAO.eliminarInmueble(miInmueble);            
                inmuebles.remove(miInmueble);
            }
            catch(Exception e){
                
            }
        } else {
            //throw new Exception("El cliente no se encuentra Registrado");
        }
    }
    
    //metodo para eliminar un archivo recibiendo la ruta como parametro
    public void eliminarArchivo(String ruta){        
        File archivo = new File(ruta);
        archivo.delete();                                                                               
    }
    
    //registrar una transaccion para arrendar o vender inmueble:
    public void registrarTransaccion(int nIdCliente, int nIdInmueble, String nTipoTrans){
        try{
            Transaccion nTrans = new Transaccion(nIdInmueble, nIdCliente, nIdInmueble, nTipoTrans);
            transaccionDAO.agregarTransaccion(nTrans);
            transacciones.add(nTrans);                                                                           
        }catch(Exception e){
            setMensaje(e.getMessage());            
        }
    }
    
    //buscar inmueble enviando como parametro ciudad
    public ArrayList<Inmueble> buscarInmueblesXCiudad(String pNombreCiudad) throws Exception{
        ArrayList<Inmueble> misInmuebles = new ArrayList<Inmueble>();
        //Inmueble miInmueble = null;
        misInmuebles = inmuebleDAO.buscarInmuebleXCiudad(pNombreCiudad);
        return misInmuebles;
    }
    
    
    
    
}
