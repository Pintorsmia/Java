package RadioEcoute;

public class ControllerReceiver {
    private Auditeur auditeur;

    public ControllerReceiver(Auditeur auditeur) {
        this.auditeur = auditeur;
    }

    public String getMessageDiffuse(){
       return auditeur.getMessageRecu();
    }

    public Auditeur getAuditeur() {
        return auditeur;
    }
}
