/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.services;

import esprit.cnx.MaConnection;
import esprit.entity.Domaine;
import esprit.entity.Utilisateur;
import esprit.interfaces.UserCrudInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ASUS
 */
public class UserService implements UserCrudInterface<Utilisateur>{
    Connection cnx;
    
    public UserService() {
        
            cnx = MaConnection.getInstance().getCnx();

    }

    @Override
    public void ajouter(Utilisateur t) {
        try{
            String sql = "insert into utilisateur(login,email,password,nom,prenom,adresse,role,domaine,numTel) values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setString(1,t.getLogin());
            ste.setString(2, t.getEmail());
            ste.setString(3,t.getPassword());
            ste.setString(4,t.getNom());
            ste.setString(5,t.getPrenom());
            ste.setString(6, t.getAdresse());
            ste.setInt(7, t.getRole());
            ste.setInt(8, t.getDomaine().getId());
            ste.setInt(9,t.getNumTel());
            ste.executeUpdate();
            System.out.println("User added succesfully ");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Utilisateur> getAllFreelancers() {
        List<Utilisateur> freelancers = new ArrayList<>();
        try {
            String sql = "select * from utilisateur where role=3";
            Statement ste = cnx.createStatement();
            ResultSet s = ste.executeQuery(sql);
            while (s.next()) {

               Utilisateur f = new Utilisateur(s.getInt("id"),s.getInt("role"), new Domaine(s.getInt("domaine")),s.getString("nom"),s.getString("email"), s.getString("password"), s.getString("prenom"), s.getString("login"), s.getInt("numTel"), s.getString("adresse"));
               freelancers.add(f);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return freelancers;
    }
    
    public ObservableList<Utilisateur> getFreelancers(){
        ObservableList<Utilisateur> freelancers = FXCollections.observableArrayList();
        try {
            String sql = "select * from utilisateur where role=3";
            Statement ste = cnx.createStatement();
            ResultSet s = ste.executeQuery(sql);
            while (s.next()) {

               Utilisateur f = new Utilisateur(s.getInt("id"),s.getInt("role"),new Domaine(s.getInt("domaine")),s.getString("nom"),s.getString("email"), s.getString("password"), s.getString("prenom"), s.getString("login"), s.getInt("numTel"), s.getString("adresse"));
               freelancers.add(f);
          

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return freelancers;
    }

    @Override
    public List<Utilisateur> getAllBuissinessOwners() {
        List<Utilisateur> businessowners = new ArrayList<>();
        try {
            String sql = "select * from utilisateur where role=2";
            Statement ste = cnx.createStatement();
            ResultSet s = ste.executeQuery(sql);
            while (s.next()) {

               Utilisateur f = new Utilisateur(s.getInt("id"),s.getInt("role"), new Domaine(s.getInt("domaine")),s.getString("nom"),s.getString("email"), s.getString("password"), s.getString("prenom"), s.getString("login"), s.getInt("numTel"), s.getString("adresse"));
               businessowners.add(f);
          

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return businessowners;
    }

    @Override
    public List<Utilisateur> getAllUsers() {
        List<Utilisateur> users = new ArrayList<>();
        try {
            String sql = "select * from utilisateur";
            Statement ste = cnx.createStatement();
            ResultSet s = ste.executeQuery(sql);
            while (s.next()) {

               Utilisateur f = new Utilisateur(s.getInt("id"),s.getInt("role"), new Domaine(s.getInt("domaine")),s.getString("nom"),s.getString("email"), s.getString("password"), s.getString("prenom"), s.getString("login"), s.getInt("numTel"), s.getString("adresse"));
               users.add(f);
          

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return users;
    }

    @Override
    public Utilisateur findByIdFreelancer(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateFreelancer(Utilisateur t) {
        String sql = "update utilisateur set nom=?,prenom=?,numTel=?,adresse=? where id=?";
        try {
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setString(1, t.getNom());
            ste.setString(2, t.getPrenom());
            ste.setInt(3, t.getNumTel());
            ste.setString(4, t.getAdresse());
            ste.setInt(5,t.getId());
            ste.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void updateBusinessOwner(Utilisateur t) {
        String sql = "update utilisateur set domaine=?,nom=?,prenom=?,numTel=?,adresse=? where id=?";
        try {
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setInt(1, t.getDomaine().getId());
            ste.setString(2, t.getNom());
            ste.setString(3, t.getPrenom());
            ste.setInt(4, t.getNumTel());
            ste.setString(5, t.getAdresse());
            ste.setInt(6,t.getId());
            ste.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void deleteUser(Utilisateur t) {
        String sql = "delete from utilisateur where id=?";
        try {
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setInt(1, t.getId());
            ste.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Utilisateur> getFreelancersByDomaine(Domaine d) {
        List<Utilisateur> users = new ArrayList<>();
        try {
            String sql = "select u.id,u.email,u.nom,u.prenom,u.numTel,u.login,u.password,u.adresse,d.nom,u.role,u.domaine from utilisateur u,domaine d where u.domaine=d.id and u.role=3 and d.nom=?";
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setString(1, d.getNom());
            ResultSet s = ste.executeQuery();
            while (s.next()) {

               Utilisateur f = new Utilisateur(s.getInt("id"),s.getInt("role"), new Domaine(s.getInt("domaine")), s.getInt("numTel"),s.getString("nom"),s.getString("email"), s.getString("password"), s.getString("prenom"), s.getString("login"), s.getString("adresse"),"Freelancer",d.getNom());
               users.add(f);
          

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return users;
    }
    
    public int Login(String l,String p){
        //Utilisateur user = new Utilisateur();
        try {
            String sql = "select count(1),role,id from utilisateur where login=? and password=?";
            
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setString(1,l);
            ste.setString(2,p);
            ResultSet res = ste.executeQuery();
            //ResultSet r = ste.getGeneratedKeys();
            while(res.next()){
                if(res.getInt(1)==1){
                    if(res.getInt("role") == 1){
                        return -1;
                    }
                    return res.getInt("id");
                }else{
                    return 0;
                }
            }
      
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        return 0;
    }
    
    
    
    
    public int getIdFromNom(String nom){
        //Utilisateur user = new Utilisateur();
        try {
            String sql = "select * from utilisateur where login=?";
            
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setString(1,nom);
            ResultSet res = ste.executeQuery();
            while(res.next()){
                return res.getInt("id");
                
            }
      
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return -1;
    }
    
    public Utilisateur getUserfromId(int id){
        Utilisateur user = new Utilisateur();
        try {
            String sql = "select * from utilisateur where id=?";
            
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setInt(1,id);
            ResultSet res = ste.executeQuery();
            while(res.next()){
                user.setId(id);
                user.setAdresse(res.getString("adresse"));
                user.setEmail(res.getString("email"));
                user.setNom(res.getString("nom"));
                user.setPrenom(res.getString("prenom"));
                user.setDomaine(new Domaine(res.getInt("domaine")));
                user.setNumTel(res.getInt("numTel"));
                user.setLogin(res.getString("login"));
                
            }
      
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return user;
    }

    
    
    
    
}
