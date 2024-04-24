/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.GUI;

import esprit.services.UserService;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class SignInController implements Initializable {

    @FXML
    private TextField loginCol;
    @FXML
    private PasswordField mdpCol;
    @FXML
    private Button loginBtn;
    @FXML
    private Label message;
    @FXML
    private Button btnbusinessowner;
    @FXML
    private Button btnfreelancer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void loginBtnOnAction(ActionEvent event) {
        if(loginCol.getText().isEmpty() == false && mdpCol.getText().isEmpty() == false){
            UserService serv = new UserService();
            int res = serv.Login(loginCol.getText(), mdpCol.getText());
            if(res == -1){
               Parent root ;
                    try{
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("listUtlisateur.fxml"));
                        root = loader.load();
                        ListUtlisateurController listUsers = loader.getController();

                        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        stage.setTitle("List Utilisateur");
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                    }catch(IOException e){
                        System.out.println(e.getMessage());
                    }
                
            }else{
                if(res > 0){
                  message.setText("Login Succes n : "+res);  
                  System.out.print("succes signIn , user_id : "+res);
                  Parent root ;
                    try{
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("FreelancerProfile.fxml"));
                        root = loader.load();
                        FreelancerProfileController u = loader.getController();
                        u.setId(res);
                        u.Show(res);
                        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        stage.setTitle("Mon Profile");
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                    }catch(IOException e){
                        System.out.println(e.getMessage());
                    }
            }
        else{
            message.setText("Champs Vides!");
        }
        
    }
    }}

    @FXML
    private void SignUpBusinessOwnerOnAction(ActionEvent event) {
        Parent root ;
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUpUser.fxml"));
            root = loader.load();
            SignUpUserController signUpUser = loader.getController();
            
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void SignUpFreelancerOnAction(ActionEvent event) {
        Parent root ;
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUpFreelancer.fxml"));
            root = loader.load();
            SignUpFreelancerController signUpFreelancer = loader.getController();
            
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    
    
    
    
    
    
    
}
