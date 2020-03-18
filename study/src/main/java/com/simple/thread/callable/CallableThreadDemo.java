package com.simple.thread.callable;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


class MyCallableThread implements Callable<String>{

	public String call() throws Exception {
		// TODO Auto-generated method stub
		for(int i = 0;i < 20 ;i++){
			System.out.println("执行是 i= " + i);
		}
		return "程序执行结束" ;
	}
	
}

public class CallableThreadDemo {
	
	public static void  main(String args[]) throws InterruptedException, ExecutionException {
		FutureTask<String> futureTask = new FutureTask<String>(new MyCallableThread());
		new Thread(futureTask,"线程1").start();
		new Thread(futureTask,"线程2").start();
		System.out.println("结束 " + futureTask.get());
	}

}
