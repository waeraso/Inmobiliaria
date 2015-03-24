/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.mundo;

/**
 *
 * @author KMILO
 * clase que contiene los datos como el nombre de las ciudades
 */
public class Ciudad {
    
    //id de ciudad
    int idCiudad;    
    //nombre de ciudad
    String nombre;
    //objeto de departamento con los datos del departamento al que pertenece
    String departamento;
    
    //constructor clase ciudad para inicializar datos de una ciudad
    public Ciudad(int pIdCiudad, String pNombre, String pDep){
        idCiudad = pIdCiudad;
        nombre = pNombre;
        departamento = pDep;
    }
    
    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }   
    
}
