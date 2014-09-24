/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.REST;

import com.flexcore.dao.ClienteDAO;
import com.flexcore.dto.ClienteDTO;
import com.google.gson.Gson;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

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
}
