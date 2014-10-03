/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.dao_interfaces;

import com.flexcore.dto.CuentaAhorroVistaDTO;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public interface TransaccionesCuentaAhorroVista {
    ArrayList<CuentaAhorroVistaDTO> verCuentasAhorroVista() throws Exception;
    CuentaAhorroVistaDTO crearCuentaAhorroVista(CuentaAhorroVistaDTO cuenta) throws Exception;
    CuentaAhorroVistaDTO actualizarCuentaAhorroVista(CuentaAhorroVistaDTO cuenta) throws Exception;
    void eliminarCuentaAhorroVista(int numCuenta) throws Exception;
}
