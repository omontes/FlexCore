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
import java.sql.ResultSet;
import java.util.ArrayList;

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

    @Override
    public ArrayList<CuentaAhorroVistaDTO> verCuentasAhorroVista() throws Exception {
        ArrayList<CuentaAhorroVistaDTO> listaClientes = new ArrayList<>();
         CallableStatement preparedCall = null;
         try{
            String SQL = "{call obtenerCuentasAhorroVista()}";
            ResultSet rs = statement.executeQuery(SQL);
            while (rs.next()) {
                CuentaAhorroVistaDTO cuenta = new CuentaAhorroVistaDTO();
                cuenta.setNumCuenta(rs.getInt("numCuenta"));
                cuenta.setDescripcion(rs.getString("nombre"));
                cuenta.setTipoMoneda(rs.getInt("direccion"));
                listaClientes.add(cuenta);
            }
            statement.close();
            return listaClientes;

        } catch (Exception e) {
            System.out.println("Error al realizar la consulta de obtener "
                    + "todas las cuentas ahorra vista");
            throw (e);

        } finally {
            this.cerrarConexion();
        }
    }

    @Override
    public CuentaAhorroVistaDTO actualizarCuentaAhorroVista(CuentaAhorroVistaDTO cuenta) throws Exception {
        CallableStatement preparedCall = null;
        try {
            String SQL = "{call actualizarCuentaAhorroVista (?, ?, ?)}";
            preparedCall = conexion.prepareCall(SQL);
            preparedCall.setInt(1, cuenta.getNumCuenta());
            preparedCall.setString(2, cuenta.getDescripcion());
            preparedCall.setInt(3, cuenta.getTipoMoneda());
            preparedCall.executeUpdate();
            preparedCall.close();
        }
    catch (Exception e) {
            e.printStackTrace();
        throw new RuntimeException(e);
    }finally {
            this.cerrarConexion();
    }
    return cuenta ;
    }

    @Override
    public void eliminarCuentaAhorroVista(int numCuenta) throws Exception {
        CallableStatement preparedCall = null;
        try {
            String SQL = "{call eliminarCuentaAhorroVista (?)}";
            preparedCall = conexion.prepareCall(SQL);
            preparedCall.setInt(1, numCuenta);
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
