package feux;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class AfficheurFeuTricolore extends JFrame implements Observer {
    private CtrlFeuTricolore leControleur;
    private Container contenu;
    private JButton bouton1;
    private JLabel label1;
    private String messageLabel;

    public AfficheurFeuTricolore(CtrlFeuTricolore leControleur) {
        super();
        this.leControleur = leControleur;
        this.leControleur.getLeFeu().addObserver(this);

        //Creation de l'interface
        setTitle("Ma fenetre");
        setBounds(10,40,300,200);
        //Creation des objet dans notre fenetre
        this.bouton1 = new JButton("Changement Couleur");
        //Pour afficher du texte
        this.label1 = new JLabel();
        //False car pour le moment il n'y a pas de texte a afficher
        //this.label1.setVisible(false);

        //Creation de notre container
        contenu = getContentPane();
        contenu.setLayout(new FlowLayout());
        //ajoute nos element dans le container
        contenu.add(this.bouton1);
        contenu.add(this.label1);
        ajouterEvent(); //methode cree dans la classe regroupe tous les events (c'est juste pour simplifier la lecture)
        //Affiche la fenetre
        setVisible(true);
        //Met à jour des information (pas très utile dans notre cas, mais on sait jamais)
        repaint();

    }

    //Methode d'une classe mere que l on complete
    // repaint() fais appel a cette fonction !!!
    @Override
    public void paint(Graphics g) {
        //Recupere la mathode de la classe mere
        super.paint(g);
        //Ecris dans notre label le texte contenu dans messageLabel
        this.label1.setText(this.messageLabel);
        //Maintenant que le label est remplit on peux l afficher
        this.label1.setVisible(true);
    }

    @Override
    public void update(Observable observable, Object o) {
        //repaint() etc.....
        switch(this.leControleur.getLeFeu().getCouleur()) {
            case 0:
                this.messageLabel = "Je suis l'afficheur du feu. Couleur vert.";
                this.contenu.setBackground(Color.green);
                break;
            case 1:
                this.messageLabel = "Je suis l'afficheur du feu. Couleur orange.";
                this.contenu.setBackground(Color.orange);
                break;
            case 2:
                this.messageLabel = "Je suis l'afficheur du feu. Couleur rouge.";
                this.contenu.setBackground(Color.red);
                break;
        }
        repaint();
    }

    public void ajouterEvent() {
        //ajoute une action au bouton
        this.bouton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //le try and catch ne dois pas être obligatoire mais c est dans le cour
                try {
                    //fait appel a une fonction du controleur qui lui meme fait appel a une fonction du model
                    // pour passer au message suivant
                    leControleur.changementCouleur();  //Fonction dans le controleur
                } catch (Exception err) {
                    System.err.println("Erreur" + err.toString());
                    err.printStackTrace();
                }
            }
        });
    }
}
