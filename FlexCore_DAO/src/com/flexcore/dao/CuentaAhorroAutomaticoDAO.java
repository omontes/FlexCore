/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.dao;

import com.flexcore.connection_manager.ConnectionManager;
import com.flexcore.dao_interfaces.TransaccionesCuentaAhorroAutomatico;
import com.flexcore.dto.CuentaAhorroAutomaticoDTO;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class CuentaAhorroAutomaticoDAO extends ConnectionManager implements TransaccionesCuentaAhorroAutomatico {
    
    @Override
    public ArrayList<CuentaAhorroAutomaticoDTO> verCuentasAhorroAutomatico(int pagina, String busqueda, int customerIF) throws Exception {
         ArrayList<CuentaAhorroAutomaticoDTO> listaClientes = new ArrayList<>();
         CallableStatement preparedCall = null;
         try{
            int datoInicial = (pagina - 1)*10;
            int datoFinal = pagina*10;
            String SQL = "{call obtenerCuentasAhorroAutomatico(?,?,?,?)}";
            preparedCall = conexion.prepareCall(SQL);
            preparedCall.setInt(1, datoInicial);
            preparedCall.setInt(2, datoFinal);
            preparedCall.setString(3, busqueda);
            preparedCall.setInt(4, customerIF);
            ResultSet rs =  preparedCall.executeQuery();
            while (rs.next()) {
                CuentaAhorroAutomaticoDTO cuenta = new CuentaAhorroAutomaticoDTO();
                cuenta.setNumCuenta(rs.getInt("numCuenta"));
                cuenta.setTiempoDeducciones(rs.getInt("tiempoDeducciones"));
                cuenta.setTipoTiempoDescripcion(rs.getString("tipoTiempoDescripcion"));
                cuenta.setFechaInicio(rs.getDate("fechaInicio"));
                cuenta.setTiempoAhorroMeses(rs.getInt("tiempoAhorroMeses"));
                cuenta.setNumCuentaDeduccion(rs.getInt("numCuentaDeduccion"));
                cuenta.setMontoAhorro(rs.getDouble("montoAhorro"));
                cuenta.setEstadoAhorro(rs.getBoolean("estadoAhorro"));
                cuenta.setIdPropositoDescripcion(rs.getString("idPropositoDescripcion"));
                cuenta.setSaldoReal(rs.getBigDecimal("saldoReal"));
                cuenta.setSaldoTemporal(rs.getBigDecimal("saldoTemporal"));
                listaClientes.add(cuenta);
            }
            statement.close();
            return listaClientes;

        } catch (Exception e) {
            System.out.println("Error al realizar la consulta de obtener "
                    + "todas las cuentas ahorra Automatico");
            throw (e);

        } finally {
            this.cerrarConexion();
        }
    }
    @Override
    public CuentaAhorroAutomaticoDTO crearCuentaAhorroAutomatico(CuentaAhorroAutomaticoDTO cuenta) throws Exception {
        CallableStatement preparedCall = null;
        try {
             String SQL = "{call crearCuentaAhorroAutomatico (?, ?, ?, ?, ?, ?, ?, ?, ?)}";
             preparedCall = conexion.prepareCall(SQL);
             preparedCall.setInt(1, cuenta.getIdCliente());
             preparedCall.setBigDecimal(2, cuenta.getSaldoTemporal());
             preparedCall.setBigDecimal(3, cuenta.getSaldoReal());
             preparedCall.setInt(4, cuenta.getTiempoDeducciones());
             preparedCall.setInt(5, cuenta.getTipoTiempo());
             preparedCall.setInt(6, cuenta.getTiempoAhorroMeses());
             preparedCall.setInt(7, cuenta.getNumCuentaDeduccion());
             preparedCall.setDouble(8, cuenta.getMontoAhorro());
             preparedCall.setInt(9, cuenta.getIdProposito());
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
    public CuentaAhorroAutomaticoDTO actualizarCuentaAhorroAutomatico(CuentaAhorroAutomaticoDTO cuenta) throws Exception {
        CallableStatement preparedCall = null;
        try {
            String SQL = "{call actualizarCuentaAhorroAutomatico (?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            preparedCall = conexion.prepareCall(SQL);
            preparedCall.setInt(1, cuenta.getNumCuenta());
            preparedCall.setInt(2, cuenta.getTiempoDeducciones());
            preparedCall.setInt(3, cuenta.getTipoTiempo());
            preparedCall.setInt(4, cuenta.getTiempoAhorroMeses());
            preparedCall.setInt(5, cuenta.getNumCuentaDeduccion());
            preparedCall.setDouble(6, cuenta.getMontoAhorro());
            preparedCall.setInt(7, cuenta.getIdProposito());
            preparedCall.setBigDecimal(8,cuenta.getSaldoReal());
            preparedCall.setBigDecimal(9,cuenta.getSaldoTemporal());
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
    public void eliminarCuentaAhorroAutomatico(int numCuenta) throws Exception {
        CallableStatement preparedCall = null;
        try {
            String SQL = "{call eliminarCuentaAhorroAutomatico (?)}";
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
    public int obtenerCantidadCuentasAhorroAutomatico(String entrada, int customerIF) {
         CallableStatement preparedCall = null;
        int cantidadCuentasAhorro = 0;
        try {
            String SQL = "{call obtenerCantidadCuentasAhorroAutomatico (?,?)}";
            preparedCall = conexion.prepareCall(SQL);
            preparedCall.setString(1, entrada);
            preparedCall.setInt(2, customerIF);
            preparedCall.executeQuery();
            ResultSet rs = preparedCall.getResultSet();
             while(rs.next()){
                 cantidadCuentasAhorro = rs.getInt(1);
             }
             statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            this.cerrarConexion();
        }
        return cantidadCuentasAhorro;
    }

   
}
