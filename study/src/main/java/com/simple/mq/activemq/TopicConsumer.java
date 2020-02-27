/**
 * Copyright © 2020 SCF. All rights reserved
 * @ Study 
 * @author WangY
 * 2020年2月24日
 */
package com.simple.mq.activemq;

import javax.jms.*;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/** 
 * @ClassName: ConsumerForTopic 
 * @Description: TODO
 * @date: 2020年2月24日  
 */
public class TopicConsumer {

	    private static final String ACTIVEMQ_URL =  ActiveMQConnection.DEFAULT_BROKER_URL;

	    public static void main(String[] args) throws JMSException {
	    	
	    	System.out.println("ConsumerForTopic ： " +Thread.currentThread().getId() +" : " +Thread.currentThread().getName());
	    	
	        // 创建连接工厂
	        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
	        // 创建连接
	        Connection connection = activeMQConnectionFactory.createConnection();
	        // 打开连接
	        connection.start();
	        // 创建会话
	        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        // 创建队列目标,并标识队列名称，消费者根据队列名称接收数据
	        Destination destination = session.createTopic("topicTest");
	        // 创建消费者
	        MessageConsumer consumer = session.createConsumer(destination);
	        // 创建消费的监听
	        consumer.setMessageListener(new MessageListener() {
	            public void onMessage(Message message) {
	                TextMessage textMessage = (TextMessage) message;
	                try {
	                    System.out.println("C主题-消费者_消费的消息： " + textMessage.getText());
	                } catch (JMSException e) {
	                    e.printStackTrace();
	                }
	                try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            }
	        });
	    }
	}


