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
    private int tipoTiempo;
    private Date fechaInicio;
    private int tiempoAhorroMeses;
    private int numCuentaDeduccion;
    private double montoAhorro;
    private boolean estadoAhorro;
    private Date fechaUltimaActualizacion;
    private int idProposito;

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
     * @return the tipoTiempo
     */
    public int getTipoTiempo() {
        return tipoTiempo;
    }

    /**
     * @param tipoTiempo the tipoTiempo to set
     */
    public void setTipoTiempo(int tipoTiempo) {
        this.tipoTiempo = tipoTiempo;
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
     * @return the numCuentaDeduccion
     */
    public int getNumCuentaDeduccion() {
        return numCuentaDeduccion;
    }

    /**
     * @param numCuentaDeduccion the CuentaDeduccion to set
     */
    public void setNumCuentaDeduccion(int numCuentaDeduccion) {
        this.numCuentaDeduccion = numCuentaDeduccion;
    }

    /**
     * @return the montoAhorro
     */
    public double getMontoAhorro() {
        return montoAhorro;
    }

    /**
     * @param montoAhorro the montoAhorro to set
     */
    public void setMontoAhorro(double montoAhorro) {
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

    /**
     * @return the fechaUltimaActualizacion
     */
    public Date getFechaUltimaActualizacion() {
        return fechaUltimaActualizacion;
    }

    /**
     * @param fechaUltimaActualizacion the fechaUltimaActualizacion to set
     */
    public void setFechaUltimaActualizacion(Date fechaUltimaActualizacion) {
        this.fechaUltimaActualizacion = fechaUltimaActualizacion;
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
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the idProposito
     */
    public int getIdProposito() {
        return idProposito;
    }

    /**
     * @param idProposito the idProposito to set
     */
    public void setIdProposito(int idProposito) {
        this.idProposito = idProposito;
    }
}
