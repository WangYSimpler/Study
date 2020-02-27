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
 * @ClassName: ProducerForTopic 
 * @Description 基于发布/订阅模式传输类型的生产者测试
 * @Description: TODO
 * @date: 2020年2月24日  
 */
public class TopicProducer {

	    private static final String ACTIVEMQ_URL =  ActiveMQConnection.DEFAULT_BROKER_URL;

	    public static void main(String[] args) throws JMSException {
	    	System.out.println("ProducerForTopic ： " +Thread.currentThread().getId() +" : " +Thread.currentThread().getName());
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
	        // 创建一个生产者
	        MessageProducer producer = session.createProducer(destination);
	        // 向队列推送10个文本消息数据
	        for (int i = 1 ; i <= 50 ; i++){
	            // 创建文本消息
	            TextMessage message = session.createTextMessage("第" + i + "个文本消息");
	            //发送消息
	            producer.send(message);
	            try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            //在本地打印消息
	            System.out.println("P主题—生产者_已发送的消息：" + message.getText());
	        }
	        //关闭连接
	        connection.close();
	    }

	}


