/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.dao_interfaces;

import com.flexcore.dto.PropositosDTO;
import java.util.ArrayList;

/**
 *
 * @author Oscar Montes
 */
public interface TransaccionesPropositos {
    ArrayList<PropositosDTO> verPropositos() throws Exception;
}
