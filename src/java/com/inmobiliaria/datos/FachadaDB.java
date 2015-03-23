/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.datos;

/**
 *
 * @author SoftTeam
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FachadaDB {

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	private String usuario = "root";
	private String contrasenia = "mysql";
	private String url = "jdbc:mysql://localhost/inmobiliaria";
	private Connection con = null;
	
	// -----------------------------------------------------------------
	// metodos
	// -----------------------------------------------------------------

	/**
	 * El constructor de la clase FachadaDB
	 */
	public FachadaDB()
	{
		
		

	}
	/**
	 * Conecta a la base de datos
	 * @return retorna la conexion con la base de datos
	 * @throws SQLException Se lanza esta excepción si hay problemas realizando la operación
	 * @throws ClassNotFoundException Se lanza esta excepción si hay problemas en encontrar la ruta de la clase
	 */

	public Connection conectar() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		con = (Connection)DriverManager.getConnection(url, usuario, contrasenia);
		return con;
	}
	/**
	 * Desconecta el administrador de la base de datos y la detiene
	 * @param conn permite deconectarce de la base de datos
	 * @throws SQLException Se lanza esta excepción si hay problemas realizando la operación
	 */
	public void desconectar(Connection conn) throws SQLException {
		conn.close();
	}

}
