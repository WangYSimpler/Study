package com.study.thread;

public class PrintThread implements Runnable {
	
	private PrintCallback pcback; 
	
    public PrintThread(PrintCallback pcback) {  
        this.pcback = pcback;  
    }  

	public void run() {
		// TODO Auto-generated method stub
	 pcback.CallbackMethod(Thread.currentThread().getName()); 
	}

}
