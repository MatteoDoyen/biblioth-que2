/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotheque;
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.ArrayList;

/**
 *
 * @author lievret
 */
public class Ouvrage implements Serializable{
   
    private static final long serialVersionUID = 424L;
    
    //attributs
    private String isbn;
    private String titre;
    private String nomEditeur;
    private GregorianCalendar dateParution;
    private String auteurs;
    private int dernierNumeroExemplaire;
    private TypeLecteur cible;
    private ArrayList <Exemplaire> exemplaires;
   
   
    Ouvrage(String isbn, String titre, String nomEditeur, GregorianCalendar dateParution, String nomsAuteurs, TypeLecteur cible){
       
        this.isbn = isbn;
        this.titre = titre;
        this.nomEditeur = nomEditeur;
        this.dateParution = dateParution;
        this.auteurs = nomsAuteurs;
        this.cible = cible;
        this.dernierNumeroExemplaire = 0;
        this.exemplaires = new ArrayList<>();
    }
   
    public void afficherOuvrage(){
       
        System.out.println("isbn : "+this.isbn);
        System.out.println("titre : "+this.titre);
        System.out.println("nomEditeur : "+this.nomEditeur);
        System.out.println("dateParution : "+EntreesSorties.ecrireDate(this.dateParution));
        System.out.println("auteur(s) : "+this.auteurs);
        System.out.println("public : "+this.cible);
       
    }
   
   
   
    public void ajouterExemplaire(int nombreExemplaire, int nombreExemplaireEmpruntable, GregorianCalendar dateReception){
       
        //ajouter les exemplaires empruntable
        for(int i = 0; i < nombreExemplaireEmpruntable; i++){
            
            this.dernierNumeroExemplaire++;
            this.exemplaires.add(new Exemplaire (dernierNumeroExemplaire,dateReception,true,this));
        }
       
        //ajouter les exemplaires non empruntable
        for(int i = 0; i < nombreExemplaire-nombreExemplaireEmpruntable; i++){
            
            System.out.println("test");
            this.dernierNumeroExemplaire++;
            this.exemplaires.add(new Exemplaire (dernierNumeroExemplaire,dateReception,false,this));          
        }
       
    }
   
   
    public void lierExemplaire(Exemplaire exemplaire){
       
        this.exemplaires.add(exemplaire);
    }
   
   
    public ArrayList<Exemplaire> getExemplaire(){
       
       
        return this.exemplaires;
    }
   
    public GregorianCalendar getDateParution(){
       
        return this.dateParution;
    }
   
}
