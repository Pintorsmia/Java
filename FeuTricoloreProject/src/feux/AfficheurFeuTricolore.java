package feux;

import java.util.Observable;
import java.util.Observer;

public class AfficheurFeuTricolore implements Observer {
    private CtrlFeuTricolore leControleur;

    public AfficheurFeuTricolore(CtrlFeuTricolore leControleur) {
        this.leControleur = leControleur;
        this.leControleur.getLeFeu().addObserver(this);
    }

    @Override
    public void update(Observable observable, Object o) {
        //repaint() etc.....
        switch(this.leControleur.getLeFeu().getCouleur()) {
            case 0:
                System.out.println("Je suis l'afficheur du feu. Couleur vert.");
                break;
            case 1:
                System.out.println("Je suis l'afficheur du feu. Couleur orange.");
                break;
            case 2:
                System.out.println("Je suis l'afficheur du feu. Couleur rouge.");
                break;
        }
    }
}
