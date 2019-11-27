package RadioEcoute;

public class ControllerRecepter {
    private Auditeur auditeur;

    public ControllerRecepter(Auditeur auditeur) {
        this.auditeur = auditeur;
    }

    public String getMessageDiffuse(){
       return auditeur.getMessageRecu();
    }
}
