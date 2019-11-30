package Radio_Londres;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

public class RadioLondres extends Observable {
    private ArrayList<Resistant> lesResistants;
    private ArrayList<String> listeMessages;
    private Iterator itMessage;
    private Iterator itResistant;
    private String leMessageDiffuse;
    private String nomRadio;
    private Boolean hasNext;

    public RadioLondres(String nom) {
        this.nomRadio = nom;
        this.lesResistants = new ArrayList<Resistant>();
        this.listeMessages = new ArrayList<String>();
        this.itMessage = listeMessages.iterator();
        this.hasNext = false;
    }

    public void addResistant(Resistant resistantPersonne) {
        this.lesResistants.add(resistantPersonne);
        this.itResistant = lesResistants.iterator();
    }

    public void messageSuivant(){
        if(itMessage.hasNext()) {
            this.hasNext = true;
            this.leMessageDiffuse = (String) this.itMessage.next();
        }else{
            this.leMessageDiffuse = "Fin";
            this.hasNext = false;
        }
    }
    public void addResistantDiffuseurs(String nomResistant){
        this.itResistant = lesResistants.iterator();
        while (itResistant.hasNext()) {
            Resistant tmpResistant = (Resistant) itResistant.next();
            if (tmpResistant.getPseudo() == nomResistant) {
                this.listeMessages.addAll(tmpResistant.getLesMessages());
                break;
            }
        }
        //maj de l'iterateur
        itMessage = listeMessages.iterator();
    }

    //Verifie qu'il y ait au moins un message dans la liste et demarre la radio
    public void startRadio(){
        if (this.listeMessages.isEmpty()) {
            this.hasNext = false;
        }else {
            this.hasNext = true;
        }
    }

    public void diffuseMessage() {
        messageSuivant();
        setChanged();
        notifyObservers();
    }

    public ArrayList<String> getResistants() {
        ArrayList<String> nomResistant = new ArrayList<>();
        nomResistant.add("Choisir un Resistant à diffuser"); // permet un choix par défaut
        while (itResistant.hasNext()){
            Resistant tmp = (Resistant) itResistant.next();
            nomResistant.add(tmp.getPseudo());
        }
        return nomResistant;
    }

    public String getMessageDiffuse() {
        return leMessageDiffuse;
    }

    public Boolean getHasNext() {
        return hasNext;
    }
}


