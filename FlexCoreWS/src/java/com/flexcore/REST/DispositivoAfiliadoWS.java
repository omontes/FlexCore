/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.REST;

import com.flexcore.dao.DispositivoAfiliadoDAO;
import com.flexcore.dto.DispositivoAfiliadoDTO;
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
@Path("dispositivoAfiliado")
public class DispositivoAfiliadoWS {
    
    @GET
    @Path("/getCantidadDispositivosDeCliente")
    @Produces("application/json")
    public String getCantidadClientesFisicos(int cliente) {
        String feeds = null;
        try {
            DispositivoAfiliadoDAO dispositivo_dao = new DispositivoAfiliadoDAO();
            int feedData = dispositivo_dao.obtenerCantidadTarjetas(cliente);
            Gson gson = new Gson();
            feeds = gson.toJson(feedData);
            
        } catch (Exception e) {
            System.out.println("No se pudo obtnener la cantidad de dispositivos de un cliente"); //Console 
        }
        return feeds;
    }
    
    @GET
    @Path("/getDispositivos")
    @Produces("application/json")
    public String getClientesFisicosPaginados() {
        String feeds = null;
        try {
            DispositivoAfiliadoDAO dispositivo_dao = new DispositivoAfiliadoDAO();
            ArrayList<DispositivoAfiliadoDTO> feedData = null;
            feedData=dispositivo_dao.obtenerDispositivos();
            Gson gson = new Gson();
            feeds = gson.toJson(feedData);
            
        } catch (Exception e) {
            System.out.println("No se pudo obtenener los dispositivos"); //Console 
        }
        return feeds;
    }

   @POST
    @Path("/crearDispositivoAfiliado")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public DispositivoAfiliadoDTO create(DispositivoAfiliadoDTO dispositivoAfiliado) throws SQLException, NamingException, Exception {
        DispositivoAfiliadoDAO dispositivoAfiliado_dao = new DispositivoAfiliadoDAO();
        return dispositivoAfiliado_dao.crearDispositivoAfiliado(dispositivoAfiliado);
    }
    
    @GET
    @Path("/getTarjeta/{numCuenta}")
    @Produces("application/json")
    public String getCantidadClientesJuridicosBusqueda(@PathParam("numCuenta") String entrada) {
        String feeds = null;
        try {
            DispositivoAfiliadoDAO dispositivo_dao = new DispositivoAfiliadoDAO();
            int feedData = dispositivo_dao.obtenerTarjeta(entrada);
            Gson gson = new Gson();
            feeds = gson.toJson(feedData);
            
        } catch (Exception e) {
            System.out.println("No se pudo obtenener el numero de tarjeta"
                    + " de dicho dispositivo"); //Console 
        }
        return feeds;
    }
}
