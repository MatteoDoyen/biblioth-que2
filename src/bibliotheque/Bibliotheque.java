package bibliotheque;

import static bibliotheque.EntreesSorties.lireDate;
import java.io.*;
import java.util.*;
import java.io.Serializable;

// Classe de gestion de la Bibliotheque
public class Bibliotheque implements Serializable {

    private static final long serialVersionUID = 262L;

    // -----------------------------------------------
    //Attributs
    // -----------------------------------------------
    private HashMap<Integer, Lecteur> lecteurs;
    private int dernierNumeroLecteur;
    private HashMap<String, Ouvrage> ouvrages;
    private ArrayList<Emprunt> emprunts;

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
        emprunts=new ArrayList<>();
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
            System.out.println("Le nouveau lecteur à été créé");
        } else {

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
        } else {

            EntreesSorties.afficherMessage("Aucun lecteur n'est associe a ce numero.");
        }
    }

    // le getter getlecteurs et le setter setlecteurs sont publics pour permettre le chargement et la sauvegarde de la HashMap
    private void setLecteurs(HashMap<Integer, Lecteur> dicoLecteur) {

        lecteurs = dicoLecteur;
    }

    private void setOuvrages(HashMap<String, Ouvrage> dicoOuvrage) {

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


    private Ouvrage getOuvrage(String isbn) {

        if (ouvrages.containsKey(isbn)) {

            return ouvrages.get(isbn);
        }

        return null;
    }

    //le getter getLecteurs et le setter setLecteurs sont publics pour permettre le chargement et la sauvegarde de la HashMap
    private Lecteur getLecteur(int numeroLecteur) {

        return lecteurs.get(numeroLecteur);
    }

    public void nouvelOuvrage() {

        System.out.println("Entrez un numero d'ISBN");
        Scanner entree = new Scanner(System.in);
        String isbn = entree.next();

        if (getOuvrage(isbn) == null) {

            System.out.println("Saisir la date de parution");
            GregorianCalendar dateParution = lireDate();
            GregorianCalendar dateJour = new GregorianCalendar();

            while (dateParution.compareTo(dateJour) > 0) {
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

                    lecteur = TypeLecteur.adulte;
                    break;
            }

            Ouvrage ouvrage = new Ouvrage(isbn, titreOuvrage, nomEditeur, dateParution, nomAuteur, lecteur);
            lierOuvrage(ouvrage, isbn);
        } else {

            System.out.println("Il existe déjà un ouvrage de même isbn dans cette bibliothèque");

        }
    }
    
    private void nouvelOuvrageIsbn(String isbn) {
        if (getOuvrage(isbn) == null) {

            System.out.println("Saisir la date de parution");
            Scanner entree = new Scanner(System.in);
            GregorianCalendar dateParution = lireDate();
            GregorianCalendar dateJour = new GregorianCalendar();

            while (dateParution.compareTo(dateJour) > 0) {
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
        String isbn = entree.next();
        Ouvrage ouvrage = getOuvrage(isbn);
        if (ouvrage == null) {

            System.out.println("Il ne semble pas exister d'ouvrage avec ce numero d'isbn, souhaitez vous le créer ? O/N");
            entree = new Scanner(System.in);
            
            if(entree.next().toLowerCase().matches("o")){
                
                nouvelOuvrageIsbn(isbn);
                ouvrage = getOuvrage(isbn);
                System.out.println("L'ouvrage à été créé, vous allez maintenant lui créer des exemplaires");
            } else {

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

                if (nombreExemplaireEmpruntable <= nombreExemplaire) {

                    ouvrage.ajouterExemplaire(nombreExemplaire, nombreExemplaireEmpruntable, dateReception);
                    System.out.println("Tout les exemplaires ont été ajoutés");
                } else {

                    System.out.println("Le nombre d'exemplaire(s) empruntable(s) est supérieur au(x) nombre(s) d'exemplaire(s)");
                }

            } else {

                System.out.println("La date de reception est inférieure à celle de parution");
            }
        }
    }

    void consulterOUvrage() {

        System.out.println("Entrez le numero isbn de l'ouvrage que vous souhaitez consulter");
        Scanner Entree = new Scanner(System.in);
        Ouvrage ouvrage = getOuvrage(Entree.next());

        if (ouvrage != null) {

            ouvrage.afficherOuvrage();
        } else {

            System.out.println("Il n'existe pas d'ouvrage du numéro saisi");
        }

    }

    public void consulterExemplaireOuvrage() {

        System.out.println("Entree un numero d'isbn correct");
        Scanner entree = new Scanner(System.in);
        Ouvrage ouvrage = getOuvrage(entree.next());

        if (ouvrage != null&&ouvrage.getNombreExemplaire()>0) {

            ouvrage.afficherOuvrage();

            for (Exemplaire exemplaire : ouvrage.getExemplaire()) {

                exemplaire.afficheExemplaire();
                System.out.println();
            }
        } else {
            System.out.println("Il n'existe pas d'exemplaire du numero isbn saisi ou il n'a aucun exemplaire");
        }
    }

    void emprunterExemplaire() {
        Scanner entree;
        System.out.println("Saisir le numero d'isbn de l'exemplaire à emprunter");
        entree = new Scanner(System.in);
        Ouvrage ouvrage= getOuvrage(entree.next());
        if (ouvrage != null) {
            System.out.println("Saisir le numero de lecteur");
            entree = new Scanner(System.in);
            int numeroLecteur = entree.nextInt();
            Lecteur lecteur=getLecteur(numeroLecteur);
            if (lecteur != null) {
                System.out.println("Saisir le numero d'exemplaire que vous souhaitez emprunter");
                entree = new Scanner(System.in);
                Exemplaire exemplaire=ouvrage.getExemplaire(entree.nextInt());
                if(exemplaire!=null)
                {
                    if(exemplaire.estEmpruntable()&&lecteur.getNbEmprunt()<5)
                    {
                        if(lecteur.calculAge()>=ouvrage.getTypeLecteur().ageMin())
                        {
                            lierEmprunt(numeroLecteur,exemplaire,ouvrage,lecteur);
                        }
                        else
                        {
                            System.out.println("Le lecteur est trop jeune pour emprunter l'exemplaire");
                        }
                    }
                    else
                    {
                        System.out.println("L'exemplaire n'est pas empruntable ou le lecteur à trop d'emprunt");
                    }
                }
                else
                {
                     System.out.println("Le numero d'exemplaire ne correspond à aucun exemplaire pour le numero d'isbn rentré");
                }
                
            } else {
                System.out.println("Aucun lecteur ne correspond au numero de lecteur");
            }
        } else {
            System.out.println("Aucun ouvrage ne correspond au numero d'isbn saisi");
        }

    }
    public void lierEmprunt(int numeroLecteur,Exemplaire exemplaire,Ouvrage ouvrage,Lecteur lecteur)
    {
         Emprunt emprunt = new Emprunt(numeroLecteur,ouvrage.getIsbn(),ouvrage.getTitre(),exemplaire.getNumeroExemplaire());
         this.emprunts.add(emprunt);
         lecteur.modifierEmprunt(1);
         exemplaire.setDisponibilite(false);
         System.out.println("L'exemplaire est emprunté, voici les informations concernant l'emprunt :");
         emprunt.afficherEmprunt();
    }

    public void RendreExemplaire()
    {
        Scanner entree=new Scanner(System.in);
        System.out.println("Veuillez rentrez le numero d'isbn de l'exemplaire à rendre");
        Ouvrage ouvrage=getOuvrage(entree.next());
        if(ouvrage!=null)
        {
            System.out.println("Veuillez rentrez le numero d'exemplaire emprunté");
            Exemplaire exemplaire=ouvrage.getExemplaire(entree.nextInt());
            if(exemplaire!=null&&exemplaire.estEmprunte())
            {
                Emprunt emprunt=null;
                for(int i =0;i<emprunts.size()&&emprunt==null;i++)
                {
                    if(getOuvrage(emprunts.get(i).getIsbn())==ouvrage&&emprunts.get(i).getNumExemplaire()==exemplaire.getNumeroExemplaire())
                    {
                        emprunt=emprunts.get(i);
                    }
                }
                if(emprunt!=null)
                {
                emprunts.remove(emprunt);
                exemplaire.setDisponibilite(true);
                getLecteur(emprunt.getNumLecteur()).modifierEmprunt(-1);
                System.out.println("L'exemplaire à été rendu");
                }
                else
                {
                    System.out.println("Il n'existe pas d'emprunt de numero isbn et du numero d'exemplaire rentré");
                }
            }
            else
            {
                System.out.println("L'exemplaire n'existe pas ou il n'est pas emprunté");
            }
        }
        else
        {
            System.out.println("Il n'existe pas d'ouvrage du numero isbn saisi");
        }
    }
    
    public void ConsulterEmpruntsLecteur()
    {
        Scanner entree=new Scanner(System.in);
        System.out.println("Saisissez un numero de lecteur");
        int numeroLecteur=entree.nextInt();
        Lecteur lecteur=lecteurs.get(numeroLecteur);
        if(lecteur!=null&&(lecteur.getNbEmprunt()>0))
        {
            lecteur.afficherLecteur();
            for(Emprunt unEmprunt : emprunts)
            {
                if(unEmprunt.getNumLecteur()==numeroLecteur)
                {
                    unEmprunt.afficherEmprunt();
                    System.out.println();
                }
            }
        }
        else
        {
            System.out.println("Il n'existe pas de lecteur du numéro saisi ou il n'a rien emprunté");
        }
    }
    public void RelancerLecteur(){

        GregorianCalendar dateRappel = new GregorianCalendar();
        GregorianCalendar dateAjd = new GregorianCalendar();
        boolean aucunEmpruntEnRetard = true;
        
        for(int i=0;i<emprunts.size();i++){

            dateRappel= (GregorianCalendar) emprunts.get(i).getdateRetour().clone();
            dateRappel.add(GregorianCalendar.DAY_OF_WEEK, 15);

            if(dateAjd.compareTo(dateRappel)>=0){
                emprunts.get(i).afficherEmprunt();
                aucunEmpruntEnRetard=false;
            }
        }
        if(aucunEmpruntEnRetard)
        {
            System.out.println("Il n'y à aucun emprunts en retard");
        }
    }
    public void enRetard()
    {
        GregorianCalendar dateNaissance = new  GregorianCalendar(1996,5,25);
        GregorianCalendar dateParution = new  GregorianCalendar();
        GregorianCalendar dateAjout = new  GregorianCalendar(2020,01,27);
        GregorianCalendar dateRetour = new  GregorianCalendar(2020,02,3);
        Lecteur lecteur=new Lecteur("DOYEN","Matteo",4,dateNaissance,"bip","04 25 64");
        Ouvrage ouvrage=new Ouvrage("4","moi","balek",dateParution,"wesh",TypeLecteur.adulte);
        Exemplaire  exempaire=new Exemplaire(1,dateParution,true,ouvrage);
        Emprunt emprunt=new Emprunt(lecteur.getNumLecteur(),ouvrage.getIsbn(),ouvrage.getTitre(),exempaire.getNumeroExemplaire(),dateAjout,dateRetour);
        emprunts.add(emprunt);
        
        GregorianCalendar dateNaissance2 = new  GregorianCalendar(1996,5,25);
        GregorianCalendar dateParution2 = new  GregorianCalendar();
        GregorianCalendar dateAjout2 = new  GregorianCalendar(2020,01,27);
        GregorianCalendar dateRetour2 = new  GregorianCalendar(2020,02,4);
        Lecteur lecteur2=new Lecteur("DOYEN","Matteo",6,dateNaissance2,"bip","04 25 64");
        Ouvrage ouvrage2=new Ouvrage("4","lui","balek",dateParution2,"wesh",TypeLecteur.adulte);
        Exemplaire  exempaire2=new Exemplaire(1,dateParution2,true,ouvrage2);
        Emprunt emprunt2=new Emprunt(lecteur2.getNumLecteur(),ouvrage2.getIsbn(),ouvrage2.getTitre(),exempaire2.getNumeroExemplaire(),dateAjout2,dateRetour2);
        emprunts.add(emprunt2);
    }
    public void afficherToutLesEmprunts()
    {
        for(Emprunt unEmprunt : emprunts)
        {
            unEmprunt.afficherEmprunt();
        }
    }
}






















