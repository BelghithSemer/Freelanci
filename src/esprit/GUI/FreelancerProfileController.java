/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package esprit.GUI;

import esprit.entity.CV;
import esprit.entity.Domaine;
import esprit.entity.Utilisateur;
import esprit.services.CvService;
import esprit.services.DomaineService;
import esprit.services.UserService;
import java.io.IOException;
import javafx.scene.image.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class FreelancerProfileController implements Initializable {

    @FXML
    private ImageView img;
    @FXML
    private Label tflogin;
    @FXML
    private Label tfBio;
    @FXML
    private Label tfDomaine;
    @FXML
    private Label tfnum;
    @FXML
    private Label tfemail;
    @FXML
    private Label tfadresse;
    @FXML
    private Label tfgit;
    @FXML
    private Label tflinkedin;
    
    private int id;
    @FXML
    private Label tfnom;
    
    Utilisateur user = new Utilisateur();
    CV cv  = new CV();
    @FXML
    private Label btnmodify;
    
    public void setId(int id) {
        this.id = id;
    }

    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    public void Show(int id){
        System.out.println(" method started"+id);
        UserService serv = new UserService();
        
        user = serv.getUserfromId(id);
        
        CvService c = new CvService();
        cv=c.getCvFromIdUser(id);
        DomaineService d = new DomaineService();
        String dom;
        //Domaine dom = new Domaine();
        dom = d.getDomaineById(user.getDomaine());
        tflogin.setText(user.getLogin());
        tfnom.setText(user.getNom()+" "+user.getPrenom());
        tfnum.setText("+216 "+user.getNumTel());
        tfgit.setText(cv.getGit());
        tflinkedin.setText(cv.getLinkedin());
        tfadresse.setText(user.getAdresse());
        tfemail.setText(user.getEmail());
        tfDomaine.setText(dom);
        System.out.println(cv.getImg());
        Image image = new Image("C:/xampp2/htdocs/Pi/Profileimages/"+cv.getImg());
        img.setImage(image);
        Circle clip = new Circle();
        clip.setRadius(image.getWidth() / 2);
        clip.setCenterX(image.getWidth() / 2);
        clip.setCenterY(image.getHeight() / 2);
        
        img.setClip(clip);
        img.setFitWidth(image.getWidth()/3 );
        img.setFitHeight(image.getHeight()/3);
        
    }
    
    public void Modifier(ActionEvent event){
                    Parent root ;
                    try{
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierProfile.fxml"));
                        root = loader.load();
                        ModifierProfileController update = loader.getController();
                        update.UpdateProfile(user, cv);
                        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        stage.setTitle("Modifier mon profile");
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                    }catch(IOException e){
                        System.out.println(e.getMessage());
                    }
    }

    @FXML
    private void Modifier(MouseEvent event) {
        Parent root ;
                    try{
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierProfile.fxml"));
                        root = loader.load();
                        ModifierProfileController update = loader.getController();
                        update.UpdateProfile(user, cv);
                        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        stage.setTitle("Modifier mon profile");
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                    }catch(IOException e){
                        System.out.println(e.getMessage());
                    }
    }
    
    
}
