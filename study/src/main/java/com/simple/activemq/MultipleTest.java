package com.simple.activemq;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultipleTest {

	public static void main(String[] args) {
		
		Thread p1 = new Thread(new MultipleProducer());
	    p1.start();
	    
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 5; i++) {
            pool.submit(new MultipleConsumer("queue" + i  ));
        }
        
       

	}

}
