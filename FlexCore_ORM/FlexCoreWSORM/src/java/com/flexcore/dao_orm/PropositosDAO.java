/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.dao_orm;

import com.flexcore.dao_interfaces.TransaccionesPropositos;
import com.flexcore.dto_hibernate.Propositos;
import com.flexcore.hibernate.config.NewHibernateUtil;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 *
 * @author Oscar Montes
 */
public class PropositosDAO implements TransaccionesPropositos {
   Session session = null;
   public PropositosDAO() {
        
      this.session = NewHibernateUtil.getCurrentSession();
    }
   @Override
       public List<Propositos> verPropositos() {
        List<Propositos> listaPropositos = new ArrayList<Propositos>();
        Transaction trans  = session.beginTransaction();
        Query q = (Query)session.createSQLQuery("select * from Propositos")
                .addEntity(Propositos.class)            
                ;
        listaPropositos = q.list();
        trans.commit();
        session.close();
        
        return listaPropositos;
    }

  
    
}
