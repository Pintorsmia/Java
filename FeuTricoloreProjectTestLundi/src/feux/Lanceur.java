package feux;

public class Lanceur {
    public static void main(String[] args) {

        //Modele, 0 = vert, 1 = orange, 2 = rouge
        FeuTricolore leFeuTricolore = new FeuTricolore(0);
        //2eme Feu
        //FeuTricolore leFeuTricolore1 = new FeuTricolore(2);

        //contoller
        CtrlFeuTricolore leControleur = new CtrlFeuTricolore(leFeuTricolore);
        //2eme feu
        //CtrlFeuTricolore leControleur1 = new CtrlFeuTricolore(leFeuTricolore1);

        //Vue
        AfficheurFeuTricolore afficheurFeuTricolore = new AfficheurFeuTricolore(leControleur);
        //2eme controlleur
        //AfficheurFeuTricolore afficheurFeuTricolore1 = new AfficheurFeuTricolore(leControleur1);

        //AfficheurVoiture afficheurVoiture = new AfficheurVoiture(leControleur);

        //Reste des objets

        Personne conductor1 = new Personne("Henry");
        Voiture vehicule1 = new Voiture(conductor1,"Fiat",leControleur);

        Personne conductor2 = new Personne("Pierre");
        Voiture vehicule2 = new Voiture(conductor2,"Ferrarie",leControleur);

        Personne conductor3 = new Personne("kevin");
        Voiture vehicule3 = new Voiture(conductor3,"renault",leControleur);
        //pour deuxieme feu commente la ligne du dessus, et decommente celle la
        //Voiture vehicule3 = new Voiture(conductor3,"renault",leControleur1);

        //On passe le feu au orange puis au rouge
        //System.out.println("Code du lanceur, le feu va passer au rouge");
        //leFeuTricolore.diffuseChangementCouleur();
        //leFeuTricolore.diffuseChangementCouleur();

        //on repasse au vert
       // System.out.println("\nCode du lanceur, le feu va passer au vert");
        //leFeuTricolore.diffuseChangementCouleur();

        //test
    }



}