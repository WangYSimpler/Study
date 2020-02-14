package com.simple.thread;

class MyTicketThead implements  Runnable {
	
	private int ticket = 5;
	
	public void run() {
		for(int i = 0;i<100; i++){
			if (ticket >0) {
				System.out.println("剩余票数是" + ticket-- );
			}
		}
	}
}

public class TicketTheadDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTicketThead myThread = new MyTicketThead();
		new Thread(myThread).start();
		new Thread(myThread).start();
		new Thread(myThread).start();
		
	}

}
