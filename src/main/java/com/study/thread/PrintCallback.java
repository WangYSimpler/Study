package com.study.thread;

public class PrintCallback {  
	  
    private int num;  
    private String threadName;  
    public PrintCallback() {  
        num = 0;  
    }  
      
    public synchronized void CallbackMethod(String threadName){  
        if (num <= 79) {  
            for (int i = 0; i < 6; i++) {  
                System.out.println(threadName+":"+(++num));  
            }  
        }  
          
    }  
      
    public void PrintNum() throws InterruptedException{  
        for (int i = 1; i < 6; i++) {  
            for (int j = 1; j < 4; j++) {  
                threadName = "线程"+j;  
                PrintThread runnable = new PrintThread(this);  
                Thread thread = new Thread(runnable);  
                thread.setName(threadName);  
                thread.start();  
                thread.join();  
            }  
        }  
    }  
    public static void main(String[] args) throws InterruptedException{  
        PrintCallback pc = new PrintCallback();  
        pc.PrintNum();  
    }  
}  