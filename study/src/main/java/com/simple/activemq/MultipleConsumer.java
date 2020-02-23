package com.simple.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class MultipleConsumer implements Runnable {
	
	 //用户名
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    //密码
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    //url
    private static final String URL = ActiveMQConnection.DEFAULT_BROKER_URL;

    private ConnectionFactory connfactory = null;
    private Connection connection = null;
    private Session session = null;
    private MessageProducer producer = null;


    private String name;
    public  MultipleConsumer(String name){
        this.name = name;
    }


    public void run() {
    	System.out.println("multipleComsumer 用户名 ： " + USERNAME +" ， 密码： "+ PASSWORD + " ,"+ " 地址 "+ URL);
       try{
    	   connfactory = new ActiveMQConnectionFactory(USERNAME,PASSWORD,URL);
           connection=connfactory.createConnection();
           connection.start();
           session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
           Destination queue = session.createQueue(name);
           MessageConsumer consumer = session.createConsumer(queue);
           while (true){
               TextMessage message = (TextMessage) consumer.receive();
               if(message==null) return;
               System.out.println(name + " 消费消息是  :" + message.getText());
               Thread.sleep(5);
           }
       }catch (Exception e){
           e.printStackTrace();
       }finally {
           try {
               producer.close();
               connection.close();
               session.close();
           } catch (Exception e) {
               e.printStackTrace();
           }
       }

    }
}

