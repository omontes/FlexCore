/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.dao_interfaces;

import com.flexcore.dto.RetirosDTO;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public interface TransaccionesRetiros {
    RetirosDTO crearRetiro(RetirosDTO retiro) throws Exception;
    ArrayList<RetirosDTO> verRetiros(int idCuenta) throws Exception;
}
