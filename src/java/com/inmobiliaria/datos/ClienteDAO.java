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
 * @author WILMER
 */
public class ClienteDAO {

// -----------------------------------------------------------------
// Atributos
// -----------------------------------------------------------------
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
        String sql = "INSERT INTO cliente (cedula, nombres, apellidos, email, telefono)"
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
        String sql = "SELECT * FROM cliente ORDER BY apellido asc, nombre asc";
        Connection conection = fachada.conectar();
        if (conection != null) {
            Statement instruccion = conection.createStatement();
            ResultSet tabla = instruccion.executeQuery(sql);
            while (tabla.next()) {
                int pId=0;
                //int cedula = tabla.getString("cedula");
                int cedula = Integer.parseInt( tabla.getString("cedula"));
                String nombre = tabla.getString("nombre");
                String apellidos = tabla.getString("apellido");
                String email = tabla.getString("email");
                String telefono = tabla.getString("telefono");                
                Cliente cliente = new Cliente(pId, cedula, nombre, apellidos, email, telefono);
                clientes.add(cliente);
            }        }
        return clientes;
    }
}
