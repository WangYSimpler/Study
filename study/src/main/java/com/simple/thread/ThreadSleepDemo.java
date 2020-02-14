package com.simple.thread;

public class ThreadSleepDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Thread( () ->{
			for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() +", i =" + i);
				
			}
		}).start();
	}

}
