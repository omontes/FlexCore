/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flexcore.REST;

import com.flexcore.dao.PropositosDAO;
import com.flexcore.dto.PropositosDTO;
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
@Path("propositos")
public class PropositosWS {

    @GET
    @Path("/getPropositos")
    @Produces("application/json")
    public String getClientes() {
        String feeds = null;
        try {
            PropositosDAO cliente_dao = new PropositosDAO();
            ArrayList<PropositosDTO> feedData = null;
            feedData = cliente_dao.verPropositos();
            Gson gson = new Gson();
            feeds = gson.toJson(feedData);

        } catch (Exception e) {
            System.out.println("No se pudo obtnener los propositos"); //Console 
        }
        return feeds;
    }
}
