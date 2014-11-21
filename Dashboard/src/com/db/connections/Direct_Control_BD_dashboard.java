/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.db.connections;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 * @author Monicaticooo
 */
public class Direct_Control_BD_dashboard {

    private final Connection conection;
    private final Statement statement;
    public Object[][] infoFact;
    private static Direct_Control_BD_dashboard AdminBD;

    public Direct_Control_BD_dashboard (Connection conection, Statement statement) {
        this.conection = conection;
        this.statement = statement;

    }

    public static Direct_Control_BD_dashboard getInstance() {
        if (AdminBD == null) {
            Setting_Up_BD_dashboard setting = new Setting_Up_BD_dashboard();
            AdminBD = new Direct_Control_BD_dashboard(setting.getConection(), setting.getStatement());
        }
        return AdminBD;
    }

     public void insertCommit(int project, int time, int commits, int indice){
          String query = "INSERT INTO commits(commits,tiempo,idProyecto, indice)\n" +
            "VALUES (?,?,?,?);";
        try {
            PreparedStatement stm = conection.prepareStatement(query);
            stm.setInt(1, commits);
            stm.setInt(2, time);
            stm.setInt(3, project);
            stm.setInt(4, indice);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Direct_Control_BD_FlexcoreSinOptimizar.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     public void cleanDashboard() throws SQLException{
         String query = "DELETE from commits;";
         statement.executeQuery(query);
     }
    
    private String readSql(String filePath) throws IOException {
        InputStream inputfile = Direct_Control_BD_FlexcoreSinOptimizar.class.getClass().getResourceAsStream(filePath);
        StringBuilder sb;
        try (BufferedReader input = new BufferedReader(new InputStreamReader(inputfile))) {
            String str;
            sb = new StringBuilder();
            while ((str = input.readLine()) != null) {
                sb.append(str).append("\n");
            }
        }
        return sb.toString();
    }
}
