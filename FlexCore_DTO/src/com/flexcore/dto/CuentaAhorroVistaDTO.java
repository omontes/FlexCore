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
    private int tipoMoneda;
    private BigDecimal saldoReal;
    private BigDecimal saldoTemporal;

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
}
