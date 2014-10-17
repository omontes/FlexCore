/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.dao;

import com.flexcore.connection_manager.ConnectionManager;
import com.flexcore.dao_interfaces.TransaccionesPagos;
import com.flexcore.dto.PagosDTO;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class PagosDAO extends ConnectionManager implements TransaccionesPagos {

    @Override
    public PagosDTO crearPago(PagosDTO pago) throws Exception {
        CallableStatement preparedCall = null;
        try {
             String SQL = "{call crearPago (?, ?, ?)}";
             preparedCall = conexion.prepareCall(SQL);
             preparedCall.setInt(1, pago.getIdCuentaOrigen());
             preparedCall.setInt(2, pago.getIdCuentaDestino());
             preparedCall.setDouble(3, pago.getMonto());
             preparedCall.executeUpdate();
             preparedCall.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            this.cerrarConexion();
        }
        return pago;
    }

    @Override
    public ArrayList<PagosDTO> verPagosDeCuentaDestino(int idCuentaDestino) throws Exception {
        CallableStatement preparedCall = null;
        ArrayList<PagosDTO> listaPagos = new ArrayList<>();
         try{
            String SQL = "{call verPagosEnviados(?)}";
            preparedCall = conexion.prepareCall(SQL);
            preparedCall.setInt(1, idCuentaDestino);
            preparedCall.executeQuery();
            ResultSet rs = preparedCall.getResultSet();
            while (rs.next()) {
                PagosDTO pago = new PagosDTO();
                pago.setIdCuentaOrigen(rs.getInt("idCuentaOrigen"));
                pago.setIdCuentaDestino(rs.getInt("idCuentaDestino"));
                pago.setIdPago(rs.getInt("idPago"));
                pago.setMonto(rs.getDouble("monto"));
                pago.setFecha(rs.getDate("fecha"));
                listaPagos.add(pago);
            }
            statement.close();
            return listaPagos;

        } catch (Exception e) {
            System.out.println("Error al realizar la consulta de obtener "
                    + "todas los pagos");
            throw (e);

        } finally {
            this.cerrarConexion();
        }
    }
    
}
