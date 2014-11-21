/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.rest;


import com.flexcore.dao_orm.CuentaDAO;
import com.flexcore.dto_hibernate.Cuenta;
import com.google.gson.Gson;
import java.math.BigDecimal;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


/**
 * REST Web Service
 *
 * @author Carlos
 */
@Path("cuenta")
public class CuentaWS {

    @GET
    @Path("/getCuentas/{customerIF}")
    @Produces("application/json")
    public String getCuentas(@PathParam("customerIF") int customerIF) {
        String feeds = null;
        try {
            CuentaDAO cuenta_dao = new CuentaDAO();
            List<Cuenta> feedData = null;
            feedData=cuenta_dao.verCuentas(customerIF);
            Gson gson = new Gson();
            feeds = gson.toJson(feedData);
            
        } catch (Exception e) {
            System.out.println("No se pudo obtnener las cuentas"); //Console 
        }
        return feeds;
    }
    
    @GET
    @Path("/getCuentaValida/{customerIF}")
    @Produces("application/json")
    public String verificarCuenta(@PathParam("customerIF") int customerIF) {
        String feeds = null;
        try {
            CuentaDAO cuenta_dao = new CuentaDAO();
            boolean feedData;
            feedData=cuenta_dao.verificarCuentaValida(customerIF);
            Gson gson = new Gson();
            feeds = gson.toJson(feedData);
            
        } catch (Exception e) {
            System.out.println("No se pudo obtnener si la cuenta era valida"); //Console 
        }
        return feeds;
    }
    @GET
    @Path("/getSaldoCuenta/{numCuenta}")
    @Produces("application/json")
    public String obtenerSaldoCuenta(@PathParam("numCuenta") int numCuenta) {
        String feeds = null;
        try {
            CuentaDAO cuenta_dao = new CuentaDAO();
            BigDecimal feedData;
            feedData=cuenta_dao.obtenerSaldo(numCuenta);
            Gson gson = new Gson();
            feeds = gson.toJson(feedData);
            
        } catch (Exception e) {
            System.out.println("No se pudo obtnener el saldo de la "
                    + "cuenta"); //Console 
        }
        return feeds;
    }
    /**@POST
    @Path("/crearCuenta")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Cuenta create(Cuenta cuenta) throws SQLException, NamingException, Exception {
        CuentaDAO cuenta_dao = new CuentaDAO();
        return cuenta_dao.crearCuenta(cuenta);
    }
    
    @POST
    @Path("/updateCuenta")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Cuenta update(Cuenta cuenta) throws SQLException, NamingException, Exception {
        CuentaDAO cuenta_dao = new CuentaDAO();
        return cuenta_dao.actualizarCuenta(cuenta);
    }
    
    @DELETE 
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void deleteCuentaAhorroVista(@PathParam("id") int numCuenta) throws SQLException, NamingException, Exception {
		CuentaDAO cuenta_dao = new CuentaDAO();
                cuenta_dao.eliminarCuenta(numCuenta);
    }**/
}
