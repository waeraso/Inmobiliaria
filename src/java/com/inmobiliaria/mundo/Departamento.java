/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.mundo;

/**
 *
 * @author KMILO
 * clase que contiene los datos de Departamento como el nombre
 */
public class Departamento {
    
    //id de departamento, numero entero identificador de un dep
    int idDepartamento;    
    //nombre de departamento
    String nombre;
    
    //constructor de clase departamento que contiene datos de departamento    
    public Departamento(int pIdDep, String pNom){
        idDepartamento = pIdDep;
        nombre = pNom;             
    }
    
    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
