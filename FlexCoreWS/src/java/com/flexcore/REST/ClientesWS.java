/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.REST;

import com.flexcore.dao.ClienteDAO;
import com.flexcore.dto.ClienteDTO;
import com.flexcore.dto.ClienteFisicoDTO;
import com.flexcore.dto.ClienteJuridicoDTO;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author Oscar Montes
 */
@Path("clientes")
public class ClientesWS {

    @GET
    @Path("/getClientes")
    @Produces("application/json")
    public String getClientes() {
        String feeds = null;
        try {
            ClienteDAO cliente_dao = new ClienteDAO();
            ArrayList<ClienteDTO> feedData = null;
            feedData=cliente_dao.verClientes();
            Gson gson = new Gson();
            feeds = gson.toJson(feedData);
            
        } catch (Exception e) {
            System.out.println("No se pudo obtnener los clientes"); //Console 
        }
        return feeds;
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ClienteFisicoDTO create(ClienteFisicoDTO clienteNuevo) throws SQLException, NamingException, Exception {
        ClienteDAO cliente_dao = new ClienteDAO();
        return cliente_dao.crearClienteFisico(clienteNuevo);
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ClienteJuridicoDTO create(ClienteJuridicoDTO clienteNuevo) throws SQLException, NamingException, Exception {
        ClienteDAO cliente_dao = new ClienteDAO();
        return cliente_dao.crearClienteJuridico(clienteNuevo);
    }
    
    @POST
    @Path("/updateFisico")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ClienteFisicoDTO update(ClienteFisicoDTO cliente) throws SQLException, NamingException, Exception {
        ClienteDAO cliente_dao = new ClienteDAO();
        return cliente_dao.actualizarClienteFisico(cliente);
    }
    
    @POST
    @Path("/updateJuridico")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ClienteJuridicoDTO update(ClienteJuridicoDTO cliente) throws SQLException, NamingException, Exception {
        ClienteDAO cliente_dao = new ClienteDAO();
        return cliente_dao.actualizarClienteJuridico(cliente);
    }
}
