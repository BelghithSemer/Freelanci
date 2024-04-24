/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.services;

/**
 *
 * @author 21624
 */
public class QueryUtil {
    public static String updateFormation(int id){
        return "update formation set tittre = ? where id = "  +id ;
    }
    public static String updateParticipation(int id){
        return "update participation set date = ? where id = "  +id ;
    }
}
