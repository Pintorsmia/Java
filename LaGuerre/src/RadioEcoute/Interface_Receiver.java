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
    private ArrayList<String> resistant;
    private JButton nextMessage;
    private JLabel label;
    private String message;
    private JComboBox listeResistants;

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

        //Affiche la fenetre
        setVisible(true);
        //ajouterEvent(); //methode cree dans la classe regroupe tous les events (c'est juste pour simplifier la lecture)
        //Met à jour des information (pas très utile dans notre cas, mais on sait jamais)
        //repaint();

    }

    public void ajouterEvent() {

    }


}
