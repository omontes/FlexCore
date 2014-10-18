/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.REST;

import com.flexcore.dao.CuentaAhorroVistaDAO;
import com.flexcore.dto.CuentaAhorroVistaDTO;
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
@Path("cuentaAhorroVista")
public class CuentaAhorroVistaWS {
    
    @GET
        @Path("/getCuentasVistaPaginadosBusqueda/{pagina}/{busqueda}/{customerIF}")
    @Produces("application/json")
    public String getCuentasAhorroVista(@PathParam("pagina") int pagina, @PathParam("busqueda") String busqueda,
            @PathParam("customerIF") int customerIF) {
        String feeds = null;
        try {
            CuentaAhorroVistaDAO cuenta_dao = new CuentaAhorroVistaDAO();
            ArrayList<CuentaAhorroVistaDTO> feedData = null;
            feedData=cuenta_dao.verCuentasAhorroVista(pagina,busqueda,customerIF);
            Gson gson = new Gson();
            feeds = gson.toJson(feedData);
            
        } catch (Exception e) {
            System.out.println("No se pudo obtener las cuentas de ahorro vista"); //Console 
        }
        return feeds;
    }
       @GET
    @Path("/getCantidadCuentasVistaBusqueda/{entrada}/{customerIF}")
    @Produces("application/json")
    public String getCantidadClientesJuridicosBusqueda(@PathParam("entrada") String entrada,@PathParam("customerIF") int customerIF) {
        String feeds = null;
        try {
            CuentaAhorroVistaDAO cuenta_dao = new CuentaAhorroVistaDAO();
            int feedData = cuenta_dao.obtenerCantidadCuentasAhorroVista(entrada,customerIF);
            Gson gson = new Gson();
            feeds = gson.toJson(feedData);
            
        } catch (Exception e) {
            System.out.println("No se pudo obtenener la cantidad de cuentas "
                    + "ahorro vista"); //Console 
        }
        return feeds;
    }
    @POST
    @Path("/crearCuentasVista")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public CuentaAhorroVistaDTO create(CuentaAhorroVistaDTO cuentaAhorroVista) throws SQLException, NamingException, Exception {
        CuentaAhorroVistaDAO cuenta_dao = new CuentaAhorroVistaDAO();
        return cuenta_dao.crearCuentaAhorroVista(cuentaAhorroVista);
    }
    
    @POST
    @Path("/updateVista")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public CuentaAhorroVistaDTO update(CuentaAhorroVistaDTO cuenta) throws SQLException, NamingException, Exception {
        CuentaAhorroVistaDAO cuenta_dao = new CuentaAhorroVistaDAO();
        return cuenta_dao.actualizarCuentaAhorroVista(cuenta);
    }
    
    @DELETE 
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void deleteCuentaAhorroVista(@PathParam("id") int numCuenta) throws SQLException, NamingException, Exception {
		CuentaAhorroVistaDAO cuenta_dao = new CuentaAhorroVistaDAO();
                cuenta_dao.eliminarCuentaAhorroVista(numCuenta);
    }
    
}
