/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotheque;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Exemplaire implements Serializable{
    
    /*attributs*/
    
    private GregorianCalendar dateReception;
    private int numeroExemplaire;
    private boolean empruntable;
    private Ouvrage ouvrage;
    private boolean disponible;
    
    
    /*constructeurs*/
    
    public Exemplaire (int numExemplaire, GregorianCalendar dateReception,boolean empruntable,Ouvrage ouvrage){
        
        this.numeroExemplaire = numExemplaire;
        this.dateReception = dateReception;
        this.empruntable = empruntable;
        lierOuvrage(ouvrage);
        this.disponible=true;
    }
    
    
    /*méthode d'affichage*/
    
    public void afficheExemplaire(){
        
        System.out.println("Numero Exemplaire : " + numeroExemplaire);
        System.out.println("Date de reception : " +EntreesSorties.ecrireDate(dateReception));
        
        //affichage du caractère empruntable
        if(this.empruntable==true)
        {
            
            System.out.println("Empruntable : oui" );    
        }
        else
        {
            
            System.out.println("Empruntable : non" );    
        }
        
        //affichage de la disponiblité de l'exemplaire
        if(this.disponible==true)
        {
            
            System.out.println("Disponible : oui" );    
        }
        else
        {
            
            System.out.println("Disponible : non" );    
        }
    }
    
    /*linkeur*/
    
    public void lierOuvrage(Ouvrage ouvrage){
        
        this.ouvrage = ouvrage;
    }
    
    /*méthodes de gestion de la disponiblité d'un exemplaire*/
    
    public boolean estEmpruntable()
    {
        return disponible&&empruntable;
    }
    
    
    public boolean estEmprunte()
    {
        return !disponible&&empruntable;
    }
    
    
    public void setDisponibilite(boolean disponibilite)
    {
        disponible=disponibilite;
    }
    
    
    /*getteurs*/
    
    public Ouvrage getOuvrage()
    {
        return ouvrage;
    }
    
    public int getNumeroExemplaire()
    {
        return numeroExemplaire;
    }
}
