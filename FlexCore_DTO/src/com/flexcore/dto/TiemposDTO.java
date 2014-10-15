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
public class TiemposDTO {
    private int idTiempo;
    private String Descripcion;

    /**
     * @return the idTiempo
     */
    public int getIdTiempo() {
        return idTiempo;
    }

    /**
     * @param idTiempo the idTiempo to set
     */
    public void setIdTiempo(int idTiempo) {
        this.idTiempo = idTiempo;
    }

    /**
     * @return the Descripcion
     */
    public String getDescripcion() {
        return Descripcion;
    }

    /**
     * @param Descripcion the Descripcion to set
     */
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
}
