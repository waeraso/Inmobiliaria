/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.mundo;

import com.inmobiliaria.datos.ClienteDAO;
import static java.lang.System.out;
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

    //objeto de ClienteDAO 
    private ClienteDAO clienteDAO;

    //constructor de clase inmobiliaria para inicializar las listas de clientes, ciudades, departamentos
    public Inmobiliaria(){
        try{
        clienteDAO = new ClienteDAO();
        //clientes = new ArrayList<Cliente>();
        clientes = clienteDAO.listado();               
        
        }
        catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(Inmobiliaria.class.getName()).log(Level.SEVERE, null, ex);        
        }
    }
    
    //objeto de la clase (singleton)
    private static Inmobiliaria objeto = null;
    //dar objeto de la clase
        public static Inmobiliaria darObjeto()
        {
            if (objeto == null)
            {
                objeto = new Inmobiliaria();
            }
            
            return objeto;
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

    //cambiar lista de departamentos recibiendo los nuevos datos como parametro
    public void setDepartamentos(ArrayList<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    //metodo para adicionar un departamento recibiendo como parametro el id y el nombre
    public void adicionarDepartamento(int pIdDep, String pNom) {

    }

    //metodo de modificar un departamento recibiendo como parametro id y nombre
    public void modificarDepartamento(int pIdDep, String pNom) {

    }

    //metodo buscar un departamento recibiendo el idDep como parametro
    public void buscarDepartamento(int pIdDep) {

    }

    //metodo eliminar un departamento recibiendo el idDep como parametro
    public void eliminarDepartamento(int pIdDep) {

    }

    //metodo para adicionar una recibiendo como parametro el id, el nombre y el departamento al que pertenece
    public void adicionarCiudad(int pIdCiudad, String pNom, Departamento pDep) {

    }

    //metodo de modificar una Ciudad recibiendo como parametro id, nombre y el departamento al que pertenece
    public void modificarDepartamento(int pIdCiudad, String pNom, Departamento pDep) {

    }

    //metodo buscar una ciudad recibiendo el idCiudad como parametro
    public void buscarCiudad(int pIdCiudad) {

    }

    //metodo eliminar una ciudad recibiendo el idCiudad como parametro
    public void eliminarCiudad(int pIdCiudad) {

    }

    //metodo para adicionar un cliente como parametro la cedula, nombre, apellidos, email y telefono 
    public void adicionarCliente(int pId, int pCedula, String pNom, String pApell, String pEmail, String pTel) {
        try {
            Cliente cliente = buscarCliente(pCedula);
            if (cliente == null) {
                cliente = new Cliente(pId, pCedula, pNom, pApell, pEmail, pTel);
                clienteDAO.guardarCliente(cliente);
                clientes.add(cliente);
            }
        } catch (Exception e) {
            out.println(e.getMessage());
        }
    }

    //metodo para modficar un cliente como parametro la cedula, nombre, apellidos, email y telefono 
    public void modificarCliente(int pCedula, String pNom, String pApell, String pEmail, String pTel) throws Exception {
        Cliente cliente = buscarCliente(pCedula);
        if (cliente != null)
        { 
            try{
                cliente.setNombre(pNom);
                cliente.setApellidos(pApell);
                cliente.setEmail(pEmail);
                cliente.setTelefono(pTel);
                
                clienteDAO.modificarCliente(pCedula, cliente);            
            }
            catch(Exception e){
                throw new Exception ("El cliente ya existe");
            }
                
        }
        else
            throw new Exception ("El cliente no se encuentra registrado");

    }
    
    public Cliente buscarCliente(int pCedula){
        Cliente cliente = null;
        boolean encontrado = false;
        for (int i=0; i<clientes.size()&&!encontrado; i++)
        {
            if(clientes.get(i).getCedula() == pCedula)
            {
                cliente = clientes.get(i);
                encontrado = true;
            }
        }
        return cliente;
    }

    //metodo buscar un cliente recibiendo la cedula como parametro
    public ArrayList<Cliente>  buscarClientes(int pCedula, String pNom) {
        ArrayList<Cliente> misClientes = new ArrayList<Cliente>();
        boolean encontrado = false;
        
        if(pCedula!=0 && pNom!=null){
            for(int i=0;i<clientes.size() && !encontrado;i++){
                if (clientes.get(i).getCedula()==pCedula)
                {
                    Cliente miCliente = new Cliente(clientes.get(i).getIdCliente(), clientes.get(i).getCedula(),clientes.get(i).getNombre(), clientes.get(i).getApellidos(), clientes.get(i).getEmail(), clientes.get(i).getTelefono());                              
                    misClientes.add(miCliente);
                    encontrado = true;
                }                        
            }
        }
        else if(pCedula!=0){
            for(int i=0;i<clientes.size() && !encontrado;i++){
                if (clientes.get(i).getCedula()==pCedula)
                {
                    Cliente miCliente = new Cliente(clientes.get(i).getIdCliente(), clientes.get(i).getCedula(),clientes.get(i).getNombre(), clientes.get(i).getApellidos(), clientes.get(i).getEmail(), clientes.get(i).getTelefono());                              
                    misClientes.add(miCliente);
                    encontrado = true;
                }                        
            }            
        }   
        else if(pNom!=null){
            for(int i=0; i<clientes.size() && !encontrado; i++){
                if (clientes.get(i).getNombre()==pNom)
                {
                    Cliente miCliente = new Cliente(clientes.get(i).getIdCliente(), clientes.get(i).getCedula(),clientes.get(i).getNombre(), clientes.get(i).getApellidos(), clientes.get(i).getEmail(), clientes.get(i).getTelefono());                              
                    misClientes.add(miCliente);
                    encontrado = true;
                }                        
            }            
        }   
        
        return misClientes;
    }

    //metodo eliminar un cliente recibiendo la cedula como parametro
    public void eliminarCliente(int pCedula) throws ClassNotFoundException, SQLException, Exception {
        Cliente cliente = buscarCliente(pCedula);
        if (cliente != null)
        {
            clienteDAO.eliminarCliente(cliente);
            clientes.remove(cliente);
        }
        else
            throw new Exception ("El cliente no se encuentra Registrado");

    }
}
