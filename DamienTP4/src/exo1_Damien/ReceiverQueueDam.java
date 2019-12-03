package exo1_Damien;

import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;

public class ReceiverQueueDam {
	public static void main(String[] args) throws Exception{
        
		Context context = new InitialContext();

		TopicConnectionFactory qcf = (TopicConnectionFactory) context.lookup("ConnectionFactory");
    
		Topic q = (Topic) context.lookup("topic2");
		TopicConnection  qc = qcf.createTopicConnection();

		TopicSession qs = qc.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
		
	       TopicSubscriber tsub1 = qs.createDurableSubscriber(q, "GGWP");
	       TopicSubscriber tsub2 = qs.createDurableSubscriber(q, "DAB");
		
		MessageConsumer mc = qs.createConsumer(q);
    
		qc.start();
    
		while(true){
			TextMessage message = (TextMessage) tsub1.receive();
			TextMessage message1 = (TextMessage) tsub2.receive();

			System.out.println("Message recu: " + message.getText());
			System.out.println("Message recu: " + message1.getText());
    	}
    }
}
