/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.mundo;

import com.inmobiliaria.datos.CiudadDAO;
import com.inmobiliaria.datos.ClienteDAO;
import com.inmobiliaria.datos.DepartamentoDAO;
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

    //Objeto de CiudadDAO
    private CiudadDAO ciudadDAO;

    //objeto de DepartamentoDAO 
    private DepartamentoDAO departamentoDAO;

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
    public void adicionarDepartamento(String pNom) throws Exception {
        if (buscarDepartamento(pNom) == null) {
            int id = 0;
            Departamento dept = new Departamento(id, pNom);
            departamentoDAO.agregarDepartamento(dept);
            departamentos.add(dept);
        }

    }

    //metodo de modificar un departamento recibiendo como parametro nombre
    public void modificarDepartamento(int pId, String pNom, String pNomAnterior) {
        try{
        Departamento dept = buscarDepartamento(pNomAnterior);
        if (dept != null) {
            dept = buscarDepartamento(pNom);
            if (dept == null) {
               departamentoDAO.modificarDepartamento(pId, pNom);
            } else {
                //throw new Exception("Ya existe departamento con el nombre ingresado");
            }
        } else {
            //throw new Exception("No se encuentra el departamento registrada");
        }
        }
        catch(Exception e){
            
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
            departamentoDAO.eliminarDepartamento(dept);
            departamentos.remove(dept);
        } else {
            throw new Exception("El Departamento no se encuentra registrado.");
        }
        }
        catch(Exception e){
            
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
            }
            else{
                throw new Exception("La ciudad con nombre: " + pNom + " ya se encuentra registrada.");                
            }
        } catch (Exception e) {
            throw new Exception(e);
        }

    }

    //metodo de modificar una Ciudad recibiendo como parametro id, nombre y el departamento al que pertenece
    public void modificarCiudad(String pNom, String pDep, String pNomAnterior){
        try{
        Ciudad ciudad = buscarCiudad(pNomAnterior);
        if (ciudad != null) {
            ciudad = buscarCiudad(pNom);
            if (ciudad == null) {                
                ciudadDAO.modificarCiudad(pNom, pNomAnterior);
            } else {
                throw new Exception("La ciudad con el nombre ingresado ya existe");
            }
        } else {
            throw new Exception("La ciudad ingresada no se encuentra");
        }
        }
        catch(Exception e){            
            
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

    //metodo eliminar una ciudad recibiendo el idCiudad como parametro
    public void eliminarCiudad(String pNombre){
        try{
        Ciudad ciudad = buscarCiudad(pNombre);
        if (ciudad != null) {
            ciudadDAO.eliminarCiudad(ciudad);
            ciudades.remove(ciudad);
        } else {
            throw new Exception("No se encuentra la ciudad registrada");
        }
        }
        catch(Exception e){
            
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
            }
        } catch (Exception e) {
            out.println(e.getMessage());
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
            //throw new Exception("El cliente no se encuentra registrado");
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
                }
            }
        }
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
}
