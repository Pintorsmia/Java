package Radio_Londres;

import LesSaboteurs.ControllerSaboteurFerroviaire;
import LesSaboteurs.Interface_ActionSaboteur;
import LesSaboteurs.SaboteurFerroviaire;
import RadioEcoute.ControllerReceiver;
import RadioEcoute.Envahisseur;
import RadioEcoute.GroupeClandestin;
import RadioEcoute.Interface_Receiver;

import java.util.ArrayList;

public class Lanceur {
    public static void main(String[] args) {

        //Initialisation des objets
        FlotteAlliee Allie1 = new FlotteAlliee("Les_Allies");
        ArrayList<String> ArrayMessages1 = new ArrayList<String>();
        ArrayMessages1.add("Test");
        ArrayMessages1.add("Aled");
        ArrayMessages1.add("pouet");
        Resistant Resistant1 = new Resistant("Resistant1",ArrayMessages1,Allie1);

        ArrayList<String> ArrayMessages2 = new ArrayList<String>();
        ArrayMessages2.add("1111");
        ArrayMessages2.add("Les sanglots long des violons ...");
        ArrayMessages2.add("2222");
        Resistant Resistant2 = new Resistant("Resistant2",ArrayMessages2,Allie1);


        ArrayList<String> ArrayMessages3 = new ArrayList<String>();
        ArrayMessages3.add("AAA2222");
        ArrayMessages3.add("ZZZZ3333");
        ArrayMessages3.add("MMMMM3333333");
        Resistant Resistant3 = new Resistant("Resistant3",ArrayMessages3,Allie1);
        //Creation du modele
        RadioLondres radio = new RadioLondres("Radio");

        //add des resistant pour la radio
        radio.addResistant(Resistant1);
        radio.addResistant(Resistant2);
        radio.addResistant(Resistant3);

        //Initialisation controller
        Controler_RadioLondres controler_radioLondres = new Controler_RadioLondres(radio);

        //Initialisation Vue
        Interface_RadioLondres interface_Radio = new Interface_RadioLondres(controler_radioLondres);


        //Partie Saboteur
        //modele
        SaboteurFerroviaire saboteur1 = new SaboteurFerroviaire("Coalition");
        //controller
        ControllerSaboteurFerroviaire controllerSaboteurFerroviaire = new ControllerSaboteurFerroviaire(saboteur1);
        //vue
        Interface_ActionSaboteur interface_actionSaboteur = new Interface_ActionSaboteur(controllerSaboteurFerroviaire);

        //partie Auditeur
        // modele
        Envahisseur envahisseur1 = new Envahisseur("Envahisseur1", controler_radioLondres);

        GroupeClandestin groupe1 = new GroupeClandestin("GroupeClandestin1","Les sanglots long des violons ...", saboteur1, controler_radioLondres);

        //Controller des auditeurs
        ControllerReceiver controllerReceiver1 = new ControllerReceiver(envahisseur1);
        ControllerReceiver controllerReceiver2 = new ControllerReceiver(groupe1);

        //vue des auditeurs
        Interface_Receiver interfaceEnvahisseur1 = new Interface_Receiver(controllerReceiver1);
        Interface_Receiver interfaceEnvahisseur2 = new Interface_Receiver(controllerReceiver2);

        //Test
        //System.out.println(Resistant1.getPseudo() + " et " + Resistant1.getLesMessages());

        //Correspond au bouton message suivant
        //controler_radioLondres.diffuseMessage();
        //System.out.println(radio.getLeMessageDiffuse());

        //System.out.println(radio.getResistants());
        //ArrayList<Resistant> tabResistant = radio.getResistants();
        //System.out.println(tabResistant.get(2).getLesMessages());
        //controler_radioLondres.addResistantControler(tabResistant.get(0));
        //controler_radioLondres.addResistantControler(tabResistant.get(2));

        //radio.addResistantDiffuseurs(tabResistant.get(1));


    }
}