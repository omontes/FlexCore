/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.dto;

import java.sql.Date;
import java.util.Calendar;

/**
 *
 * @author Carlos
 */
public class CuentaAhorroAutomaticoDTO {
    private int numCuenta;
    private int tiempoDeducciones;
    private int tipotiempo;
    private Date fechaInicio;
    private int tiempoAhorroMeses;
    private int CuentaDeduccion;
    private int montoAhorro;
    private boolean estadoAhorro;

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
     * @return the tiempoDeducciones
     */
    public int getTiempoDeducciones() {
        return tiempoDeducciones;
    }

    /**
     * @param tiempoDeducciones the tiempoDeducciones to set
     */
    public void setTiempoDeducciones(int tiempoDeducciones) {
        this.tiempoDeducciones = tiempoDeducciones;
    }

    /**
     * @return the tipotiempo
     */
    public int getTipotiempo() {
        return tipotiempo;
    }

    /**
     * @param tipotiempo the tipotiempo to set
     */
    public void setTipotiempo(int tipotiempo) {
        this.tipotiempo = tipotiempo;
    }

    /**
     * @return the fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio() {
        Calendar cal = Calendar.getInstance();
        this.fechaInicio = new java.sql.Date(cal.getTimeInMillis());
    }

    /**
     * @return the tiempoAhorroMeses
     */
    public int getTiempoAhorroMeses() {
        return tiempoAhorroMeses;
    }

    /**
     * @param tiempoAhorroMeses the tiempoAhorroMeses to set
     */
    public void setTiempoAhorroMeses(int tiempoAhorroMeses) {
        this.tiempoAhorroMeses = tiempoAhorroMeses;
    }

    /**
     * @return the CuentaDeduccion
     */
    public int getCuentaDeduccion() {
        return CuentaDeduccion;
    }

    /**
     * @param CuentaDeduccion the CuentaDeduccion to set
     */
    public void setCuentaDeduccion(int CuentaDeduccion) {
        this.CuentaDeduccion = CuentaDeduccion;
    }

    /**
     * @return the montoAhorro
     */
    public int getMontoAhorro() {
        return montoAhorro;
    }

    /**
     * @param montoAhorro the montoAhorro to set
     */
    public void setMontoAhorro(int montoAhorro) {
        this.montoAhorro = montoAhorro;
    }

    /**
     * @return the estadoAhorro
     */
    public boolean isEstadoAhorro() {
        return estadoAhorro;
    }

    /**
     * @param estadoAhorro the estadoAhorro to set
     */
    public void setEstadoAhorro(boolean estadoAhorro) {
        this.estadoAhorro = estadoAhorro;
    }
}
