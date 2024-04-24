/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.cnx;
import java.sql.*;

/**
 *
 * @author Asus
 */
public class MaConnection {
    
    
      private   Connection cnx ;
        String url = "jdbc:mysql://localhost:3306/pidevdb";
       String user ="root";
  String password ="";
  public static MaConnection ct;

    private MaConnection()  {
        try {
    cnx = DriverManager.getConnection(url, user, password);
                System.out.println("cnx sucess");

        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }

    }

    public static MaConnection getInstance(){
        
        if(ct == null)
            ct = new MaConnection();
         return ct;
        
    }
    
    public Connection getCnx() {
        return cnx;
    }
    
    
     
      
            
        }
        
        

