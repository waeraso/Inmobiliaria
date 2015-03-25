/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.datos;

import com.inmobiliaria.mundo.Cliente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author SoftTeam
 */
public class ClienteDAO {

// -----------------------------------------------------------------
// Atributos
// -----------------------------------------------------------------
    /**
     * Atributo que conecta con la clase fachada.
     */
    private FachadaDB fachada;

    // -----------------------------------------------------------------
    // Constructor
    // ----------------------------------------------------------------
    public ClienteDAO() {
        fachada = new FachadaDB();
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Crea la tabla necesaria para guardar los datos del cliente.
     *
     * @param pCliente ingresa los datos del cliente
     * @return los datos del cliente
     * @throws SQLException Se lanza esta excepción si hay problemas realizando
     * la operación
     * @throws ClassNotFoundException Se lanza esta excepción si hay problemas
     * en encontrar la ruta de la clase
     */
    public int guardarCliente(Cliente pCliente) throws SQLException, ClassNotFoundException {
        int insertar = -1;
        int cedula = pCliente.getCedula();
        String nombre = pCliente.getNombre();
        String apellidos = pCliente.getApellidos();
        String email = pCliente.getEmail();
        String telefono = pCliente.getTelefono();
        String sql = "INSERT INTO cliente (cedula, nombre, apellidos, email, telefono)"
                + "VALUES ('" + cedula + "','" + nombre + "', '" + apellidos + "', '" + email + "', '" + telefono + "')";
        Connection conection = fachada.conectar();
        if (conection != null) {
            Statement stm = conection.createStatement();
            insertar = stm.executeUpdate(sql);
            stm.close();
            conection.close();
        }
        fachada.desconectar(conection);
        return insertar;
    }

    /**
     * Este método se encarga de consultar la información de los clientes
     *
     * @return retorna los datos de los clientes registrados
     * @throws ClassNotFoundException Se lanza esta excepción si hay problemas
     * en encontrar la ruta de la clase
     * @throws SQLException Se lanza esta excepción si hay problemas realizando
     * la operación
     */
    public ArrayList<Cliente> listado() throws ClassNotFoundException, SQLException {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        String sql = "SELECT * FROM cliente ORDER BY apellidos asc";
        Connection conection = fachada.conectar();
        if (conection != null) {
            Statement instruccion = conection.createStatement();
            ResultSet tabla = instruccion.executeQuery(sql);
            while (tabla.next()) {
                
                int idCliente = Integer.parseInt(tabla.getString("idCliente"));
                int cedula = Integer.parseInt(tabla.getString("cedula"));
                String nombre = tabla.getString("nombre");
                String apellidos = tabla.getString("apellidos");
                String email = tabla.getString("email");
                String telefono = tabla.getString("telefono");
                Cliente cliente = new Cliente(idCliente, cedula, nombre, apellidos, email, telefono);
                clientes.add(cliente);
            }
        }
        return clientes;
    }

    /**
     * consulta por cedula, nombres o apellidos el cliente en la base de datos.
     *
     * @param pCedula, pNombres o pApellidos
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Cliente buscarCliente(String pCedula, String pNombres, String pApellidos) throws SQLException, ClassNotFoundException {
        Cliente cliente = null;
        String sql = "SELECT cedula, nombres, apellidos, email, telefono FROM cliente WHERE cedula='" + pCedula + "'nombres='" + pNombres + "'apellidos='" + pApellidos + "'";
        Connection miConexion = fachada.conectar();
        if (miConexion != null) {
            Statement instruccion = miConexion.createStatement();
            ResultSet tabla = instruccion.executeQuery(sql);
            while (tabla.next()) {
                cliente = new Cliente(Integer.parseInt(tabla.getString("idCliente")),Integer.parseInt(tabla.getString("cedula")), tabla.getString("nombre"), tabla.getString("apellido"), tabla.getString("email"), tabla.getString("telefono"));
            }
        }
        fachada.desconectar(miConexion);
        return cliente;
    }

    /**
     * eliminar un cliente de la base de datos
     *
     * @param pCliente
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public int eliminarCliente(Cliente pCliente) throws ClassNotFoundException, SQLException {
        int resultado = -1;
        String sql = "DELETE FROM cliente WHERE cedula='" + pCliente.getCedula() + "'";
        Connection miConexion = fachada.conectar();
        if (miConexion != null) {
            Statement instruccion = (Statement) miConexion.createStatement();
            resultado = ((java.sql.Statement) instruccion).executeUpdate(sql);
            miConexion.close();
        }
        fachada.desconectar(miConexion);
        return resultado;
    }

    /**
     * modificar un cliente en la base de datos
     *
     * @param pCedula
     * @param pCliente
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public int modificarCliente(int pCedula, Cliente pCliente) throws ClassNotFoundException, SQLException {
        int resultado = -1;
        String sql = "UPDATE cliente SET nombres='" + pCliente.getNombre() + "', apellidos='" + pCliente.getApellidos() + "', email='" + pCliente.getEmail() + "', telefono='" + pCliente.getTelefono() + "'"
                + "WHERE cedula='" + pCedula + "'";
        Connection miConexion = fachada.conectar();
        if (miConexion != null) {
            Statement instruccion = (Statement) miConexion.createStatement();
            resultado = ((java.sql.Statement) instruccion).executeUpdate(sql);
            miConexion.close();
        }
        fachada.desconectar(miConexion);
        return resultado;
    }

    
    
    
    
}
