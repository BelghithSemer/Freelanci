/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.interfaces;

import java.util.List;

/**
 *
 * @author 21624
 */
public interface InterfaceService <p>{
     public void ajouter(p t);
    public List<p> getAll();
    public boolean findById(int id);
}
