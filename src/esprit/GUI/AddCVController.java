/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.GUI;

import esprit.entity.CV;
import esprit.entity.Utilisateur;
import esprit.services.CvService;
import esprit.services.UserService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AddCVController implements Initializable {

    @FXML
    private TextField linkedinCol;
    @FXML
    private TextField githubCol;
    @FXML
    private Button btnimg;
    @FXML
    private ImageView img;
    
    String image,pdf;
    @FXML
    private Button btnAjouter;
    private String userLogin;

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserLogin() {
        return userLogin;
    }
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    @FXML
    public String choisirImage(){
        /*FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(new ExtensionFilter("*jpeg","*png","*jpg"));
        File file = fc.showOpenDialog(new Stage());
        System.out.println(file);
        image = file.toString();
        return file.toString();*/
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(new ExtensionFilter("*jpeg","*png","*jpg"));
        File file = fc.showOpenDialog(new Stage());
        File f = new File(file.getAbsolutePath());
        try{
        InputStream input = new FileInputStream(f);
        FileOutputStream output  = new FileOutputStream("C:/xampp2/htdocs/Pi/Profileimages/"+f.getName());
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
        while((bytesRead = input.read(buffer)) != -1){
            output.write(buffer, 0, bytesRead);
        }
        }catch(FileNotFoundException e){
            System.out.println(e);
        }catch(IOException i){
            System.out.println(i);
        }
        image=f.getName();
        return "/"+f.getName();
   }
    
    @FXML
    public String choisirCv(){
        /*FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(new ExtensionFilter("PDF File","*pdf"));
        File file = fc.showOpenDialog(new Stage());
        System.out.println(file);
        pdf = file.toString();
        //test
        System.out.println(userLogin);
        CV cv = new CV();
        UserService us = new UserService();
        int idu;
        idu = us.getIdFromNom(userLogin);
        System.out.println(idu);
        */
        // fin 
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(new ExtensionFilter("*pdf"));
        File file = fc.showOpenDialog(new Stage());
        File f = new File(file.getAbsolutePath());
        try{
        InputStream input = new FileInputStream(f);
        FileOutputStream output  = new FileOutputStream("C:/xampp2/htdocs/Pi/CV/"+f.getName());
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
        while((bytesRead = input.read(buffer)) != -1){
            output.write(buffer, 0, bytesRead);
        }
        }catch(FileNotFoundException e){
            System.out.println(e);
        }catch(IOException i){
            System.out.println(i);
        }
        pdf=f.getName();
        return "/"+f.getName();
        
    }
    
    
    @FXML
    public void AddCvOnAction(){
        if(githubCol.getText().isEmpty() != true && linkedinCol.getText().isEmpty() != true 
                && pdf != null && image != null){
            CvService serv = new CvService();
            CV cv = new CV();
            UserService us = new UserService();
            
            cv.setCv(pdf);
            cv.setGit(githubCol.getText());
            cv.setLinkedin(linkedinCol.getText());
            cv.setImg(image);
            int idu;
            System.out.println(userLogin);
            idu = us.getIdFromNom(userLogin);
            System.out.println(idu);
            Utilisateur u = new Utilisateur(idu);
            cv.setUser(u);
            cv.setBio("Je suis beaux");
            serv.ajouter(cv);
        }else{
            System.out.print("il manque encore des champs ! ");
        }
    }

 
    
    
}
