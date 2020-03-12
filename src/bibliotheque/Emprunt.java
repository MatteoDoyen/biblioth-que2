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
        private static int numEmprunt;
        
        static
        {
            numEmprunt=0;
        }
}
    
