/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freelanceapplication;

import esprit.GUI.FreelancerProfileController;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author ASUS
 */
public class Test extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Parent root ;
        try{
            root = FXMLLoader.load(getClass().getResource("../esprit/GUI/SignIn.fxml"));
            Scene scene = new Scene(root, 600, 400);
        
            
            /*FXMLLoader loader = FXMLLoader.load(getClass().getResource("../esprit/GUI/FreelancerProfile.fxml"));
            root = loader.load();
            FreelancerProfileController u = loader.getController();
            u.setId(18);
            Scene scene = new Scene(root, 600, 400);
            */
            primaryStage.setTitle("Sign In");
            primaryStage.initStyle(StageStyle.DECORATED); 
            primaryStage.setScene(scene);
            primaryStage.show();
           
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
       
    }

    /**
     * @param args the command line arguments
    */
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
