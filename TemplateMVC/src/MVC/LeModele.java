package MVC;

import java.util.ArrayList;
import java.util.Observable;

public class LeModele extends Observable {
    private ArrayList<String> tab = new ArrayList<String>(); //tableau contenant les messages
    private String messageDiffuse;  //Le message qui va etre lu
    private int index = 0;  //Pour parcourir le tableau (flemme de faire des iterateur)

    public LeModele(ArrayList<String> tab) {
        this.tab = tab;
    }

    //Recupere le prochain message et si c est le dernier alors on reprend le premier
    public void messageSuivant(){
        this.messageDiffuse = tab.get(this.index);
        if (this.index + 1 == tab.size()){
            this.index = 0;
        }else {
            this.index++;
        }
    }

    //Fonction a executer pour changer de message et avertir les observer
    public void diffuseMessage() {
        this.messageSuivant();
        //Les deux lignes sont toujours presente
        setChanged();
        notifyObservers();
    }

    //Getter pour recuperer le message (la variable est en private)
    public String getMessageDiffuse() {
        return messageDiffuse;
    }

}
