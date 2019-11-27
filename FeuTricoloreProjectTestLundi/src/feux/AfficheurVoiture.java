package feux;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class AfficheurVoiture extends JFrame implements Observer {
    private CtrlFeuTricolore leControleur;
    private String nom;
    private Container contenu;
    private JLabel label1;
    private String messageLabel;


    public AfficheurVoiture(CtrlFeuTricolore leControleur,String nom) {
        super();
        this.leControleur = leControleur;
        this.leControleur.getLeFeu().addObserver(this);
        this.nom=nom;
        //Creation de l'interface
        setTitle("Ma fenetre");
        setBounds(10,40,300,200);
        //Creation des objet dans notre fenetre

        //Pour afficher du texte
        this.label1 = new JLabel();
        //False car pour le moment il n'y a pas de texte a afficher
        //this.label1.setVisible(false);

        //Creation de notre container
        contenu = getContentPane();
        contenu.setLayout(new FlowLayout());
        //ajoute nos element dans le container
        contenu.add(this.label1);
        //Affiche la fenetre
        setVisible(true);
        //Met à jour des information (pas très utile dans notre cas, mais on sait jamais)
        repaint();

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.label1.setText(this.messageLabel);
        //Maintenant que le label est remplit on peux l afficher
        this.label1.setVisible(true);
    }

    @Override
    public void update(Observable observable, Object o) {
        switch(this.leControleur.getLeFeu().getCouleur()) {
            case 0:
                this.messageLabel= this.nom + "Démarre frere. Couleur vert.";
                this.contenu.setBackground(Color.green);
                break;
            case 1:
                this.messageLabel=this.nom + "Attention filston. Couleur orange.";
                this.contenu.setBackground(Color.orange);
                break;
            case 2:
                this.messageLabel=this.nom + "Arretes toi fdp. Couleur rouge.";
                this.contenu.setBackground(Color.red);

        }
        repaint();
    }
}
