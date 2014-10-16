/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.dao_interfaces;

import com.flexcore.dto.MonedasDTO;
import java.util.ArrayList;

/**
 *
 * @author Oscar Montes
 */
public interface TransaccionesMonedas {
    ArrayList<MonedasDTO> verMonedas() throws Exception;
}
