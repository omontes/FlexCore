/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.rest;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Oscar Montes
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.flexcore.corsfilter.CorsFilter.class);
        resources.add(com.flexcore.rest.ClientesWS.class);
        resources.add(com.flexcore.rest.CuentaAhorroAutomaticoWS.class);
        resources.add(com.flexcore.rest.CuentaWS.class);
        resources.add(com.flexcore.rest.MonedasWS.class);
        resources.add(com.flexcore.rest.PagosWS.class);
        resources.add(com.flexcore.rest.PropositosWS.class);
        resources.add(com.flexcore.rest.TiemposWS.class);
    }
    
}
