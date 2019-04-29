package Demo;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
 

public class App implements Runnable  {
	
	String url;
	String queueName;
	int queuecount;
	public static boolean endLoop = false;
	
	
	public App(String url, String queueName, int queuecount){
		this.url=url;
		this.queueName=queueName;
		this.queuecount=queuecount;
		
	}
	
	public void run() 
	{
		System.out.println("calling to producer thread " + queuecount + "Thread Id :" + Thread.currentThread().getId());
		
		//for(int i = 0 ; i< queuecount ; i++)
		producer();
	}
	
	
	public void producer() {
		
		
		
		
		  try {
              // Create a ConnectionFactory
              ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);

              // Create a Connection
              Connection connection = connectionFactory.createConnection();
              connection.start();

              // Create a Session
              Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

              // Create the destination (Topic or Queue)
              Destination destination = session.createQueue(queueName);

              // Create a MessageProducer from the Session to the Topic or Queue
              MessageProducer producer = session.createProducer(destination);
              producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

              // Create a messages
              String text = "Hello world! From: " + Thread.currentThread().getName() + " : " + this.hashCode();
              TextMessage message = session.createTextMessage(text);

              // Tell the producer to send the message
              System.out.println("Sent message: "+ message.hashCode() + " : " + Thread.currentThread().getId());
              
              while(true)
              {
				for (int i = 0; i < queuecount; i++) {
					System.out.println("Sending Message" + i + "  " + message);
					producer.send(message);
					// Thread.sleep(2000);
				}
				Thread.sleep(60000);
				if (endLoop)
					break;
              }
              // Clean up data accordingly 
              session.close();
              connection.close();
          }
          catch (Exception e) {
              System.out.println("Caught: " + e);
              e.printStackTrace();
          }
	}
	
	
	
 
}