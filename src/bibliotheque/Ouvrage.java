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
       
        System.out.println("isbn : "+isbn);
        System.out.println("titre : "+titre);
        System.out.println("nomEditeur : "+nomEditeur);
        System.out.println("dateParution : "+EntreesSorties.ecrireDate(dateParution));
        System.out.println("auteur(s) : "+auteurs);
        System.out.println("public : "+cible);
       
    }
   
   
   
    public void ajouterExemplaire(int nombreExemplaire, int nombreExemplaireEmpruntable, GregorianCalendar dateReception){
       
        //ajouter les exemplaires empruntable
        for(int i = 0; i < nombreExemplaireEmpruntable; i++){
            
            dernierNumeroExemplaire++;
            exemplaires.add(new Exemplaire (dernierNumeroExemplaire,dateReception,true,this));
        }
       
        //ajouter les exemplaires non empruntable
        for(int i = 0; i < nombreExemplaire-nombreExemplaireEmpruntable; i++){
            
            dernierNumeroExemplaire++;
            exemplaires.add(new Exemplaire (dernierNumeroExemplaire,dateReception,false,this));          
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
    public Exemplaire getExemplaire(int NumeroExemplaire)
    {
        Exemplaire exemplaire=null;
        for(Exemplaire unExemplaire : exemplaires)
        {
            if(unExemplaire.getNumeroExemplaire()==NumeroExemplaire)
            {
                exemplaire=unExemplaire;
            }
        }
        return exemplaire;
    }
    public TypeLecteur getTypeLecteur()
    {
        return cible;
    }
    public String getIsbn()
    {
        return isbn;
    }
    public String getTitre()
    {
        return titre;
    }
}
