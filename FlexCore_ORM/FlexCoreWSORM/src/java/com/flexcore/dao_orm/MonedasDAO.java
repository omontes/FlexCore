/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.dao_orm;

import com.flexcore.dao_interfaces.TransaccionesMonedas;
import com.flexcore.dto_hibernate.Moneda;
import com.flexcore.hibernate.config.NewHibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Oscar Montes
 */
public class MonedasDAO implements TransaccionesMonedas {
    Session session = null;
    public MonedasDAO() {
        
      this.session = NewHibernateUtil.getCurrentSession();
    }
    @Override
    public List<Moneda> verMonedas() throws Exception {
        List<Moneda> listaMonedas = new ArrayList<Moneda>();
        Transaction trans  = session.beginTransaction();
        Query q = (Query)session.createSQLQuery("select * from Moneda")
                .addEntity(Moneda.class)            
                ;
        listaMonedas = q.list();
        trans.commit();
        session.close();
        
        return listaMonedas;
    }
    
}
