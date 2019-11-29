package RadioEcoute;

import Radio_Londres.Controler_RadioLondres;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;


public class Interface_Receiver extends JFrame implements Observer {
    private ControllerReceiver controller;
    private Container contenu;
    private JButton diffuseAction;
    private JLabel label;
    private String message;


    public Interface_Receiver(ControllerReceiver controller) {
        this.controller = controller;
        this.controller.getAuditeur().addObserver(this);
        this.creationFenetre();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.label.setText(message);
    }

    @Override
    public void update(Observable observable, Object o) {
        message = controller.getMessageDiffuse();
        if (controller.getAction()){
            this.diffuseAction.setEnabled(true);
        }
        repaint();
    }

    public void creationFenetre(){
        //Creation de l'interface
        setTitle("Auditeur : " + this.controller.getNom());
        setBounds(10,40,300,200);
        setLocation(300,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Creation des objet dans notre fenetre
        this.label = new JLabel();
        this.label.setVisible(true);


        this.contenu = getContentPane();
        this.contenu.setLayout(new FlowLayout());
        //ajouts des elements
        this.contenu.add(this.label);
        //Pour le bouton on vérifie juste que ce soit un Groupe clandestin et pas une personne "lambda"
        if(this.controller.getAuditeur() instanceof GroupeClandestin){
            this.diffuseAction = new JButton("Transmettre ordre");
            this.diffuseAction.setEnabled(false);
            this.contenu.add(this.diffuseAction);
            ajouterEvent(); //methode cree dans la classe regroupe tous les events (c'est juste pour simplifier la lecture)
        }

        //Affiche la fenetre
        setVisible(true);

        //Met à jour des information (pas très utile dans notre cas, mais on sait jamais)
        //repaint();

    }

    public void ajouterEvent() {
        this.diffuseAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    //fait appel a une fonction du controleur qui lui meme fait appel a une fonction du model
                    // pour passer au message suivant
                    controller.diffuseOrdre();  //Fonction dans le controleur
                } catch (Exception err) {
                    System.err.println("Erreur" + err.toString());
                    err.printStackTrace();
                }
            }
        });
    }


}
