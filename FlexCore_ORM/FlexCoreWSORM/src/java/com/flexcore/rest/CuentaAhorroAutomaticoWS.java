/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.rest;

import com.flexcore.dao_orm.CuentaAhorroAutomaticoDAO;
import com.flexcore.dto_hibernate.Cuentaahorroautomatico;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 * REST Web Service
 *
 * @author Carlos
 */
/*sd*/
@Path("cuentaAhorroAutomatico")
public class CuentaAhorroAutomaticoWS {
    
    @GET
    @Path("/getCuentasAutoPaginadosBusqueda/{pagina}/{busqueda}/{customerIF}")
    @Produces("application/json")
    public String getCuentas(@PathParam("pagina") int pagina, @PathParam("busqueda") String busqueda,
            @PathParam("customerIF") int customerIF) {
        String feeds = null;
        try {
            CuentaAhorroAutomaticoDAO cuenta_dao = new CuentaAhorroAutomaticoDAO();
            List<Cuentaahorroautomatico> feedData = null;
            feedData=cuenta_dao.verCuentasAhorroAutomatico(pagina,busqueda,customerIF);
            Gson gson = new Gson();
            feeds = gson.toJson(feedData);
            
        } catch (Exception e) {
            System.out.println("No se pudo obtnener las cuentas ahorro automatico"); //Console 
        }
        return feeds;
    }
    @GET
    @Path("/getCantidadCuentasAutoBusqueda/{entrada}/{customerIF}")
    @Produces("application/json")
    public String getCantidadCuentasAhorroBusqueda(@PathParam("entrada") String entrada,@PathParam("customerIF") int customerIF) {
        String feeds = null;
        try {
            CuentaAhorroAutomaticoDAO cuenta_dao = new CuentaAhorroAutomaticoDAO();
            int feedData = cuenta_dao.obtenerCantidadCuentasAhorroAutomatico(entrada,customerIF);
            Gson gson = new Gson();
            feeds = gson.toJson(feedData);
            
        } catch (Exception e) {
            System.out.println("No se pudo obtenener la cantidad de cuentas "
                    + "ahorro automatico"); //Console 
        }
        return feeds;
    }
    
    
    @POST
    @Path("/crearCuentaAhorroAutomatico")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Cuentaahorroautomatico create(Cuentaahorroautomatico cuentaAhorroAutomatico) throws SQLException, NamingException, Exception {
        
        CuentaAhorroAutomaticoDAO cliente_dao = new CuentaAhorroAutomaticoDAO();
        return cliente_dao.crearCuentaAhorroAutomatico(cuentaAhorroAutomatico);
        
      
    }
    
    @POST
    @Path("/updateAuto")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Cuentaahorroautomatico update(Cuentaahorroautomatico cuenta) throws SQLException, NamingException, Exception {
        CuentaAhorroAutomaticoDAO cuenta_dao = new CuentaAhorroAutomaticoDAO();
        return cuenta_dao.actualizarCuentaAhorroAutomatico(cuenta);
    }
    
    @DELETE 
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void deleteCuentaAhorroAutomatico(@PathParam("id") int numCuenta) throws SQLException, NamingException, Exception {
		CuentaAhorroAutomaticoDAO cuenta_dao = new CuentaAhorroAutomaticoDAO();
                cuenta_dao.eliminarCuentaAhorroAutomatico(numCuenta);
    }
}
