/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.dto;

import java.math.BigDecimal;

/**
 *
 * @author Carlos
 */
public class CuentaAhorroVistaDTO {
    private int numCuenta;
    private String descripcion;
    private String tipoMonedaDescripcion;
    private int tipoMoneda;
    private BigDecimal saldoReal;
    private BigDecimal saldoTemporal;
    private int idCliente;

    /**
     * @return the numCuenta
     */
    public int getNumCuenta() {
        return numCuenta;
    }

    /**
     * @param numCuenta the numCuenta to set
     */
    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    

    /**
     * @return the saldoReal
     */
    public BigDecimal getSaldoReal() {
        return saldoReal;
    }

    /**
     * @param saldoReal the saldoReal to set
     */
    public void setSaldoReal(BigDecimal saldoReal) {
        this.saldoReal = saldoReal;
    }

    /**
     * @return the saldoTemporal
     */
    public BigDecimal getSaldoTemporal() {
        return saldoTemporal;
    }

    /**
     * @param saldoTemporal the saldoTemporal to set
     */
    public void setSaldoTemporal(BigDecimal saldoTemporal) {
        this.saldoTemporal = saldoTemporal;
    }

    /**
     * @return the tipoMonedaDescripcion
     */
    public String getTipoMonedaDescripcion() {
        return tipoMonedaDescripcion;
    }

    /**
     * @param tipoMonedaDescripcion the tipoMonedaDescripcion to set
     */
    public void setTipoMonedaDescripcion(String tipoMonedaDescripcion) {
        this.tipoMonedaDescripcion = tipoMonedaDescripcion;
    }

    /**
     * @return the tipoMoneda
     */
    public int getTipoMoneda() {
        return tipoMoneda;
    }

    /**
     * @param tipoMoneda the tipoMoneda to set
     */
    public void setTipoMoneda(int tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }

    /**
     * @return the idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

  
}
