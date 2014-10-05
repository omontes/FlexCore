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
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class CuentaAhorroAutomaticoDAO extends ConnectionManager implements TransaccionesCuentaAhorroAutomatico {
    
    @Override
    public ArrayList<CuentaAhorroAutomaticoDTO> verCuentasAhorroAutomatico() throws Exception {
         ArrayList<CuentaAhorroAutomaticoDTO> listaClientes = new ArrayList<>();
         CallableStatement preparedCall = null;
         try{
            String SQL = "{call obtenerCuentasAhorroAutomatico()}";
            ResultSet rs = statement.executeQuery(SQL);
            while (rs.next()) {
                CuentaAhorroAutomaticoDTO cuenta = new CuentaAhorroAutomaticoDTO();
                cuenta.setNumCuenta(rs.getInt("numCuenta"));
                cuenta.setTiempoDeducciones(rs.getInt("tiempoDeducciones"));
                cuenta.setTipoTiempo(rs.getInt("tipoTiempo"));
                cuenta.setFechaInicio(rs.getDate("fechaInicio"));
                cuenta.setTiempoAhorroMeses(rs.getInt("tiempoAhorroMeses"));
                cuenta.setNumCuentaDeduccion(rs.getInt("numCuentaDeduccion"));
                cuenta.setMontoAhorro(rs.getDouble("montoAhorro"));
                cuenta.setEstadoAhorro(rs.getBoolean("estadoAhorro"));
                cuenta.setFechaUltimaActualizacion(rs.getDate("fechaUltimaActualizacion"));
                cuenta.setIdProposito(rs.getInt("idProposito"));
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
             String SQL = "{call crearCuentaAhorroAutomatico (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
             preparedCall = conexion.prepareCall(SQL);
             preparedCall.setInt(1, cuenta.getNumCuenta());
             preparedCall.setInt(2, cuenta.getTiempoDeducciones());
             preparedCall.setInt(3, cuenta.getTipoTiempo());
             preparedCall.setDate(4, cuenta.getFechaInicio());
             preparedCall.setInt(5, cuenta.getTiempoAhorroMeses());
             preparedCall.setInt(6, cuenta.getNumCuentaDeduccion());
             preparedCall.setDouble(7, cuenta.getMontoAhorro());
             preparedCall.setBoolean(8, cuenta.isEstadoAhorro());
             preparedCall.setDate(9, cuenta.getFechaUltimaActualizacion());
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
            String SQL = "{call actualizarCuentaAhorroAutomatico (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            preparedCall = conexion.prepareCall(SQL);
            preparedCall.setInt(1, cuenta.getNumCuenta());
            preparedCall.setInt(2, cuenta.getTiempoDeducciones());
            preparedCall.setInt(3, cuenta.getTipoTiempo());
            preparedCall.setDate(4, cuenta.getFechaInicio());
            preparedCall.setInt(5, cuenta.getTiempoAhorroMeses());
            preparedCall.setInt(6, cuenta.getNumCuentaDeduccion());
            preparedCall.setDouble(7, cuenta.getMontoAhorro());
            preparedCall.setBoolean(8, cuenta.isEstadoAhorro());
            preparedCall.setDate(9, cuenta.getFechaUltimaActualizacion());
            preparedCall.setInt(10, cuenta.getIdProposito());
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
}
