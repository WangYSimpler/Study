package com.simple.mq.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class P2PConsumer {
	
	public static void main(String[] args) throws JMSException, InterruptedException {
		
		System.out.println("消费者类 XXX");
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,
                ActiveMQConnectionFactory.DEFAULT_PASSWORD,"tcp://127.0.0.1:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(Boolean.FALSE,Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue("queue");
        MessageConsumer consumer = session.createConsumer(destination);
        while (true){
            TextMessage message = (TextMessage) consumer.receive();
            if (message==null){
                break;
            }
            Thread.sleep(2000);
            System.out.println(message.getText());
        }
        if(connection!=null){
            connection.close();
        }
    }

	
}
