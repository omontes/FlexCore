/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.dto;

/**
 *
 * @author Carlos
 */
public class CuentaDTO {
    private int numCuenta;
    private int idCliente;
    private double saldoTemporal;
    private double saldoReal;
    private boolean estadoCuenta;

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

    /**
     * @return the saldoTemporal
     */
    public double getSaldoTemporal() {
        return saldoTemporal;
    }

    /**
     * @param saldoTemporal the saldoTemporal to set
     */
    public void setSaldoTemporal(double saldoTemporal) {
        this.saldoTemporal = saldoTemporal;
    }

    /**
     * @return the saldoReal
     */
    public double getSaldoReal() {
        return saldoReal;
    }

    /**
     * @param saldoReal the saldoReal to set
     */
    public void setSaldoReal(double saldoReal) {
        this.saldoReal = saldoReal;
    }

    /**
     * @return the estadoCuenta
     */
    public boolean isEstadoCuenta() {
        return estadoCuenta;
    }

    /**
     * @param estadoCuenta the estadoCuenta to set
     */
    public void setEstadoCuenta(boolean estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }
}
