/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.dao;

import com.flexcore.connection_manager.ConnectionManager;
import com.flexcore.dao_interfaces.TransaccionesTransacciones;
import com.flexcore.dto.TransaccionesDTO;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class TransaccionesDAO extends ConnectionManager implements TransaccionesTransacciones{

    @Override
    public ArrayList<TransaccionesDTO> verTransacciones(int idCuenta) throws Exception {
        CallableStatement preparedCall = null;
        ArrayList<TransaccionesDTO> listaTransacciones = new ArrayList<>();
         try{
            String SQL = "{call obtenerTransacciones(?)}";
            preparedCall = conexion.prepareCall(SQL);
            preparedCall.setInt(1, idCuenta);
            preparedCall.executeQuery();
            ResultSet rs = preparedCall.getResultSet();
            while (rs.next()) {
                TransaccionesDTO transaccion = new TransaccionesDTO();
                transaccion.setNumCuenta(rs.getInt("numCuenta"));
                transaccion.setFecha(rs.getDate("fecha"));
                transaccion.setDescripcion(rs.getString("descripcion"));
                transaccion.setIdTransaccion(rs.getInt("idTransaccion"));
                listaTransacciones.add(transaccion);
            }
            statement.close();
            return listaTransacciones;

        } catch (Exception e) {
            System.out.println("Error al realizar la consulta de obtener "
                    + "todas las transacciones");
            throw (e);

        } finally {
            this.cerrarConexion();
        }
    }
    
}
