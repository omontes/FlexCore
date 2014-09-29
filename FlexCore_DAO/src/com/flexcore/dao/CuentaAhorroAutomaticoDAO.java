/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.dao;

import com.flexcore.connection_manager.ConnectionManager;
import com.flexcore.dao_interfaces.TransaccionesCuentaAhorroAutomatico;
import com.flexcore.dto.CuentaAhorroAutomaticoDTO;
import java.sql.CallableStatement;

/**
 *
 * @author Carlos
 */
public class CuentaAhorroAutomaticoDAO extends ConnectionManager implements TransaccionesCuentaAhorroAutomatico {

    @Override
    public CuentaAhorroAutomaticoDTO crearCuentaAhorroAutomatico(CuentaAhorroAutomaticoDTO cuenta) throws Exception {
        CallableStatement preparedCall = null;
        try {
             String SQL = "{call crearCuentaAhorroAutomatico (?, ?, ?, ?, ?, ?, ?, ?)}";
             preparedCall = conexion.prepareCall(SQL);
             preparedCall.setInt(1, cuenta.getNumCuenta());
             preparedCall.setInt(2, cuenta.getTiempoDeducciones());
             preparedCall.setInt(3, cuenta.getTipotiempo());
             preparedCall.setDate(4, cuenta.getFechaInicio());
             preparedCall.setInt(5, cuenta.getTiempoAhorroMeses());
             preparedCall.setInt(6, cuenta.getCuentaDeduccion());
             preparedCall.setInt(7, cuenta.getMontoAhorro());
             preparedCall.setBoolean(8, cuenta.isEstadoAhorro());
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

    public CuentaAhorroAutomaticoDTO crearCuentaAhorroVista(CuentaAhorroAutomaticoDTO cuentaAhorroAutomatico) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
