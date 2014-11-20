/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dashboard;

/**
 *
 * @author Oscar Montes
 */
public class Dashboard implements Runnable{
  
  int tiempoSegundos;

    
  public Dashboard(int timeSegundos){
      tiempoSegundos = timeSegundos;
  }

   public void run() {
         System.out.println("Inicio");
         try {
            Thread.sleep(tiempoSegundos*1000, 0);
         } catch (Exception e) {
              System.out.println(e);
         }
         System.out.println("Termino");
   }


    
}
