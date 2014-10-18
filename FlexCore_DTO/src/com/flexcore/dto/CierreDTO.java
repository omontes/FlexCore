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
public class CierreDTO {
    private Date fecha;
    private boolean estadoCierre;

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
     * @return the estadoCierre
     */
    public boolean isEstadoCierre() {
        return estadoCierre;
    }

    /**
     * @param estadoCierre the estadoCierre to set
     */
    public void setEstadoCierre(boolean estadoCierre) {
        this.estadoCierre = estadoCierre;
    }
}
