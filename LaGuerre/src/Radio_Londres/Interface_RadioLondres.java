package Radio_Londres;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Interface_RadioLondres extends JFrame implements Observer {
    private Controler_RadioLondres controller;
    private Boolean statusStart;
    private Container contenu;
    private ArrayList<String> resistant;
    private JButton start;
    private JButton nextMessage;
    private JLabel label;
    private String message;
    private JComboBox listeResistants;

    public Interface_RadioLondres(Controler_RadioLondres controller){
        this.controller = controller;
        this.controller.getRadioLondres().addObserver(this);
        this.resistant = controller.getRadioLondres().getResistants();
        this.statusStart = false;
        creationFenetre();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (this.statusStart){
            this.nextMessage.setEnabled(true);
        }else{
            this.nextMessage.setEnabled(false);
        }
        if (this.controller.getHasNext()){
            this.nextMessage.setEnabled(true);
        }else{
            this.nextMessage.setEnabled(false);
        }
        this.label.setText(message);

    }

    @Override
    public void update(Observable observable, Object o) {

        message = controller.getMessageDiffuse();
        repaint();
    }



    public void creationFenetre(){
        //Creation de l'interface
        setTitle("La Radio");
        setBounds(10,40,300,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Creation des objet dans notre fenetre
        this.start = new JButton("Start");
        this.nextMessage = new JButton("Message Suivant");
        this.nextMessage.setEnabled(false);
        this.label = new JLabel();
        this.label.setVisible(true);
        this.listeResistants = new JComboBox();
        this.listeResistants.setModel(new DefaultComboBoxModel(resistant.toArray()));
        this.contenu = getContentPane();
        this.contenu.setLayout(new FlowLayout());
        //ajouts des elements
        this.contenu.add(this.listeResistants);
        this.contenu.add(this.start);
        this.contenu.add(this.nextMessage);
        this.contenu.add(this.label);

        //Affiche la fenetre
        setVisible(true);
        ajouterEvent(); //methode cree dans la classe regroupe tous les events (c'est juste pour simplifier la lecture)
        //Met à jour des information (pas très utile dans notre cas, mais on sait jamais)
        //repaint();

    }

    public void ajouterEvent() {
        //ajoute une action au bouton
        this.nextMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    //fait appel a une fonction du controleur qui lui meme fait appel a une fonction du model
                    // pour passer au message suivant
                    controller.diffuseMessageControler();  //Fonction dans le controleur
                } catch (Exception err) {
                    System.err.println("Erreur" + err.toString());
                    err.printStackTrace();
                }
            }
        });
        this.listeResistants.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if(itemEvent.getStateChange() == ItemEvent.SELECTED){
                    String item = (String) itemEvent.getItem();
                    controller.addResistantControler(item);
                    System.out.println(item);
                }
            }
        });
        this.start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    controller.startRadio();
                    repaint();
                } catch (Exception err) {
                    System.err.println("Erreur" + err.toString());
                    err.printStackTrace();
                }
            }
        });


    }
}
