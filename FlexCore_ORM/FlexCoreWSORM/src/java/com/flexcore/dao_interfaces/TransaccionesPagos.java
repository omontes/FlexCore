/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.dao_interfaces;


import com.flexcore.dto_hibernate.Pagos;
import java.util.List;

/**
 *
 * @author Carlos
 */
public interface TransaccionesPagos {
    Pagos crearPago(Pagos pago);
    List<Object> verPagosDeCuentaDestino(int idCuentaDestino);
}
