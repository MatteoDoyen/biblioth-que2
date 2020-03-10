package bibliotheque;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {

        Bibliotheque bibliotheque = DonneesUtilitaire.loadDB();
        MenuBiblio menu = new MenuBiblio(bibliotheque);
        menu.menuPrincipal();
    }
}









