/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.REST;

import com.flexcore.dao.CuentaDAO;
import com.flexcore.dto.CuentaDTO;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.ArrayList;
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
 * @author Carlos
 */
@Path("cuenta")
public class CuentaWS {

    @GET
    @Path("/getCuentas")
    @Produces("application/json")
    public String getClientes() {
        String feeds = null;
        try {
            CuentaDAO cuenta_dao = new CuentaDAO();
            ArrayList<CuentaDTO> feedData = null;
            feedData=cuenta_dao.verCuentas();
            Gson gson = new Gson();
            feeds = gson.toJson(feedData);
            
        } catch (Exception e) {
            System.out.println("No se pudo obtnener las cuentas"); //Console 
        }
        return feeds;
    }

    @POST
    @Path("/crearCuenta")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public CuentaDTO create(CuentaDTO cuenta) throws SQLException, NamingException, Exception {
        CuentaDAO cuenta_dao = new CuentaDAO();
        return cuenta_dao.crearCuenta(cuenta);
    }
    
    @POST
    @Path("/updateCuenta")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public CuentaDTO update(CuentaDTO cuenta) throws SQLException, NamingException, Exception {
        CuentaDAO cuenta_dao = new CuentaDAO();
        return cuenta_dao.actualizarCuenta(cuenta);
    }
    
    @DELETE 
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void deleteCuentaAhorroVista(@PathParam("id") int numCuenta) throws SQLException, NamingException, Exception {
		CuentaDAO cuenta_dao = new CuentaDAO();
                cuenta_dao.eliminarCuenta(numCuenta);
    }
}
