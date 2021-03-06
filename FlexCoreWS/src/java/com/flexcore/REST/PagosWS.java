/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.REST;

import com.flexcore.dao.PagosDAO;
import com.flexcore.dto.PagosDTO;
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
@Path("pagos")
public class PagosWS {
    
    @POST
    @Path("/crearPago")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public PagosDTO create(PagosDTO pago) throws SQLException, NamingException, Exception {
        PagosDAO pago_dao = new PagosDAO();
        return pago_dao.crearPago(pago);
    }
    
    @GET
    @Path("/verPagosDestino")
    @Produces("application/json")
    public String getClientes(int idCuentaDestino) {
        String feeds = null;
        try {
            PagosDAO pagos_dao = new PagosDAO();
            ArrayList<PagosDTO> feedData = null;
            feedData=pagos_dao.verPagosDeCuentaDestino(idCuentaDestino);
            Gson gson = new Gson();
            feeds = gson.toJson(feedData);
            
        } catch (Exception e) {
            System.out.println("No se pudo obtnener los pagos"); //Console 
        }
        return feeds;
    }
}
