/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.datos;
import com.inmobiliaria.mundo.Ciudad;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author AlejandroOC
 */
public class CiudadDAO {

    /// ---------------------------------------
    /// Atributos
    /// ---------------------------------------

    /**
     * Atributo que conecta con la clase fachada.
     */
    private FachadaDB fachada;
    
    /// ---------------------------------------
    /// Constructor
    /// ---------------------------------------
    /**
    * Constructor de la clase CiudadDAO.
    */
    public CiudadDAO()
    {
        fachada = new FachadaDB();
    }
    
    
    /// ---------------------------------------
    /// Metodos
    /// ---------------------------------------
    /**
     * Agregar una ciudad a la base de datos
     * @param pCiudad
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public int agregarCiudad(Ciudad pCiudad) throws ClassNotFoundException, SQLException{
        int insertar = -1;
        String nombre = pCiudad.getNombre();
        String departamento = pCiudad.getDepartamento();
        String sql = "INSERT INTO ciudad (nombre, departamento)"
                + "VALUES("+nombre+",'" + pCiudad.getNombre()+"',"+ departamento +",'"+pCiudad.getDepartamento()+"')";
        Connection miConexion = fachada.conectar();
        if(miConexion != null)
        {
            Statement instruccion = (Statement) miConexion.createStatement();
            insertar = ((java.sql.Statement) instruccion).executeUpdate(sql);
            miConexion.close();
        }
        fachada.desconectar(miConexion);
        return insertar;
    }
    
    
    /**
     * Este método se encarga de consultar la información de las ciudades
     *
     * @return retorna los datos de las ciudades registradas
     * @throws ClassNotFoundException Se lanza esta excepción si hay problemas
     * en encontrar la ruta de la clase
     * @throws SQLException Se lanza esta excepción si hay problemas realizando
     * la operación
     */
    public ArrayList<Ciudad> listado() throws ClassNotFoundException, SQLException {
        ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();
        String sql = "SELECT * FROM ciudad ORDER BY nombre asc";
        Connection conection = fachada.conectar();
        if (conection != null) {
            Statement instruccion = conection.createStatement();
            ResultSet tabla = instruccion.executeQuery(sql);
            while (tabla.next()) {
                int pIdCiudad = 0;                
                String nombre = tabla.getString("nombre");
                String departamento = tabla.getString("departamento");
                Ciudad ciudad = new Ciudad(pIdCiudad, nombre, departamento);
                ciudades.add(ciudad);
            }
        }
        return ciudades;
    }
    
    
    
    /**
     * consulta por nombre la ciudad en la base de datos 
     * @param pNombre
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public Ciudad buscarCiudad(String pNombre) throws SQLException, ClassNotFoundException
    {
        Ciudad ciudad = null;
        String sql = "SELECT idCiudad, nombre, departamento FROM ciudad WHERE nombre='"+ pNombre +"'";
        Connection miConexion = fachada.conectar();
        if(miConexion != null)
        {
            Statement instruccion = miConexion.createStatement();
            ResultSet tabla = instruccion.executeQuery(sql);
            while(tabla.next())
            {
                ciudad = new Ciudad(Integer.parseInt(tabla.getString("idCiudad")),tabla.getString("nombre"),tabla.getString("departamento"));
            }
        }
        fachada.desconectar(miConexion);
        return ciudad;
    }   
    
    
    /**
     * modificar una ciudad en la base de datos
     * @param pNombre
     * @param pCiudad
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public int modificarCiudad(String pNombre, Ciudad pCiudad) throws ClassNotFoundException, SQLException{
        int resultado = -1;
        String sql = "UPDATE ciudad SET nombre='"+ pCiudad.getNombre()+"'"
                + "WHERE nombre='"+ pNombre +"'";
        Connection miConexion = fachada.conectar();
        if(miConexion != null)
        {
            Statement instruccion = (Statement) miConexion.createStatement();
            resultado = ((java.sql.Statement) instruccion).executeUpdate(sql);
            miConexion.close();
        }
        fachada.desconectar(miConexion);
        return resultado;
    }    
        
    /**
     * eliminar una ciudad de la base de datos 
     * @param pCiudad
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public int eliminarCiudad(Ciudad pCiudad) throws ClassNotFoundException, SQLException{
        int resultado = -1;
        String sql = "DELETE FROM ciudad WHERE nombre='"+pCiudad.getNombre()+"'";
        Connection miConexion = fachada.conectar();
        if(miConexion != null)
        {
            Statement instruccion = (Statement) miConexion.createStatement();
            resultado = ((java.sql.Statement) instruccion).executeUpdate(sql);
            miConexion.close();
        }
        fachada.desconectar(miConexion);
        return resultado;
    }
    
    
}
