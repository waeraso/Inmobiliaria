/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.mundo;

/**
 * Clase que representa la transaccion de un inmueble por parte de un cliente
 * @author andre_000
 */
public class Transaccion 

{
    int idTransaccion;
    int idCliente;
    int idInmueble;
    String tipoTransaccion;  

    public Transaccion(int idTransaccion, int idCliente, int idInmueble, String tipoTransaccion) {
        this.idTransaccion = idTransaccion;
        this.idCliente = idCliente;
        this.idInmueble = idInmueble;
        this.tipoTransaccion = tipoTransaccion;
    }       

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(int idInmueble) {
        this.idInmueble = idInmueble;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }
    
    
}
