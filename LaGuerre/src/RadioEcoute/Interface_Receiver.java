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
    private JButton startandstop;
    private JButton diffuseAction;
    private JLabel label;
    private JLabel labelInfo;
    private String message;
    private String statusEcoute;


    public Interface_Receiver(ControllerReceiver controller) {
        this.controller = controller;
        this.statusEcoute = "Start";
        ecouterRadio(true);
        this.creationFenetre();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.label.setText(message);
        this.startandstop.setText(this.statusEcoute);
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
        setTitle("Interface Récepteur : " + this.controller.getNom());
        setBounds(10,40,300,200);
        setLocation(300,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Creation des objet dans notre fenetre
        this.label = new JLabel();
        this.label.setVisible(true);
        this.labelInfo = new JLabel("Message Recu :");
        this.startandstop = new JButton(this.statusEcoute);


        this.contenu = getContentPane();
        this.contenu.setLayout(new FlowLayout());
        //ajouts des elements
        this.contenu.add(this.labelInfo);
        this.contenu.add(this.label);
        //Pour le bouton on vérifie juste que ce soit un Groupe clandestin et pas une personne "lambda"
        if(this.controller.getAuditeur() instanceof GroupeClandestin){
            this.diffuseAction = new JButton("Transmettre ordre");
            this.diffuseAction.setEnabled(false);
            this.contenu.add(this.diffuseAction);
            ajouterEventClandestin(); //methode cree dans la classe regroupe tous les events (c'est juste pour simplifier la lecture)
        }
        this.contenu.add(this.startandstop);
        ajouterEvent();
        //Affiche la fenetre
        setVisible(true);

        //Met à jour des information (pas très utile dans notre cas, mais on sait jamais)
        //repaint();

    }

    public void ajouterEvent() {
        this.startandstop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    switch (statusEcoute){
                        case "Start":
                            ecouterRadio(true);
                            break;
                        case "Stop":
                            ecouterRadio(false);
                            break;
                    }
                } catch (Exception err) {
                    System.err.println("Erreur" + err.toString());
                    err.printStackTrace();
                }
            }
        });
    }
    public void ajouterEventClandestin() {
        this.diffuseAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    //fait appel a une fonction du controleur qui lui meme fait appel a une fonction du model
                    // pour passer au message suivant
                    controller.diffuseOrdre();  //Fonction dans le controleur
                    //On arrete d'ecouter
                    ecouterRadio(false);
                } catch (Exception err) {
                    System.err.println("Erreur" + err.toString());
                    err.printStackTrace();
                }
            }
        });
    }

    public void ecouterRadio(Boolean status){
        if (status){
            this.controller.getAuditeur().addObserver(this);
            this.statusEcoute = "Stop";
        }else {
            this.controller.getAuditeur().deleteObserver(this);
            this.statusEcoute = "Start";
        }
        repaint();
    }


}
