/*
 * To change this license header, choose License Headers in Project Properties. 
 */

package com.inmobiliaria.mundo;

/**
 *
 * @author KMILO
 * * Clase que contiene los datos de clientes de la inmobiliaria
 */
public class Cliente {
    
    //cedula de cliente
    private int cedula;
    //nombre dle cliente
    private String nombre;    
    //apellidos del cliente
    private String apellidos;
    //correo electronico del cliente
    private String email;
    //telefono del cliente
    private String telefono;
    
    //constructor de clase Cliente para inicializar atributos
    public Cliente(int pCedula, String pNombre, String pApellidos, String pEmail, String pTelefono){
        cedula = pCedula;
        nombre = pNombre;
        apellidos = pApellidos;
        email = pEmail;
        telefono = pTelefono;                 
    }    
    
    //obtener la cedula de un cliente
    public int getCedula() {
        return cedula;
    }

    //cambiar la cedula de un cliente enviando una nueva como parametro
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    //obtener el nombre de un cliente
    public String getNombre() {
        return nombre;
    }

    //cambiar el nombre de un cliente enviando uno nuevo como parametro
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //obtener los apellidos de un cliente
    public String getApellidos() {
        return apellidos;
    }

    //cambiar los apellidos de un cliente enviando uno nuevo como parametro
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    //obtener el email de un cliente
    public String getEmail() {
        return email;
    }

    //cambiar el email de un cliente enviando uno nuevo como parametro
    public void setEmail(String email) {
        this.email = email;
    }
    
    //obtener el telefono de un cliente
    public String getTelefono() {
        return telefono;
    }

    //cambiar el telefono de un cliente enviando uno nuevo como parametro
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
}
