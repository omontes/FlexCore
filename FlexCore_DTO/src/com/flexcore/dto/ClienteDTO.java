/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.dto;

/**
 *
 * @author Oscar Montes
 */
public class ClienteDTO {
    private int customerIF;
    private String nombre;
    private String direccion;
    private int telCasa;
    private int telOficina;
    private int celular;

    /**
     * @return the idCliente
     */
    public int getCustomerIF() {
        return customerIF;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setCustomerIF(int idCliente) {
        this.customerIF = idCliente;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the telCasa
     */
    public int getTelCasa() {
        return telCasa;
    }

    /**
     * @param telCasa the telCasa to set
     */
    public void setTelCasa(int telCasa) {
        this.telCasa = telCasa;
    }

    /**
     * @return the telOficina
     */
    public int getTelOficina() {
        return telOficina;
    }

    /**
     * @param telOficina the telOficina to set
     */
    public void setTelOficina(int telOficina) {
        this.telOficina = telOficina;
    }

    /**
     * @return the celular
     */
    public int getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(int celular) {
        this.celular = celular;
    }
}
