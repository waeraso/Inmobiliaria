/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.mundo;

/**
 * Clase que representa un inmueble por parte de un cliente
 * @author andre_000
 */
public class Inmueble 
{
    ///----------------------------------------------
    /// Atributos
    ///----------------------------------------------
    /**
     * identificador del inmueble
     */
    private int  idInmueble;
    /**
     * barrio del inmueble
     */
    private String barrio;
    /**
     * direccion del inmueble
     */
    private String direccion;
    /**
     * telefono del inmueble
     */
    private String telefono;
    /**
     * tipo del inmueble
     */
    private String tipo;
    /**
     * tamaño del inmueble
     */
    private String tamanio;
    /**
     * precio del inmueble
     */
    private int precio;
    /**
     * foto del inmueble
     */
    private String imagen;
    
    /**
    * Constructor de la clase Inmueble
    * @param pIdInmuebe identificacion del inmueble. idInmueble !=null
    * @param pBarrio barrio del inmueble. barrio !="" and barrio !=null
    * @param pDireccion direccion del inmueble. direccion !="" and direccion !=null
    * @param pTelefono telefono del inmueble. telefono !="" and telefono !=null
    * @param pTipo tipo del inmueble. tipo !="" and tipo !=null
    * @param pTamanio tamaño del inmueble. tamaño !="" and tamaño !=null
    * @param pPrecio precio del inmueble. precio !="" and precio !=nullC
    * @param pImagen imagen del inmueble. imagen !="" and imagen !=null
    */
    public Inmueble (int pIdInmueble,String pBarrio,String pDireccion,String pTelefono, String pTipo,String pTamanio,int pPrecio,String pImagen)
    {
        idInmueble=pIdInmueble;
        barrio=pBarrio;
        direccion=pDireccion;
        telefono=pTelefono;
        tipo=pTipo;
        tamanio=pTamanio;
        precio=pPrecio;
        imagen=pImagen;
    }
        
    ///----------------------------------------------
    /// Metodos
    ///----------------------------------------------
    
    /**
     * metodo que retorna el identificador del inmueble
     * @return idInmueble
     */
    public int getIdInmueble() {
        return idInmueble;
    }
    
    /**
     * metodo que cambia el identificador
     * @param pIdInmueble identificador del inmueble. idInmueble !="" and idInmueble !=null
     */
    public void setIdInmueble(int idInmueble) {
        this.idInmueble = idInmueble;
    }

     /**
     * metodo que retorna el barrio del inmueble
     * @return barrio
     */
    public String getBarrio() {
        return barrio;
    }
    
    /**
     * metodo que cambia el barrio
     * @param pBarrio barrio del inmueble. barrio !="" and barrio !=null
     */
    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    /**
     * metodo que retorna la direccion del inmueble
     * @return ddireccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * metodo que cambia la direccion
     * @param pDireccion direccion del inmueble. direccion !="" and direccion !=null
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * metodo que retorna el telefono del inmueble
     * @return telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * metodo que cambia el telefono
     * @param pTelefono telefono del inmueble. telefono !="" and telefono !=null
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * metodo que retorna el tipo del inmueble
     * @return tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * metodo que cambia el tipo
     * @param pTipo tipo del inmueble. tipo !="" and tipo !=null
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * metodo que retorna el tamanio del inmueble
     * @return tamanio
     */
    public String getTamanio() {
        return tamanio;
    }

    /**
     * metodo que cambia el tamanio
     * @param pTamanio tipo del inmueble. tamanio !="" and tamanio !=null
     */
    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    /**
     * metodo que retorna el precio del inmueble
     * @return precio
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * metodo que cambia el precio
     * @param pPrecio precio del inmueble. precio !="" and precio !=null
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }

     /**
     * metodo que retorna la imagen del inmueble
     * @return imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * metodo que cambia la imagen
     * @param pImagen imagen del inmueble. imagen !="" and imagen !=null
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
