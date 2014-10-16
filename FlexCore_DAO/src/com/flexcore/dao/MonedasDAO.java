/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.dao;

import com.flexcore.connection_manager.ConnectionManager;
import com.flexcore.dao_interfaces.TransaccionesMonedas;
import com.flexcore.dto.MonedasDTO;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Oscar Montes
 */
public class MonedasDAO extends ConnectionManager implements TransaccionesMonedas {

    @Override
    public ArrayList<MonedasDTO> verMonedas() throws Exception {
        ArrayList<MonedasDTO> listaMonedas = new ArrayList<MonedasDTO>();
        try{
            String consultarMonedas = this.leerSQL("/sqlfiles/consultarMonedas.sql");
            ResultSet rs = statement.executeQuery(consultarMonedas);
            while (rs.next()) {
                MonedasDTO moneda = new MonedasDTO();
                moneda.setIdMoneda(rs.getInt("idMoneda"));
                moneda.setDescripcion(rs.getString("descripcion"));
                listaMonedas.add(moneda);
            }
            statement.close();
            return listaMonedas;

        } catch (Exception e) {
            System.out.println("Error al realizar la consulta de obtener "
                    + "todas las monedas");
            throw (e);

        } finally {
            this.cerrarConexion();
        }
    }
    
}
