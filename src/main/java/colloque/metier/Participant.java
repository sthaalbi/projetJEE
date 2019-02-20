/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colloque.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author formation
 */
@Entity
@Table(name = "participant")
public class Participant {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "num_pers")
    private int numpers;
    
    @Column(name = "nom", nullable = false)
    private String nom;
    
    @Column(name = "prenom", nullable = false)
    private String prenom;    
    
    @Column(name = "email", nullable = false)
    private String email;
    
    @Column(name = "datenaiss", nullable = false)
    private String datenaiss;

    public Participant(String nom, String prenom, String email, String datenaiss) {
     
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.datenaiss = datenaiss;
    }



    public int getNumpers() {
        return numpers;
    }

    public void setNumpers(int numpers) {
        this.numpers = numpers;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDatenaiss() {
        return datenaiss;
    }

    public void setDatenaiss(String datenaiss) {
        this.datenaiss = datenaiss;
    }
    
    
}
