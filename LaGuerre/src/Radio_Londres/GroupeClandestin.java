package Radio_Londres;

import java.util.ArrayList;

public class GroupeClandestin extends Auditeur{
        private Saboteurs saboteurs;
        private Boolean debarquement;
        private String leMessageAttendu;

    public GroupeClandestin(Saboteurs saboteurs, String leMessageAttendu) {
        this.saboteurs = saboteurs;
        this.leMessageAttendu = leMessageAttendu;
    }
}
