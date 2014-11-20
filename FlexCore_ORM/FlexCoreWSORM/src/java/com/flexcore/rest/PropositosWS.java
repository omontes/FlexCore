/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flexcore.rest;

import com.flexcore.dao_orm.PropositosDAO;
import com.flexcore.dto_hibernate.Propositos;
import com.flexcore.hibernate.config.PropositosAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
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
    public String getPropositos() {
        String feeds = null;
        try {
            PropositosDAO proposito_dao = new PropositosDAO();
            List<Propositos> feedData = proposito_dao.verPropositos();
            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.registerTypeAdapter
        (Propositos.class, new PropositosAdapter()).create();
            feeds = gson.toJson(feedData);
            

        } catch (Exception e) {
            System.out.println("No se pudo obtnener los propositos");  
        }
        return feeds;
    }
}
