/**
 * Copyright © 2020 SCF. All rights reserved
 * @ Study 
 * @author WangY
 * 2020年2月27日
 */
package com.simple.mq.rocketmq;

/** 
* @ClassName: RocketMQ_Consumer 
* @Description: TODO
* @date: 2020年2月27日  
*/

import java.util.List;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

public class RocketMQ_Consumer {
	
	public static void main(String[] args) throws InterruptedException, MQClientException {

		// 实例化 consumer，指定 consumer 组名
		DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("please_rename_unique_group_name");

		// 指定 name server
		consumer.setNamesrvAddr("localhost:9876");

		// 订阅1个或多个topic
		consumer.subscribe("TopicTest", "*");

		// 注册回调，当收到消息时执行
		consumer.registerMessageListener(new MessageListenerConcurrently() {

			public ConsumeConcurrentlyStatus consumeMessage(final List<MessageExt> msgs,
					final ConsumeConcurrentlyContext context) {
				System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), msgs);

				return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
			}
		});

		// 启动 consumer
		consumer.start();

		System.out.printf("Consumer Started.%n");
	}
}
