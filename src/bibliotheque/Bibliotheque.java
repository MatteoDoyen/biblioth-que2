package bibliotheque;

import static bibliotheque.EntreesSorties.lireDate;
import java.io.*;
import java.util.*;
import java.io.Serializable;

// Classe de gestion de la Bibliotheque
public class Bibliotheque implements Serializable{

    private static final long serialVersionUID = 262L;

    // -----------------------------------------------
    //Attributs
    // -----------------------------------------------
    private HashMap<Integer, Lecteur> lecteurs;
    private int dernierNumeroLecteur;
    private HashMap<String, Ouvrage> ouvrages;

    /*
		 * Le dictionnaire de lecteur permet à bibliotheque de 
		 * garantir l'unicité de ces derniers, et facilitent les recherches et créations.
     */
    // -----------------------------------------------
    //Constructeur
    // -----------------------------------------------
    public Bibliotheque() {
        
        this.setLecteurs(new HashMap<Integer, Lecteur>());
        this.setOuvrages(new HashMap<String, Ouvrage>());
        dernierNumeroLecteur = 0;
    }

// -----------------------------------------------
    // Public
// -----------------------------------------------	
    // -----------------------------------------------
    // Methodes
    // -----------------------------------------------
    /*
		 * La méthode nouveauLecteur permet de créé un lecteur en demandant la saisie de son numéro
		 * nom, prénom, date de naissance, adresse et numéro de téléphone.
		 * L'age doit être compris entre 3 et 110 ans
		 * Le lecteur est identifié par son numéro, si celui ci existe déjà dans le dictionnaire
		 * de bibliothèque, un message d'erreur est affiché.
		 * Une fois le nouveau lecteur créé, il est ajouté au dictionnaire de lecteur
		 * afin de garantir la cohérence des données.
     */
    public void nouveauLecteur() {
        
        System.out.println("Entrez la date de naissance du lecteur : ");
        
        Scanner Entree;
        GregorianCalendar datedujour = new GregorianCalendar();
        GregorianCalendar dateNaissance = EntreesSorties.lireDate();
        
        if (dateNaissance.compareTo(datedujour) < 0) {
            
            System.out.println("Entrez le nom du lecteur : ");
            Entree = new Scanner(System.in);
            String nomLecteur = Entree.next();
            
            System.out.println("Entrez le prenom du lecteur : ");
            Entree = new Scanner(System.in);
            String prenomLecteur = Entree.next();
            
            System.out.println("Entrez l'adresse du lecteur : ");
            Entree = new Scanner(System.in);
            String adresse = Entree.nextLine();
            
            System.out.println("Entrez le numero de téléphone du lecteur : ");
            Entree = new Scanner(System.in);
            String numeroTelephone = Entree.nextLine();
            
            dernierNumeroLecteur += 1;
            Lecteur lecteur = new Lecteur(nomLecteur, prenomLecteur, dernierNumeroLecteur, dateNaissance, adresse, numeroTelephone);
            lierLecteur(lecteur, dernierNumeroLecteur);
            
        }
        else {
            
            System.out.println("La date de naissance est supérieure à la date du jour");
        }
    }

    /*
	 * La méthode consulterLecteur permet d'afficher l'ensemble des informations relatives à
	 * un lecteur, par la saisie de son identifiant (numéro de lecteur).
	 * Si le numéro de lecteur n'est pas dans la base de données de bibliotheque un message d'erreur est
	 * renvoyé a l'utilisateur.
         * une fois le lecteur trouvé, un message lui demande de s'afficher. Il serait préférable de demander 
         * au lecteur ses infos et de les afficher. Ainsi les interactions avec l'utilisateur seraient regroupées dans la classe application
     */
    public void consulterLecteur() {
        
        Integer numLecteur = EntreesSorties.lireEntier("Entrez le numero du lecteur : ");

        Lecteur L = unLecteur(numLecteur);

        if (L != null) {
            
            L.afficherLecteur();
        }
        else {
            
            EntreesSorties.afficherMessage("Aucun lecteur n'est associe a ce numero.");
        }
    }

    // le getter getlecteurs et le setter setlecteurs sont publics pour permettre le chargement et la sauvegarde de la HashMap
    public void setLecteurs(HashMap<Integer, Lecteur> dicoLecteur) {
        
        lecteurs = dicoLecteur;
    }
    
    
    public void setOuvrages(HashMap<String, Ouvrage> dicoOuvrage) {
        
        ouvrages = dicoOuvrage;
    }

// -----------------------------------------------
    // Private
// -----------------------------------------------
    // -----------------------------------------------
    // Methodes
    // -----------------------------------------------
    /*
	 * La méthode unLecteur permet de rechercher dans la base de donnée de bibliotheque un objet 
	 * lecteur identifié par son numéro, et de renvoyer l'objet. (ou la donnée null s'il n'est pas trouvé)
     */
    private Lecteur unLecteur(Integer numLecteur) {
        
        return lecteurs.get(numLecteur);
    }

    /*
	 * La méthode lierLecteur permet d'ajouter un lecteur a la base de donnée de bibliotheque.
     */
    private void lierLecteur(Lecteur L, Integer numLecteur) {
        
        lecteurs.put(numLecteur, L);
    }

    /*
	 * La méthode leslecteurs permet de créer un iterator sur les lecteurs, dans le but de les parcourir
	 * pour eventuellement les relancer.
     */
    private Iterator<Lecteur> lesLecteurs() {
        
        return lecteurs.values().iterator();
    }

    public Ouvrage getOuvrage(String isbn) {
        
        if (ouvrages.containsKey(isbn)) {
            
            return ouvrages.get(isbn);
        }
        
        return null;
    }

    //le getter getLecteurs et le setter setLecteurs sont publics pour permettre le chargement et la sauvegarde de la HashMap
    public HashMap<Integer, Lecteur> getLecteurs() {
        
        return lecteurs;
    }
    
    public HashMap<String, Ouvrage> getOuvrages() {
        
        return ouvrages;
    }

    public void nouvelOuvrage() {
        
        System.out.println("Entrez un numero d'ISBN");
        Scanner entree = new Scanner(System.in);
        String isbn = entree.next();
        
        if (getOuvrage(isbn) == null) {
            
            System.out.println("Saisir la date de parution");
            GregorianCalendar dateParution = lireDate();
            GregorianCalendar dateJour = new GregorianCalendar();
            
            while(dateParution.compareTo(dateJour)>0)
            {
                System.out.println("La date de parution est ultérieur à aujourd'hui, veuillez rentrer une date valide");
                dateParution = lireDate();
            }
                System.out.println("Saisir le titre du nouvel ouvrage");
                entree = new Scanner(System.in);
                String titreOuvrage = entree.nextLine();
                
                System.out.println("le nom de l'éditeur");
                entree = new Scanner(System.in);
                String nomEditeur = entree.nextLine();
                
                System.out.println("le ou les auteur(s)");
                entree = new Scanner(System.in);
                String nomAuteur = entree.nextLine();
                
                System.out.println("le type de public (1 enfant,2 adolescent,3 adulte)");
                entree = new Scanner(System.in);
                TypeLecteur lecteur;
                
                switch (entree.nextInt()) {
                    
                    case 1:
                        
                        lecteur = TypeLecteur.enfant;
                        break;
                        
                    case 2:
                        
                        lecteur = TypeLecteur.adolescent;
                        break;
                        
                    case 3:
                        
                        lecteur = TypeLecteur.adulte;
                        break;
                        
                    default:
                        
                        lecteur = TypeLecteur.enfant;
                        break;
                }
                
                Ouvrage ouvrage = new Ouvrage(isbn, titreOuvrage, nomEditeur, dateParution, nomAuteur, lecteur);
                lierOuvrage(ouvrage, isbn);
                ouvrage.afficherOuvrage();
        }
        else {
            
            System.out.println("Il existe déjà un ouvrage de même isbn dans cette bibliothèque");
            
        }
    }
    
    public void nouvelOuvrage(String isbn) {
        if (getOuvrage(isbn) == null) {
            
            System.out.println("Saisir la date de parution");
            Scanner entree = new Scanner(System.in);
            GregorianCalendar dateParution = lireDate();
            GregorianCalendar dateJour = new GregorianCalendar();
            
            while(dateParution.compareTo(dateJour)>0)
            {
                System.out.println("La date de parution est ultérieur à aujourd'hui, veuillez rentrer une date valide");
                dateParution = lireDate();
            }
                System.out.println("Saisir le titre du nouvel ouvrage");
                entree = new Scanner(System.in);
                String titreOuvrage = entree.nextLine();
                
                System.out.println("le nom de l'éditeur");
                entree = new Scanner(System.in);
                String nomEditeur = entree.nextLine();
                
                System.out.println("le ou les auteur(s)");
                entree = new Scanner(System.in);
                String nomAuteur = entree.nextLine();
                
                System.out.println("le type de public (1 enfant,2 adolescent,3 adulte)");
                entree = new Scanner(System.in);
                TypeLecteur lecteur;
                
                switch (entree.nextInt()) {
                    
                    case 1:
                        
                        lecteur = TypeLecteur.enfant;
                        break;
                        
                    case 2:
                        
                        lecteur = TypeLecteur.adolescent;
                        break;
                        
                    case 3:
                        
                        lecteur = TypeLecteur.adulte;
                        break;
                        
                    default:
                        
                        lecteur = TypeLecteur.enfant;
                        break;
                }
                
                Ouvrage ouvrage = new Ouvrage(isbn, titreOuvrage, nomEditeur, dateParution, nomAuteur, lecteur);
                lierOuvrage(ouvrage, isbn);
                ouvrage.afficherOuvrage();
        }
        else {
            
            System.out.println("Il existe déjà un ouvrage de même isbn dans cette bibliothèque");
            
        }
    }

    private void lierOuvrage(Ouvrage ouvrage, String isbn) {
        
        ouvrages.put(isbn, ouvrage);
    }

    public void nouvelExemplaire() {
        
        System.out.println("Saisissez le numero d'isbn de l'ouvrage que vous souhaitez ajouter");
        Scanner entree = new Scanner(System.in);
        String isbn= entree.next();
        Ouvrage ouvrage = getOuvrage(isbn);
        if(ouvrage == null)
         {
            
            System.out.println("Il ne semble pas exister d'ouvrage avec ce numero d'isbn, souhaitez vous le créer ? O/N");
            entree = new Scanner(System.in);
            
            if(entree.next().toLowerCase().matches("o")){
                
                nouvelOuvrage(isbn);
                ouvrage = getOuvrage(isbn);
            }
            else {
                
                System.out.println("Vous avez choisi de ne pas créer d'ouvrage du numero d'isbn saisi");
            }
            
        }
        if (ouvrage != null) {
            
            System.out.println("L'ouvrage existe, saisissez les informations relative : ");
            System.out.println("Date de reception");
            GregorianCalendar dateReception = lireDate();
            
            if (dateReception.compareTo(ouvrage.getDateParution()) > 0) {
                
                System.out.println("Nombre d'exemplaire(s) à ajouter");
                entree = new Scanner(System.in);
                int nombreExemplaire = entree.nextInt();
                
                System.out.println("Nombre d'exemplaire(s) empruntable sur le lot");
                entree = new Scanner(System.in);
                int nombreExemplaireEmpruntable = entree.nextInt();
                
                if(nombreExemplaireEmpruntable<=nombreExemplaire){
                    
                   ouvrage.ajouterExemplaire(nombreExemplaire, nombreExemplaireEmpruntable,dateReception);
                }
                else{
                    
                   System.out.println("Le nombre d'exemplaire(s) empruntable(s) est supérieur au(x) nombre(s) d'exemplaire(s)");
                }

            }
            else {
                
                System.out.println("La date de reception est inférieure à celle de parution");
            }
        }
    }
    
    
    void consulterOUvrage(){
        
        System.out.println("Entrez le numero isbn de l'ouvrage que vous souhaitez consulter");
        Scanner Entree=new Scanner(System.in);
        Ouvrage ouvrage=getOuvrage(Entree.next());
        
        if(ouvrage!=null){
            
            ouvrage.afficherOuvrage();
        }
        else{
            
            System.out.println("Il n'existe pas d'ouvrage du numéro saisi");
        }
        
    }
    
    public void consulterExemplaireOuvrage(){
       
        System.out.println("Entree un numero d'isbn correct");
        Scanner entree = new Scanner(System.in);     
        Ouvrage ouvrage = getOuvrage(entree.next());
       
        if(ouvrage != null){
           
            ouvrage.afficherOuvrage();
           
            for(Exemplaire exemplaire : ouvrage.getExemplaire()){
               
                exemplaire.afficheExemplaire();
            }
        }
        else
        {
            System.out.println("Il n'existe pas d'exemplaire du numero isbn saisi");
        }
       
    }
}


















































































