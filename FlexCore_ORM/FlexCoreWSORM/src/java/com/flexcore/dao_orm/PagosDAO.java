/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.dao_orm;


import com.flexcore.dao_interfaces.TransaccionesPagos;
import com.flexcore.dto_hibernate.Pagos;
import com.flexcore.hibernate.config.NewHibernateUtil;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Carlos
 */
public class PagosDAO implements TransaccionesPagos {
   Session session = null;
   public PagosDAO() {
        
      this.session = NewHibernateUtil.getCurrentSession();
    }
   
    @Override
    public Pagos crearPago(Pagos pago) {
       

        Transaction trans  = session.beginTransaction();
     
        Query q = session.createSQLQuery(" { call crearPagoORM (?, ?, ?) }")
                .setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        q.setInteger(0,pago.getIdCuentaOrigen()); 
        q.setInteger(1,pago.getIdCuentaDestino()); 
        q.setBigDecimal(2,pago.getMonto());
        q.executeUpdate();
        
       
        trans.commit();
        session.close();
        return pago;
     
    }

    @Override
    public List<Object> verPagosDeCuentaDestino(int idCuentaDestino) {

        List<Object> listaPagos = new ArrayList<>();
        Transaction trans = session.beginTransaction();
        Query q = session.createSQLQuery(" { call verPagosEnviados(?) }")
                .setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        q.setInteger(0, idCuentaDestino);
        q.executeUpdate();
        listaPagos = q.list();
        trans.commit();
        
        session.close();
        return listaPagos;
    }

}
