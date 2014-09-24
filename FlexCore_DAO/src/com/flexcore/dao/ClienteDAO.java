/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.dao;

import com.flexcore.connection_manager.ConnectionManager;
import com.flexcore.dao_interfaces.TransaccionesCliente;
import com.flexcore.dto.ClienteDTO;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Oscar Montes
 */
public class ClienteDAO extends ConnectionManager implements TransaccionesCliente {

    @Override
    public ArrayList<ClienteDTO> verClientes() throws Exception {
         ArrayList<ClienteDTO> listaClientes = new ArrayList<ClienteDTO>();
        try{
            String consultarClientes = this.leerSQL("/sqlfiles/consultarClientes.sql");
            ResultSet rs = statement.executeQuery(consultarClientes);
            while (rs.next()) {
                ClienteDTO cliente = new ClienteDTO();
                cliente.setIdCliente(rs.getInt("idCliente"));
                listaClientes.add(cliente);
            }
            statement.close();
            return listaClientes;

        } catch (Exception e) {
            System.out.println("Error al realizar la consulta de obtener "
                    + "todos los clientes");
            throw (e);

        } finally {
            this.cerrarConexion();
        }
    }
    
}
