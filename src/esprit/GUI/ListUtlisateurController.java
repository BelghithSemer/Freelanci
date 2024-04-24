/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.GUI;

import esprit.entity.Utilisateur;
import esprit.services.UserService;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ListUtlisateurController implements Initializable {

    @FXML
    private TableView<Utilisateur> FreelancersTable =new TableView<Utilisateur>();
    @FXML
    private TableColumn<Utilisateur, Integer> idCol = new TableColumn<>("id");
    @FXML
    private TableColumn<Utilisateur, String> email= new TableColumn<>("email");
    @FXML
    private TableColumn<Utilisateur, Integer> numTel= new TableColumn<>("numTel");
    @FXML
    private TableColumn<Utilisateur, String> nom= new TableColumn<>("nom");
    @FXML
    private TableColumn<Utilisateur, String> prenom = new TableColumn<>("prenom");
    @FXML
    private TableColumn<Utilisateur, String> adresse = new TableColumn<>("adresse");
    
    


    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            idCol.setCellValueFactory(new PropertyValueFactory<Utilisateur , Integer>("idCol"));
            email.setCellValueFactory(new PropertyValueFactory<Utilisateur , String>("email"));
            numTel.setCellValueFactory(new PropertyValueFactory<Utilisateur , Integer>("numTel"));
            nom.setCellValueFactory(new PropertyValueFactory<Utilisateur , String>("nom"));
            prenom.setCellValueFactory(new PropertyValueFactory<Utilisateur , String>("prenom"));
            adresse.setCellValueFactory(new PropertyValueFactory<Utilisateur , String>("adresse"));
            UserService serv = new UserService();
            ObservableList<Utilisateur> data = FXCollections.observableArrayList();
            //List<Utilisateur> list = new ArrayList<Utilisateur>();
            data = serv.getFreelancers();
            
            FreelancersTable.getColumns().addAll(idCol,email,numTel,nom,prenom,adresse);
            FreelancersTable.setItems(data);
            
            
            
            
            
            
            
            
    }    

    
    
}
