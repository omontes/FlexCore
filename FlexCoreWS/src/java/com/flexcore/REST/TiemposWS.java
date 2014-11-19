/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.REST;

import com.flexcore.dao.TiemposDAO;
import com.flexcore.dto.TiemposDTO;
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
@Path("tiempos")
public class TiemposWS {

     @GET
    @Path("/getTiempos")
    @Produces("application/json")
    public String getTiempos() {
        String feeds = null;
        try {
            TiemposDAO tiempos_dao = new TiemposDAO();
            ArrayList<TiemposDTO> feedData = null;
            feedData = tiempos_dao.verTiempos();
            Gson gson = new Gson();
            feeds = gson.toJson(feedData);

        } catch (Exception e) {
            System.out.println("No se pudo obtnener los tipos tiempo"); //Console 
        }
        return feeds;
    }
}
