/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.dao_interfaces;

import com.flexcore.dto.CuentaAhorroAutomaticoDTO;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public interface TransaccionesCuentaAhorroAutomatico {
    ArrayList<CuentaAhorroAutomaticoDTO> verCuentasAhorroAutomatico(int pagina, String busqueda) throws Exception;
    CuentaAhorroAutomaticoDTO crearCuentaAhorroAutomatico(CuentaAhorroAutomaticoDTO cuenta) throws Exception;
    CuentaAhorroAutomaticoDTO actualizarCuentaAhorroAutomatico(CuentaAhorroAutomaticoDTO cuenta) throws Exception;
    void eliminarCuentaAhorroAutomatico(int numCuenta) throws Exception;
    int obtenerCantidadCuentasAhorroAutomatico(String entrada) throws Exception;;
}
