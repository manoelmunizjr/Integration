package org.mmz.mq.integragion.mmz_mq_integration;

import javax.jms.JMSException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) 
    {
       // System.out.println( "Hello World!" );
     
      final String sender = "sender";
      
      String acao = args[0];
      
      try {
          if (acao.equalsIgnoreCase(sender)) {
	    	  MessageSender execSender = new MessageSender(args[1]);	    	  
	    	  System.out.println(" >>>>>>> Mensagem enviada:  '" + execSender.getMessageAdded() + "'");  
	      } else {
	    	  MessageReceiver execReceiver = new MessageReceiver();
	    	  System.out.println(" <<<<< Mensagem recebida:  '" + execReceiver.getMessageReturned() + "'");
	      }
      } catch (JMSException e) {
    	  e.printStackTrace();
      }
                   
    }
}
