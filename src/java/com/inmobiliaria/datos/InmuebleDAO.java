/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.datos;

import com.inmobiliaria.mundo.Inmueble;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author WILMER
 */
public class InmuebleDAO {
    
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
    public InmuebleDAO() {
        fachada = new FachadaDB();
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Crea la tabla necesaria para guardar los datos del cliente.
     *
     * @param pInmueble
     * @return los datos del cliente
     * @throws SQLException Se lanza esta excepción si hay problemas realizando
     * la operación
     * @throws ClassNotFoundException Se lanza esta excepción si hay problemas
     * en encontrar la ruta de la clase
     */
    public int guardarCliente(Inmueble pInmueble) throws SQLException, ClassNotFoundException {
        int insertar = -1;
        
        String barrio = pInmueble.getBarrio();
        String direccion = pInmueble.getDireccion();
        String telefono = pInmueble.getTelefono();
        String tipo = pInmueble.getTipo();
        String tamanio = pInmueble.getTamanio();
        int precio = pInmueble.getPrecio();
        String imagen = pInmueble.getImagen();
        
        String sql = "INSERT INTO inmueble (barrio, direccion, telefono, tipo, tamanio, precio, imagen)"
                + "VALUES ('" + barrio + "','" + telefono + "', '" + tipo + "', '" + tamanio + "', '" + precio + "','"+imagen+"')";
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
    public ArrayList<Inmueble> listado() throws ClassNotFoundException, SQLException {
        ArrayList<Inmueble> inmuebles = new ArrayList<Inmueble>();
        String sql = "SELECT * FROM inmueble ORDER BY barrio asc";
        Connection conection = fachada.conectar();
        if (conection != null) {
            Statement instruccion = conection.createStatement();
            ResultSet tabla = instruccion.executeQuery(sql);
            while (tabla.next()) {
                
                int idInmueble = Integer.parseInt(tabla.getString("idInmueble"));
                String barrio = tabla.getString("barrio");
                String direccion = tabla.getString("direccion");
                String telefono = tabla.getString("telefono");
                String tipo = tabla.getString("tipo");
                String tamanio = tabla.getString("tamanio");
                int precio = Integer.parseInt(tabla.getString("precio"));
                String imagen = tabla.getString("imagen");
                Inmueble inmueble = new Inmueble(idInmueble, barrio, direccion, telefono, tipo, tamanio, precio, imagen);
                inmuebles.add(inmueble);
            }
        }
        return inmuebles;
    }

    /**
     * consulta por cedula, nombres o apellidos el cliente en la base de datos.
     *
     * @param pCedula, pNombres o pApellidos
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public ArrayList<Inmueble> buscarInmueble(String pCedula, String pNombres, String pApellidos) throws SQLException, ClassNotFoundException {
      
        return null;
    }

    /**
     * eliminar un cliente de la base de datos
     *
     * @param pCliente
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public int eliminarInmueble(Inmueble pInmueble) throws ClassNotFoundException, SQLException {
        int resultado = -1;
        String sql = "DELETE FROM cliente WHERE cedula='" + pInmueble.getIdInmueble()+ "'";
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
    public int modificarInmueble(int pIdInmueble, Inmueble pInmueble) throws ClassNotFoundException, SQLException {
        int resultado = -1;
        String sql = "UPDATE inmueble SET barrio='" + pInmueble.getBarrio()+ "', direccion='" + pInmueble.getDireccion()+ "', telefono='" + pInmueble.getTelefono()+ "', tipo='" + pInmueble.getTipo()+ "', precio='"+pInmueble.getPrecio()+"', imagen='"+pInmueble.getImagen()+"'"
                + "WHERE idInmueble='" + pIdInmueble + "'";
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
