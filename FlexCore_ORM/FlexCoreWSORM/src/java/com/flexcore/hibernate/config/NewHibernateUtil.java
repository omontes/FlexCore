/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flexcore.hibernate.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;



/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Oscar Montes
 */
public class NewHibernateUtil {

    private static final EntityManagerFactory entityManagerFact;
     private static Session session;
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            
               entityManagerFact = buildEntityManagerFactory();;
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial entityFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static Session getCurrentSession() {
        EntityManager entityManager = entityManagerFact.createEntityManager();
        session = entityManager.unwrap( Session.class );
        return session;
    }
    private static EntityManagerFactory buildEntityManagerFactory() {
        try {
            //Create the "entityManager using JPA"
           
            
             EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernateSetup");
            
             return entityManagerFactory;
           
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial entityManagerFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
}
