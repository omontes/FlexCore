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
import java.math.BigDecimal;
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
    public List<Cuentaahorroautomatico> verCuentasAhorroAutomatico(int pagina, String busqueda, int customerIF) throws Exception {
            List<Cuentaahorroautomatico> listacuentaAhorro = new ArrayList<>();
         
            int datoInicial = (pagina - 1)*10;
            int datoFinal = pagina*10;
        
            Transaction trans  = session.beginTransaction();
     
            Query q = session.createSQLQuery(" { call obtenerCuentasAhorroAutomatico(?,?,?,?) }")
                    .setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
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
    public Cuentaahorroautomatico crearCuentaAhorroAutomatico(Cuentaahorroautomatico cuentaAhorro) throws Exception {
        Transaction trans  = session.beginTransaction();
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
        Cauto.setNumCuentaDeduccion(cuentaAhorro.getNumCuentaDeduccion());
        session.save(Cauto);
        trans.commit();
        session.close();
        return cuentaAhorro;
    }

   /** @Override
    public Cuentaahorroautomatico actualizarCuentaAhorroAutomatico(Cuentaahorroautomatico cuenta) throws Exception {
        CallableStatement preparedCall = null;
        try {
            String SQL = "{call actualizarCuentaAhorroAutomatico (?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            preparedCall = conexion.prepareCall(SQL);
            preparedCall.setInt(1, cuenta.getNumCuenta());
            preparedCall.setInt(2, cuenta.getTiempoDeducciones());
            preparedCall.setInt(3, cuenta.getTipoTiempo());
            preparedCall.setInt(4, cuenta.getTiempoAhorroMeses());
            preparedCall.setInt(5, cuenta.getNumCuentaDeduccion());
            preparedCall.setDouble(6, cuenta.getMontoAhorro());
            preparedCall.setInt(7, cuenta.getIdProposito());
            preparedCall.setBigDecimal(8,cuenta.getSaldoReal());
            preparedCall.setBigDecimal(9,cuenta.getSaldoTemporal());
            preparedCall.executeUpdate();
            preparedCall.close();
        }
    catch (Exception e) {
            e.printStackTrace();
        throw new RuntimeException(e);
    }finally {
            this.cerrarConexion();
    }
    return cuenta ;
    }

    @Override
    public void eliminarCuentaAhorroAutomatico(int numCuenta) throws Exception {
        CallableStatement preparedCall = null;
        try {
            String SQL = "{call eliminarCuentaAhorroAutomatico (?)}";
            preparedCall = conexion.prepareCall(SQL);
            preparedCall.setInt(1, numCuenta);
            preparedCall.executeUpdate();
            preparedCall.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
	       } finally {
            this.cerrarConexion();
        }
    }
    **/

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
