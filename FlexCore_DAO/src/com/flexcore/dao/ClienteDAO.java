/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.dao;

import com.flexcore.connection_manager.ConnectionManager;
import com.flexcore.dao_interfaces.TransaccionesCliente;
import com.flexcore.dto.ClienteDTO;
import com.flexcore.dto.ClienteFisicoDTO;
import com.flexcore.dto.ClienteJuridicoDTO;
import java.sql.CallableStatement;
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
                cliente.setCustomerIF(rs.getInt("idCliente"));
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

    @Override
    public ClienteFisicoDTO crearClienteFisico(ClienteFisicoDTO cliente) throws Exception {
        CallableStatement preparedCall = null;
         try {
             String SQL = "{call crearClienteFisico (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
             preparedCall = conexion.prepareCall(SQL);
             preparedCall.setInt(1, cliente.getCustomerIF());
             preparedCall.setString(2, cliente.getNombre());
             preparedCall.setString(3, cliente.getDireccion());
             preparedCall.setInt(4, cliente.getTelCasa());
             preparedCall.setInt(5, cliente.getTelOficina());
             preparedCall.setInt(6, cliente.getCelular());
             preparedCall.setInt(7, cliente.getCedula());
             preparedCall.setString(8, cliente.getFotografia());
             preparedCall.setString(9, cliente.getPrimerApellido());
             preparedCall.setString(10, cliente.getSegundoApellido());
             preparedCall.executeUpdate();
             preparedCall.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            this.cerrarConexion();
        }
        return cliente;
    }

    @Override
    public ClienteJuridicoDTO crearClienteJuridico(ClienteJuridicoDTO cliente) throws Exception {
        CallableStatement preparedCall = null;
        try {
             String SQL = "{call crearClienteJuridico (?, ?, ?, ?, ?, ?, ?)}";
             preparedCall = conexion.prepareCall(SQL);
             preparedCall.setInt(1, cliente.getCustomerIF());
             preparedCall.setString(2, cliente.getNombre());
             preparedCall.setString(3, cliente.getDireccion());
             preparedCall.setInt(4, cliente.getTelCasa());
             preparedCall.setInt(5, cliente.getTelOficina());
             preparedCall.setInt(6, cliente.getCelular());
             preparedCall.setInt(7, cliente.getCedulaJuridica());
             preparedCall.executeUpdate();
             preparedCall.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            this.cerrarConexion();
        }
        return cliente;
    }

    @Override
    public ClienteFisicoDTO actualizarClienteFisico(ClienteFisicoDTO cliente) throws Exception { 
        CallableStatement preparedCall = null;
        try {
            String SQL = "{call actualizarClienteFisico (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            preparedCall = conexion.prepareCall(SQL);
            preparedCall.setInt(1, cliente.getCustomerIF());
            preparedCall.setString(2, cliente.getNombre());
            preparedCall.setString(3, cliente.getDireccion());
            preparedCall.setInt(4, cliente.getTelCasa());
            preparedCall.setInt(5, cliente.getTelOficina());
            preparedCall.setInt(6, cliente.getCelular());
            preparedCall.setInt(7, cliente.getCedula());
            preparedCall.setString(8, cliente.getFotografia());
            preparedCall.setString(9, cliente.getPrimerApellido());
            preparedCall.setString(10, cliente.getSegundoApellido());
            preparedCall.executeUpdate();
            preparedCall.close();
        }
    catch (Exception e) {
            e.printStackTrace();
        throw new RuntimeException(e);
    }finally {
            this.cerrarConexion();
    }
    return cliente ;
    }

    @Override
    public ClienteJuridicoDTO actualizarClienteJuridico(ClienteJuridicoDTO cliente) throws Exception {
        CallableStatement preparedCall = null;
        try {
            String SQL = "{call actualizarClienteJuridico (?, ?, ?, ?, ?, ?, ?)}";
            preparedCall = conexion.prepareCall(SQL);
            preparedCall.setInt(1, cliente.getCustomerIF());
            preparedCall.setString(2, cliente.getNombre());
            preparedCall.setString(3, cliente.getDireccion());
            preparedCall.setInt(4, cliente.getTelCasa());
            preparedCall.setInt(5, cliente.getTelOficina());
            preparedCall.setInt(6, cliente.getCelular());
            preparedCall.setInt(7, cliente.getCedulaJuridica());
            preparedCall.executeUpdate();
            preparedCall.close();
        }
    catch (Exception e) {
            e.printStackTrace();
        throw new RuntimeException(e);
    }finally {
            this.cerrarConexion();
    }
    return cliente ;
    }

    
}
