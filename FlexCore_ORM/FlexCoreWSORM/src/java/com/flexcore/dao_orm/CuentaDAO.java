/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.dao_orm;


import com.flexcore.dao_interfaces.TransaccionesCuenta;
import com.flexcore.dto_hibernate.Cuenta;
import com.flexcore.dto_hibernate.Cuentaahorroautomatico;
import com.flexcore.dto_hibernate.Cuentaahorrovista;
import com.flexcore.hibernate.config.NewHibernateUtil;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Carlos
 */
public class CuentaDAO implements TransaccionesCuenta  {
    Session session = null;
    public CuentaDAO() {
        
      this.session = NewHibernateUtil.getCurrentSession();
    }
    @Override
    public List<Cuenta> verCuentas(int customerIF) {
        List<Cuenta> listaCuentas = new ArrayList<>();

        Transaction trans = session.beginTransaction();

        Query q = session.createSQLQuery(" { call obtenerCuentas (?) }")
                 .setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        q.setInteger(0, customerIF);
        q.executeUpdate();

        listaCuentas = q.list();
        trans.commit();
        session.close();

        return listaCuentas;

    }
    @Override
    public boolean verificarCuentaValida(int numCuenta) {
        boolean isNULL = false;
        int numeroCuenta = 0;
        boolean estadoCuenta = false;
        List<Cuenta> listaCuentas = new ArrayList<>();
        Transaction trans = session.beginTransaction();
        Query q = (Query) session.createSQLQuery(" { call verificarCuenta (?) }")
                .addEntity(Cuenta.class);
        q.setInteger(0, numCuenta);
        q.executeUpdate();

        listaCuentas = q.list();
        Iterator<Cuenta> it = listaCuentas.iterator();
        while (it.hasNext()) {
            Cuenta cuenta = it.next();
            numeroCuenta = cuenta.getNumCuenta();
            estadoCuenta = cuenta.getEstadoCuenta();
            isNULL = cuenta.isIsNULL();
       }

        trans.commit();
        session.close();

        if (numeroCuenta == 1 && isNULL == true) {
            return true;
        } else if (numeroCuenta == 0) {
            return false;
        } else if (numeroCuenta == 1 && estadoCuenta == false) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public BigDecimal obtenerSaldo(int numCuenta) {
        
        BigDecimal saldo = BigDecimal.ZERO;
        Transaction trans = session.beginTransaction();
        Cuenta cuenta = (Cuenta) session.get(Cuenta.class, numCuenta);
        saldo = cuenta.getSaldoReal().add(cuenta.getSaldoTemporal());
        trans.commit();
        session.close();
        return saldo;
    }

    public void eliminarCuenta(int numCuenta) {
        Transaction trans = session.beginTransaction();
        Cuenta cuenta = (Cuenta) session.get(Cuenta.class, numCuenta);
        Cuentaahorroautomatico cuentaAuto = cuenta.getCuentaahorroautomatico();
        Cuentaahorrovista cuentaVista = cuenta.getCuentaahorrovista();
        if(cuentaAuto!=null){
        session.delete(cuentaAuto);}
        if(cuentaVista!=null){
            session.delete(cuentaVista);
        }
        session.delete(cuenta);
        trans.commit();
        session.close();
    }
    
}
