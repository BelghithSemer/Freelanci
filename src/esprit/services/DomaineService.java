/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.services;

import esprit.cnx.MaConnection;
import esprit.entity.Domaine;
import esprit.interfaces.DomaineInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class DomaineService implements DomaineInterface<Domaine>{
    Connection cnx;
    
    public DomaineService() {
        
            cnx = MaConnection.getInstance().getCnx();

    }
    @Override
    public void ajouter(Domaine t) {
        try{
            String sql = "insert into Domaine(nom) values(?)";
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setString(1,t.getNom());
            ste.executeUpdate();
            System.out.println("Domaine added succesfully ");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Domaine> getAll() {
        List<Domaine> domaines = new ArrayList<>();
        try {
            String sql = "select * from Domaine ";
            Statement ste = cnx.createStatement();
            ResultSet s = ste.executeQuery(sql);
            while (s.next()) {

               Domaine f = new Domaine(s.getInt("id"),s.getString("nom"));
               domaines.add(f);
          

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return domaines;
    }

    @Override
    public void updateDomaine(Domaine t) {
        String sql = "update Domaine set nom=? where id=?";
                try {
                    PreparedStatement ste = cnx.prepareStatement(sql);
                    ste.setString(1, t.getNom());
                    ste.setInt(2, t.getId());
                    ste.executeUpdate();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }    }

    @Override
    public void deleteDomaine(Domaine t) {
        String sql = "delete from Domaine where id=?";
        try {
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setInt(1, t.getId());
            ste.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public int getDomaineId(String nom){
        List<Domaine> domaines = new ArrayList<>();
        int idd=0;
        try {
            String sql = "Select * from Domaine where domaine.nom = ?";
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setString(1,nom);
            ResultSet s = ste.executeQuery();
            
            while (s.next()) {

               Domaine f = new Domaine(s.getInt("id"),s.getString("nom"));
               idd=s.getInt("id");
               domaines.add(f);
          

            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return idd;
        
    }
    
    public String getDomaineById(Domaine d){
        String dom="";
        try {
            String sql = "select * from domaine where id=?";
            
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setInt(1,d.getId());
            ResultSet res = ste.executeQuery();
            while(res.next()){
                dom=res.getString("nom");
            }
      
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        return dom;
    }
    
}
