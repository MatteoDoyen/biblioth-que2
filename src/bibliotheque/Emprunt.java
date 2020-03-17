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
        private Lecteur lecteur;
        private Exemplaire exemplaire;
        
        public Emprunt(Lecteur lecteur,Exemplaire exemplaire)
        {
            dateEmprunt=new GregorianCalendar();
            dateRetour=new GregorianCalendar();
            dateRetour.add(GregorianCalendar.DAY_OF_WEEK, 8);
            this.lecteur=lecteur;
            exemplaire.setDisponibilite(false);
            this.exemplaire=exemplaire;
            lecteur.addEmprunt();
        }
        public void afficherEmprunt()
        {
            System.out.println("Date d'emprunt : "+EntreesSorties.ecrireDate(dateEmprunt));
            System.out.println("Date de retour : "+EntreesSorties.ecrireDate(dateRetour));
            System.out.println("Numero de lecteur : "+lecteur.getNumLecteur()) ;
            System.out.println("Numero d'isbn de l'ouvrage : "+exemplaire.getOuvrage().getIsbn());
            System.out.println("Numero de l'exemplaire empruntés : "+exemplaire.getNumeroExemplaire());
        }
        public Exemplaire getExemplaire()
        {
            return exemplaire;
        }
}
