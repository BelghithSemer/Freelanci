/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.entity;

import java.time.LocalDateTime;
import java.util.List;


/**
 *
 * @author 21624
 */
public class Formation {
    private int id ;
    private String description;
    private int nbre_max;
    private int nbre_participants;
    private String tittre;
    private String lien_Meet;
    private LocalDateTime date;
    List <Participation> participations ;
    private Utilisateur formateur ;

    public Formation(int id, String description, int nbre_max, int nbre_participants, String tittre, String lien_Meet, LocalDateTime date, List<Participation> participations, Utilisateur formateur) {
        this.id = id;
        this.description = description;
        this.nbre_max = nbre_max;
        this.nbre_participants = nbre_participants;
        this.tittre = tittre;
        this.lien_Meet = lien_Meet;
        this.date = date;
        this.participations = participations;
        this.formateur = formateur;
    }

    public Formation(String description, int nbre_max, int nbre_participants, String tittre, String lien_Meet, LocalDateTime date, List<Participation> participations, Utilisateur formateur) {
        this.description = description;
        this.nbre_max = nbre_max;
        this.nbre_participants = nbre_participants;
        this.tittre = tittre;
        this.lien_Meet = lien_Meet;
        this.date = date;
        this.participations = participations;
        this.formateur = formateur;
    }
    

    public Formation(String description, int nbre_max, int nbre_participants, String tittre, String lien_Meet, LocalDateTime date) {
        this.description = description;
        this.nbre_max = nbre_max;
        this.nbre_participants = nbre_participants;
        this.tittre = tittre;
        this.lien_Meet = lien_Meet;
        this.date = date;
    }

    public Formation(String description, int nbre_max, int nbre_participants, String tittre, String lien_Meet, LocalDateTime date, Utilisateur formateur) {
        this.description = description;
        this.nbre_max = nbre_max;
        this.nbre_participants = nbre_participants;
        this.tittre = tittre;
        this.lien_Meet = lien_Meet;
        this.date = date;
        this.formateur = formateur;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNbre_max() {
        return nbre_max;
    }

    public void setNbre_max(int nbre_max) {
        this.nbre_max = nbre_max;
    }

    public int getNbre_participants() {
        return nbre_participants;
    }

    public void setNbre_participants(int nbre_participants) {
        this.nbre_participants = nbre_participants;
    }

    public String getTittre() {
        return tittre;
    }

    public void setTittre(String tittre) {
        this.tittre = tittre;
    }

    public String getLien_Meet() {
        return lien_Meet;
    }

    public void setLien_Meet(String lien_Meet) {
        this.lien_Meet = lien_Meet;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<Participation> getParticipations() {
        return participations;
    }

    public void setParticipations(List<Participation> participations) {
        this.participations = participations;
    }

    public Utilisateur getFormateur() {
        return formateur;
    }

    public void setFormateur(Utilisateur formateur) {
        this.formateur = formateur;
    }

    @Override
    public String toString() {
        return "Formation{" + "id=" + id + ", description=" + description + ", nbre_max=" + nbre_max + ", nbre_participants=" + nbre_participants + ", tittre=" + tittre + ", lien_Meet=" + lien_Meet + ", date=" + date + ", participations=" + participations + ", formateur=" + formateur + '}';
    }

    

    
    
    
}
