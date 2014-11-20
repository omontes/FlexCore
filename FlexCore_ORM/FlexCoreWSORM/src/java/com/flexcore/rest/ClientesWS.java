/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.rest;

import com.flexcore.dao_orm.ClienteDAO;
import com.flexcore.dto_hibernate.Clientefisico;
import com.flexcore.dto_hibernate.Clientejuridico;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
    @Path("/verificarCliente/{customerIF}")
    @Produces("application/json")
    public String verificarCliente(@PathParam("customerIF") int customerIF) {
        String feeds = null;
        try {
            ClienteDAO cliente_dao = new ClienteDAO();
            int feedData=cliente_dao.verificarCliente(customerIF);
            Gson gson = new Gson();
            feeds = gson.toJson(feedData);
            
        } catch (Exception e) {
            System.out.println("No se pudo verificar el cliente"); //Console 
        }
        return feeds;
    }
   
    @GET
    @Path("/getCantidadClientesFisicosBusqueda/{entrada}")
    @Produces("application/json")
    public String getCantidadClientesFisicosBusqueda(@PathParam("entrada") String entrada) {
        String feeds = null;
        try {
            ClienteDAO cliente_dao = new ClienteDAO();
            int feedData = cliente_dao.obtenerCantidadClientesFisicosBusqueda(entrada);
            Gson gson = new Gson();
            feeds = gson.toJson(feedData);
            
        } catch (Exception e) {
            System.out.println("No se pudo obtenener la cantidad de clientes"); //Console 
        }
        return feeds;
    }
    
    @GET
    @Path("/getCantidadClientesJuridicosBusqueda/{entrada}")
    @Produces("application/json")
    public String getCantidadClientesJuridicosBusqueda(@PathParam("entrada") String entrada) {
        String feeds = null;
        try {
            ClienteDAO cliente_dao = new ClienteDAO();
            int feedData = cliente_dao.obtenerCantidadClientesJuridicosBusqueda(entrada);
            Gson gson = new Gson();
            feeds = gson.toJson(feedData);
            
        } catch (Exception e) {
            System.out.println("No se pudo obtenener la cantidad de clientes"); //Console 
        }
        return feeds;
    }
  
    @GET
    @Path("/getClientesFisicosPaginadosBusqueda/{pagina}/{busqueda}")
    @Produces("application/json")
    public String getClientesFisicosPaginadosBusqueda(@PathParam("pagina") int pagina, @PathParam("busqueda") String entrada) {
        String feeds = null;
        try {
            ClienteDAO cliente_dao = new ClienteDAO();
            List<Clientefisico> feedData = null;
            feedData=cliente_dao.verClientesFisicosPaginadosBusqueda(pagina, entrada);
            Gson gson = new Gson();
            feeds = gson.toJson(feedData);
            
        } catch (Exception e) {
            System.out.println("No se pudo obtenener los clientes"); //Console 
        }
        return feeds;
    }
    
    @GET
    @Path("/getClientesJuridicosPaginadosBusqueda/{pagina}/{busqueda}")
    @Produces("application/json")
    public String getClientesJuridicosPaginadosBusqueda(@PathParam("pagina") int pagina, @PathParam("busqueda") String entrada) {
        String feeds = null;
        try {
            ClienteDAO cliente_dao = new ClienteDAO();
            List<Clientejuridico> feedData = null;
            feedData=cliente_dao.verClientesJuridicosPaginadosBusqueda(pagina, entrada);
            Gson gson = new Gson();
            feeds = gson.toJson(feedData);
            
        } catch (Exception e) {
            System.out.println("No se pudo obtenener los clientes"); //Console 
        }
        return feeds;
    }
    
    @POST
    @Path("/crearClientesFisicos")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Clientefisico create(Clientefisico clienteNuevo) throws SQLException, NamingException, Exception {
        ClienteDAO cliente_dao = new ClienteDAO();
        return cliente_dao.crearClienteFisico(clienteNuevo);
    }
    
    @POST
    @Path("/crearClientesJuridicos")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Clientejuridico create(Clientejuridico clienteNuevo) throws SQLException, NamingException, Exception {
        System.out.println("sdas");
        ClienteDAO cliente_dao = new ClienteDAO();
        return cliente_dao.crearClienteJuridico(clienteNuevo);
    }
    
    @POST
    @Path("/updateFisico")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Clientefisico update(Clientefisico cliente) throws SQLException, NamingException, Exception {
        ClienteDAO cliente_dao = new ClienteDAO();
        return cliente_dao.actualizarClienteFisico(cliente);
    }
    
    @POST
    @Path("/updateJuridico")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Clientejuridico update(Clientejuridico cliente) throws SQLException, NamingException, Exception {
        ClienteDAO cliente_dao = new ClienteDAO();
        return cliente_dao.actualizarClienteJuridico(cliente);
    }
    
    @DELETE 
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void deleteCliente(@PathParam("id") int id) throws SQLException, NamingException, Exception {
		ClienteDAO cliente_dao = new ClienteDAO();
                cliente_dao.eliminarCliente(id);
	}
}
