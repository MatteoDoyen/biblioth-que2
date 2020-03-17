/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotheque;

import java.util.GregorianCalendar;

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
            this.exemplaire=exemplaire;
            exemplaire.setDisponibilite(false);
            lecteur.addEmprunt();
        }
        
}
