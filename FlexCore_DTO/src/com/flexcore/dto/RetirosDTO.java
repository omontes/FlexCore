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
public class RetirosDTO {
    private int idRetiro;
    private double monto;
    private Date fecha;
    private int idCuenta; 

    /**
     * @return the idRetiro
     */
    public int getIdRetiro() {
        return idRetiro;
    }

    /**
     * @param idRetiro the idRetiro to set
     */
    public void setIdRetiro(int idRetiro) {
        this.idRetiro = idRetiro;
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

    /**
     * @return the idCuenta
     */
    public int getIdCuenta() {
        return idCuenta;
    }

    /**
     * @param idCuenta the idCuenta to set
     */
    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }
}
