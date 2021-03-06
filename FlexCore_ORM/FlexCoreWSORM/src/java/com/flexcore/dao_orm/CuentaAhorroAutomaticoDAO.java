/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.dao_orm;


import com.flexcore.dao_interfaces.TransaccionesCuentaAhorroAutomatico;
import com.flexcore.dto_hibernate.Cliente;
import com.flexcore.dto_hibernate.Cuenta;
import com.flexcore.dto_hibernate.Cuentaahorroautomatico;
import com.flexcore.dto_hibernate.Propositos;
import com.flexcore.dto_hibernate.Tipostiempo;
import com.flexcore.hibernate.config.NewHibernateUtil;
import java.sql.CallableStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Carlos
 */
public class CuentaAhorroAutomaticoDAO implements TransaccionesCuentaAhorroAutomatico {
    Session session = null;
   public CuentaAhorroAutomaticoDAO() {
        
      this.session = NewHibernateUtil.getCurrentSession();
    }
   
    @Override
    public List<Cuentaahorroautomatico> verCuentasAhorroAutomatico(int pagina, String busqueda, int customerIF) {
            List<Cuentaahorroautomatico> listacuentaAhorro = new ArrayList<>();
         
            int datoInicial = (pagina - 1)*10;
            int datoFinal = pagina*10;
        
            Transaction trans  = session.beginTransaction();
     
            Query q = session.createSQLQuery(" { call obtenerCuentasAhorroAutomatico(?,?,?,?) }")
                    .setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP)
                    
                    ;
            q.setInteger(0,datoInicial); 
            q.setInteger(1,datoFinal); 
            q.setString(2,busqueda);
            q.setInteger(3,customerIF);
            q.executeUpdate();
        
            listacuentaAhorro = q.list();
            trans.commit();
            session.close();

            return listacuentaAhorro;
    }
    @Override
    public Cuentaahorroautomatico crearCuentaAhorroAutomatico(Cuentaahorroautomatico cuentaAhorro) {
        Transaction trans  = session.beginTransaction();
        /**System.out.println(cuentaAhorro.getIdCliente());
        Cliente client = (Cliente) session.get(Cliente.class, cuentaAhorro.getIdCliente());
        Cuenta cuenta = new Cuenta(client,cuentaAhorro.getSaldoTemporal(),
                cuentaAhorro.getSaldoReal());
        cuenta.setEstadoCuenta(true);
        session.save(cuenta);
        Propositos proposito = (Propositos) session.get(Propositos.class, cuentaAhorro.getIdProposito());
        Tipostiempo tipotiempo = (Tipostiempo) session.get(Tipostiempo.class, cuentaAhorro.getTipoTiempo());
        Date date = new Date();
        Cuentaahorroautomatico Cauto = new Cuentaahorroautomatico(
                    proposito,
                    null,
                    tipotiempo,
                    cuentaAhorro.getTiempoDeducciones(),
                    date, 
                    cuentaAhorro.getTiempoAhorroMeses(), 
                    cuentaAhorro.getMontoAhorro(),
                    true, 
                    date);
        Cauto.setNumCuenta(cuenta.getNumCuenta());
        Cauto.setCuenta(cuenta);
        Cauto.setNumCuentaDeduccion(cuentaAhorro.getNumCuentaDeduccion());**/
        
        /**Cambiar por Cauto **/
        System.out.println("LLEGOOOOOOOOOOO AQUII");
        System.out.println("Cuenta num cuenta");
        //System.out.println(cuentaAhorro.getCuenta().getNumCuenta());
        System.out.println("Cuenta");
        //System.out.println(cuentaAhorro.getNumCuenta());
        System.out.println("Cliente");
        System.out.println(cuentaAhorro.getCuenta().getCliente().getCustomerIF());
        System.out.println("Propositos Descripcion");
        System.out.println(cuentaAhorro.getPropositos().getIdcuentaPropositos());
        System.out.println("Cuenta deduccion");
        System.out.println(cuentaAhorro.getNumCuentaDeduccion());
        session.save(cuentaAhorro.getCuenta());
        session.save(cuentaAhorro);
        trans.commit();
        session.close();
        return cuentaAhorro;
    }

    @Override
    public Cuentaahorroautomatico actualizarCuentaAhorroAutomatico(Cuentaahorroautomatico cuentaAuto)  {
       
        Transaction trans = session.beginTransaction();
              
        Cuentaahorroautomatico cuentaAhorroAutomatico = (Cuentaahorroautomatico)
                session.get(Cuentaahorroautomatico.class, cuentaAuto.getNumCuenta());
       
        Tipostiempo tiempo = (Tipostiempo) session.get(Tipostiempo.class, cuentaAuto.getTipoTiempo());
        cuentaAhorroAutomatico.setTipostiempo(tiempo);
        
        
       
        
        cuentaAhorroAutomatico.setTiempoDeducciones(cuentaAuto.getTiempoDeducciones());
        cuentaAhorroAutomatico.setTiempoAhorroMeses(cuentaAuto.getTiempoAhorroMeses());
        cuentaAhorroAutomatico.setNumCuentaDeduccion(cuentaAuto.getNumCuentaDeduccion());
        cuentaAhorroAutomatico.setMontoAhorro(cuentaAuto.getMontoAhorro());
        
        Propositos proposito = (Propositos) session.get(Propositos.class, cuentaAuto.getIdProposito());
        cuentaAhorroAutomatico.setPropositos(proposito);
        
        cuentaAhorroAutomatico.setNumCuenta(cuentaAuto.getNumCuenta());
        Cuenta cuenta = cuentaAhorroAutomatico.getCuenta();
        cuenta.setSaldoReal(cuentaAuto.getSaldoReal());
        cuenta.setSaldoTemporal(cuentaAuto.getSaldoTemporal());
        session.merge(cuenta);
        session.merge(cuentaAhorroAutomatico);
             
        trans.commit();
        session.close();
        return cuentaAuto;
   
       
    }

    @Override
    public void eliminarCuentaAhorroAutomatico(int numCuenta) {
        Transaction trans = session.beginTransaction();
        Cuenta cuenta = (Cuenta) session.get(Cuenta.class, numCuenta);
        session.delete(cuenta);
        trans.commit();
        session.close();

    }
    

    public int obtenerCantidadCuentasAhorroAutomatico(String entrada, int customerIF) {
        int cantidadCuentasAhorro = 0;
        Transaction trans = session.beginTransaction();
        Query q = session.createSQLQuery(" { call obtenerCantidadCuentasAhorroAutomatico (?,?) }");
        q.setString(0, entrada);  
        q.setInteger(1, customerIF);  
        q.executeUpdate();
        cantidadCuentasAhorro = Integer.parseInt(q.list().get(0).toString());
        
        trans.commit();
        session.close();

        return cantidadCuentasAhorro;
    }
    

   
}
