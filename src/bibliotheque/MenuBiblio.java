package bibliotheque;

public class MenuBiblio {

    private Bibliotheque _bibliotheque;

    public MenuBiblio(Bibliotheque bibliotheque) {
        _bibliotheque = bibliotheque;
    }

    /*
	 * menuPrincipal permet à l'utilisateur de selectionner un type de sous menu (Lecteur, Ouvrage ou Exemplaire) 
	 * où il effectuera par la suite l'action désirée. Si l'utilisateur a fini d'utiliser le programme, il choisit l'option Quitter.
     */
    public void menuPrincipal() {
        Integer menu;
        do {
            EntreesSorties.afficherMessage(" ========================================================");
            EntreesSorties.afficherMessage("|                   Menu Principal                       |");
            EntreesSorties.afficherMessage("| Saisissez un numero correspondant :                    |");
            EntreesSorties.afficherMessage("| Menu Lecteur        : 1                                |");
            EntreesSorties.afficherMessage("| Menu Ouvrage        : 2                                |");
            EntreesSorties.afficherMessage("| Menu Exemplaire     : 3                                |");
            EntreesSorties.afficherMessage("| Menu Emprunt        : 4                                |");
            EntreesSorties.afficherMessage("| Quitter : 0                                            |");
            EntreesSorties.afficherMessage(" ========================================================");
            menu = EntreesSorties.lireEntier();

            switch (menu) {
                case 1: {
                    this.menuLecteur();

                    break;
                }
                case 2: {
                    this.menuOuvrage();
                    break;
                }
                case 3: {
                    this.menuExemplaire();
                    break;
                }
                case 4: {
                    this.menuEmprunt();
                    break;
                }
                case 0:
                    break;
                default: {
                    System.out.println("Choix non valide");
                    break;
                }
            }
        } while (menu != 0);
    }

    /* menuLect permet d'effectuer une série d'action concernant les utilisateur (lecteurs) de la bibliothèque.
	 * Une fois une action effectuée, l'utilisateur sera rediriger vers ce même menu afin de pouvoir sélectionner
	 * une nouvelle fois une action concernant les lecteurs.
	 * "Retour Menu Principal" renvoi l'utilisateur au menu principal.
     */
    public void menuLecteur() {
        Integer menuLect;
        do {
            EntreesSorties.afficherMessage(" ========================================================");
            EntreesSorties.afficherMessage("| Saisissez un numero correspondant :                    |");
            EntreesSorties.afficherMessage("| Nouveau Lecteur       : 1                              |");
            EntreesSorties.afficherMessage("| Consulter Lecteur     : 2                              |");
            EntreesSorties.afficherMessage("| Retour Menu Principal : 0                              |");
            EntreesSorties.afficherMessage(" ========================================================");
            menuLect = EntreesSorties.lireEntier();

            switch (menuLect) {
                case 1: {
                    _bibliotheque.nouveauLecteur();
                    DonneesUtilitaire.updateDB(_bibliotheque);
                    break;
                }
                case 2: {
                    _bibliotheque.consulterLecteur();
                    break;
                }
                case 0:
                    break;
                default: {
                    System.out.println("Choix non valide");
                    break;
                }
            }
        } while (menuLect != 0);
        
    }
    public void menuOuvrage() {
        Integer menuOuvrage;
        do {
            EntreesSorties.afficherMessage(" ========================================================");
            EntreesSorties.afficherMessage("| Saisissez un numero correspondant :                    |");
            EntreesSorties.afficherMessage("| Nouveau Ouvrage       : 1                              |");
            EntreesSorties.afficherMessage("| Consulter Ouvrage     : 2                              |");
            EntreesSorties.afficherMessage("| Retour Menu Principal : 0                              |");
            EntreesSorties.afficherMessage(" ========================================================");
            menuOuvrage = EntreesSorties.lireEntier();

            switch (menuOuvrage) {
                case 1: {
                    _bibliotheque.nouvelOuvrage();
                    DonneesUtilitaire.updateDB(_bibliotheque);
                    break;
                }
                case 2: {
                    _bibliotheque.consulterOUvrage();
                    break;
                }
                case 0:
                    break;
                default: {
                    System.out.println("Choix non valide");
                    break;
                }
            }
        } while (menuOuvrage != 0);
    }
    public void menuExemplaire() {
        Integer menuExemplaire;
        do {
            EntreesSorties.afficherMessage(" ========================================================");
            EntreesSorties.afficherMessage("| Saisissez un numero correspondant :                    |");
            EntreesSorties.afficherMessage("| Nouvel Exemplaire       : 1                            |");
            EntreesSorties.afficherMessage("| Consulter Exemplaire    : 2                            |");
            EntreesSorties.afficherMessage("| Retour Menu Principal   : 0                            |");
            EntreesSorties.afficherMessage(" ========================================================");
            menuExemplaire = EntreesSorties.lireEntier();

            switch (menuExemplaire) {
                case 1: {
                    _bibliotheque.nouvelExemplaire();
                    DonneesUtilitaire.updateDB(_bibliotheque);
                    break;
                }
                case 2: {
                    _bibliotheque.consulterExemplaireOuvrage();
                    break;
                }
                case 0:
                    break;
                default: {
                    System.out.println("Choix non valide");
                    break;
                }
            }
        } while (menuExemplaire != 0);
    }
        public void menuEmprunt() {
        Integer menuExemplaire;
        do {
            EntreesSorties.afficherMessage(" ========================================================");
            EntreesSorties.afficherMessage("| Saisissez un numero correspondant :                    |");
            EntreesSorties.afficherMessage("| Nouvel Emprunt                     : 1                 |");
            EntreesSorties.afficherMessage("| Consulter Les Exemplaire Emprunté  : 2                 |");
            EntreesSorties.afficherMessage("| Rendre Un Exemplaire               : 3                 |");
            EntreesSorties.afficherMessage("| Retour Menu Principal   : 0                            |");
            EntreesSorties.afficherMessage(" ========================================================");
            menuExemplaire = EntreesSorties.lireEntier();

            switch (menuExemplaire) {
                case 1: {
                    _bibliotheque.emprunterExemplaire();
                    DonneesUtilitaire.updateDB(_bibliotheque);
                    break;
                }
                case 2: {
                     _bibliotheque.ConsulterLesEmprunts();
                    break;
                }
                case 3: {
                    _bibliotheque.ConsulterLesEmprunts();
                    DonneesUtilitaire.updateDB(_bibliotheque);
                    break;
                }
                case 0:
                    break;
                default: {
                    System.out.println("Choix non valide");
                    break;
                }
            }
        } while (menuExemplaire != 0);
    }
}















































