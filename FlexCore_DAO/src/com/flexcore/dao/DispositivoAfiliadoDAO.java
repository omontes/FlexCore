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
import java.sql.ResultSet;
import java.util.ArrayList;

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

    @Override
    public int obtenerTarjeta(String entrada) {
        CallableStatement preparedCall = null;
        int numTarjeta = 0;
        try {
            String SQL = "{call DispositivoCuenta (?)}";
            preparedCall = conexion.prepareCall(SQL);
            preparedCall.setString(1, entrada);
            preparedCall.executeQuery();
            ResultSet rs = preparedCall.getResultSet();
             while(rs.next()){
                 numTarjeta = rs.getInt(1);
             }
             statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            this.cerrarConexion();
        }
        return numTarjeta;
        
    }

    @Override
    public ArrayList<DispositivoAfiliadoDTO> obtenerDispositivos() throws Exception {
        CallableStatement preparedCall = null;
        ArrayList<DispositivoAfiliadoDTO> listaDispositivos = new ArrayList<>();
         try{
            String SQL = "{call obtenerDispositivos ()}";
            preparedCall = conexion.prepareCall(SQL);
            preparedCall.executeQuery();
            ResultSet rs = preparedCall.getResultSet();
            while (rs.next()) {
                DispositivoAfiliadoDTO tarjeta = new DispositivoAfiliadoDTO();
                tarjeta.setIdTarjeta(rs.getInt("idTarjeta"));
                tarjeta.setIdCuenta(rs.getInt("idCuenta"));
                tarjeta.setEstado(rs.getBoolean("Estado"));
                listaDispositivos.add(tarjeta);
            }
            statement.close();
            return listaDispositivos;

        } catch (Exception e) {
            System.out.println("Error al realizar la consulta de obtener "
                    + "todos los clientes fisicos");
            throw (e);

        } finally {
            this.cerrarConexion();
        }
    }

    @Override
    public int obtenerCantidadTarjetas(int cliente) throws Exception {
        CallableStatement preparedCall = null;
        int cantidadClientes = 0;
        try {
             String SQL = "{call obtenerCantidadDispositivos(?)}";
             preparedCall = conexion.prepareCall(SQL);
             preparedCall.setInt(1, cliente);
             preparedCall.executeQuery();
             ResultSet rs = preparedCall.getResultSet();
             while(rs.next()){
                 cantidadClientes = rs.getInt(1);
             }
             statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            this.cerrarConexion();
        }
        return cantidadClientes;
    }
    
}
