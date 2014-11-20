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
import java.sql.SQLException;

import java.sql.Statement;



/**
 * @author Monicaticooo
 */
public class Direct_Control_BD_dashboard {

    private final Connection conection;
    private final Statement statement;
    public Object[][] infoFact;
    private static Direct_Control_BD_FlexcoreSinOptimizar AdminBD;

    public Direct_Control_BD_dashboard (Connection conection, Statement statement) {
        this.conection = conection;
        this.statement = statement;

    }

    public static Direct_Control_BD_FlexcoreSinOptimizar getInstance() {
        if (AdminBD == null) {
            Setting_Up_BD_flexcoreOptimizado setting = new Setting_Up_BD_flexcoreOptimizado();
            AdminBD = new Direct_Control_BD_FlexcoreSinOptimizar(setting.getConection(), setting.getStatement());
        }
        return AdminBD;
    }

     public void valorInventario(String UbicacionInv) {// esta bien
       /** try {

            String valorInventario = this.readSql("/sql_files/ValorInventario.sql");
            PreparedStatement stm = this.conection.prepareStatement(valorInventario);
            stm.setString(1, UbicacionInv);
            ResultSet resultset = stm.executeQuery();
            //Imprime el resultado obtenido del valor del inventario
            while (resultset.next()) {
                System.out.println(resultset.getString(1)
                        + "||" + resultset.getString(2) + "||"
                        + resultset.getInt(3)
                        + "||" + resultset.getInt(4) + "||"
                        + resultset.getInt(5));
            }

        } catch (Exception e) {
            System.out.println("Error al obtener el valor del inventario");
        }**/

    }
     
     public void cleanDashboard() throws SQLException{
         String query = "UPDATE commits SET commits = 0, tiempo = 0;";
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
