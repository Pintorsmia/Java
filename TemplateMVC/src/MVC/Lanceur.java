package MVC;


import java.util.ArrayList;

public class Lanceur {
    public static void main(String[] args) {

        //Creation d'un arraylist pour le modele
        ArrayList<String> tab = new ArrayList<>();
        tab.add("First");
        tab.add("Hello");
        tab.add("Last");
        //Creation du modele
        LeModele leModele = new LeModele(tab);

        //Creation du controleur
        LeControleur leControleur = new LeControleur(leModele);

        //Creation de la vue
        LaVue laVue = new LaVue(leControleur);


        //Test


    }
}