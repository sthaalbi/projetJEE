/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colloque.services;

import colloque.metier.Participant;
import java.util.List;
import java.util.Objects;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author formation
 */
public class ParticipantService {
    private final SessionFactory sessionFctory;
    public ParticipantService(SessionFactory sessionFactory){
        this.sessionFctory = Objects.requireNonNull(sessionFactory);
    }
    public void insertParticipant(Participant participant){
        Objects.requireNonNull(participant);
        try (Session session = this.sessionFctory.openSession()) {
            session.beginTransaction();
            session.save(participant);
            session.getTransaction().commit();
        }
    }
    
    @SuppressWarnings("unchecked")
    public List<Participant> getAllParticipant(){
        List<Participant> result;
        try (Session session = this.sessionFctory.openSession()) {
            result = session.createQuery("from Participant").list();
        }
        return result;
    }
}
