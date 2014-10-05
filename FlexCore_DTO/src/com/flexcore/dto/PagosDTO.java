/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.dto;

import java.sql.Date;

/**
 *
 * @author Carlos
 */
public class PagosDTO {
    private int idCuentaOrigen;
    private int idCuentaDestino;
    private int idPago;
    private double monto;
    private Date fecha;

    /**
     * @return the idCuentaOrigen
     */
    public int getIdCuentaOrigen() {
        return idCuentaOrigen;
    }

    /**
     * @param idCuentaOrigen the idCuentaOrigen to set
     */
    public void setIdCuentaOrigen(int idCuentaOrigen) {
        this.idCuentaOrigen = idCuentaOrigen;
    }

    /**
     * @return the idCuentaDestino
     */
    public int getIdCuentaDestino() {
        return idCuentaDestino;
    }

    /**
     * @param idCuentaDestino the idCuentaDestino to set
     */
    public void setIdCuentaDestino(int idCuentaDestino) {
        this.idCuentaDestino = idCuentaDestino;
    }

    /**
     * @return the idPago
     */
    public int getIdPago() {
        return idPago;
    }

    /**
     * @param idPago the idPago to set
     */
    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    /**
     * @return the monto
     */
    public double getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
