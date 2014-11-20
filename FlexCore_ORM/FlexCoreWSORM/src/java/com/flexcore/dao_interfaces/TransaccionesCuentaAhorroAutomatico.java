/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.dao_interfaces;

import com.flexcore.dto_hibernate.Cuentaahorroautomatico;
import java.util.List;

/**
 *
 * @author Carlos
 */
public interface TransaccionesCuentaAhorroAutomatico {
    List<Cuentaahorroautomatico> verCuentasAhorroAutomatico(int pagina, String busqueda, int customerIF) throws Exception;
    Cuentaahorroautomatico crearCuentaAhorroAutomatico(Cuentaahorroautomatico cuenta) throws Exception;
    //Cuentaahorroautomatico actualizarCuentaAhorroAutomatico(Cuentaahorroautomatico cuenta) throws Exception;
    //void eliminarCuentaAhorroAutomatico(int numCuenta) throws Exception;
    //int obtenerCantidadCuentasAhorroAutomatico(String entrada, int customerIF) throws Exception;;
}
