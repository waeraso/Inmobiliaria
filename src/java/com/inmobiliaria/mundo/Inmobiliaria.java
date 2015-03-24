/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.mundo;

import com.inmobiliaria.datos.ClienteDAO;
import static java.lang.System.out;
import java.util.ArrayList;

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
    public Inmobiliaria() {
        clienteDAO = new ClienteDAO();

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
    public void modificarCliente(int pCedula, String pNom, String pApell, String pEmail, String pTel) {

    }

    //metodo buscar un cliente recibiendo la cedula como parametro
    public Cliente buscarCliente(int pCedula) {

        return null;
    }

    //metodo eliminar un cliente recibiendo la cedula como parametro
    public void eliminarCliente(int pCedula) {

    }

}
