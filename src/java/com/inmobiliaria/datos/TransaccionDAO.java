/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.datos;
import com.inmobiliaria.mundo.Transaccion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author KMILO
 */
public class TransaccionDAO {
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
    public TransaccionDAO() {
        fachada = new FachadaDB();
    }

    /**
     *
     * @param pTransaccion
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public int agregarTransaccion(Transaccion pTransaccion) throws SQLException, ClassNotFoundException {
        int insertar = -1;
        
        int idCliente = pTransaccion.getIdCliente();
        int idInmueble = pTransaccion.getIdInmueble();
        String tipoTran = pTransaccion.getTipoTransaccion();
                
        
        String sql = "INSERT INTO transaccion (idCliente, idInmueble, tipoTransaccion)"
                + "VALUES ('" + idCliente + "','" + idInmueble + "','" + tipoTran + "')";
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
    
    public ArrayList<Transaccion> listado() throws ClassNotFoundException, SQLException {
        ArrayList<Transaccion> transacciones = new ArrayList<Transaccion>();
        String sql = "SELECT * FROM transaccion";
        Connection conection = fachada.conectar();
        if (conection != null) {
            Statement instruccion = conection.createStatement();
            ResultSet tabla = instruccion.executeQuery(sql);
            while (tabla.next()) {
                
                int idTransaccion = Integer.parseInt(tabla.getString("idTransaccion"));
                int idCliente = Integer.parseInt(tabla.getString("idCliente"));
                int idInmueble = Integer.parseInt(tabla.getString("idInmueble"));                
                String tipoTrans = tabla.getString("tipoTransaccion");
                Transaccion transaccion = new Transaccion(idTransaccion, idCliente, idInmueble, tipoTrans);
                transacciones.add(transaccion);
            }
        }
        return transacciones;
    }
    
    
}
