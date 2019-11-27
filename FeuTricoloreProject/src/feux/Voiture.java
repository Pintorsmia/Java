package feux;

public class Voiture {
    private Personne conducteur;
    private String marque;

    public Voiture(Personne conducteur, String marque) {
        this.conducteur = conducteur;
        this.marque = marque;
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
