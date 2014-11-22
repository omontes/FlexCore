/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.dao;

import com.flexcore.connection_manager.ConnectionManager;
import com.flexcore.dao_interfaces.TransaccionesCuenta;
import com.flexcore.dto.CuentaDTO;
import java.math.BigDecimal;
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

    @Override
    public boolean verificarCuentaValida(int numCuenta) throws Exception {
        CuentaDTO cuenta = new CuentaDTO();
        CallableStatement preparedCall = null;
        try{
            String SQL = "{call verificarCuenta (?)}";
            preparedCall = conexion.prepareCall(SQL);
            preparedCall.setInt(1, numCuenta);
            ResultSet rs =  preparedCall.executeQuery();
            boolean isNULL = false;
            while (rs.next()) {
                cuenta.setNumCuenta(rs.getInt("numCuenta"));
                cuenta.setEstadoCuenta(rs.getBoolean("estadoCuenta"));
                isNULL = rs.getBoolean("isNull");
            }
            statement.close();
            if(cuenta.getNumCuenta()==1&&isNULL==true){
                return true;
            }else if(cuenta.getNumCuenta()==0){
                return false;
            }else if(cuenta.getNumCuenta()==1 && cuenta.isEstadoCuenta()==false){
                return true;
            }else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al realizar la consulta de obtener "
                    + "todas las cuentas");
            throw (e);

        } finally {
            this.cerrarConexion();
        }
    }

    @Override
    public BigDecimal obtenerSaldo(int numCuenta) {
        CallableStatement preparedCall = null;
        BigDecimal saldo = BigDecimal.ZERO;
        try {
            String SQL = "{call obtenerSaldoCuenta (?)}";
            preparedCall = conexion.prepareCall(SQL);
            preparedCall.setInt(1, numCuenta);
            preparedCall.executeQuery();
            ResultSet rs = preparedCall.getResultSet();
             while(rs.next()){
                 saldo = rs.getBigDecimal(1);
             }
             statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            this.cerrarConexion();
        }
        return saldo;
    }
    
}
