/**
 * Copyright © 2020 SCF. All rights reserved
 * @ Study 
 * @author WangY
 * 2020年2月24日
 */
package com.simple.mq.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.simple.utils.DateUtil;

public class BlockingQueueInstance {
	
	/**
	 * 定义装东西篮子
	 */
	public static class Basket {
		// 篮子，能够容纳5个苹果
		BlockingQueue<Object> basket = new ArrayBlockingQueue<Object>(5);

		// 生产放入篮子
		public void produce(Object object ) throws InterruptedException {
			// put方法放入一个苹果，若basket满了，等到basket有位置
			basket.put(object);
		}

		// 消费苹果，从篮子中取走
		public Object consume() throws InterruptedException {
			// get方法取出object，若basket为空，等到basket有为止
			 
			return basket.take();
		}

		public int getObjectNumber() {
			return basket.size();
		}
	}

	// 测试方法
	public static void testBasket() {
		// 建立一个篮子
		final Basket basket = new Basket();
		// 定义苹果生产者
		class Producer implements Runnable {
			public void run() {
				try {
					while (true) {
						// 生产苹果
						System.out.println("生产者准备生产苹果：" + DateUtil.retFormatNowDate());
						basket.produce("An Apple");
						System.out.println("生产者生产苹果完毕：" + DateUtil.retFormatNowDate());
						System.out.println("生产完后有苹果：" + basket.getObjectNumber() + "个");
						// 休眠300ms
						Thread.sleep(500);
					}
				} catch (InterruptedException ex) {
				}
			}
		}
		// 定义苹果消费者
		class Consumer implements Runnable {
			public void run() {
				try {
					while (true) {
						// 消费苹果
						System.out.println("消费者准备消费苹果：" + DateUtil.retFormatNowDate());
						System.out.println("消费 产品 " +basket.consume());
						System.out.println("消费者消费苹果完毕：" + DateUtil.retFormatNowDate());
						System.out.println("消费完后有苹果：" + basket.getObjectNumber() + "个");
						// 休眠1000ms
						Thread.sleep(600);
					}
				} catch (InterruptedException ex) {
				}
			}
		}

		ExecutorService service = Executors.newCachedThreadPool();
		Producer producer = new Producer();
		Consumer consumer = new Consumer();
		service.submit(producer);
		service.submit(consumer);
		
		try {
			// 程序运行100s后，所有任务停止
			Thread.sleep(50000);
		} catch (InterruptedException e) {
		}
		service.shutdownNow();
	}

	public static void main(String[] args) {
		BlockingQueueInstance.testBasket();
	}
}
