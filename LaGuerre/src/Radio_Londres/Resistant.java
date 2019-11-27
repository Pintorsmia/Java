package Radio_Londres;

import java.util.ArrayList;

public class Resistant {
    private String pseudo;
    private ArrayList<String> lesMessages;
    private FlotteAlliee flotteAlliee;

    public Resistant(String pseudo, ArrayList<String> lesMessages, FlotteAlliee flotteAlliee) {
        this.pseudo = pseudo;
        this.lesMessages = lesMessages;
        this.flotteAlliee = flotteAlliee;
    }

    public String getPseudo() {
        return pseudo;
    }

    public ArrayList<String> getLesMessages() {
        return lesMessages;
    }
}
