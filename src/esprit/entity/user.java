/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.entity;

/**
 *
 * @author 21624
 */
public class user {
    private int id ,role,domaine;
    private String nom,email,password,prenom,login,numTel,adresse;

    public void setDomaine(int domaine) {
        this.domaine = domaine;
    }

    public user() {
    }

    public int getDomaine() {
        return domaine;
    }

    public user(int id, int role, int domaine, String nom, String email, String password, String prenom, String login, String numTel, String adresse) {
        this.id = id;
        this.role = role;
        this.domaine = domaine;
        this.nom = nom;
        this.email = email;
        this.password = password;
        this.prenom = prenom;
        this.login = login;
        this.numTel = numTel;
        this.adresse = adresse;
    }

    public user(int role, int domaine, String nom, String email, String password, String prenom, String login, String numTel, String adresse) {
        this.role = role;
        this.domaine = domaine;
        this.nom = nom;
        this.email = email;
        this.password = password;
        this.prenom = prenom;
        this.login = login;
        this.numTel = numTel;
        this.adresse = adresse;
    }

    public user(String nom, int role, String email, String password, String prenom, String login, String numTel, String adresse) {
        this.nom = nom;
        this.role = role;
        this.email = email;
        this.password = password;
        this.prenom = prenom;
        this.login = login;
        this.numTel = numTel;
        this.adresse = adresse;
    }

    public user(int id, String nom, int role, String email, String password, String prenom, String login, String numTel, String adresse) {
        this.id = id;
        this.nom = nom;
        this.role = role;
        this.email = email;
        this.password = password;
        this.prenom = prenom;
        this.login = login;
        this.numTel = numTel;
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "user{" + "id=" + id + ", nom=" + nom + ", role=" + role + ", email=" + email + ", password=" + password + ", prenom=" + prenom + ", login=" + login + ", numTel=" + numTel + ", adresse=" + adresse + '}';
    }

    
    public void setRole(int role) {
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getLogin() {
        return login;
    }

    public String getNumTel() {
        return numTel;
    }

    public String getAdresse() {
        return adresse;
    }
    

    public user(int id) {
        this.id = id;
    }

    public user(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public user(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

  
    
}
