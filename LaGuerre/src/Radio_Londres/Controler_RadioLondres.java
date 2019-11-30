package Radio_Londres;

import java.util.ArrayList;

public class Controler_RadioLondres {
    private RadioLondres radioLondres;

    public Controler_RadioLondres(RadioLondres radioLondres) {
        this.radioLondres = radioLondres;
    }

    public ArrayList<String> getResistantControler(){
        return this.radioLondres.getResistants();
    }

    public void addResistantControler(String resistant){
        this.radioLondres.addResistantDiffuseurs(resistant);
    }

    public void diffuseMessageControler(){
        this.radioLondres.diffuseMessage();
    }

    public String getMessageDiffuse(){
        return this.radioLondres.getMessageDiffuse();
    }

    public RadioLondres getRadioLondres() {
        return radioLondres;
    }

    public void startRadio(){
        this.radioLondres.startRadio();
    }
    public boolean getHasNext(){
        return this.radioLondres.getHasNext();
    }

}
