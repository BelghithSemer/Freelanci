/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.interfaces;

/**
 *
 * @author ASUS
 */
public interface CrudCvInterface<T>{
    public void ajouter(T t);
   
    public  T findByIdFreelancer(int id);
    
    public void updateCV(T t);
        
    public void deleteCV(T t);
    
}
