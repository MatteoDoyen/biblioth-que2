/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotheque;

/**
 *
 * @author doyenma
 */
public enum TypeLecteur {
    
    //attributs
    enfant("enfant",0),adolescent("adolescent",11),adulte("adulte",17);
    private String type;
    private int ageMin;
    
    
    //methodes
    TypeLecteur(String type,int ageMin)
    {
        
        this.type=type;
        this.ageMin=ageMin;
    }
    public int ageMin(){
        
        return ageMin;
    }
}
