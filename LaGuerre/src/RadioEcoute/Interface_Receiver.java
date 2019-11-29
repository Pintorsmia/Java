package RadioEcoute;

import java.util.Observable;
import java.util.Observer;


public class Interface_Receiver implements Observer {
    private ControllerReceiver controller;

    public Interface_Receiver(ControllerReceiver controller) {
        this.controller = controller;
        this.controller.getAuditeur().addObserver(this);
    }

    @Override
    public void update(Observable observable, Object o) {
        System.out.println("yyyyyyy");
    }
}
