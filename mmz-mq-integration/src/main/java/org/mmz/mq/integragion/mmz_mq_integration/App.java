package org.mmz.mq.integragion.mmz_mq_integration;

import javax.jms.JMSException;

/**
 * Sender/Receiver ActiveMQ Integration
 *
 */
public class App 
{
    public static void main( String[] args ) 
    {
       
      final String sender = "sender";
      final String receiver = "receiver";
      
      String acao = args[0];
      
      try {
          if (acao.equalsIgnoreCase(sender)) {
	    	  MessageSender execSender = new MessageSender(args[1]);	    	  
	    	  System.out.println(" >>>>>>> Mensagem enviada:  '" + execSender.getMessageAdded() + "'");  
	      } else if (acao.equalsIgnoreCase(receiver)) {
	    	  MessageReceiver execReceiver = new MessageReceiver();
	    	  System.out.println(" <<<<< Mensagem recebida:  '" + execReceiver.getMessageReturned() + "'");
	      }
      } catch (JMSException e) {
    	  e.printStackTrace();
      }
                   
    }
}
