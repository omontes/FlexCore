/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.dao;

import com.flexcore.connection_manager.ConnectionManager;
import com.flexcore.dao_interfaces.TransaccionesCuentaAhorroVista;
import com.flexcore.dto.CuentaAhorroVistaDTO;
import java.sql.CallableStatement;

/**
 *
 * @author Carlos
 */
public class CuentaAhorroVistaDAO extends ConnectionManager implements TransaccionesCuentaAhorroVista {

    @Override
    public CuentaAhorroVistaDTO crearCuentaAhorroVista(CuentaAhorroVistaDTO cuenta) throws Exception {
        CallableStatement preparedCall = null;
        try {
             String SQL = "{call crearCuentaAhorroVista (?, ?, ?)}";
             preparedCall = conexion.prepareCall(SQL);
             preparedCall.setInt(1, cuenta.getNumCuenta());
             preparedCall.setString(2, cuenta.getDescripcion());
             preparedCall.setInt(3, cuenta.getTipoMoneda());
             preparedCall.executeUpdate();
             preparedCall.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            this.cerrarConexion();
        }
        return cuenta;
    }
    
}
