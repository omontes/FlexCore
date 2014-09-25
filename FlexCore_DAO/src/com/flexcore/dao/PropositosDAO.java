/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.dao;

import com.flexcore.connection_manager.ConnectionManager;
import com.flexcore.dao_interfaces.TransaccionesPropositos;
import com.flexcore.dto.PropositosDTO;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Oscar Montes
 */
public class PropositosDAO extends ConnectionManager implements TransaccionesPropositos {

   @Override
    public ArrayList<PropositosDTO> verPropositos() throws Exception {
         ArrayList<PropositosDTO> listaPropositos = new ArrayList<PropositosDTO>();
        try{
            String consultarPropositos = this.leerSQL("/sqlfiles/consultarPropositos.sql");
            ResultSet rs = statement.executeQuery(consultarPropositos);
            while (rs.next()) {
                PropositosDTO proposito = new PropositosDTO();
                proposito.setIdcuentaPropositos(rs.getInt("idcuentaPropositos"));
                proposito.setDescripcion(rs.getString("descripcion"));
                listaPropositos.add(proposito);
            }
            statement.close();
            return listaPropositos;

        } catch (Exception e) {
            System.out.println("Error al realizar la consulta de obtener "
                    + "todos los propositos");
            throw (e);

        } finally {
            this.cerrarConexion();
        }
    }
   
    
}
