package MVC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class Fenetre extends JFrame implements Observer {
    private LeControleur leControleur;
    private String messageLabel;
    private Frame frame;
    private JPanel panel;
    private JButton Suivant;
    private JLabel label1;

    public Fenetre(LeControleur leControleur) {
        //Creation d'une fenetre avec un bouton
        super();
        //Delaration basique
        this.leControleur = leControleur;
        this.leControleur.getLeModele().addObserver(this);

        Suivant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }
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
        //On recupere le message diffuse par le modele (via le controleur) et on le stock dans une variable
        this.messageLabel = leControleur.getLeModele().getMessageDiffuse();
        //On actualise notre fenetre
        repaint();
    }

    public void runWindow(){

    }
}
