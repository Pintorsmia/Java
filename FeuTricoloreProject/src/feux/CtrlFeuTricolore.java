package feux;

public class CtrlFeuTricolore {
    private FeuTricolore leFeu;

    public CtrlFeuTricolore(FeuTricolore leFeu) {
        this.leFeu = leFeu;
    }

    public FeuTricolore getLeFeu() {
        return leFeu;
    }

    public void setLeFeu(FeuTricolore leFeu) {
        this.leFeu = leFeu;
    }
}
