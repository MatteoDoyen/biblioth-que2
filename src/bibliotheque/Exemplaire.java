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
    private boolean disponible;
   
    public Exemplaire (int numExemplaire, GregorianCalendar dateReception,boolean empruntable,Ouvrage ouvrage){
        this.numeroExemplaire = numExemplaire;
        this.dateReception = dateReception;
        this.empruntable = empruntable;
        lierOuvrage(ouvrage);
        this.disponible=true;
    }
   
    public void afficheExemplaire(){
        System.out.println("Numero Exemplaire : " + numeroExemplaire);
        System.out.println("Date de reception : " +EntreesSorties.ecrireDate(dateReception));
        if(this.empruntable==true)
        {
            System.out.println("Empruntable : oui" );    
        }
        else
        {
            System.out.println("Empruntable : non" );    
        }
        if(this.disponible==true)
        {
            System.out.println("Disponible : oui" );    
        }
        else
        {
            System.out.println("Disponible : non" );    
        }
    }
    public void lierOuvrage(Ouvrage ouvrage){
        this.ouvrage = ouvrage;
    }
    public int getNumeroExemplaire()
    {
        return numeroExemplaire;
    }
    public boolean estEmpruntable()
    {
        return disponible&&empruntable;
    }
    public void setDisponibilite(boolean disponibilite)
    {
        disponible=disponibilite;
    }
    public Ouvrage getOuvrage()
    {
        return ouvrage;
    }
    public boolean estEmprunter()
    {
        return !disponible&&empruntable;
    }
}
