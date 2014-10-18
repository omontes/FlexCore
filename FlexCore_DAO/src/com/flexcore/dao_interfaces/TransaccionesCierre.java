/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.dao_interfaces;

import com.flexcore.dto.CierreDTO;

/**
 *
 * @author Carlos
 */
public interface TransaccionesCierre {
    void crearCierre(CierreDTO cierre) throws Exception;
    void cerrarCierre(CierreDTO cierre) throws Exception;
}
