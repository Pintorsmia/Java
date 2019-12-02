package MQTT;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class ClientSub {

	public static void main(String[] args) {
		// TODO Auto-generated method stub



		// TODO Auto-generated method stub
		String topic        = "topic";
		String content      = "Bonjour";
		int qos             = 2;
		String broker       = "tcp://localhost:1883";
		String clientId     = "JavaSample";
		MemoryPersistence persistence = new MemoryPersistence();

		try {
			MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
			MqttConnectOptions connOpts = new MqttConnectOptions();
			connOpts.setCleanSession(true);
			System.out.println("Connecting to broker: "+broker);
			sampleClient.connect(connOpts);
			System.out.println("Connected");
			sampleClient.subscribe(topic,qos);
			System.out.println("Subscribe");
			sampleClient.setCallback(new MqttCallback() {
				
				@Override
				public void messageArrived(String arg0, MqttMessage arg1) throws Exception {
					// TODO Auto-generated method stub
					System.out.println(new String(arg1.getPayload()));
				}
				
				@Override
				public void deliveryComplete(IMqttDeliveryToken arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void connectionLost(Throwable arg0) {
					// TODO Auto-generated method stub
					
				}
			});
			
			
			
			


			sampleClient.disconnect();
			System.out.println("Disconnected");
			System.exit(0);
		} catch(MqttException me) {
			System.out.println("reason "+me.getReasonCode());
			System.out.println("msg "+me.getMessage());
			System.out.println("loc "+me.getLocalizedMessage());
			System.out.println("cause "+me.getCause());
			System.out.println("excep "+me);
			me.printStackTrace();
		}




	}

}
