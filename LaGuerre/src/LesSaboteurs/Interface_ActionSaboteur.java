package LesSaboteurs;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Interface_ActionSaboteur extends JFrame implements Observer {
    private ControllerSaboteurFerroviaire controller;
    private Container contenu;
    private JLabel labelInfo;
    private JLabel label;
    private String message;

    public Interface_ActionSaboteur(ControllerSaboteurFerroviaire controller) {
        this.controller = controller;
        this.controller.getSaboteur().addObserver(this);
        this.message = "Ne rien faire";
        this.creationFenetre();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.label.setText(message);
    }

    @Override
    public void update(Observable observable, Object o) {
       if (this.controller.getAction()) {
            this.message = "C'est l'heure du DUDUDUDUDU DUEL !!!";
        }
        repaint();
    }

    public void creationFenetre(){
        //Creation de l'interface
        setTitle("Interface Saboteur : " + this.controller.getNom());
        setBounds(10,40,300,200);
        setLocation(600,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Creation des objet dans notre fenetre
        this.labelInfo = new JLabel("Action :");
        this.label = new JLabel();
        this.label.setVisible(true);

        this.contenu = getContentPane();
        this.contenu.setLayout(new FlowLayout());
        //ajouts des elements
        this.contenu.add(this.labelInfo);
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
