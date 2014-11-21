/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.dao_interfaces;


import com.flexcore.dto_hibernate.Cuenta;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Carlos
 */
public interface TransaccionesCuenta {
    List<Cuenta> verCuentas(int customerIF);
    //Cuenta crearCuenta(Cuenta cuenta) throws Exception;
    //Cuenta actualizarCuenta(Cuenta cuenta) throws Exception;
    //void eliminarCuenta(int numCuenta) throws Exception;
    boolean verificarCuentaValida(int numCuenta);
    BigDecimal obtenerSaldo(int numCuenta);
}
