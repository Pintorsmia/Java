package MVC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class LaVue extends JFrame implements Observer {
    private LeControleur leControleur;
    private JButton bouton1;
    private JLabel label1;
    private String messageLabel;

    public LaVue(LeControleur leControleur) {
        //Creation d'une fenetre avec un bouton
        super();
        //Delaration basique
        this.leControleur = leControleur;
        this.leControleur.getLeModele().addObserver(this);

        //Creation de l'interface
        setTitle("Ma fenetre");
        setBounds(10,40,300,200);
        //Creation des objet dans notre fenetre
        this.bouton1 = new JButton("MonBouton");
        //Pour afficher du texte
        this.label1 = new JLabel();
        //False car pour le moment il n'y a pas de texte a afficher
        this.label1.setVisible(false);

        //Creation de notre container
        Container contenu = getContentPane();
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

    //function venant de observable
    @Override
    public void update(Observable observable, Object o) {
        //On recupere le message diffuse par le modele (via le controleur) et on le stock dans une variable
        this.messageLabel = leControleur.getLeModele().getMessageDiffuse();
        //On actualise notre fenetre
        repaint();
    }

    //Le code de cette fonction peut être mis dans le constructeur mais je trouve plus simple de tous separer
    public void ajouterEvent(){
        //ajoute une action au bouton
        this.bouton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //le try and catch ne dois pas être obligatoire mais c est dans le cour
                try{
                    //fait appel a une fonction du controleur qui lui meme fait appel a une fonction du model
                    // pour passer au message suivant
                    leControleur.fonctionControleur();  //Fonction dans le controleur
                }catch (Exception err){
                    System.err.println("Erreur" + err.toString());
                    err.printStackTrace();
                }
            }
        });
    }


}


