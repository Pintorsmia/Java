package MVC;

public class LeControleur {
    private LeModele leModele;

    public LeControleur(LeModele leModele) {
        this.leModele = leModele;
    }
    //Cette fonction sera utilise pas la vue (via un bouton par exemple)
    public void fonctionControleur(){
        this.leModele.diffuseMessage();
        }
    //Permet a la vue d avoir acces au modele
    public LeModele getLeModele() {
        return leModele;
    }
}


