/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensg.colloque;

import colloque.metier.Participant;
import colloque.services.ParticipantService;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


/**
 *
 * @author formation
 */
public class ParticipantSession {
    private static SessionFactory createSessionFactory(){
        final StandardServiceRegistry registry;
        registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try {
            return new MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder
                    .destroy(registry);
        }
         
        return null;
    }
   
    public static void main(String[] args) {
        SessionFactory sessionFactory;
        sessionFactory = createSessionFactory();
        ParticipantService participantService = new ParticipantService(sessionFactory);
        participantService.insertParticipant(new Participant("toto","tutu","toto@gmail.com", "2000-12-12"));
        closeSessionFactory(sessionFactory);
  
    }

    private static void closeSessionFactory(SessionFactory sessionFactory) {
        sessionFactory.close();
    }
}
