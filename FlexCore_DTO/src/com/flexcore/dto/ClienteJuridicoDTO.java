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
public class ClienteJuridicoDTO extends ClienteDTO {
    private int cedulaJuridica;

    /**
     * @return the cedulaJuridica
     */
    public int getCedulaJuridica() {
        return cedulaJuridica;
    }

    /**
     * @param cedulaJuridica the cedulaJuridica to set
     */
    public void setCedulaJuridica(int cedulaJuridica) {
        this.cedulaJuridica = cedulaJuridica;
    }
}
