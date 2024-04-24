/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.services;

import esprit.cnx.MaConnection;
import esprit.entity.CV;
import esprit.entity.Domaine;
import esprit.interfaces.CrudCvInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class CvService implements CrudCvInterface<CV>{
    Connection cnx;
    
    public CvService() {
        
            cnx = MaConnection.getInstance().getCnx();

    }

    @Override
    public void ajouter(CV t) {
        try{
            String sql = "insert into CV(id_utilisateur,pdf_cv,img,link_github,link_linkedin,bio) values(?,?,?,?,?,?)";
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setInt(1,t.getUser().getId());
            ste.setString(2, t.getCv());
            ste.setString(3,t.getImg());
            ste.setString(4,t.getGit());
            ste.setString(5,t.getLinkedin());
            ste.setString(6, t.getBio());
            ste.executeUpdate();
            System.out.println("CV added succesfully ");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public CV findByIdFreelancer(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateCV(CV t) {
        String sql = "update CV set pdf_cv=?,img=?,link_github=?,link_linkedin=?,bio=? where id=?";
        try {
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setString(1, t.getCv());
            ste.setString(2, t.getImg());
            ste.setString(3, t.getGit());
            ste.setString(4, t.getLinkedin());
            ste.setString(5, t.getBio());
            ste.setInt(6,t.getId());
            ste.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void deleteCV(CV t) {
        String sql = "delete from CV where id=?";
        try {
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setInt(1, t.getId());
            ste.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public CV getCvFromIdUser(int id){
        CV cv = new CV();
        try {
            String sql = "select * from cv where id_utilisateur=?";
            
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setInt(1,id);
            ResultSet res = ste.executeQuery();
            while(res.next()){
                cv.setBio(res.getString("bio"));
                cv.setCv(res.getString("pdf_cv"));
                cv.setId(res.getInt("id"));
                cv.setGit(res.getString("link_github"));
                cv.setLinkedin(res.getString("link_linkedin"));
                cv.setImg(res.getString("img"));
                
            }
      
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return cv;
    }
    
}
