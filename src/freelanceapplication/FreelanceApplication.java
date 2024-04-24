/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freelanceapplication;

import esprit.entity.CV;
import esprit.entity.Domaine;
import esprit.entity.Formation;
import esprit.entity.Participation;
import esprit.entity.Utilisateur;
import esprit.services.CvService;
import esprit.services.UserService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class FreelanceApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Utilisateur u = new Utilisateur(8,3, 2,"Belghith","samerbelghith2017@gmail.com","lqknjhqbkcjh","Semer","SemerBelghith",20320859,"Avenue Mohamed V");
        //Utilisateur u = new Utilisateur(2, 1,"Stou","stou2023@gmail.com","lqknjhqbk","Ra3d","STOU",28194715,"Wardiya,Tunis");
        Utilisateur u = new Utilisateur();
        UserService serv = new UserService();
        u = serv.getUserfromId(18);
        CvService c = new CvService();
        CV cv = new CV();
        cv=c.getCvFromIdUser(18);
        System.out.println(u);
        System.out.println(cv);
        //serv.ajouter(u);
        //serv.updateFreelancer(u);
        //List<Utilisateur> list = new ArrayList<Utilisateur>();
        //Domaine d = new Domaine(3,"Marketing");
        //list = serv.getFreelancersByDomaine(d);
        //System.out.println(list);
        //serv.deleteUser(u);
     
        
        
    }
    
}
