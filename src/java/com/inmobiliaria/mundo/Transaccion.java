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
    /// ---------------------------------------
    /// Atributos
    /// ---------------------------------------
    
    /**
     * Número de id de la transaccion
     */
    private int idTransaccion;
    
    /**
     * Cliente que compra un inmueble
     */
    private String cliente;
    
    /**
     * inmueble que el cliente compra
     */
    private String inmueble;
    
    /**
     * tipo de inmueble que el cliente compra
     */
    private String tipo;

    /// ---------------------------------------
    /// Constructor
    /// ---------------------------------------
    /**
     * Constructor del clase Transaccion
     * @param pIdTransaccion - id de la transaccion. pIdTransaccion != null
     * @param pCliente - Cliente del inmueble. pCliente != null
     * @param pInmueble - inmueble que el cliente compra. pInmueble != null
     * @param pTipo - tipo de inmueble vendido. pTipo != null
     */
    public Transaccion(int pIdTransaccion,String pCliente, String pInmueble, String pTipo)
    {
        idTransaccion=pIdTransaccion;
        cliente = pCliente;
        inmueble = pInmueble;
        tipo = pTipo;
    }

    /// ---------------------------------------
    /// Metodos
    /// ---------------------------------------
    /**
     * Método que retorna el cliente que compra el inmueble
     * @return cliente
     */
    public String getCliente() 
    {
        return cliente;
    }

    /**
     * Método que modifica el cliente que compra el inmueble
     * @param pCliente - Cliente. pCliente != null
     */
    public void setCliente(String pCliente) 
    {
        this.cliente = pCliente;
    }

    /**
     * Método que retorna el inmueble vendido
     * @return inmueble
     */
    public String getInmueble() 
    {
        return inmueble;
    }

    /**
     * Método que modifica el inmueble vendido
     * @param pInmueble - inmueble vendido. pInmueble != null 
     */
    public void setInmueble(String pInmueble) 
    {
        this.inmueble = pInmueble;
    }

    /**
     * Método que retorna el tipo de inmueble 
     * @return tipo
     */
    public String getTipo() 
    {
        return tipo;
    }

    /**
     * Método que retorna el tipo de inmueble
     * @param pTipo - inmueble vendido. pTipo != null
     */
    public void setTipo(String pTipo) 
    {
        this.tipo = pTipo;
    }
    /**
     * Método que retorna el id de la transaccion
     * @return idTransaccion
     */
    public int getIdTransaccion() 
    {
        return idTransaccion;
    }

    /**
     * Método que modifica el id de la transaccion
     * @param pIdTransaccion - id de la transaccion. pId != null
     */
    public void setIdTransaccion(int pIdTransaccion) 
    {
        this.idTransaccion = pIdTransaccion;
    }
    
}
