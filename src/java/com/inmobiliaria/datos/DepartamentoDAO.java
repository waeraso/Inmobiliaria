/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.datos;
import com.inmobiliaria.mundo.Departamento;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author AlejandroOC
 */
public class DepartamentoDAO {
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
     * Constructor de la clase DepartamentoDAO.
     */
    public DepartamentoDAO() {
        fachada = new FachadaDB();
    }

    /// ---------------------------------------
    /// Metodos
    /// ---------------------------------------
    /**
     * Agregar un departamento a la base de datos
     * @param pDepartamento
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public int agregarDepartamento(Departamento pDepartamento) throws ClassNotFoundException, SQLException{
        int insertar = -1;
        String nombre = pDepartamento.getNombre();
        String sql = "INSERT INTO departamento (nombre)"
                + "VALUES("+nombre+",'" + pDepartamento.getNombre()+"')";
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
     * Este método se encarga de consultar la información de los departamentos
     *
     * @return retorna los datos de los departamentos registrados
     * @throws ClassNotFoundException Se lanza esta excepción si hay problemas
     * en encontrar la ruta de la clase
     * @throws SQLException Se lanza esta excepción si hay problemas realizando
     * la operación
     */
    public ArrayList<Departamento> listado() throws ClassNotFoundException, SQLException {
        ArrayList<Departamento> departamentos = new ArrayList<Departamento>();
        String sql = "SELECT * FROM departamento ORDER BY nombre asc";
        Connection conection = fachada.conectar();
        if (conection != null) {
            Statement instruccion = conection.createStatement();
            ResultSet tabla = instruccion.executeQuery(sql);
            while (tabla.next()) {
                int pIdDep = 0;                
                String nombre = tabla.getString("nombre");
                Departamento departamento = new Departamento(pIdDep, nombre);
                departamentos.add(departamento);
            }
        }
        return departamentos;
    }
    
    
    /**
     * consulta por nombre el departamento en la base de datos 
     * @param pNombre
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public Departamento buscarDepartamento(String pNombre) throws SQLException, ClassNotFoundException
    {
        Departamento departamento = null;
        String sql = "SELECT idDepartamento, nombre FROM departamento WHERE nombre='"+ pNombre +"'";
        Connection miConexion = fachada.conectar();
        if(miConexion != null)
        {
            Statement instruccion = miConexion.createStatement();
            ResultSet tabla = instruccion.executeQuery(sql);
            while(tabla.next())
            {
                departamento = new Departamento(Integer.parseInt(tabla.getString("idDepartamento")),tabla.getString("nombre"));
            }
        }
        fachada.desconectar(miConexion);
        return departamento;    
    }
    
    
    /**
     * Modificar un Departamento en la base de datos
     * @param pNombre
     * @param pDepartamento
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public int modificarDepartamento(String pNombre, Departamento pDepartamento) throws ClassNotFoundException, SQLException{
        int resultado = -1;
        String sql = "UPDATE departamento SET nombre='"+ pDepartamento.getNombre()+"'"
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
     * Eliminar un Departamento de la base de datos 
     * @param pCiudad
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public int eliminarDepartamento (Departamento pDepartamento) throws ClassNotFoundException, SQLException{
        int resultado = -1;
        String sql = "DELETE FROM departamento WHERE nombre='"+pDepartamento.getNombre()+"'";
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
