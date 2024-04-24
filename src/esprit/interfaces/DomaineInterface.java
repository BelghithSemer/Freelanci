/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.interfaces;

import java.util.List;

/**
 *
 * @author ASUS
 */
public interface DomaineInterface<T>{
    public void ajouter(T t);
    
    public List<T> getAll();
    
    //public  T findByIdFreelancer(int id);
    
    public void updateDomaine(T t);
        
    public void deleteDomaine(T t);
}
