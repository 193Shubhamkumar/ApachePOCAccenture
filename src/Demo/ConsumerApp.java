package Demo;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
 

public class ConsumerApp implements Runnable  {
 
 String url;
 String queueName;
 int queuecount;
 public static boolean endloop = false;
 
 
 public ConsumerApp(String url, String queueName, int queuecount){
  this.url=url;
  this.queueName=queueName;
  this.queuecount=queuecount;
  
 }
 
 public void run() {
  System.out.println("calling to  thread" + queuecount + "Thread Id:" + Thread.currentThread().getId() );
  consumer();
 }
 
 
 
 public void consumer(){
   try {
    
             // Create a ConnectionFactory
             ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);

             // Create a Connection
             Connection connection = connectionFactory.createConnection();
             connection.start();

//             connection.setExceptionListener(this);

             // Create a Session
             Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

             // Create the destination (Topic or Queue)
             Destination destination = session.createQueue(queueName);

             // Create a MessageConsumer from the Session to the Topic or Queue
             MessageConsumer consumer = session.createConsumer(destination);
              
             Message message = null; 
             while (true)  {
            	 
             
             for (int i =0 ; i < queuecount; i++)
             {
                 System.out.println("Receving Message" + i + " "+ message);
                // Wait for a message
                message = consumer.receive(1000);
                Thread.sleep(6000);
                if (message instanceof TextMessage)
                {
                 TextMessage textMessage = (TextMessage) message;
                 String text = textMessage.getText();
                 System.out.println("Received: " + text);
                } 
                else 
                {
                  System.out.println("Received: " + message);
                }
              }

              
              if(endloop) {
            	  break;
              }
             } 
             consumer.close();
             session.close();
             connection.close();
             
   }
              catch (Exception e)
              {System.out.println("Caught: " + e);
              e.printStackTrace();
              }
              }
}






