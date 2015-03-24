/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.mundo;

/**
 * Clase que representa una categoria de un inmueble por parte de un cliente
 * @author andre_000
 */
public class Categoria 
{
    ///----------------------------------------------
    /// Atributos
    ///----------------------------------------------
    /**
     * identificador de la categoria
     */
    private int idCategoria;
    /**
     * descripcion de la categoria
     */
    private String descripcion;
    
    /**
    * Constructor de la clase Categoria
    * @param pIdCategoria identificacion de la categoria. idCategoria !=null
    * @param pDescripcion descripcion de la categoria. categoria !="" and categoria !=null
    */
    public Categoria (int pIdCategoria,String pDescripcion)
    {
        idCategoria=pIdCategoria;
        descripcion=pDescripcion;
    }
    ///----------------------------------------------
    /// Metodos
    ///----------------------------------------------
    
     /**
     * metodo que retorna el identificador de la categoria
     * @return idDescripcion
     */
    public int getIdCategoria() {
        return idCategoria;
    }

    /**
     * metodo que cambia el identificador
     * @param pIdCategoria identificador de la categoria. idCategoria !="" and idCategoria !=null
     */   
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    /**
     * metodo que retorna la descripcion de la categoria
     * @return descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * metodo que cambia la escripcion
     * @param pDescripcion descripcion de la categoria. descripcion !="" and descripcion !=null
     */  
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
        

    
}
