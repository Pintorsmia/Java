package LesSaboteurs;

import java.util.Observable;
import java.util.Observer;

public class SaboteurFerroviaire extends Observable {
    private String pseudo;
    private Boolean boolAction;

    public SaboteurFerroviaire(String pseudo) {
        this.pseudo = pseudo;
        this.boolAction = false;
    }

    public void diffuseAction(){
        this.boolAction = true;
        setChanged();
        notifyObservers();
    }

    public String getPseudo() {
        return pseudo;
    }

    public Boolean getBoolAction() {
        return boolAction;
    }
}
