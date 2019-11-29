package RadioEcoute;

import Radio_Londres.Controler_RadioLondres;
import Radio_Londres.RadioLondres;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public abstract class Auditeur extends Observable implements Observer {
    protected String pseudo;
    protected Controler_RadioLondres controller;
    protected ArrayList<String> historiqueMessages;
    protected String messageRecu;

    public Auditeur(Controler_RadioLondres controller) {
        this.controller = controller;
        this.controller.getRadioLondres().addObserver(this);
    }

    @Override
    public void update(Observable observable, Object o) {
        messageRecu = controller.getMessageDiffuse();
        setChanged();
        notifyObservers();
    }

    public String getPseudo() {
        return pseudo;
    }

    public String getMessageRecu() {
        return messageRecu;
    }

    public Boolean getAction(){
        return false;
    }
}
