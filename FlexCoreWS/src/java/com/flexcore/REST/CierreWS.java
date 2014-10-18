/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.REST;

import com.flexcore.dao.CierreDAO;
import com.flexcore.dto.CierreDTO;
import java.sql.SQLException;
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
@Path("cierre")
public class CierreWS {
    
    @POST
    @Path("/crearCierre")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public CierreDTO create(CierreDTO cierre) throws SQLException, NamingException, Exception {
        CierreDAO cierre_dao = new CierreDAO();
        cierre_dao.crearCierre(cierre);
        return null;
    }
    
    @POST
    @Path("/cerrarCierre")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public CierreDTO cerrar(CierreDTO cierre) throws SQLException, NamingException, Exception {
        CierreDAO cierre_dao = new CierreDAO();
        cierre_dao.cerrarCierre(cierre);
        return null;
    }
}
