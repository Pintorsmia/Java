package exo1_Damien;

import javax.jms.MessageProducer;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

public class SenderQueueDam {

	public static void main(String[] args) throws Exception {

        Context context = new InitialContext();

        TopicConnectionFactory tcf = (TopicConnectionFactory) context.lookup("ConnectionFactory");
        Topic t = (Topic) context.lookup("topic2");
        TopicConnection tc = tcf.createTopicConnection();        
        
        TopicSession ts = tc.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
        

        

        MessageProducer mp = ts.createProducer(t);
        tc.start();

        for(int i = 1; i <= 10; i++)
        {
            Thread.sleep(1000);
            TextMessage message = ts.createTextMessage();
            message.setText("Contenu du message " + i);
            mp.send(message);
            System.out.println(message.getText());
         }

    }
}
