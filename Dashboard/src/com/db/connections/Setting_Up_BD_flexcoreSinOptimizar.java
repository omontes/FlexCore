/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.db.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
/**
 *
 * @author Monicaticooo
 */
/**
 * Establece la conexion con la base de datos
 */
public final class Setting_Up_BD_flexcoreSinOptimizar{

    /**
     * Parametros de conexion
     */
    private String driver = "com.mysql.jdbc.Driver";
    private String database = "jdbc:mysql://localhost:3306/flexcore";
    private String user = "root";
    private String pass = "123456";
    private Connection conection;
    private Statement statement;
    DateFormat dateFormat = new SimpleDateFormat("EEEE");//formato fecha act

    /**
     * Intenta la conexion a la Base de Datos
     */
    public Setting_Up_BD_flexcoreSinOptimizar() {
        try {
            Class.forName(driver);
            this.setConection(DriverManager.getConnection(database, user, pass));
            this.setStatement(conection.createStatement());
        } catch (Exception e) {
            System.out.println("Error al recuperar conexion "
                    + e.toString());
            JOptionPane.showMessageDialog(null,
                    "No se pudo conectar a la base de datos.");

        }
    }

    /**
     * @return the statement
     */
    public Statement getStatement() {
        return statement;
    }

    /**
     * @param statement the statement to set
     */
    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    /**
     * @return the conection
     */
    public Connection getConection() {
        return conection;
    }

    /**
     * @param conection the conection to set
     */
    public void setConection(Connection conection) {
        this.conection = conection;
    }

   
}
