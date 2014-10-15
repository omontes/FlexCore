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
             String SQL = "{call crearClienteFisico (?, ?, ?, ?, ?, ?, ?, ?, ?)}";
             preparedCall = conexion.prepareCall(SQL);
             preparedCall.setString(1, cliente.getNombre());
             preparedCall.setString(2, cliente.getDireccion());
             preparedCall.setInt(3, cliente.getTelCasa());
             preparedCall.setInt(4, cliente.getTelOficina());
             preparedCall.setInt(5, cliente.getCelular());
             preparedCall.setInt(6, cliente.getCedula());
             preparedCall.setString(7, cliente.getFotografia());
             preparedCall.setString(8, cliente.getPrimerApellido());
             preparedCall.setString(9, cliente.getSegundoApellido());
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
             String SQL = "{call crearClienteJuridico (?, ?, ?, ?, ?, ?)}";
             preparedCall = conexion.prepareCall(SQL);
             preparedCall.setString(1, cliente.getNombre());
             preparedCall.setString(2, cliente.getDireccion());
             preparedCall.setInt(3, cliente.getTelCasa());
             preparedCall.setInt(4, cliente.getTelOficina());
             preparedCall.setInt(5, cliente.getCelular());
             preparedCall.setInt(6, cliente.getCedulaJuridica());
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

    @Override
    public void eliminarCliente(int idCliente) throws Exception {
        CallableStatement preparedCall = null;
        try {
            String SQL = "{call eliminarCliente (?)}";
            preparedCall = conexion.prepareCall(SQL);
            preparedCall.setInt(1, idCliente);
            preparedCall.executeUpdate();
            preparedCall.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
	       } finally {
            this.cerrarConexion();
        }
    }

    @Override
    public ArrayList<ClienteFisicoDTO> verClientesFisicos() throws Exception {
         ArrayList<ClienteFisicoDTO> listaClientes = new ArrayList<>();
         CallableStatement preparedCall = null;
         try{
            String SQL = "{call obtenerClientesFisicos ()}";
            ResultSet rs = statement.executeQuery(SQL);
            while (rs.next()) {
                ClienteFisicoDTO cliente = new ClienteFisicoDTO();
                cliente.setCustomerIF(rs.getInt("customerIF"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setTelCasa(rs.getInt("telCasa"));
                cliente.setTelOficina(rs.getInt("telOficina"));
                cliente.setCelular(rs.getInt("celular"));
                cliente.setCedula(rs.getInt("cedula"));
                cliente.setFotografia(rs.getString("fotografia"));
                cliente.setPrimerApellido(rs.getString("primerApellido"));
                cliente.setSegundoApellido(rs.getString("segundoApellido"));
                listaClientes.add(cliente);
            }
            statement.close();
            return listaClientes;

        } catch (Exception e) {
            System.out.println("Error al realizar la consulta de obtener "
                    + "todos los clientes fisicos");
            throw (e);

        } finally {
            this.cerrarConexion();
        }
    }

    @Override
    public ArrayList<ClienteJuridicoDTO> verClientesJuridicos() throws Exception {
        ArrayList<ClienteJuridicoDTO> listaClientes = new ArrayList<>();
         CallableStatement preparedCall = null;
         try{
            String SQL = "{call obtenerClientesJuridicos ()}";
            ResultSet rs = statement.executeQuery(SQL);
            while (rs.next()) {
                ClienteJuridicoDTO cliente = new ClienteJuridicoDTO();
                cliente.setCustomerIF(rs.getInt("customerIF"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setTelCasa(rs.getInt("telCasa"));
                cliente.setTelOficina(rs.getInt("telOficina"));
                cliente.setCelular(rs.getInt("celular"));
                cliente.setCedulaJuridica(rs.getInt("cedulaJuridica"));
                listaClientes.add(cliente);
            }
            statement.close();
            return listaClientes;

        } catch (Exception e) {
            System.out.println("Error al realizar la consulta de obtener "
                    + "todos los clientes juridico");
            throw (e);

        } finally {
            this.cerrarConexion();
        }
    }

    @Override
    public int obtenerCantidadClientesFisicos() throws Exception {
        int cantidadClientes = 0;
        try {
             String SQL = "{call obtenerCantidadClientesFisicos ()}";
             ResultSet rs = statement.executeQuery(SQL);
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

    @Override
    public int obtenerCantidadClientesJuridicos() throws Exception {
        int cantidadClientes = 0;
        try {
             String SQL = "{call obtenerCantidadClientesJuridicos ()}";
             ResultSet rs = statement.executeQuery(SQL);
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

    @Override
    public ArrayList<ClienteFisicoDTO> verClientesFisicosPaginados(int pagina) throws Exception {
        CallableStatement preparedCall = null;
        ArrayList<ClienteFisicoDTO> listaClientes = new ArrayList<>();
         try{
            int datoInicial = (pagina - 1)*10;
            int datoFinal = pagina*10;
            String SQL = "{call obtenerClientesFisicosPaginados (?, ?)}";
            preparedCall = conexion.prepareCall(SQL);
            preparedCall.setInt(1, datoInicial);
            preparedCall.setInt(2, datoFinal);
            preparedCall.executeQuery();
            ResultSet rs = preparedCall.getResultSet();
            while (rs.next()) {
                ClienteFisicoDTO cliente = new ClienteFisicoDTO();
                cliente.setCustomerIF(rs.getInt("customerIF"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setTelCasa(rs.getInt("telCasa"));
                cliente.setTelOficina(rs.getInt("telOficina"));
                cliente.setCelular(rs.getInt("celular"));
                cliente.setCedula(rs.getInt("cedula"));
                cliente.setFotografia(rs.getString("fotografia"));
                cliente.setPrimerApellido(rs.getString("primerApellido"));
                cliente.setSegundoApellido(rs.getString("segundoApellido"));
                listaClientes.add(cliente);
            }
            statement.close();
            return listaClientes;

        } catch (Exception e) {
            System.out.println("Error al realizar la consulta de obtener "
                    + "todos los clientes fisicos");
            throw (e);

        } finally {
            this.cerrarConexion();
        }
    }

    @Override
    public ArrayList<ClienteJuridicoDTO> verClientesJuridicosPaginados(int pagina) throws Exception {
        CallableStatement preparedCall = null;
        ArrayList<ClienteJuridicoDTO> listaClientes = new ArrayList<>();
         try{
            int datoInicial = (pagina - 1)*10;
            int datoFinal = pagina*10;
            String SQL = "{call obtenerClientesJuridicosPaginados (?, ?)}";
            preparedCall = conexion.prepareCall(SQL);
            preparedCall.setInt(1, datoInicial);
            preparedCall.setInt(2, datoFinal);
            preparedCall.executeQuery();
            ResultSet rs = preparedCall.getResultSet();
            while (rs.next()) {
                ClienteJuridicoDTO cliente = new ClienteJuridicoDTO();
                cliente.setCustomerIF(rs.getInt("customerIF"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setTelCasa(rs.getInt("telCasa"));
                cliente.setTelOficina(rs.getInt("telOficina"));
                cliente.setCelular(rs.getInt("celular"));
                cliente.setCedulaJuridica(rs.getInt("cedulaJuridica"));
                listaClientes.add(cliente);
            }
            statement.close();
            return listaClientes;

        } catch (Exception e) {
            System.out.println("Error al realizar la consulta de obtener "
                    + "todos los clientes juridicos");
            throw (e);

        } finally {
            this.cerrarConexion();
        }
    }

    @Override
    public ArrayList<ClienteFisicoDTO> verClientesFisicosPaginadosBusqueda(int pagina, String entrada) throws Exception {
        CallableStatement preparedCall = null;
        ArrayList<ClienteFisicoDTO> listaClientes = new ArrayList<>();
         try{
            int datoInicial = (pagina - 1)*10;
            int datoFinal = pagina*10;
            String SQL = "{call obtenerClientesFisicosBusquedaPaginado (?, ?, ?)}";
            preparedCall = conexion.prepareCall(SQL);
            preparedCall.setInt(1, datoInicial);
            preparedCall.setInt(2, datoFinal);
            preparedCall.setString(3, entrada);
            preparedCall.executeQuery();
            ResultSet rs = preparedCall.getResultSet();
            while (rs.next()) {
                ClienteFisicoDTO cliente = new ClienteFisicoDTO();
                cliente.setCustomerIF(rs.getInt("customerIF"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setTelCasa(rs.getInt("telCasa"));
                cliente.setTelOficina(rs.getInt("telOficina"));
                cliente.setCelular(rs.getInt("celular"));
                cliente.setCedula(rs.getInt("cedula"));
                cliente.setFotografia(rs.getString("fotografia"));
                cliente.setPrimerApellido(rs.getString("primerApellido"));
                cliente.setSegundoApellido(rs.getString("segundoApellido"));
                listaClientes.add(cliente);
            }
            statement.close();
            return listaClientes;

        } catch (Exception e) {
            System.out.println("Error al realizar la consulta de obtener "
                    + "todos los clientes fisicos");
            throw (e);

        } finally {
            this.cerrarConexion();
        }
    }

    @Override
    public ArrayList<ClienteJuridicoDTO> verClientesJuridicosPaginadosBusqueda(int pagina, String entrada) throws Exception {
        CallableStatement preparedCall = null;
        ArrayList<ClienteJuridicoDTO> listaClientes = new ArrayList<>();
         try{
            int datoInicial = (pagina - 1)*10;
            int datoFinal = pagina*10;
            String SQL = "{call obtenerClientesJuridicosBusquedaPaginado (?, ?, ?)}";
            preparedCall = conexion.prepareCall(SQL);
            preparedCall.setInt(1, datoInicial);
            preparedCall.setInt(2, datoFinal);
            preparedCall.setString(3, entrada);
            preparedCall.executeQuery();
            ResultSet rs = preparedCall.getResultSet();
            while (rs.next()) {
                ClienteJuridicoDTO cliente = new ClienteJuridicoDTO();
                cliente.setCustomerIF(rs.getInt("customerIF"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setTelCasa(rs.getInt("telCasa"));
                cliente.setTelOficina(rs.getInt("telOficina"));
                cliente.setCelular(rs.getInt("celular"));
                cliente.setCedulaJuridica(rs.getInt("cedulaJuridica"));
                listaClientes.add(cliente);
            }
            statement.close();
            return listaClientes;

        } catch (Exception e) {
            System.out.println("Error al realizar la consulta de obtener "
                    + "todos los clientes juridicos");
            throw (e);

        } finally {
            this.cerrarConexion();
        }
    }

    @Override
    public int obtenerCantidadClientesFisicosBusqueda(String entrada) throws Exception {
        CallableStatement preparedCall = null;
        int cantidadClientes = 0;
        try {
            String SQL = "{call obtenerCantidadClientesFisicosBusqueda (?)}";
            preparedCall = conexion.prepareCall(SQL);
            preparedCall.setString(1, entrada);
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

    @Override
    public int obtenerCantidadClientesJuridicosBusqueda(String entrada) throws Exception {
        CallableStatement preparedCall = null;
        int cantidadClientes = 0;
        try {
            String SQL = "{call obtenerCantidadClientesJuridicosBusqueda (?)}";
            preparedCall = conexion.prepareCall(SQL);
            preparedCall.setString(1, entrada);
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
