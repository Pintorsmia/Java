package LesSaboteurs;

public class ControllerSaboteurFerroviaire {
    private SaboteurFerroviaire saboteur;

    public ControllerSaboteurFerroviaire(SaboteurFerroviaire saboteur) {
        this.saboteur = saboteur;
    }

    public Boolean getAction(){
        return saboteur.getBoolAction();
    }

    public String getNom(){
        return saboteur.getPseudo();
    }
    public SaboteurFerroviaire getSaboteur() {
        return saboteur;
    }
}
