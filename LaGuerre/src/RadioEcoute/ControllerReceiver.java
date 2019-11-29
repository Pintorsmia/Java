package RadioEcoute;

public class ControllerReceiver {
    private Auditeur auditeur;

    public ControllerReceiver(Auditeur auditeur) {
        this.auditeur = auditeur;
    }

    public String getMessageDiffuse(){
       return auditeur.getMessageRecu();
    }

    public String getNom(){
        return auditeur.getPseudo();
    }
    public Auditeur getAuditeur() {
        return auditeur;
    }
}
