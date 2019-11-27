package Radio_Londres;

import java.util.ArrayList;

public abstract class Auditeur {
    private String pseudo;
    private RadioLondres radioLondres;
    private Boolean statusEcoute;
    private ArrayList<String> historiqueMessage = new ArrayList<String>();
    private String leMessageRecu;
}
