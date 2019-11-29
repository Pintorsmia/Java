package RadioEcoute;

import Radio_Londres.Controler_RadioLondres;

public class GroupeClandestin extends Auditeur {


    public GroupeClandestin(String pseudo, Controler_RadioLondres controller) {
        super(controller);
        this.pseudo = pseudo;
    }
}
