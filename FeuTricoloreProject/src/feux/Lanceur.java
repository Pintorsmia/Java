package feux;

public class Lanceur {
    public static void main(String[] args) {

        //Modele, 0 = vert, 1 = orange, 2 = rouge
        FeuTricolore leFeuTricolore = new FeuTricolore(0);

        //contoller
        CtrlFeuTricolore leControleur = new CtrlFeuTricolore(leFeuTricolore);

        //Vue
        AfficheurFeuTricolore afficheurFeuTricolore = new AfficheurFeuTricolore(leControleur);
        AfficheurVoiture afficheurVoiture = new AfficheurVoiture(leControleur);

        //Reste des objets

        Personne conductor1 = new Personne("Henry");
        Voiture vehicule1 = new Voiture(conductor1,"Fiat");

        Personne conductor2 = new Personne("Pierre");
        Voiture vehicule2 = new Voiture(conductor2,"Ferrarie");

        Personne conductor3 = new Personne("kevin");
        Voiture vehicule3 = new Voiture(conductor3,"renault");

        //On passe le feu au orange puis au rouge
        System.out.println("Code du lanceur, le feu va passer au rouge");
        leFeuTricolore.diffuseChangementCouleur();
        leFeuTricolore.diffuseChangementCouleur();

        //on repasse au vert
        System.out.println("\nCode du lanceur, le feu va passer au vert");
        leFeuTricolore.diffuseChangementCouleur();

        //test
    }



}