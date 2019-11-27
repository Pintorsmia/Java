package feux;

public class Voiture {
    private Personne conducteur;
    private String marque;
    private AfficheurVoiture afficheurVoiture;

    public Voiture(Personne conducteur, String marque,CtrlFeuTricolore leControleur) {
        this.conducteur = conducteur;
        this.marque = marque;
        this.afficheurVoiture = new AfficheurVoiture(leControleur,this.conducteur.getNom());
    }

    public Personne getConducteur() {
        return conducteur;
    }

    public void setConducteur(Personne conducteur) {
        this.conducteur = conducteur;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }
}
