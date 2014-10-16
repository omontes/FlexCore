/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.dao;

import com.flexcore.connection_manager.ConnectionManager;
import com.flexcore.dao_interfaces.TransaccionesCuenta;
import com.flexcore.dto.CuentaDTO;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class CuentaDAO extends ConnectionManager implements TransaccionesCuenta  {

    @Override
    public ArrayList<CuentaDTO> verCuentas(int customerIF) throws Exception {
        ArrayList<CuentaDTO> listaCuentas = new ArrayList<>();
        CallableStatement preparedCall = null;
         try{
            String SQL = "{call obtenerCuentas (?)}";
            preparedCall = conexion.prepareCall(SQL);
            preparedCall.setInt(1, customerIF);
            ResultSet rs =  preparedCall.executeQuery();
            while (rs.next()) {
                CuentaDTO cuenta = new CuentaDTO();
                cuenta.setNumCuenta(rs.getInt("numCuenta"));
                cuenta.setIdCliente(rs.getInt("idCliente"));
                cuenta.setSaldoTemporal(rs.getDouble("saldoTemporal"));
                cuenta.setSaldoReal(rs.getDouble("saldoReal"));
                cuenta.setEstadoCuenta(rs.getBoolean("estadoCuenta"));
                listaCuentas.add(cuenta);
            }
            statement.close();
            return listaCuentas;

        } catch (Exception e) {
            System.out.println("Error al realizar la consulta de obtener "
                    + "todas las cuentas");
            throw (e);

        } finally {
            this.cerrarConexion();
        }
    }

    @Override
    public CuentaDTO crearCuenta(CuentaDTO cuenta) throws Exception {
        CallableStatement preparedCall = null;
        try {
             String SQL = "{call crearCuenta (?, ?, ?, ?, ?)}";
             preparedCall = conexion.prepareCall(SQL);
             preparedCall.setInt(1, cuenta.getNumCuenta());
             preparedCall.setInt(2, cuenta.getIdCliente());
             preparedCall.setDouble(3, cuenta.getSaldoTemporal());
             preparedCall.setDouble(4, cuenta.getSaldoReal());
             preparedCall.setBoolean(5, cuenta.isEstadoCuenta());
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
    public CuentaDTO actualizarCuenta(CuentaDTO cuenta) throws Exception {
        CallableStatement preparedCall = null;
        try {
            String SQL = "{call actualizarCuenta (?, ?, ?, ?, ?)}";
            preparedCall = conexion.prepareCall(SQL);
            preparedCall.setInt(1, cuenta.getNumCuenta());
            preparedCall.setInt(2, cuenta.getIdCliente());
            preparedCall.setDouble(3, cuenta.getSaldoTemporal());
            preparedCall.setDouble(4, cuenta.getSaldoReal());
            preparedCall.setBoolean(5, cuenta.isEstadoCuenta());
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
    public void eliminarCuenta(int numCuenta) throws Exception {
        CallableStatement preparedCall = null;
        try {
            String SQL = "{call eliminarCuenta (?)}";
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
