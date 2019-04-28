package org.mmz.mq.integragion.mmz_mq_integration;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
 
public class MessageReceiver {

	private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    
	private static String subject = "fornecedorSituacaoPedido";
 
    private String messageReturned = new String();
    
    public MessageReceiver() throws JMSException {
        
    	ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.start();
 
        Session session = connection.createSession(false,
                Session.AUTO_ACKNOWLEDGE);
 
        Destination destination = session.createQueue(subject);
 
        MessageConsumer consumer = (MessageConsumer) session.createConsumer(destination);
 
        // Here we receive the message.
        Message message = ((javax.jms.MessageConsumer) consumer).receive();
 
        // We will be using TestMessage in our example. MessageProducer sent us a TextMessage
        // so we must cast to it to get access to its .getText() method.
        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            System.out.println(" ----------> Mensagem do fornecedor:  '" + textMessage.getText() + "'");          
            setMessageReturned(textMessage.getText());
            //            
        }
        connection.close();
               
    }

	public String getMessageReturned() {
		return messageReturned;
	}

	private void setMessageReturned(String messageReturned) {
		this.messageReturned = messageReturned;
	}


}
