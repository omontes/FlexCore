/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.dao_interfaces;

import com.flexcore.dto_hibernate.Moneda;
import java.util.List;

/**
 *
 * @author Oscar Montes
 */
public interface TransaccionesMonedas {
    List<Moneda> verMonedas() throws Exception;
}
