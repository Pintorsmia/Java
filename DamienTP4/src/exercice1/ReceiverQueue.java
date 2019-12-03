package exercice1;

import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;


public class ReceiverQueue {

    	public static void main(String[] args) throws Exception{
        
    		Context context = new InitialContext();

    		QueueConnectionFactory qcf = (QueueConnectionFactory) context.lookup("ConnectionFactory");
        
    		Queue q = (Queue) context.lookup("queue1");
    		QueueConnection  qc = qcf.createQueueConnection();

    		QueueSession qs = qc.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
        
    		MessageConsumer mc = qs.createConsumer(q);
        
    		qc.start();
        
    		while(true){
    			TextMessage message = (TextMessage) mc.receive();
    			System.out.println("Message recu: " + message.getText());
        	}
        }
}
   
