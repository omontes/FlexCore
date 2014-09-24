/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.connection_manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Oscar Montes
 */
public class ConnectionManager {
    
    public Connection conexion;
    public Statement statement;
    public String urlDB ="jdbc/flexcore";
    
    public ConnectionManager(){
        this.initializeConnection();
        try {
            this.statement=conexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

    }
    public void cerrarConexion(){
        try {
            conexion.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }
    public Connection getConexion() throws NamingException, SQLException{
        this.initializeConnection();
        return conexion;
        
    }

    public Statement getStatement() throws NamingException, SQLException{
        this.initializeConnection();
        this.statement=conexion.createStatement();
        return statement;
    }
    private void initializeConnection(){
       
        try {
            InitialContext ctx =  new InitialContext();
          
            DataSource das = (DataSource) ctx.lookup(urlDB);
            conexion = das.getConnection();
            
        } catch (NamingException ex) {
            System.out.println("error al iniciar conexion");
            Logger.getLogger(ConnectionManager.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println("error al iniciar conexion");
            Logger.getLogger(ConnectionManager.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
       
    }
    
      public String leerSQL(String direccion) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputfile = classLoader.getResourceAsStream(direccion);
        StringBuilder sb;
        try (BufferedReader input = new BufferedReader
        (new InputStreamReader(inputfile))) {
            String str;
            sb = new StringBuilder();
            while ((str = input.readLine()) != null) {
                sb.append(str).append("\n");
            }
        }
        return sb.toString();
    }
    
    
}

