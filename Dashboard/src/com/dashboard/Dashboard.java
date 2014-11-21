/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dashboard;

import com.db.connections.Direct_Control_BD_FlexcoreSinOptimizar;
import com.db.connections.Direct_Control_BD_dashboard;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Oscar Montes
 */
public class Dashboard implements Runnable{
  
  int tiempoSegundos;
  String WebService;
  String VersionBase;
  Direct_Control_BD_FlexcoreSinOptimizar adminBDSinOptmizar =Direct_Control_BD_FlexcoreSinOptimizar.getInstance();
  Direct_Control_BD_dashboard adminBDDashboard  = Direct_Control_BD_dashboard.getInstance();
  public Dashboard(int ptimeSegundos,String pWebService,String pVersionBase){
      tiempoSegundos = ptimeSegundos;
      WebService  =  pWebService;
      VersionBase = pVersionBase;
  }
  


  
  
  
    public void run() {
        try {
            //HACE EL FLUSH PARA LA BASE SIN OPTIMIZAR
            System.out.println("Inicio");
            int commitsAnterior;
            int commitsActuales;
            for (int i = 0; i < 30; i++) {
                //adminBDSinOptmizar.flush();
                commitsAnterior = adminBDSinOptmizar.getCommits();
                try {
                    Thread.sleep(tiempoSegundos * 1000, 0);
                } catch (Exception e) {
                    System.out.println(e);
                }
                //INSERTA LOS COMMITS DE LA BASE SIN OPTIMIZAR
                commitsActuales = adminBDSinOptmizar.getCommits() - commitsAnterior;
                adminBDDashboard.insertCommit(4, tiempoSegundos, commitsActuales);

            }
            System.out.println("Termino");

        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    
}
