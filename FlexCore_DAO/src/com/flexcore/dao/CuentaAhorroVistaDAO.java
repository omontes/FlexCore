/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.dao;

import com.flexcore.connection_manager.ConnectionManager;
import com.flexcore.dao_interfaces.TransaccionesCuentaAhorroVista;
import com.flexcore.dto.CuentaAhorroVistaDTO;
import java.math.BigDecimal;
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
             String SQL = "{call crearCuentaAhorroVista (?, ?, ?, ?, ?)}";
             preparedCall = conexion.prepareCall(SQL);
             preparedCall.setString(1, cuenta.getDescripcion());
             preparedCall.setInt(2, cuenta.getTipoMoneda());
             preparedCall.setBigDecimal(3,cuenta.getSaldoReal());
             preparedCall.setBigDecimal(4,cuenta.getSaldoTemporal());
             preparedCall.setInt(5,cuenta.getIdCliente());
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
    public ArrayList<CuentaAhorroVistaDTO> verCuentasAhorroVista(int pagina, String busqueda, int customerIF) throws Exception {
         ArrayList<CuentaAhorroVistaDTO> listaClientes = new ArrayList<>();
         CallableStatement preparedCall = null;
         try{
            int datoInicial = (pagina - 1)*10;
            int datoFinal = pagina*10;
            String SQL = "{call obtenerCuentasAhorroVista(?,?,?,?)}";
            preparedCall = conexion.prepareCall(SQL);
            preparedCall.setInt(1, datoInicial);
            preparedCall.setInt(2, datoFinal);
            preparedCall.setString(3, busqueda);
            preparedCall.setInt(4, customerIF);
            ResultSet rs =  preparedCall.executeQuery();
            while (rs.next()) {
                CuentaAhorroVistaDTO cuenta = new CuentaAhorroVistaDTO();
                cuenta.setNumCuenta(rs.getInt("numCuenta"));
                cuenta.setDescripcion(rs.getString("descripcion"));
                cuenta.setTipoMonedaDescripcion(rs.getString("tipoMoneda"));
                cuenta.setSaldoReal(rs.getBigDecimal("saldoReal"));
                cuenta.setSaldoTemporal(rs.getBigDecimal("saldoTemporal"));
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
            String SQL = "{call actualizarCuentaAhorroVista (?, ?, ?, ?, ?)}";
            preparedCall = conexion.prepareCall(SQL);
            preparedCall.setInt(1, cuenta.getNumCuenta());
            preparedCall.setString(2, cuenta.getDescripcion());
            preparedCall.setBigDecimal(3, cuenta.getSaldoReal());
            preparedCall.setBigDecimal(4, cuenta.getSaldoTemporal());
            preparedCall.setInt(5, cuenta.getTipoMoneda());
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

    @Override
    public int obtenerCantidadCuentasAhorroVista(String entrada, int customerIF) {
         CallableStatement preparedCall = null;
        int cantidadCuentasAhorroVista = 0;
        try {
            String SQL = "{call obtenerCantidadCuentasAhorroVista (?,?)}";
            preparedCall = conexion.prepareCall(SQL);
            preparedCall.setString(1, entrada);
            preparedCall.setInt(2, customerIF);
            preparedCall.executeQuery();
            ResultSet rs = preparedCall.getResultSet();
             while(rs.next()){
                 cantidadCuentasAhorroVista = rs.getInt(1);
             }
             statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            this.cerrarConexion();
        }
        return cantidadCuentasAhorroVista;
    }

    
}
