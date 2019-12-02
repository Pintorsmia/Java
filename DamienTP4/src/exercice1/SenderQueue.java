package exercice1;

import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;


public class SenderQueue {

    public static void main(String[] args) throws Exception {

        Context context = new InitialContext();

        QueueConnectionFactory qcf = (QueueConnectionFactory) context.lookup("ConnectionFactory");
        Queue q = (Queue) context.lookup("queue1");
        QueueConnection qc = qcf.createQueueConnection();

        QueueSession qs = qc.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

        MessageProducer mp = qs.createProducer(q);
        qc.start();

        for(int i = 1; i <= 10; i++)
        {
            Thread.sleep(1000);
            TextMessage message = qs.createTextMessage();
            message.setText("Contenu du message " + i);
            mp.send(message);
            System.out.println(message.getText());
         }

    }
}
