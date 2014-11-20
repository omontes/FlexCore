/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.dao_orm;


import com.flexcore.dao_interfaces.TransaccionesTiempos;

import com.flexcore.dto_hibernate.Tipostiempo;
import com.flexcore.hibernate.config.NewHibernateUtil;
import java.util.Iterator;


import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;



/**
 *
 * @author Oscar Montes
 */
public class TiemposDAO implements TransaccionesTiempos {
     Session session = null;
   public TiemposDAO() {
        
      this.session = NewHibernateUtil.getCurrentSession();
    }
   
    @Override
    public List<Tipostiempo> verTiempos() {
        List<Tipostiempo> tiemposList;
        Transaction trans  = session.beginTransaction();
       
        Query q = (Query)session.createSQLQuery("select * from Tipostiempo")
                .addEntity(Tipostiempo.class)            
                ;
      
        tiemposList = q.list();
        /**Iterator<Tipostiempo> it = tiemposList.iterator();
        while(it.hasNext()){
            try{
                System.out.println(it.next().getDescripcion());}
            //System.out.println(it.next().getDescripcion());}
            catch(Exception e){
                System.out.println(e);
            }
        }**/
        
        trans.commit();
        session.close();
        
        
        return tiemposList;
    
    
}
}
