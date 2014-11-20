/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.rest;

import com.flexcore.dao_orm.TiemposDAO;
import com.flexcore.dto_hibernate.Tipostiempo;
import com.flexcore.hibernate.config.TipostiempoAdapter;
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
@Path("tiempos")
public class TiemposWS {

    @GET
    @Path("/getTiempos")
    @Produces("application/json")
    public String getTiempos() {
        String feeds = null;
        try {
            TiemposDAO tiemposDao = new TiemposDAO();

            List<Tipostiempo> feedData = null;
            feedData = tiemposDao.verTiempos();
            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.registerTypeAdapter
        (Tipostiempo.class, new TipostiempoAdapter()).create();
            feeds = gson.toJson(feedData);

        } catch (Exception e) {
            System.out.println("No se pudo obtnener los tipos tiempo");
          
        }
        return feeds;
    }

}
