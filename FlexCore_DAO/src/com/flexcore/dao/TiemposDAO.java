/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.dao;

import com.flexcore.connection_manager.ConnectionManager;
import com.flexcore.dao_interfaces.TransaccionesTiempos;
import com.flexcore.dto.TiemposDTO;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Oscar Montes
 */
public class TiemposDAO extends ConnectionManager implements TransaccionesTiempos {

    @Override
    public ArrayList<TiemposDTO> verTiempos() throws Exception {
        ArrayList<TiemposDTO> listaTiempos = new ArrayList<TiemposDTO>();
        try{
            String consultarTiempos = this.leerSQL("/sqlfiles/consultarTiempos.sql");
            ResultSet rs = statement.executeQuery(consultarTiempos);
            while (rs.next()) {
                TiemposDTO tiempos = new TiemposDTO();
                tiempos.setIdTiempo(rs.getInt("idTiempo"));
                tiempos.setDescripcion(rs.getString("descripcion"));
                listaTiempos.add(tiempos);
            }
            statement.close();
            return listaTiempos;

        } catch (Exception e) {
            System.out.println("Error al realizar la consulta de obtener "
                    + "todos los tipos de tiempo");
            throw (e);

        } finally {
            this.cerrarConexion();
        }
    }
    
    
}
