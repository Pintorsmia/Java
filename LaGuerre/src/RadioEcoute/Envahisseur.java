package RadioEcoute;

import Radio_Londres.Controler_RadioLondres;

public class Envahisseur extends Auditeur {

    public Envahisseur(String pseudo, Controler_RadioLondres controller) {
        this.pseudo = pseudo;
        this.controller = controller;

    }
}
