package bibliotheque;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;

// Classe de gestion de Lecteur
public class Lecteur implements Serializable {

    private static final long serialVersionUID = 422L;

    // -----------------------------------------------
    //Attributs
    // -----------------------------------------------
    private String nom;
    private String prenom;
    private Integer numeroLecteur;
    private GregorianCalendar dateNaissance;
    private String adresse;
    private String numeroTelephone;
    private ArrayList<Exemplaire> Exemplaires;

    // -----------------------------------------------
    //Constructeur
    // -----------------------------------------------
    public Lecteur(String nom, String prenom, Integer numLecteur, GregorianCalendar dateNaissance, String adresse, String numeroTelephone) {
        
        nom = nom;
        prenom = prenom;
        numeroLecteur = numLecteur;
        dateNaissance = dateNaissance;
        adresse = adresse;
        numeroTelephone = numeroTelephone;
        Exemplaires=new ArrayList<>();
    }

   
    // -----------------------------------------------
    // Methodes
    // -----------------------------------------------

    /*
* La methode afficherLecteur affiche l'ensemble des informations relatives à un lecteur.
     */
    public void afficherLecteur() {
        
        
        System.out.println("Numero lecteur : " + numeroLecteur);
        System.out.println("Nom et prenom du lecteur: " + nom + " " + prenom);
        System.out.println("Age : " + calculAge() + " ans");
        System.out.println("Adresse : " + adresse);
        System.out.println("Telephone : " + numeroTelephone);
        if(Exemplaires!= null)
        {
            System.out.println("Exemplaires empruntés");
            for(Exemplaire exemplaire : Exemplaires)
            {
                exemplaire.afficheExemplaire();
            }
        }
        EntreesSorties.afficherMessage("");
    }

    /*
* la methode calculAge permet de determiner l'age des lecteurs grace a leur date de naissance
* et la date actuelle. De cette façon, il n'y a pas de mise a jour a faire sur l'age des lecteurs.
     */
    public Integer calculAge() {
        
        Integer age;
        GregorianCalendar dateNaissComp;
        GregorianCalendar dateActuelle = new GregorianCalendar();
        dateNaissComp = new GregorianCalendar(dateActuelle.get(GregorianCalendar.YEAR), dateNaissance.get(GregorianCalendar.MONTH), dateNaissance.get(GregorianCalendar.DATE));
        
        if (dateNaissComp.before(dateActuelle)) {
            
            age = dateActuelle.get(GregorianCalendar.YEAR) - dateNaissance.get(GregorianCalendar.YEAR);
        }
        else {
            
            age = dateActuelle.get(GregorianCalendar.YEAR) - dateNaissance.get(GregorianCalendar.YEAR) - 1;
        }
        
        return age;
    }

}







