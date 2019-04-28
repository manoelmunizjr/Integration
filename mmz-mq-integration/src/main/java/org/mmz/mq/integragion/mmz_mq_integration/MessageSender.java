package org.mmz.mq.integragion.mmz_mq_integration;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
 
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class MessageSender {

	private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
     
    private static String subject = "enviarPedido"; // Queue Name.You can create any/many queue names as per your requirement. 
     
    private String messageAdded = new String();
    
    public MessageSender(String messageToSend) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.start();
         
        Session session = connection.createSession(false,
                Session.AUTO_ACKNOWLEDGE);  
         
        Destination destination = session.createQueue(subject); 
         
        MessageProducer producer = session.createProducer(destination);
         
        TextMessage message = session
                .createTextMessage(messageToSend);
         
        // message.setText("  Adicionado teste");
        producer.send(message);
        
        setMessageAdded(message.getText());
         
        connection.close();
        
    }

	public String getMessageAdded() {
		return messageAdded;
	}

	private void setMessageAdded(String messageAdded) {
		this.messageAdded = messageAdded;
	}
        
}
