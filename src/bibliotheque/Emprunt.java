/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotheque;

import java.util.GregorianCalendar;
import static bibliotheque.EntreesSorties.lireDate;

/**
 *
 * @author doyenma
 */
public class Emprunt {

        private GregorianCalendar dateEmprunt;
        private GregorianCalendar dateRetour;
        private int numeroLecteur;
        private int numeroExemplaire;
        private String titreOuvrage;
        private String isbn;
        
        public Emprunt(int numeroLecteur,String isbn,String titreOuvrage,int numeroExemplaire)
        {
            dateEmprunt=new GregorianCalendar();
            dateRetour=new GregorianCalendar();
            dateRetour.add(GregorianCalendar.DAY_OF_WEEK, 8);
            this.numeroLecteur=numeroLecteur;
            this.isbn=isbn;
            this.titreOuvrage=titreOuvrage;
            this.numeroExemplaire=numeroExemplaire;
            
        }
        public Emprunt(int numeroLecteur,String isbn,String titreOuvrage,int numeroExemplaire,GregorianCalendar dateEmprunt,GregorianCalendar dateRetour)
        {
            this.dateEmprunt=dateEmprunt;
            this.dateRetour=dateRetour;
            this.numeroLecteur=numeroLecteur;
            this.isbn=isbn;
            this.titreOuvrage=titreOuvrage;
            this.numeroExemplaire=numeroExemplaire;
        }
        public void afficherEmprunt()
        {
            System.out.println("Titre de l'ouvrage : "+titreOuvrage);
            System.out.println("Numero d'isbn de l'ouvrage : "+isbn);
            System.out.println("Numero de l'exemplaire empruntés : "+numeroExemplaire);
            System.out.println("Date d'emprunt : "+EntreesSorties.ecrireDate(dateEmprunt));
            System.out.println("Date de retour : "+EntreesSorties.ecrireDate(dateRetour));
        }
        public int getNumExemplaire()
        {
            return numeroExemplaire;
        }
        public String getIsbn()
        {
            return isbn;
        }
        public int getNumLecteur()
        {
            return numeroLecteur;
        }
        public GregorianCalendar getdateRetour()
        {
            return dateRetour;
        }
}
