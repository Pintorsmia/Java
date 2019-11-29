package RadioEcoute;

import LesSaboteurs.SaboteurFerroviaire;
import Radio_Londres.Controler_RadioLondres;

import java.util.Observable;

public class GroupeClandestin extends Auditeur {
    private SaboteurFerroviaire saboteur;
    private String msgAttendu;
    private Boolean action;

    public GroupeClandestin(String pseudo,String msgAttendu, SaboteurFerroviaire saboteur, Controler_RadioLondres controller) {
        super(controller);
        this.pseudo = pseudo;
        this.msgAttendu = msgAttendu;
        this.saboteur = saboteur;
        this.action = false;
    }

    @Override
    public void update(Observable observable, Object o) {
        super.update(observable, o);
        if (this.messageRecu == this.msgAttendu){
            this.action = true;
            saboteur.diffuseAction();
            setChanged();
            notifyObservers();
        }
    }

    @Override
    public Boolean getAction() {
        super.getAction();
        return action;
    }
}
