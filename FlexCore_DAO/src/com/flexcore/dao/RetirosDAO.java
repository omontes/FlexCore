/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.dao;

import com.flexcore.connection_manager.ConnectionManager;
import com.flexcore.dao_interfaces.TransaccionesRetiros;
import com.flexcore.dto.RetirosDTO;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class RetirosDAO extends ConnectionManager implements TransaccionesRetiros {

    @Override
    public RetirosDTO crearRetiro(RetirosDTO retiro) throws Exception {
        CallableStatement preparedCall = null;
        try {
             String SQL = "{call crearRetiro (?, ?, ?, ?)}";
             preparedCall = conexion.prepareCall(SQL);
             preparedCall.setInt(1, retiro.getIdRetiro());
             preparedCall.setDouble(2, retiro.getMonto());
             preparedCall.setDate(3, retiro.getFecha());
             preparedCall.setInt(4, retiro.getIdCuenta());
             preparedCall.executeUpdate();
             preparedCall.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            this.cerrarConexion();
        }
        return retiro;
    }

    @Override
    public ArrayList<RetirosDTO> verRetiros(int idCuenta) throws Exception {
        CallableStatement preparedCall = null;
        ArrayList<RetirosDTO> listaRetiros = new ArrayList<>();
         try{
            String SQL = "{call verRetiros(?)}";
            preparedCall = conexion.prepareCall(SQL);
            preparedCall.setInt(1, idCuenta);
            preparedCall.executeQuery();
            ResultSet rs = preparedCall.getResultSet();
            while (rs.next()) {
                RetirosDTO retiro = new RetirosDTO();
                retiro.setIdRetiro(rs.getInt("idRetiro"));
                retiro.setMonto(rs.getDouble("monto"));
                retiro.setFecha(rs.getDate("fecha"));
                retiro.setIdCuenta(rs.getInt("idCuenta"));
                listaRetiros.add(retiro);
            }
            statement.close();
            return listaRetiros;

        } catch (Exception e) {
            System.out.println("Error al realizar la consulta de obtener "
                    + "todas los retiros");
            throw (e);

        } finally {
            this.cerrarConexion();
        }
    }
    
}
