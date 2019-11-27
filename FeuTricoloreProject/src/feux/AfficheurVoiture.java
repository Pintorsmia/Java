package feux;

import java.util.Observable;
import java.util.Observer;

public class AfficheurVoiture implements Observer {
    private CtrlFeuTricolore leControleur;

    public AfficheurVoiture(CtrlFeuTricolore leControleur) {
        this.leControleur = leControleur;
        this.leControleur.getLeFeu().addObserver(this);
    }

    @Override
    public void update(Observable observable, Object o) {
        switch(this.leControleur.getLeFeu().getCouleur()) {
            case 0:
                System.out.println("Je suis l'afficheur de la voiture. Couleur vert.");
                break;
            case 1:
                System.out.println("Je suis l'afficheur de la voiture. Couleur orange.");
                break;
            case 2:
                System.out.println("Je suis l'afficheur de la voiture. Couleur rouge.");
        }
    }
}
