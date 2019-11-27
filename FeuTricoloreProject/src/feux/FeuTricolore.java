package feux;

import java.util.Observable;

public class FeuTricolore extends Observable {
    private int couleur;

    public FeuTricolore(int couleur) {
        this.couleur = couleur;
    }

    public void diffuseChangementCouleur(){
        //action à réaliser
        //Objectif passer du vert au rouge puis retourner au vert
        if(this.couleur != 2){
            this.couleur++;
        }else{
            this.couleur = 0;
        }

        setChanged();
        notifyObservers();
    }

    public int getCouleur() {
        return couleur;
    }

    public void setCouleur(int couleur) {
        this.couleur = couleur;
    }
}
