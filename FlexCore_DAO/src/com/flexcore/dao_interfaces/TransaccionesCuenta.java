/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.dao_interfaces;

import com.flexcore.dto.CuentaDTO;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public interface TransaccionesCuenta {
    ArrayList<CuentaDTO> verCuentas(int customerIF) throws Exception;
    CuentaDTO crearCuenta(CuentaDTO cuenta) throws Exception;
    CuentaDTO actualizarCuenta(CuentaDTO cuenta) throws Exception;
    void eliminarCuenta(int numCuenta) throws Exception;
    boolean verificarCuentaValida(int numCuenta) throws Exception;
}
