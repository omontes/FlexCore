/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.REST;

import com.flexcore.dao.CuentaAhorroVistaDAO;
import com.flexcore.dto.CuentaAhorroVistaDTO;
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
@Path("cuentaAhorroVista")
public class CuentaAhorroVistaWS {

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public CuentaAhorroVistaDTO create(CuentaAhorroVistaDTO cuentaAhorroVista) throws SQLException, NamingException, Exception {
        CuentaAhorroVistaDAO cliente_dao = new CuentaAhorroVistaDAO();
        return cliente_dao.crearCuentaAhorroVista(cuentaAhorroVista);
    }
    
}
