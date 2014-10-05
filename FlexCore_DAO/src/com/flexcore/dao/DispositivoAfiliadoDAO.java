/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.dao;

import com.flexcore.connection_manager.ConnectionManager;
import com.flexcore.dao_interfaces.TransaccionesDispositivoAfiliado;
import com.flexcore.dto.DispositivoAfiliadoDTO;
import java.sql.CallableStatement;

/**
 *
 * @author Carlos
 */
public class DispositivoAfiliadoDAO extends ConnectionManager implements TransaccionesDispositivoAfiliado {

    @Override
    public DispositivoAfiliadoDTO crearDispositivoAfiliado(DispositivoAfiliadoDTO dispositovoAfiliado) throws Exception {
        CallableStatement preparedCall = null;
        try {
             String SQL = "{call crearDispositivoAfiliado (?, ?, ?)}";
             preparedCall = conexion.prepareCall(SQL);
             preparedCall.setInt(1, dispositovoAfiliado.getIdTarjeta());
             preparedCall.setInt(2, dispositovoAfiliado.getIdCuenta());
             preparedCall.setBoolean(3, dispositovoAfiliado.isEstado());
             preparedCall.executeUpdate();
             preparedCall.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            this.cerrarConexion();
        }
        return dispositovoAfiliado;
    }
    
}
