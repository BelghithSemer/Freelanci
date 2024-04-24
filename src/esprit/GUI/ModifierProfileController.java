/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package esprit.GUI;

import esprit.entity.CV;
import esprit.entity.Utilisateur;
import esprit.services.CvService;
import esprit.services.DomaineService;
import esprit.services.UserService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ModifierProfileController implements Initializable {

    @FXML
    private ImageView img;
    @FXML
    private Label tflogin;
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfprenom;
    @FXML
    private TextField tfnum;
    @FXML
    private TextField tfadresse;
    @FXML
    private TextField tfgit;
    @FXML
    private TextField tflinkedin;
    @FXML
    private TextField tfbio;
    @FXML
    private Button btnimg;
    @FXML
    private Button btncv;
    @FXML
    private Button btnmodifier;
    String image_path,pdf;
    Utilisateur user = new Utilisateur();
    UserService serv = new UserService();
       CvService c = new CvService();
    CV cv  = new CV();
    @FXML
    private Label errormsg;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void UpdateProfile(Utilisateur user, CV cv){
        System.out.println(" method Update started"+user.getId());
        
        
        user = serv.getUserfromId(user.getId());
        
     
        cv=c.getCvFromIdUser(user.getId());
        DomaineService d = new DomaineService();
        String dom;
        //Domaine dom = new Domaine();
        dom = d.getDomaineById(user.getDomaine());
        tflogin.setText(user.getLogin());
        tfnom.setText(user.getNom());
        tfprenom.setText(user.getPrenom());
        tfnum.setText(""+user.getNumTel());
        tfgit.setText(cv.getGit());
        tflinkedin.setText(cv.getLinkedin());
        tfadresse.setText(user.getAdresse());
        
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
        
        
        
        System.out.println(" method Update ended succesfully"+user.getId());
    }
    
    @FXML
    public void choisirImage(){
        FileChooser fc = new FileChooser();
        fc.setTitle("Choisir Votre Image de profile");
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("*jpeg","*png","*jpg"));
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
        cv.setImg(f.getName());
    }
    
    
    
    @FXML
    public void choisirCv(){
        System.out.println("Methode choisir cv started .");
        FileChooser fc = new FileChooser();
        fc.setTitle("Choisir Votre CV");
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
        File file = fc.showOpenDialog(new Stage());
        File f = new File(file.getAbsolutePath());
        try {
            InputStream input = new FileInputStream(f);
            FileOutputStream output = new FileOutputStream("C:/xampp2/htdocs/Pi/CV/" + f.getName());
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = input.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException i) {
            System.out.println(i);
        }
        cv.setCv(f.getName());
         System.out.println("Methode choisir cv ended .");
        
    }

    @FXML
    private void Modifier(ActionEvent event) {
        /// Updating The user and cv in the database
        if(tfnom.getText().isEmpty() != true || tfprenom.getText().isEmpty() != true || tfnum.getText().isEmpty() != true
                || tfadresse.getText().isEmpty() != true || tfgit.getText().isEmpty() != true || tflinkedin.getText().isEmpty() != true
                || tfbio.getText().isEmpty() != true){
            
            user.setAdresse(tfadresse.getText());
            user.setNom(tfnom.getText());
            user.setNumTel(Integer.valueOf(tfnum.getText()));
            user.setPrenom(tfprenom.getText());
            cv.setBio(tfbio.getText());
            cv.setGit(tfgit.getText());
            cv.setLinkedin(tflinkedin.getText());
            serv.updateFreelancer(user);
            c.updateCV(cv);
            System.out.println("Modified Successfully ! ");
        }
        errormsg.setText("SVP Remplir Touts les champs !");
        
    }
    
    
}
