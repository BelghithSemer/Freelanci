/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.GUI;

import esprit.entity.Domaine;
import esprit.entity.Utilisateur;
import esprit.services.DomaineService;
import esprit.services.UserService;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class SignUpFreelancerController implements Initializable {

    @FXML
    private TextField loginCol;
    @FXML
    private TextField nomCol;
    @FXML
    private TextField prenomCol;
    @FXML
    private TextField emailCol;
    @FXML
    private TextField adresseCol;
    @FXML
    private PasswordField mdpCol;
    @FXML
    private PasswordField mdp2Col;
    @FXML
    private TextField numTelCol;
    @FXML
    private Button btn;
    @FXML
    private Label message;
    @FXML
    private ChoiceBox<String> box;
    @FXML
    private Label msg;
    @FXML
    private Label msgmail;
    @FXML
    private Label msgnum;
    @FXML
    private Label msglogin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DomaineService dom = new DomaineService();
        List<Domaine> domaines = new ArrayList<Domaine>();
        domaines = dom.getAll();
        List<String> doms = new ArrayList<String>();
        for(Domaine d : domaines){
            doms.add(d.getNom());
        }
        box.getItems().addAll(doms);
    }    
    
    @FXML
    public void CreateAccount(ActionEvent event){
        int idd=0;
        DomaineService dom = new DomaineService();
        idd = dom.getDomaineId(box.getValue());
        Domaine d = new Domaine(idd);
        if(loginCol.getText().isEmpty() == false && nomCol.getText().isEmpty() == false && prenomCol.getText().isEmpty() == false 
                && emailCol.getText().isEmpty() == false && adresseCol.getText().isEmpty() == false && mdpCol.getText().isEmpty() == false 
                && mdp2Col.getText().isEmpty() == false && numTelCol.getText().isEmpty() == false 
                && box.getValue() != null && idd != 0){
            if( checkEmail() && checkLogin() && checkNumTel()){
                Utilisateur user = new Utilisateur();
                UserService serv = new UserService();
                user.setEmail(emailCol.getText());
                user.setAdresse(adresseCol.getText());
                user.setNumTel(Integer.valueOf(numTelCol.getText()));
                user.setNom(nomCol.getText());
                user.setPrenom(prenomCol.getText());
                user.setLogin(loginCol.getText());
                user.setRole(3);
                user.setDomaine(d);
                user.setPassword(mdpCol.getText());
                serv.ajouter(user);
                
            }else{
               message.setText("Donnes mal ecrit !");

            }
        }else{
            message.setText("Completer tous les champs svp ! ");
        }
        
        Parent root ;
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddCV.fxml"));
            root = loader.load();
            AddCVController AddCVUser = loader.getController();
            AddCVUser.setUserLogin(loginCol.getText());
            
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }       
    }
    
    public boolean checkPassword(){
        if(mdpCol.getText() != mdp2Col.getText()){
            message.setText("Mot de passe non confirmer !");
            msg.setText("ici probleme");
            return false;
        } 
        return true;
    }
    
    public boolean checkEmail(){
        String emailRegex = "^(\\S+)\\@(\\S+)\\.(\\S+)$";

        Pattern pat  = Pattern.compile(emailRegex);
        if(pat.matcher(emailCol.getText()).matches()){
            return true;
        }else{
            msgmail.setText("prob ici");
            return false;
        }
 
    }
    
    public boolean checkLogin(){
        UserService serv = new UserService();
        List<Utilisateur> list = new ArrayList<Utilisateur>();
        list = serv.getAllUsers();
        for(Utilisateur u :  list){
            if (u.getLogin() == loginCol.getText()){
                msglogin.setText("prob ici");
                return false;
            }
        }
        return true; 
        }
    
    public boolean checkNumTel(){
        if(numTelCol.getText().matches("\\d{8}")){
            return true;
        }
        msgnum.setText("prob ici");
        return false;
    }
    
}
