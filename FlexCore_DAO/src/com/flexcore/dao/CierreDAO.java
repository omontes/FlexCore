/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.dao;

import com.flexcore.connection_manager.ConnectionManager;
import com.flexcore.dao_interfaces.TransaccionesCierre;
import com.flexcore.dto.CierreDTO;
import java.sql.CallableStatement;

/**
 *
 * @author Carlos
 */
public class CierreDAO extends ConnectionManager implements TransaccionesCierre{

    @Override
    public void crearCierre(CierreDTO cierre) throws Exception {
        CallableStatement preparedCall = null;
         try {
             String SQL = "{call crearCierre ()}";
             preparedCall = conexion.prepareCall(SQL);
             preparedCall.executeUpdate();
             preparedCall.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            this.cerrarConexion();
        }
    }

    @Override
    public void cerrarCierre(CierreDTO cierre) throws Exception {
        CallableStatement preparedCall = null;
         try {
             String SQL = "{call cerrarCierre ()}";
             preparedCall = conexion.prepareCall(SQL);
             preparedCall.executeUpdate();
             preparedCall.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            this.cerrarConexion();
        }
    }
    
}
