/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.dao_orm;

import com.flexcore.dao_interfaces.TransaccionesCliente;
import com.flexcore.dto_hibernate.Cliente;
import com.flexcore.dto_hibernate.Clientefisico;
import com.flexcore.dto_hibernate.Clientejuridico;
import com.flexcore.hibernate.config.NewHibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 *
 * @author Oscar Montes
 */
public class ClienteDAO implements TransaccionesCliente {

     Session session = null;
   public ClienteDAO() {
        
      this.session = NewHibernateUtil.getCurrentSession();
    }

    @Override
    public Clientefisico crearClienteFisico(Clientefisico clienteFisico) throws Exception {
        
       
        Transaction trans  = session.beginTransaction();
        Cliente cliente = new 
        Cliente(clienteFisico.getNombre(), 
                clienteFisico.getDireccion(),
                clienteFisico.getTelCasa(),
                clienteFisico.getTelOficina(),
                clienteFisico.getCelular(),null, null, null); 
        clienteFisico.setCliente(cliente);
        
        session.save(clienteFisico);
        trans.commit();
        
        session.close();
        return clienteFisico;
    }

    @Override
    public Clientejuridico crearClienteJuridico(Clientejuridico clienteJuridico) throws Exception {
        Transaction trans  = session.beginTransaction();
        
        Cliente cliente = new 
        Cliente(clienteJuridico.getNombre(), 
                clienteJuridico.getDireccion(),
                clienteJuridico.getTelCasa(),
                clienteJuridico.getTelOficina(),
                clienteJuridico.getCelular(),null, null, null); 
        clienteJuridico.setCliente(cliente);
        session.save(clienteJuridico);
        trans.commit();
        
        session.close();
        return clienteJuridico;
    }

    @Override
    public Clientefisico actualizarClienteFisico(Clientefisico clienteFisico) throws Exception {
        Transaction trans = session.beginTransaction();
        //Correccion porque me mandaron el CustomerIF
        clienteFisico.setIdClienteFisico(clienteFisico.getCustomerIF());
        
        
        Cliente client = (Cliente) session.get(Cliente.class, clienteFisico.getCustomerIF());
        client.setNombre(clienteFisico.getNombre());
        client.setDireccion(clienteFisico.getDireccion());
        client.setTelCasa(clienteFisico.getTelCasa());
        client.setTelOficina(clienteFisico.getTelOficina());
        client.setCelular(clienteFisico.getCelular());
        
        session.merge(client);
        session.merge(clienteFisico);
        
        
        trans.commit();
        session.close();
        return clienteFisico;
    }

    @Override
    public Clientejuridico actualizarClienteJuridico(Clientejuridico clienteJuridico) throws Exception {
        Transaction trans = session.beginTransaction();
        //Correccion porque me mandaron el CustomerIF
        clienteJuridico.setIdclienteJuridico(clienteJuridico.getCustomerIF());
        
        
        Cliente client = (Cliente) session.get(Cliente.class, clienteJuridico.getCustomerIF());
        client.setNombre(clienteJuridico.getNombre());
        client.setDireccion(clienteJuridico.getDireccion());
        client.setTelCasa(clienteJuridico.getTelCasa());
        client.setTelOficina(clienteJuridico.getTelOficina());
        client.setCelular(clienteJuridico.getCelular());
        
        session.merge(client);
        session.merge(clienteJuridico);
        
        
        trans.commit();
        session.close();
        return clienteJuridico;
    
    }

    @Override
    public void eliminarCliente(int idCliente) throws Exception {
        Transaction trans = session.beginTransaction();
        Cliente cliente = (Cliente) session.get(Cliente.class, idCliente);
        session.delete(cliente);
        trans.commit();
        session.close();

    }

   @Override
    public List<Clientefisico> verClientesFisicosPaginadosBusqueda(int pagina, String entrada) throws Exception {

        int datoInicial = (pagina - 1) * 10;
        int datoFinal = pagina * 10;

        Transaction trans  = session.beginTransaction();
     
        Query q = session.createSQLQuery(" { call obtenerClientesFisicosBusquedaPaginado(?,?,?) }")
                .setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        q.setInteger(0,datoInicial); 
        q.setInteger(1,datoFinal); 
        q.setString(2,entrada);
        q.executeUpdate();
        
        List<Clientefisico> listaClienteFisicos = q.list();
        trans.commit();
        session.close();

        return listaClienteFisicos;
    }

    @Override
    public List<Clientejuridico> verClientesJuridicosPaginadosBusqueda(int pagina, String entrada) throws Exception {
        int datoInicial = (pagina - 1) * 10;
        int datoFinal = pagina * 10;
        Transaction trans  = session.beginTransaction();
     
        Query q = session.createSQLQuery(" { call obtenerClientesJuridicosBusquedaPaginado(?,?,?) }")
                .setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        q.setInteger(0,datoInicial); 
        q.setInteger(1,datoFinal); 
        q.setString(2,entrada);
        q.executeUpdate();
        
        List<Clientejuridico> listaClienteJuridicos = q.list();
        
        trans.commit();
        session.close();

        return listaClienteJuridicos;
    }

    @Override
    public int obtenerCantidadClientesFisicosBusqueda(String entrada) throws Exception {
        int cantidadClientes = 0;
        Transaction trans = session.beginTransaction();
        Query q = session.createSQLQuery(" { call obtenerCantidadClientesFisicosBusqueda (?) }");
        q.setString(0, entrada);  // first parameter, index starts with 0
        q.executeUpdate();
        System.out.println("Obteniendo cantidad cliente Fisico");
        System.out.println(q.list().get(0).toString());
        cantidadClientes = Integer.parseInt(q.list().get(0).toString());
        trans.commit();
        session.close();

        return cantidadClientes;
    }

    @Override
    public int obtenerCantidadClientesJuridicosBusqueda(String entrada) throws Exception {
        int cantidadClientes = 0;
        Transaction trans = session.beginTransaction();
        Query q = session.createSQLQuery(" { call obtenerCantidadClientesJuridicosBusqueda (?) }");
        q.setString(0, entrada);  // first parameter, index starts with 0
        q.executeUpdate();
        cantidadClientes = Integer.parseInt(q.list().get(0).toString());
        System.out.println("Obteniendo cantidad cliente Juridico");
        System.out.println(q.list().get(0));
        trans.commit();
        session.close();

        return cantidadClientes;
    }

    @Override
    public int verificarCliente(int customerIF) {
        int existe = 0;
        Transaction trans = session.beginTransaction();
        Cliente cliente = (Cliente) session.get(Cliente.class, customerIF);
       
        if(cliente!=null){
            existe= 1;
        }
       
        trans.commit();
        session.close();
        return existe;
    }

    
}
