/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotheque;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Exemplaire implements Serializable{
   
    private GregorianCalendar dateReception;
    private int numeroExemplaire;
    private boolean empruntable;
    private Ouvrage ouvrage;
   
    public Exemplaire (int numExemplaire, GregorianCalendar dateReception,boolean empruntable,Ouvrage ouvrage){
        this.numeroExemplaire = numExemplaire;
        this.dateReception = dateReception;
        this.empruntable = empruntable;
        this.lierOuvrage(ouvrage);
    }
   
    public void afficheExemplaire(){
        System.out.println("Numero Exemplaire : " + this.numeroExemplaire);
        System.out.println("Date de reception : " +EntreesSorties.ecrireDate(this.dateReception));
        if(this.empruntable==true)
        {
            System.out.println("Empruntable : oui" );    
        }
        else
        {
            System.out.println("Empruntable : non" );    
        }
    }
    public void lierOuvrage(Ouvrage ouvrage){
        this.ouvrage = ouvrage;
    } 
}
