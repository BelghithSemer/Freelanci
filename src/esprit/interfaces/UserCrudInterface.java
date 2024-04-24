/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.interfaces;

import esprit.entity.Domaine;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface UserCrudInterface<T> {
    
    public void ajouter(T t);
   
    public List<T> getAllFreelancers();
    
    public List<T> getFreelancersByDomaine(Domaine d);
    
    public List<T> getAllBuissinessOwners();
    
    public List<T> getAllUsers();
   
    public  T findByIdFreelancer(int id);
    
    public void updateFreelancer(T t);
    
    public void updateBusinessOwner(T t);
        
    public void deleteUser(T t);
}
