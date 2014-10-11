/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.REST;

import com.flexcore.dao.TransaccionesDAO;
import com.flexcore.dto.TransaccionesDTO;
import com.google.gson.Gson;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author Carlos
 */
@Path("transacciones")
public class TransaccionesWS {

    @GET
    @Path("/verTransacciones")
    @Produces("application/json")
    public String getTransacciones(int idCuenta) {
        String feeds = null;
        try {
            TransaccionesDAO transacciones_dao = new TransaccionesDAO();
            ArrayList<TransaccionesDTO> feedData = null;
            feedData=transacciones_dao.verTransacciones(idCuenta);
            Gson gson = new Gson();
            feeds = gson.toJson(feedData);
            
        } catch (Exception e) {
            System.out.println("No se pudo obtnener los transacciones"); //Console 
        }
        return feeds;
    }
}
