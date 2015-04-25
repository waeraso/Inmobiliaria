/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.datos;

import com.inmobiliaria.mundo.Categoria;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author WILMER
 */
public class CategoriaDAO {
    
    private FachadaDB fachada;
    
    public CategoriaDAO(){
        fachada=new FachadaDB();
    }
      /// ---------------------------------------
    /// Metodos
    /// ---------------------------------------
    /**
     * Agregar una ciudad a la base de datos
     * @param pCategoria
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public int agregarCategoria(Categoria pCategoria) throws ClassNotFoundException, SQLException{
        int insertar = -1;
        String descripcion = pCategoria.getDescripcion();
        String sql = "INSERT INTO categoria (descripcion)"
                + "VALUES('"+descripcion+"')";
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
     * Este método se encarga de consultar la información de las categorias
     *
     * @return retorna los datos de las categorias registradas
     * @throws ClassNotFoundException Se lanza esta excepción si hay problemas
     * en encontrar la ruta de la clase
     * @throws SQLException Se lanza esta excepción si hay problemas realizando
     * la operación
     */
    public ArrayList<Categoria> listado() throws ClassNotFoundException, SQLException {
        ArrayList<Categoria> categorias = new ArrayList<Categoria>();
        String sql = "SELECT * FROM categoria ORDER BY nombre asc";
        Connection conection = fachada.conectar();
        if (conection != null) {
            Statement instruccion = conection.createStatement();
            ResultSet tabla = instruccion.executeQuery(sql);
            while (tabla.next()) {
                int idCategoria = Integer.parseInt(tabla.getString("idCategoria"));               
                String descripcion = tabla.getString("categoria");
                Categoria categoria = new Categoria(idCategoria, descripcion);
                categorias.add(categoria);
            }
        }
        return categorias;
    }
    
    
    
    /**
     * consulta por nombre la ciudad en la base de datos 
     * @param pDescripcion
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public Categoria buscarCategoria(String pDescripcion) throws SQLException, ClassNotFoundException
    {
        Categoria categoria = null;
        String sql = "SELECT idCategoria, descripcion FROM categoria WHERE descripcion='"+ pDescripcion +"'";
        Connection miConexion = fachada.conectar();
        if(miConexion != null)
        {
            Statement instruccion = miConexion.createStatement();
            ResultSet tabla = instruccion.executeQuery(sql);
            while(tabla.next())
            {
                categoria = new Categoria(Integer.parseInt(tabla.getString("idCategoria")),tabla.getString("descripcion"));
            }
        }
        fachada.desconectar(miConexion);
        return categoria;
    }   
    
    
    /**
     * modificar una ciudad en la base de datos
     * @param pNombre
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public int modificarCiudad(String pDescripcion, String pDesAnterior) throws ClassNotFoundException, SQLException{
        int resultado = -1;
        String sql = "UPDATE categoria SET descripcion='"+ pDescripcion+"'"
                + "WHERE descripcion='"+ pDesAnterior +"'";
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
    public int eliminarCiudad(Categoria pCategoria) throws ClassNotFoundException, SQLException{
        int resultado = -1;
        String sql = "DELETE FROM ciudad WHERE nombre='"+pCategoria.getDescripcion()+"'";
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
