/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.rest;

import com.flexcore.dao_orm.MonedasDAO;
import com.flexcore.dto_hibernate.Moneda;
import com.flexcore.hibernate.config.MonedaAdapter;
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
@Path("monedas")
public class MonedasWS {

    @GET
    @Path("/getMonedas")
    @Produces("application/json")
    public String getMonedas() {
        String feeds = null;
        try {
            MonedasDAO moneda_dao = new MonedasDAO();
            List<Moneda> feedData = null;
            feedData = moneda_dao.verMonedas();
            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.registerTypeAdapter
            (Moneda.class, new MonedaAdapter()).create();
            feeds = gson.toJson(feedData);

        } catch (Exception e) {
            System.out.println("No se pudo obtnener las monedas"); //Console 
        }
        return feeds;
    }
}
