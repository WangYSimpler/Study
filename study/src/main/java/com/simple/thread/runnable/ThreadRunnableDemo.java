package com.simple.thread.runnable;

public class ThreadRunnableDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int x = 0; x<3;x++){
			String title = "线程对象 : " + x;
			Runnable runnable = ()->{
				for(int i = 0; i<10;i++){
					System.out.println( title + " 运行 ，i = " +i);
				}
			};
			new Thread(runnable).start();
			
		}
	}

}
