/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.REST;

import com.flexcore.dao.RetirosDAO;
import com.flexcore.dto.RetirosDTO;
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
 * @author Carlos
 */
@Path("retiros")
public class RetirosWS {
    @POST
    @Path("/crearRetiro")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public RetirosDTO create(RetirosDTO retiro) throws SQLException, NamingException, Exception {
        RetirosDAO retiro_dao = new RetirosDAO();
        return retiro_dao.crearRetiro(retiro);
    }
    
    @GET
    @Path("/verRetiros")
    @Produces("application/json")
    public String getClientes(int idCuenta) {
        String feeds = null;
        try {
            RetirosDAO pagos_dao = new RetirosDAO();
            ArrayList<RetirosDTO> feedData = null;
            feedData=pagos_dao.verRetiros(idCuenta);
            Gson gson = new Gson();
            feeds = gson.toJson(feedData);
            
        } catch (Exception e) {
            System.out.println("No se pudo obtnener los retiros"); //Console 
        }
        return feeds;
    }
}
